package com.example.testviewpager;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	private List<View> viewList;
	private ViewPager viewPager;
	
	private List<String> titleList;
	private PagerTabStrip tabStrip;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		viewList=new ArrayList<View>();
		
		//ͨ��View������ΪViewPager������Դ
		View view1=View.inflate(this, R.layout.view1, null);
		View view2=View.inflate(this, R.layout.view2, null);
		View view3=View.inflate(this, R.layout.view3, null);
		View view4=View.inflate(this, R.layout.view4, null);
		
		viewList.add(view1);
		viewList.add(view2);
		viewList.add(view3);
		viewList.add(view4);

		//��ʼ��ViewPager
		viewPager=(ViewPager) findViewById(R.id.pager);
		
		//ΪViewPager���ñ���
		titleList=new ArrayList<String>();
		titleList.add("��һҳ");
		titleList.add("�ڶ�ҳ");
		titleList.add("����ҳ");
		titleList.add("����ҳ");
		
		//ΪPagerTabStrip����һЩ����
		tabStrip=(PagerTabStrip) findViewById(R.id.pagerTab);
		tabStrip.setBackgroundColor(Color.BLUE);
		tabStrip.setTextColor(Color.RED);
		tabStrip.setDrawFullUnderline(false);
		tabStrip.setTabIndicatorColor(Color.GREEN);	

		//����PagerAdapter��������
		MyPagerAdapter adapter=new MyPagerAdapter(viewList,titleList);
		
		//ViewPager����������
		viewPager.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
