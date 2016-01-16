package com.example.testsqlite;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.sql.SQLData;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class VoiceNotesDao {

	private DB dbHelper = null;
	private SQLiteDatabase db = null;
	private ContentValues contentValues;

	public VoiceNotesDao(Context context) {
		dbHelper = new DB(context);
	}

	// ���루������
	public long insertVoiceNotes(VoiceNotes voiceNotes) {

		db = dbHelper.getWritableDatabase(); // ���SQLiteDatabase

		contentValues = new ContentValues();
		contentValues.put(DBInfo.Table._NOTES_DATETIME, voiceNotes.getId());
		contentValues.put(DBInfo.Table._NOTESFILE_PATH,
				voiceNotes.getNotesfile_path());
		contentValues.put(DBInfo.Table._REMINDER_DATE,
				voiceNotes.getReminder_date());
		contentValues.put(DBInfo.Table._REMINDER_TIME,
				voiceNotes.getReminder_time());
		contentValues.put(DBInfo.Table._REMINDER_TEXT,
				voiceNotes.getReminder_text());
		contentValues.put(DBInfo.Table._REMINDER_LOCATION,
				voiceNotes.getReminder_location());

		// ��ͼƬ���ͽ���һ����ת������,Ȼ����ܴ洢��BLOB������
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		BitmapDrawable bitmapDrawable = (BitmapDrawable) voiceNotes
				.getReminder_photo();
		bitmapDrawable.getBitmap().compress(CompressFormat.PNG, 100,
				outputStream);// ������ѹ����PNG��������
		contentValues.put(DBInfo.Table._REMINDER_PHOTO,
				outputStream.toByteArray());// �洢ͼƬ��������

		long rowID = db.insert(DBInfo.Table.VoiceNOTES_TABLE,
				DBInfo.Table._NOTES_DATETIME, contentValues);// �������ݣ�����һ���к�

		db.close();

		return rowID;
	}

	// ����
	public int updateVoiceNotes(VoiceNotes voiceNotes) {
		return 1;
	}

	// ɾ��
	public long deleteVoiceNotes(String notes_datetime) {
		return 1;
	}

	// ����ĳһ������������¼
	public VoiceNotes findVoiceNoteByNotesDateTime(String notes_datetime) {
		return null;
	}

	// �������е�����������¼
	String[] columns = { DBInfo.Table._ID, DBInfo.Table._NOTES_DATETIME,
			DBInfo.Table._NOTESFILE_PATH, DBInfo.Table._REMINDER_DATE,
			DBInfo.Table._REMINDER_TIME, DBInfo.Table._REMINDER_TEXT,
			DBInfo.Table._REMINDER_LOCATION, DBInfo.Table._REMINDER_PHOTO }; // VoiceNotes�ֶα�

	public List<VoiceNotes> findAllVoiceNotes() {
		db = dbHelper.getReadableDatabase();
		List<VoiceNotes> voiceNotesList = null;
		VoiceNotes voiceNotes = null;

		Cursor cursor = db.query(DBInfo.Table.VoiceNOTES_TABLE, columns, null,
				null, null, null, null);

		if (cursor != null && cursor.getCount() > 0) {
			voiceNotesList = new ArrayList<VoiceNotes>(cursor.getCount());
			while (cursor.moveToNext()) {
				voiceNotes = new VoiceNotes();

				voiceNotes.setId(cursor.getLong(cursor
						.getColumnIndex(DBInfo.Table._ID)));
				voiceNotes.setNotes_datetime(cursor.getString(cursor
						.getColumnIndex(DBInfo.Table._NOTES_DATETIME)));
				voiceNotes.setNotesfile_path(cursor.getString(cursor
						.getColumnIndex(DBInfo.Table._NOTESFILE_PATH)));
				voiceNotes.setReminder_date(cursor.getString(cursor
						.getColumnIndex(DBInfo.Table._REMINDER_DATE)));
				voiceNotes.setReminder_time(cursor.getString(cursor
						.getColumnIndex(DBInfo.Table._REMINDER_TIME)));
				voiceNotes.setReminder_text(cursor.getString(cursor
						.getColumnIndex(DBInfo.Table._REMINDER_TEXT)));
				voiceNotes.setReminder_location(cursor.getString(cursor
						.getColumnIndex(DBInfo.Table._REMINDER_LOCATION)));
				
				//ͼƬ
				byte[] byteReminderPhoto = cursor.getBlob(cursor
						.getColumnIndex(DBInfo.Table._REMINDER_PHOTO));
				ByteArrayInputStream arrayInputStream=new ByteArrayInputStream(byteReminderPhoto);
				Drawable drawable = Drawable.createFromStream(arrayInputStream, "reminder_photo");
				voiceNotes.setReminder_photo(drawable);

				voiceNotesList.add(voiceNotes);
			}
		}
		cursor.close();
		db.close();
		return voiceNotesList;
	}
}
