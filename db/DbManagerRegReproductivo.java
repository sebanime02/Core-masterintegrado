package com.example.pablosanjuan.core.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.pablosanjuan.core.vo.RegReproductivoVO;
import java.util.ArrayList;
import java.util.List;

public class DbManagerRegReproductivo {

    public static final String TABLE_NAME = "RegReproductivo";
    public static final String ID = "_id";
    public static final String ID_BOVINO = "id_bovino";
    public static final String NOMBRE = "Nombre";
    public static final String FECHA_MONTE = "FechaMonte";
    public static final String PESO = "Peso";
    public static final String EDAD = "Edad";
    public static final String COND_CORPORAL = "ConCorporal";
    public static final String EMPADRE = "Empadre";
    public static final String NUM_PAJILLA = "NumPajilla";
    public static final String RAZA_ANIMAL = "RazaAnimal";
    public static final String PROCEDENCIA = "Procedencia";
    public static final String ID_REPRODUCTOR = "IdReproductor";
    public static final String DIAG_PRENEZ = "DiagPrenez";
    public static final String FECHA_POSIBLE_PARTO = "FechaPosibleParto";
    public static final String FECHA_PARTO = "FechaParto";
    public static final String NUM_PARTO = "NumParto";
    public static final String CRIA = "Cria";
    public static final String INTERVALO_ENTE_PARTOS = "IntervalEntrePartos";
    public static final String DIAS_VACIOS = "DiasVacios";
    public static final String DIAS_LACTANCIA = "DiasLactancia";

    public static final String CREATE_TABLE = "create table " +TABLE_NAME+ " ("
            + ID + " integer primary key autoincrement,"
            + ID_BOVINO + " text not null,"
            + NOMBRE + " text not null,"
            + FECHA_MONTE  + " text not null,"
            + PESO  + " text not null,"
            + EDAD + " text not null,"
            + COND_CORPORAL + " text not null,"
            + EMPADRE  + " text not null,"
            + NUM_PAJILLA + " text not null,"
            + RAZA_ANIMAL + " text not null,"
            + PROCEDENCIA + " text not null,"
            + ID_REPRODUCTOR + " text not null,"
            + DIAG_PRENEZ + " text not null,"
            + FECHA_POSIBLE_PARTO + " text not null,"
            + FECHA_PARTO + " text not null,"
            + NUM_PARTO + " text not null,"
            + CRIA + " text not null,"
            + INTERVALO_ENTE_PARTOS + " text not null,"
            + DIAS_VACIOS + " text not null,"
            + DIAS_LACTANCIA + " text not null);";


    private DbHelper helper;
    private SQLiteDatabase db;
    private Cursor dbCursor;

    public DbManagerRegReproductivo(Context context){
        helper = new DbHelper(context);
        db = helper.getWritableDatabase();
    }

    public ContentValues generarContentValues (String id_bovinos, String nombre, String fecha_monte, String peso, String edad, String cond_corporal, String empadre,
                                               String num_pajilla, String raza_animal, String procedencia, String id_reproductor, String diag_prenez, String fecha_pos_parto,
                                               String fecha_parto, String num_parto, String cria, String inter_entre_partos, String dias_vacios, String dias_lactancia ){
        ContentValues valores = new ContentValues();
        valores.put(ID_BOVINO, id_bovinos);
        valores.put(NOMBRE, nombre);
        valores.put(FECHA_MONTE , fecha_monte);
        valores.put(PESO , peso);
        valores.put(EDAD, edad);
        valores.put(COND_CORPORAL, cond_corporal);
        valores.put(EMPADRE , empadre);
        valores.put(NUM_PAJILLA, num_pajilla);
        valores.put(RAZA_ANIMAL, raza_animal);
        valores.put(PROCEDENCIA, procedencia);
        valores.put(ID_REPRODUCTOR, id_reproductor);
        valores.put(DIAG_PRENEZ, diag_prenez);
        valores.put(FECHA_POSIBLE_PARTO, fecha_pos_parto);
        valores.put(FECHA_PARTO, fecha_parto);
        valores.put(NUM_PARTO, num_parto);
        valores.put(CRIA, cria);
        valores.put(INTERVALO_ENTE_PARTOS, inter_entre_partos);
        valores.put(DIAS_VACIOS , dias_vacios);
        valores.put(DIAS_LACTANCIA , dias_lactancia);
        return valores;
    }

    public void insertar (String id_bovinos, String nombre, String fecha_monte, String peso, String edad, String cond_corporal, String empadre,
                          String num_pajilla, String raza_animal, String procedencia, String id_reproductor, String diag_prenez, String fecha_pos_parto,
                          String fecha_parto, String num_parto, String cria, String inter_entre_partos, String dias_vacios, String dias_lactancia ){

        db.insert(TABLE_NAME, null, generarContentValues(id_bovinos, nombre, fecha_monte, peso, edad, cond_corporal, empadre, num_pajilla, raza_animal,
                                    procedencia,id_reproductor,diag_prenez,fecha_pos_parto,fecha_parto,num_parto,cria,inter_entre_partos,dias_vacios,dias_lactancia));
    }

    public Cursor cargarCursorRegistro(){
        String[] columnas = new String[]{ID_BOVINO,NOMBRE,FECHA_MONTE ,PESO ,EDAD,COND_CORPORAL,EMPADRE ,NUM_PAJILLA,RAZA_ANIMAL,PROCEDENCIA,ID_REPRODUCTOR,DIAG_PRENEZ,FECHA_POSIBLE_PARTO,FECHA_PARTO,NUM_PARTO,CRIA,INTERVALO_ENTE_PARTOS,DIAS_VACIOS,DIAS_LACTANCIA};
        return db.query(TABLE_NAME, columnas, null, null, null, null, null);
    }

    public List<RegReproductivoVO> getRegistros() {
        List<RegReproductivoVO> listaRegistros = null;
        String[] columnas = new String[]{ID_BOVINO,NOMBRE,FECHA_MONTE ,PESO ,EDAD,COND_CORPORAL,EMPADRE ,NUM_PAJILLA,RAZA_ANIMAL,PROCEDENCIA,ID_REPRODUCTOR,DIAG_PRENEZ,FECHA_POSIBLE_PARTO,FECHA_PARTO,NUM_PARTO,CRIA,INTERVALO_ENTE_PARTOS,DIAS_VACIOS,DIAS_LACTANCIA};
        dbCursor = db.query(TABLE_NAME, columnas, null, null, null, null, null);
        if (dbCursor.getCount() > 0) {
            listaRegistros = new ArrayList<RegReproductivoVO>();
            dbCursor.moveToFirst();
            while (!dbCursor.isAfterLast()) {
                RegReproductivoVO registro = new RegReproductivoVO();
                registro.setId_Bovinos(dbCursor.getString(0));
                registro.setNombre(dbCursor.getString(1));
                registro.setFecha_Monte(dbCursor.getString(2));
                registro.setPeso(dbCursor.getString(3));
                registro.setEdad(dbCursor.getString(4));
                registro.setCond_Corporal(dbCursor.getString(5));
                registro.setEmpadre(dbCursor.getString(6));
                registro.setNum_Pajilla(dbCursor.getString(7));
                registro.setRaza_Animal(dbCursor.getString(8));
                registro.setProcedencia(dbCursor.getString(9));
                registro.setId_Reproductor(dbCursor.getString(10));
                registro.setDiag_Prenez(dbCursor.getString(11));
                registro.setFecha_Pos_Parto(dbCursor.getString(12));
                registro.setFecha_Parto(dbCursor.getString(13));
                registro.setNum_Parto(dbCursor.getString(14));
                registro.setCria(dbCursor.getString(15));
                registro.setInter_Entre_Partos(dbCursor.getString(16));
                registro.setDias_Vacios(dbCursor.getString(17));
                registro.setDias_Lactancia(dbCursor.getString(18));
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
