package com.example.pablosanjuan.core;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;


public class IngresarRegReporductivo1 extends ActionBarActivity implements View.OnClickListener {

    private String[] reg_repro;
    private ImageButton foto;
    private EditText edt_id_bovino, edt_nombre_bovino, ed_peso_reg_repro, ed_edad_reg_repro, ed_cond_corporal;
    private Button btn_siguiente_reg_repro, btn_fecha_monta;
    private String var_fecha="";
    private Calendar calendar;
    private int year, month, day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingresarregreporductivo1);

        edt_id_bovino = (EditText) findViewById(R.id.edt_id_bovino_reg_repro);
        edt_nombre_bovino = (EditText) findViewById(R.id.edt_nombre_bovino_reg_repro);

        ed_peso_reg_repro = (EditText) findViewById(R.id.ed_peso_reg_repro);
        ed_edad_reg_repro = (EditText) findViewById(R.id.ed_edad_reg_repro);
        ed_cond_corporal = (EditText) findViewById(R.id.ed_cond_corporal);

        btn_siguiente_reg_repro = (Button) findViewById(R.id.btn_siguiente_reg_repro);
        btn_fecha_monta = (Button) findViewById(R.id.btn_fecha_monta);
        btn_fecha_monta.setOnClickListener(this);
        btn_siguiente_reg_repro.setOnClickListener(this);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        Typeface font = Typeface.createFromAsset(getAssets(), "Avgardn.ttf");
        btn_siguiente_reg_repro.setTypeface(font);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_siguiente_reg_repro:

                if(validar(edt_id_bovino.getText().toString(),edt_nombre_bovino.getText().toString(),ed_peso_reg_repro.getText().toString(),ed_edad_reg_repro.getText().toString(),ed_cond_corporal.getText().toString())==false){
                    Toast.makeText(this, "Debe Llenar Todos Los Campos y Elegir una Foto", Toast.LENGTH_LONG).show();
                }else {
                    reg_repro = new String[7];
                    Intent ir_reg = new Intent(this, IngresarRegReporductivo2.class);

                    reg_repro[0] = edt_id_bovino.getText().toString();
                    reg_repro[1] = "nombre_foto";
                    reg_repro[2] = edt_nombre_bovino.getText().toString();;
                    reg_repro[3] = var_fecha;
                    reg_repro[4] = ed_peso_reg_repro.getText().toString();
                    reg_repro[5] = ed_edad_reg_repro.getText().toString();
                    reg_repro[6] = ed_cond_corporal.getText().toString();

                    ir_reg.putExtra("reg_repro", reg_repro);
                    startActivity(ir_reg);
                }
            break;
            case R.id.btn_fecha_monta:
                showDialog(999);
                break;
        }
    }
    public Boolean validar(String id, String nombre, String fecha_monta, String peso, String condi) {
        if (id.equals("") || nombre.equals("") || fecha_monta.equals("") || peso.equals("") || condi.equals("")) {
            return false;
        }else {
            return true;
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
        btn_fecha_monta.setText(var_fecha);
    }
}
