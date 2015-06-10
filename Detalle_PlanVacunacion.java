package com.example.pablosanjuan.core;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.pablosanjuan.core.db.DbManager_vacunas;
import com.example.pablosanjuan.core.vo.VacunaVO;

import java.util.ArrayList;
import java.util.List;


public class Detalle_PlanVacunacion extends ActionBarActivity {
    private ListView listView;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle__plan_vacunacion);
        listView=(ListView)findViewById(R.id.listViewDetallesPV);
        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            id=bundle.getString("id");
        }
        try{
            List<VacunaVO> vacunas=new DbManager_vacunas(this).getRegistrosByIdBovino(id);
            ArrayList<String> datos=new ArrayList<>();
            if(vacunas!=null){
                for(int i=0;i<vacunas.size();i++){
                    VacunaVO vacu=vacunas.get(i);
                    datos.add(""+vacu.getNombreVacuna());

                }
                listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,datos));
            }

        }catch (Exception e){}

    }




}
