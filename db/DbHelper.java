package com.example.pablosanjuan.core.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper{

	private static final String DB_NAME = "dbbovi2.sqlite";
	private static final int DB_VERSION = 1;
	
	public DbHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
        db.execSQL(DbManager_inventario.CREATE_TABLE);
        db.execSQL(DbManager_usuario.CREATE_TABLE);
        db.execSQL(DbManagerRegReproductivo.CREATE_TABLE);
		db.execSQL(DbManager_vacunas.CREATE_TABLE);
		db.execSQL(DbManager_control.CREATE_TABLE);

		db.execSQL(DbManager_manejo.CREATE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}
}
