package com.example.testnotification;

import android.app.Activity;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener{

	NotificationManager manager;   //֪ͨ��������
	int notification_ID;           //֪ͨID
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		manager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);  //��ȡϵͳ֪ͨ����
		
		findViewById(R.id.btnSend).setOnClickListener(this);
		findViewById(R.id.btnCancle).setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnSend:
			sendNotification();
			break;

		case R.id.btnCancle:
			cancleNotification();
			break;
		}
	}

	private void sendNotification() {
		Builder builder=new Notification.Builder(this);
		builder.setTicker("Hello");    // �����ֻ�״̬������ʾ
		builder.setSmallIcon(R.drawable.ic_launcher);   // �����ֻ�״̬����ͼ��
		builder.setWhen(System.currentTimeMillis());    // ����ʱ��
		
		builder.setContentTitle("֪ͨ��֪ͨ");    // ���ñ���
		builder.setContentText("֪ͨ����ʾ������"); // ����֪ͨ����
		
		Intent intent=new Intent(this,MainActivity.class);   //���õ������ת��MainActivity
		PendingIntent pendingIntent=PendingIntent.getActivity(this, 0, intent, 0);
		builder.setContentIntent(pendingIntent);   //���õ�������ͼ
		
		builder.setDefaults(Notification.DEFAULT_ALL);  //ֱ�����ó�Ĭ�ϣ���ȫ����������������
		/* ���Ȩ��
		 * <uses-permission android:name="android.permission.VIBRATE"/>
	     * <uses-permission android:name="android.permission.FLASHLIGHT"/>
	     * */
		//builder.setDefaults(Notification.DEFAULT_SOUND);   //������ʾ��
		//builder.setDefaults(Notification.DEFAULT_LIGHTS);  //����ָʾ��
		//builder.setDefaults(Notification.DEFAULT_VIBRATE); //������
		
		Notification notification=builder.build();  //��ȡNotification   // 4.1����
		//Notification notification2=builder.getNotification();         // 4.1����
			
		manager.notify(notification_ID, notification);    //ͨ��֪ͨ����������ʾ֪ͨ
	}
	
	private void cancleNotification() {
		// TODO Auto-generated method stub
		manager.cancel(notification_ID);    //ȡ��֪ͨ
	}

}
