package com.example.testsqlite;

import android.graphics.drawable.Drawable;

public class DBInfo {

	public static class DB {
		/**
		 * ���ݿ�����
		 */
		public static final String DB_NAME = "voicenotes";

		/**
		 * ���ݿ�汾
		 */
		public static final int DB_VERSION = 1;

	}

	public static class Table {
		/**
		 * ¼����¼������
		 */
		public static final String VoiceNOTES_TABLE = "voicenotes_info";

		public static final String _ID = "_id"; // ����
		public static final String _NOTES_DATETIME = "notes_datetime"; // ¼��ʱ��
		public static final String _NOTESFILE_PATH = "notesfile_path";
		public static final String _REMINDER_DATE = "reminder_date";
		public static final String _REMINDER_TIME = "reminder_time";
		public static final String _REMINDER_TEXT = "reminder_text";
		public static final String _REMINDER_LOCATION = "reminder_location";
		public static final String _REMINDER_PHOTO = "reminder_photo";

		public static final String CREATE_NOTES_TABLE = "create table if not exist "
				+ VoiceNOTES_TABLE
				+ "("
				+ _ID
				+ " integer primary key autoincrement, "
				+ _NOTES_DATETIME
				+ " text, "
				+ _NOTESFILE_PATH
				+ " text, "
				+ _REMINDER_DATE
				+ " text, "
				+ _REMINDER_TIME
				+ " text, "
				+ _REMINDER_TEXT
				+ " text, "
				+ _REMINDER_LOCATION
				+ " text, "
				+ _REMINDER_PHOTO
				+ " BLOB ) ;";

		//ɾ����ռ�
		public static final String DROP_NOTES_TABLE = "drop table " +VoiceNOTES_TABLE;
		
		
	}
}
