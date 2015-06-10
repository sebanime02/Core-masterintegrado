package com.example.pablosanjuan.core;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;


public class IngresarRegReporductivo2 extends ActionBarActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private Button btn_atras, btn_sigte;
    private String[] reg_repro, reg_repro2;
    private RadioGroup rdgGrupo;
    private String var_empadre;
    private EditText num_pajilla, raza, procedencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingresarregreporductivo2);
        Bundle bundl=getIntent().getExtras();

        btn_atras = (Button) findViewById(R.id.btn_atras_ing_rep_2);
        btn_sigte = (Button) findViewById(R.id.btn_siguiente_ing_rep_2);
        rdgGrupo = (RadioGroup) findViewById(R.id.rdgGrupo_empadre);
        num_pajilla = (EditText) findViewById(R.id.num_pajilla);
        raza = (EditText) findViewById(R.id.raza_animlal);
        procedencia = (EditText) findViewById(R.id.procedencia);

        btn_atras.setOnClickListener(this);
        btn_sigte.setOnClickListener(this);
        rdgGrupo.setOnCheckedChangeListener(this);
        Typeface font = Typeface.createFromAsset(getAssets(), "Avgardn.ttf");
        btn_atras.setTypeface(font);
        btn_sigte.setTypeface(font);

        if(bundl!=null){
            reg_repro= bundl.getStringArray("reg_repro");
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_siguiente_ing_rep_2:
                if (validar(num_pajilla.getText().toString(), raza.getText().toString(), procedencia.getText().toString(), var_empadre) == false) {
                    Toast.makeText(this, "Debe Llenar Todos Los Campos y elegir un empadre", Toast.LENGTH_LONG).show();
                } else {

                    reg_repro2 = new String[11];
                    reg_repro2[0] = reg_repro[0];
                    reg_repro2[1] = reg_repro[1];
                    reg_repro2[2] = reg_repro[2];
                    reg_repro2[3] = reg_repro[3];
                    reg_repro2[4] = reg_repro[4];
                    reg_repro2[5] = reg_repro[5];
                    reg_repro2[6] = reg_repro[6];
                    reg_repro2[7] = var_empadre;
                    reg_repro2[8] = num_pajilla.getText().toString();
                    reg_repro2[9] = raza.getText().toString();
                    reg_repro2[10] = procedencia.getText().toString();
                    Intent ir_reg2 = new Intent(this, IngresarRegReporductivo3.class);
                    ir_reg2.putExtra("reg_repro2", reg_repro2);
                    startActivity(ir_reg2);
                }
                break;
            case R.id.btn_atras_ing_rep_2:
                Intent ir_reg_atras2 = new Intent(this, IngresarRegReporductivo1.class);
                startActivity(ir_reg_atras2);
                break;
        }
    }

    public Boolean validar(String pajilla, String raza, String procedencia, String empadre) {
        if (pajilla.equals("") || raza.equals("") || raza.equals("") || procedencia.equals("") || empadre.equals("")) {
            return false;
        }else {
            return true;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        // TODO Auto-generated method stub
        if (checkedId == R.id.rdgMontaNatural) {
            var_empadre = "Monta Natural";
        } else if (checkedId == R.id.rdgInseminacion) {
            var_empadre = "Inseminacion Artificial";
        }
    }
}