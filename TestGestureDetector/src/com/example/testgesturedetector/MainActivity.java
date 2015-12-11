package com.example.testgesturedetector;

import android.os.Bundle;
import android.app.Activity;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ImageView imageView;
	private GestureDetector mygestureDetector;

	// �̳�SimpleOnGestureListener�࣬Ȼ�����ظ���Ȥ�����ơ�
	class MyGestureListenter extends SimpleOnGestureListener {

		@Override
		// ���ػ�������
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			if (e1.getX() - e2.getX() > 50) {
				Toast.makeText(MainActivity.this, "�������󻬶�", Toast.LENGTH_SHORT)
						.show();
			} else if (e2.getX() - e1.getX() > 50) {
				Toast.makeText(MainActivity.this, "�������һ���", Toast.LENGTH_SHORT)
						.show();
			}
			return super.onFling(e1, e2, velocityX, velocityY);
		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/*
		 * GestureDetector����ԭ�� 
		 * 1�������յ��û�������Ϣʱ������Ϣ����GestureDetector�ӹ���
		 * 2��ͨ�����ü��������GestureDetector���������ƣ� 
		 * 3��GestureDetector�ṩ������������
		 *     A.OnGestureListenter������������Ϣ��
		 *     B.OnDoubleTapListenter������˫������Ϣ��
		 */
		imageView = (ImageView) findViewById(R.id.img);
		mygestureDetector = new GestureDetector(new MyGestureListenter());

		// MotionEvent������setOnTouchListener����
		// ������onTouch��GestureDetector���󽫼����¼�ת����MyGestureListenter(extends SimpleOnGestureListener)
		// ������MyGestureListenter����ʵ����Ҫ���ص�����
		imageView.setOnTouchListener(new OnTouchListener() {

			@Override
			// ���Բ�������Ļ������Event
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				mygestureDetector.onTouchEvent(event); // ת��event�¼���ת����MyGestureListenter(extends SimpleOnGestureListener)
				return false;
			}
		});
	}

	//������ͻ
	/*@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		if(mygestureDetector!=null){
			if(mygestureDetector.onTouchEvent(ev)){
				return true;
			}
		}
		return super.dispatchTouchEvent(ev);
	}*/
	
	//������дonTouchEvent������onFling����Ч
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return mygestureDetector.onTouchEvent(event);
	}
}
