package com.example.pablosanjuan.core;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;


public class RegistrarVacuna1 extends ActionBarActivity {
    private EditText edt_id;
    private EditText edt_nombre;
    private String var_fecha="";
    private Button btn_fecha;
    private int year, month, day;
    private Calendar calendar;
    private String[] datos=new String[2];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_vacuna1);
        edt_id=(EditText)findViewById(R.id.edt_id_pv);
        edt_nombre=(EditText)findViewById(R.id.edt_nombre_pv);
        btn_fecha=(Button)findViewById(R.id.btn_fecha_pv);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_fecha_pv:
                showDialog(999);
                break;
            case R.id.btn_siguiente_pv:
                Intent intent=new Intent(this,RegistrarVacuna2.class);
                datos[0]=edt_id.getText().toString();
                datos[1]=var_fecha;
                if(!datos[0].equals("")&&!datos[1].equals("")){
                    intent.putExtra("datos",datos);
                    startActivity(intent);
                }else{
                    Toast.makeText(this,"Verifique los campos",Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }


    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            DatePickerDialog dialogDate = new DatePickerDialog(this, myDateListener, year, month, day);
            dialogDate.getDatePicker().setMaxDate(new Date().getTime());
            return dialogDate;
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1, arg2 + 1, arg3);
        }
    };

    private void showDate(int year, int month, int day) {
        var_fecha = (new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year)).toString();
        btn_fecha.setText(var_fecha);
    }

}
