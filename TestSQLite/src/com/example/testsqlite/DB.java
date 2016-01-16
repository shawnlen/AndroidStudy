package com.example.testsqlite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper {

	/**
	 * @param context
	 * @param name
	 *            :���ݿ�����
	 * @param factory
	 *            ���α깤��
	 * @param version
	 *            �����ݿ�汾
	 */
	public DB(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	public DB(Context context) {
		this(context, DBInfo.DB.DB_NAME, null, DBInfo.DB.DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(DBInfo.Table.CREATE_NOTES_TABLE);
	}

	/**
	 * �������ݿ�
	 * 
	 * @param db
	 * @param oldVersion
	 * @param newVersion
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL(DBInfo.Table.DROP_NOTES_TABLE); // ɾ����Ӧ���ȱ��ݣ�

		onCreate(db); // ���´���
	}

}
