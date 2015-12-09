package com.example.testdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	private String[] single_list={"��","Ů","δ֪"};
	private String[] multi_list={"����","����","����","ƹ����","��ë��"};
	private String[] item_list={"��Ŀ����","��������ʦ","����","����"};
	private String like="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findViewById(R.id.btnOK).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder builder = new AlertDialog.Builder(
						MainActivity.this);

				builder.setTitle("ȷ�϶Ի���");
				builder.setIcon(R.drawable.ic_launcher);
				builder.setMessage("���ǡ�ȷ�϶Ի��򡱵���ʾ���ݲ��֣�");
				builder.setPositiveButton("ȷ��",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								Toast.makeText(MainActivity.this, "�����ȷ����ť",
										Toast.LENGTH_LONG).show();
							}
						});

				builder.setNegativeButton("ȡ��",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								Toast.makeText(MainActivity.this, "�����ȡ����ť",
										Toast.LENGTH_LONG).show();
							}
						});

				AlertDialog dialog = builder.create();
				dialog.show();
			}
		});

		findViewById(R.id.btnSingle).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder builder = new AlertDialog.Builder(
						MainActivity.this);

				builder.setTitle("��ѡ�Ի��򡪡��Ա�");
				builder.setIcon(R.drawable.ic_launcher);

				builder.setSingleChoiceItems(single_list, 0, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						String str=single_list[which];
						Toast.makeText(MainActivity.this, "��ѡ����Ա��ǣ�"+str	, Toast.LENGTH_LONG).show();
						
					}
				});	
				
				AlertDialog dialog = builder.create();
				dialog.show();
			}
		});
		
		
		findViewById(R.id.btnMulti).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder builder = new AlertDialog.Builder(
						MainActivity.this);

				builder.setTitle("��ѡ�Ի��򡪡�����");
				builder.setIcon(R.drawable.ic_launcher);

				builder.setMultiChoiceItems(multi_list,null,new DialogInterface.OnMultiChoiceClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which, boolean isChecked) {
						// TODO Auto-generated method stub
						if(isChecked){
							like+=multi_list[which];
							like+=",";
							Toast.makeText(MainActivity.this, "��ѡ����"+multi_list[which], Toast.LENGTH_SHORT).show();
						}
						else{
							Toast.makeText(MainActivity.this, "��ȡ����"+multi_list[which], Toast.LENGTH_SHORT).show();
						}
					}
				});
				
				builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this, "���İ����У�"+like, Toast.LENGTH_SHORT).show();
					}
				});
				
				builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.dismiss();
					}
				});
				
				AlertDialog dialog = builder.create();
				dialog.show();
			}
		});
	
		findViewById(R.id.btnList).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder builder = new AlertDialog.Builder(
						MainActivity.this);

				builder.setTitle("�б�Ի��򡪡�����");
				builder.setIcon(R.drawable.ic_launcher);

				builder.setItems(item_list, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity.this, "���ǣ�"+item_list[which], Toast.LENGTH_SHORT).show();
					}
				});
				
				AlertDialog dialog = builder.create();
				dialog.show();
			}
		});
		
		
		findViewById(R.id.btnSelf).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				//��ȡ�Զ���ĶԻ��򲼾֣���ת����View����
				LayoutInflater inflater=LayoutInflater.from(MainActivity.this);
				View view_dialog=inflater.inflate(R.layout.dialog_layout, null);
				
				AlertDialog.Builder builder = new AlertDialog.Builder(
						MainActivity.this);

				builder.setTitle("�Զ���Ի���");
				builder.setIcon(R.drawable.ic_launcher);
				
				builder.setView(view_dialog);   //���ò��֣��ѻ�ȡ���Զ��岼�ִ���ȥ
							
				
				AlertDialog dialog = builder.create();
				dialog.show();
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
