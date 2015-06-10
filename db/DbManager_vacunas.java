package com.example.pablosanjuan.core.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pablosanjuan.core.vo.VacunaVO;

import java.util.ArrayList;
import java.util.List;

public class DbManager_vacunas {

	public static final String TABLE_NAME = "vacuna";
	public static final String ID = "_id";
    public static final String ID_BOVINO = "IdBovino";
	public static final String FECHA_VACUNACION = "Fecha_vacunacion";
	public static final String NOMBRE_VACUNA = "Nombre_vacuna";
    public static final String DOSIS_VACUNA = "Dosis_vacuna";
    public static final String VIA_ADMI_VACUNA = "Via_admi_Vacuna";


	public static final String CREATE_TABLE = "create table " +TABLE_NAME+ " ("
            + ID + " integer primary key autoincrement,"
            + ID_BOVINO + " text not null,"
            + FECHA_VACUNACION + " text not null,"
			+ NOMBRE_VACUNA + " text not null,"
			+ DOSIS_VACUNA + " text not null,"
			+ VIA_ADMI_VACUNA + " text not null);";

	private DbHelper helper;
	private SQLiteDatabase db;
	private Cursor dbCursor;

	public DbManager_vacunas(Context context){
		helper = new DbHelper(context);
		db = helper.getWritableDatabase();
	}
	
	public ContentValues generarContentValues (String idBovino, String fecha, String nombrevacuna, String dosisVacuna, String viaVacuna){
		ContentValues valores = new ContentValues();
        valores.put(ID_BOVINO, idBovino);
        valores.put(FECHA_VACUNACION, fecha);
        valores.put(NOMBRE_VACUNA, nombrevacuna);
		valores.put(DOSIS_VACUNA, dosisVacuna);
		valores.put(VIA_ADMI_VACUNA,viaVacuna);
		return valores;
	}
	
	public void inserta(String idBovino, String fecha, String nombrevacuna, String dosisVacuna, String viaVacuna){

        db.insert(TABLE_NAME, null, generarContentValues(idBovino, fecha, nombrevacuna, dosisVacuna, viaVacuna));
	}
	
	public Cursor cargarCursorRegistro(){
		String[] columnas = new String[]{ID_BOVINO,FECHA_VACUNACION,NOMBRE_VACUNA,DOSIS_VACUNA,VIA_ADMI_VACUNA};
		return db.query(TABLE_NAME, columnas, null, null, null, null, null);
	}
	public List<VacunaVO> getRegistrosByIdBovino(String id) {
		List<VacunaVO> listaRegistros = null;
		String[] columnas = new String[]{ID,ID_BOVINO,FECHA_VACUNACION,NOMBRE_VACUNA,DOSIS_VACUNA,VIA_ADMI_VACUNA};
		dbCursor = db.query(TABLE_NAME, columnas, ID_BOVINO+"='"+id+"'", null, null, null, null);
		if (dbCursor.getCount() > 0) {
			listaRegistros = new ArrayList<VacunaVO>();
			dbCursor.moveToFirst();
			while (!dbCursor.isAfterLast()) {
				VacunaVO registro = new VacunaVO();
				registro.setId((dbCursor.getString(0)));
				registro.setIdBovino((dbCursor.getString(1)));
				registro.setFechaVacunacion(dbCursor.getString(2));
				registro.setNombreVacuna(dbCursor.getString(3));
				registro.setDosisvacuna(dbCursor.getString(4));
				registro.setViaAdmivacuna(dbCursor.getString(5));
				listaRegistros.add(registro);
				dbCursor.moveToNext();
			}
		}
		dbCursor.close();
		return listaRegistros;
	}

	public List<VacunaVO> getRegistros() {
		List<VacunaVO> listaRegistros = null;
		String[] columnas = new String[]{ID,ID_BOVINO,FECHA_VACUNACION,NOMBRE_VACUNA,DOSIS_VACUNA,VIA_ADMI_VACUNA};
		dbCursor = db.query(TABLE_NAME, columnas, null, null, null, null, null);
		if (dbCursor.getCount() > 0) {
			listaRegistros = new ArrayList<VacunaVO>();
			dbCursor.moveToFirst();
			while (!dbCursor.isAfterLast()) {
				VacunaVO registro = new VacunaVO();
				registro.setId((dbCursor.getString(0)));
				registro.setIdBovino((dbCursor.getString(1)));
				registro.setFechaVacunacion(dbCursor.getString(2));
				registro.setNombreVacuna(dbCursor.getString(3));
				registro.setDosisvacuna(dbCursor.getString(4));
				registro.setViaAdmivacuna(dbCursor.getString(5));
				listaRegistros.add(registro);
				dbCursor.moveToNext();
			}
		}
		dbCursor.close();
		return listaRegistros;
	}
	public void borrarRegistros(){
		db.delete(TABLE_NAME, null, null);
	}
    }
