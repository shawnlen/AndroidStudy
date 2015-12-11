package com.example.asharedpreferencesdemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.AvoidXfermode.Mode;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SharedPreferences sharedPreferences=getSharedPreferences("user", Context.MODE_PRIVATE);    // ʵ����SharedPreferences����
				
				Editor editor=sharedPreferences.edit();     // ʵ����SharedPreferences.Editor����
				editor.putString("name", "����");            // ��putString�ķ����������� 
				editor.putString("IP", "192.168.1.102");
				editor.putString("password", "123456");
				editor.commit();                            // �ύ��ǰ���� 
				
				Toast.makeText(MainActivity.this, "д�����ݳɹ���", Toast.LENGTH_SHORT).show();
			}
		});
		
		findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// �ڶ�ȡSharedPreferences����ǰҪʵ������һ��SharedPreferences���� 
				SharedPreferences preferences=getSharedPreferences("user", Context.MODE_PRIVATE);  
				
				String nameStr=preferences.getString("name", "");  // ʹ��getString�������value��ע���2��������value��Ĭ��ֵ
				String ipStr=preferences.getString("IP", "");
				String pwStr=preferences.getString("password", "");
				
				Toast.makeText(MainActivity.this, "�û���Ϣ��������"+nameStr+",IP:"+ipStr+",���룺"+pwStr, Toast.LENGTH_LONG).show();
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
