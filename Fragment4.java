package com.example.pablosanjuan.core;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.pablosanjuan.core.adapters.planVacunacion.AdapterPlanVacu;
import com.example.pablosanjuan.core.db.DbManager_inventario;
import com.example.pablosanjuan.core.vo.InventarioVO;

import java.util.List;

/**
 * Created by Pablo Sanjuan on 28/05/2015.
 */
public class Fragment4 extends Fragment {
    ListView lista;
    AdapterPlanVacu adapter;
    DbManager_inventario manager;
    private List<InventarioVO> listaRegistros;
    private com.melnykov.fab.FloatingActionButton floatingActionButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment4, container, false);
        floatingActionButton=(com.melnykov.fab.FloatingActionButton)rootView.findViewById(R.id.fabPlanVacu);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ir = new Intent(getActivity(), RegistrarVacuna1.class);
                startActivity(ir);

            }
        });
        lista = (ListView) rootView.findViewById(R.id.listViewPlanVacunas);

        return rootView;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listaRegistros = new DbManager_inventario(getActivity()).getRegistros();
        adapter =  new AdapterPlanVacu(getActivity(), listaRegistros);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getActivity(),Detalle_PlanVacunacion.class);
                intent.putExtra("id",""+l);
                startActivity(intent);
            }
        });

    }



}