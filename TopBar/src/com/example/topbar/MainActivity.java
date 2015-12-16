package com.example.topbar;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		MyTopBar topBar =(MyTopBar) findViewById(R.id.my_topbar);
		//�����Զ����Topbar���Զ����click�����¼�
		topBar.setOnTopbarClickListenter(new MyTopBar.myTopbarClicklistenter() {
			
			@Override
			public void leftClick() {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "�����Back", Toast.LENGTH_SHORT).show();
			}
			
			@Override
			public void rightClick() {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "�����More", Toast.LENGTH_SHORT).show();
			}
		});
		
		//topBar.setLeftIsVisible(false);
		topBar.setRightIsVisible(false);
	}

}
