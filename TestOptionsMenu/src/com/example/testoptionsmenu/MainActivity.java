package com.example.testoptionsmenu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	
	 /** @Override public boolean onCreateOptionsMenu(Menu menu) { // Inflate the
	 * menu; this adds items to the action bar if it is present.
	 * 
	 * // ����ѡ��˵� // (1)��̬���� // (2)ͨ��xml����MenuInflater.inflate();
	 * 
	 * // ���ò˵������¼���onOptionsItemSelected();
	 * 
	 * getMenuInflater().inflate(R.menu.main, menu); return true; }
	 
*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		//menu.add(groupId, itemId, order, title):����ֵ��MenuItem
		
		//(2)��̬����
		MenuItem menuItem = menu.add(1, 100, 1, "�˵�һ");
		menuItem.setTitle("Menuһ");
		menuItem.setIcon(R.drawable.ic_launcher);  //API>=11ʱ����ʾͼ��
		
		menu.add(1, 101, 2, "�˵���");
		menu.add(1, 102, 3, "�˵���");
		menu.add(1, 103, 4, "�˵���");
		
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case 100:
			Intent intent=new Intent(MainActivity.this,Menu1.class);
			item.setIntent(intent);     //�������תҳ��
			Toast.makeText(this, "����˲˵���һ", Toast.LENGTH_SHORT).show();
			break;
		case 101:
			Toast.makeText(this, "����˲˵����", Toast.LENGTH_SHORT).show();
			break;
		case 102:
			Toast.makeText(this, "����˲˵�����", Toast.LENGTH_SHORT).show();
			break;
		case 103:
			Toast.makeText(this, "����˲˵�����", Toast.LENGTH_SHORT).show();
			break;
		}
		return super.onOptionsItemSelected(item);
	}

}
