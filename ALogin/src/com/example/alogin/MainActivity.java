package com.example.alogin;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private EditText etName,etIP,etPw;
	private CheckBox checkBox;
	private Button btnLogin,btnCancel;
	
	SharedPreferences sharedPreferences;
	Editor editor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		etName=(EditText) findViewById(R.id.name);
		etIP=(EditText) findViewById(R.id.ip);
		etPw=(EditText) findViewById(R.id.password);
		
		checkBox=(CheckBox) findViewById(R.id.check);
		
		btnLogin=(Button) findViewById(R.id.login);
		btnCancel=(Button) findViewById(R.id.cancel);
					
		btnLogin.setOnClickListener(this);
		btnCancel.setOnClickListener(this);
		
		sharedPreferences = getSharedPreferences("UserInfo", MODE_PRIVATE);
		editor = sharedPreferences.edit();

		String getName = sharedPreferences.getString("name", "");         //�˴��ǹ��ڡ���ס��¼��Ϣ���Ĳ���
		String getIP=sharedPreferences.getString("IP", "");
		String getPassword=sharedPreferences.getString("password", "");
		if(getName==null){
			checkBox.setChecked(false);
		}
		else{
			checkBox.setChecked(true);
			etName.setText(getName);
		}
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
		case R.id.login:
			
			String name = etName.getText().toString().trim();
			String IP = etIP.getText().toString().trim();
			String password=etPw.getText().toString().trim();
			
			if(name.equals("admin") /*&& IP.equals("192.168.1.102")*/ && password.equals("GO")){
				if(checkBox.isChecked()){
					
					editor.putString("name", name);      //ֻ��ס��¼��
					//editor.putString("IP", IP);
					//editor.putString("password", password);
					editor.commit();
					Toast.makeText(MainActivity.this, "��¼���ѱ���", Toast.LENGTH_SHORT).show();
				}
				else{
					editor.remove("name");      //���û�й�ѡ����ס��¼��Ϣ��
					//editor.remove("IP");
					//editor.remove("password");
					editor.commit();
					Toast.makeText(MainActivity.this, "��¼��δ����", Toast.LENGTH_SHORT).show();
				}
				Toast.makeText(MainActivity.this, "��½�ɹ�", Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(MainActivity.this, "��¼ʧ��", Toast.LENGTH_SHORT).show();
			}
						
			break;

		case R.id.cancel:
			
			break;
		}
	}

}
