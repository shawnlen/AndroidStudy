package com.example.testsubmenu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.main, menu);
		
		//��̬����Ӳ˵���
		/*SubMenu subMenu1 = menu.addSubMenu("�ļ�");
		SubMenu subMenu2 = menu.addSubMenu("�༭");
		
		subMenu1.setHeaderTitle("�ļ�����");
		subMenu1.setHeaderIcon(R.drawable.ic_launcher);
		subMenu1.add(1, 100, 1, "�½�");
		subMenu1.add(1, 101, 1, "��");
		subMenu1.add(1, 102, 1, "����");
		subMenu1.add(1, 103, 1, "������");
		
		subMenu2.setHeaderTitle("�༭����");
		subMenu2.setHeaderIcon(R.drawable.ic_launcher);
		subMenu2.add(2, 100, 1, "ճ��");
		subMenu2.add(2, 101, 1, "����");
		subMenu2.add(2, 102, 1, "����");
		subMenu2.add(2, 103, 1, "������");*/
		
		//ͨ������XML��̬�����Ӳ˵�
		MenuInflater menuInflater=getMenuInflater();
		menuInflater.inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		//��̬�ĵ���¼�
		/*if (item.getGroupId()==1) {
			switch (item.getItemId()) {
			case 100:
				Toast.makeText(this, "������½�", Toast.LENGTH_SHORT).show();
				break;

			case 101:
				Toast.makeText(this, "����˴�", Toast.LENGTH_SHORT).show();
				break;
			case 102:
				Toast.makeText(this, "����˱���", Toast.LENGTH_SHORT).show();
				break;
			case 103:
				Toast.makeText(this, "�����������", Toast.LENGTH_SHORT).show();
				break;
			}
		} 
		else {
			
			switch (item.getItemId()) {
			case 100:
				Toast.makeText(this, "�����ճ��", Toast.LENGTH_SHORT).show();
				break;

			case 101:
				Toast.makeText(this, "����˸���", Toast.LENGTH_SHORT).show();
				break;
			case 102:
				Toast.makeText(this, "����˼���", Toast.LENGTH_SHORT).show();
				break;
			case 103:
				Toast.makeText(this, "�����������", Toast.LENGTH_SHORT).show();
				break;
		}
			
		}*/
		
		//��̬�ĵ���¼�
		switch (item.getItemId()) {
		case R.id.new_file:
			Toast.makeText(this, "������½�", Toast.LENGTH_SHORT).show();
			break;
		case R.id.open_file:
			Toast.makeText(this, "����˴�", Toast.LENGTH_SHORT).show();
			break;
		case R.id.save_file:
			Toast.makeText(this, "����˱���", Toast.LENGTH_SHORT).show();
			break;
		case R.id.rename_file:
			Toast.makeText(this, "�����������", Toast.LENGTH_SHORT).show();
			break;

		case R.id.v_file:
			Toast.makeText(this, "�����ճ��", Toast.LENGTH_SHORT).show();
			break;
		case R.id.c_edit:
			Toast.makeText(this, "����˸���", Toast.LENGTH_SHORT).show();
			break;
		case R.id.x_edit:
			Toast.makeText(this, "����˼���", Toast.LENGTH_SHORT).show();
			break;
		case R.id.rename_edit:
			Toast.makeText(this, "�����������", Toast.LENGTH_SHORT).show();
			break;
		}

		return super.onOptionsItemSelected(item);
	}
}
