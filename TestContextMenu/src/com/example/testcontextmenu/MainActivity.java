package com.example.testcontextmenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ListView listView;
	private SimpleAdapter simpleAdapter;
	private List<Map<String, Object>> data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listView = (ListView) findViewById(R.id.listView);

		data = new ArrayList<Map<String, Object>>();
		simpleAdapter = new SimpleAdapter(this, getData(), R.layout.item,
				new String[] { "image", "text" }, new int[] { R.id.imageView,
						R.id.textView });

		listView.setAdapter(simpleAdapter);

		// ΪListVIewע�������Ĳ˵�
		this.registerForContextMenu(listView);
	}

	private List<Map<String, Object>> getData() {
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("image", R.drawable.calendar);
		map1.put("text", "����");
		data.add(map1);
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("image", R.drawable.camera);
		map2.put("text", "�����");
		data.add(map2);
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("image", R.drawable.clock);
		map3.put("text", "ʱ��");
		data.add(map3);
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("image", R.drawable.games_control);
		map4.put("text", "��Ϸ");
		data.add(map4);
		Map<String, Object> map5 = new HashMap<String, Object>();
		map5.put("image", R.drawable.world);
		map5.put("text", "��ͼ");
		data.add(map5);

		return data;
	}

	//ѡ��˵�
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}
	

	// ��д�����Ĳ˵�
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		menu.setHeaderTitle("Ӧ�ó�����չ����");
		menu.setHeaderIcon(R.drawable.ic_launcher);
		
		//��̬��Ӳ˵���
		//menu.add(1, 100, 1, "ճ��");
		//menu.add(1, 101, 1, "����");
		//menu.add(1, 102, 1, "����");
		//menu.add(1, 103, 1, "������");
		
		//ͨ��XML���ز˵���
		MenuInflater inflater=getMenuInflater();
		inflater.inflate(R.menu.main_context, menu);
	}

	// ���������Ĳ˵��ĵ���¼�
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		/*switch (item.getItemId()) {
		case 100:
			Toast.makeText(MainActivity.this, "�����ճ��", Toast.LENGTH_SHORT).show();
			break;

		case 101:
			Toast.makeText(MainActivity.this, "����˸���", Toast.LENGTH_SHORT).show();

			break;
		case 102:
			Toast.makeText(MainActivity.this, "����˼���", Toast.LENGTH_SHORT).show();

			break;
		case 103:
			Toast.makeText(MainActivity.this, "�����������", Toast.LENGTH_SHORT).show();

			break;
		}*/
		
		switch (item.getItemId()) {
		case R.id.action_settings1:
			Toast.makeText(MainActivity.this, "�����ճ��", Toast.LENGTH_SHORT).show();
			break;

		case R.id.action_settings2:
			Toast.makeText(MainActivity.this, "����˸���", Toast.LENGTH_SHORT).show();

			break;
		case R.id.action_settings3:
			Toast.makeText(MainActivity.this, "����˼���", Toast.LENGTH_SHORT).show();

			break;
		case R.id.action_settings4:
			Toast.makeText(MainActivity.this, "�����������", Toast.LENGTH_SHORT).show();

			break;
		}
		return super.onContextItemSelected(item);

	}
}
