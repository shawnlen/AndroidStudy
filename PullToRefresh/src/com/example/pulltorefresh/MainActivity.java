package com.example.pulltorefresh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleAdapter;

import com.example.pulltorefresh.RefreshListView.IReflashListenter;

public class MainActivity extends Activity implements IReflashListenter, OnItemClickListener {
	private RefreshListView listView;
	private int NewsIcon[] = { R.drawable.tools1, R.drawable.tools2,
			R.drawable.tools3, R.drawable.tools4, R.drawable.games1,
			R.drawable.games2, R.drawable.games3, R.drawable.games4,
			R.drawable.games5, R.drawable.games6 };
	private String NewsName[] = { "ToolsItem1", "ToolsItem2", "ToolsItem3",
			"ToolsItem4", "GamesItem1", "GamesItem2", "GamesItem3",
			"GamesItem4", "GamesItem5", "GamesItem6" };
	private SimpleAdapter adapter;
	private List<Map<String, Object>> NewsDataList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listView = (RefreshListView) findViewById(R.id.newsListView);
		listView.setInterface(this);
		NewsDataList = new ArrayList<Map<String, Object>>();
		adapter = new SimpleAdapter(this, getNewsData(),
				R.layout.news_tab_item,
				new String[] { "NewsImage", "NewsName" }, new int[] {
						R.id.newsImageViewItem, R.id.newssName });
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
	}
	
	

	private List<? extends Map<String, ?>> getNewsData() {
		// TODO Auto-generated method stub
		for (int i = 0; i < NewsIcon.length; i++) {
			Map<String, Object> GamesMap = new HashMap<String, Object>();
			GamesMap.put("NewsImage", NewsIcon[i]);
			GamesMap.put("NewsName", NewsName[i]);
			NewsDataList.add(GamesMap);
		}
		return NewsDataList;
	}

	//��ȡˢ������
	private List<? extends Map<String, ?>> getReflashNewsData() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 2; i++) {
			Map<String, Object> GamesMap = new HashMap<String, Object>();
			GamesMap.put("NewsImage", NewsIcon[i]);
			GamesMap.put("NewsName", NewsName[i]+"ˢ������"+i);
			NewsDataList.add(0,GamesMap);
		}
		return NewsDataList;
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// ListView�ĵ���¼�
		
	}

	@Override
	public void onReflash() {
		// TODO Auto-generated method stub
		Handler handler=new Handler();
		handler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//��ȡ��������
				getReflashNewsData();
				//֪ͨ������ʾˢ������				
				adapter = new SimpleAdapter(MainActivity.this, NewsDataList,
						R.layout.news_tab_item,
						new String[] { "NewsImage", "NewsName" }, new int[] {
								R.id.newsImageViewItem, R.id.newssName });   //��������������¾ɣ�NewsDataList
				listView.setAdapter(adapter);
				//֪ͨListViewˢ���������
				listView.reflashComplete();
			}
		}, 2000);//�˴���Ϊ�ˡ������Ͽ���ȥ��ˢ���ӳٵ�Ч������ʵ��Ӧ���в���Ҫ
		
	}

}
