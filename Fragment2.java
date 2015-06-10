package com.example.pablosanjuan.core;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pablosanjuan.core.adapters.AdapterInventario;
import com.example.pablosanjuan.core.adapters.AdapterRegReporductivo;
import com.example.pablosanjuan.core.adapters.MyAdapter_usuario;
import com.example.pablosanjuan.core.db.DbManagerRegReproductivo;
import com.example.pablosanjuan.core.db.DbManager_inventario;
import com.example.pablosanjuan.core.db.DbManager_usuario;
import com.example.pablosanjuan.core.vo.InventarioVO;
import com.example.pablosanjuan.core.vo.RegReproductivoVO;
import com.example.pablosanjuan.core.vo.UsuarioVO;

import java.util.List;

/**
 * Created by Pablo Sanjuan on 28/05/2015.
 */
public class Fragment2 extends Fragment implements View.OnClickListener {

    private Button btn_add_registo, b_borrar_reg_repro;
    ListView lista;
    AdapterRegReporductivo adapter;
    DbManagerRegReproductivo manager1;
    private List<RegReproductivoVO> listaRegistros;
    TextView info;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment2, container, false);

        info = (TextView) rootView.findViewById(R.id.info_reproductivo);
        manager1 = new DbManagerRegReproductivo(getActivity());
        lista = (ListView) rootView.findViewById(R.id.lista_frag2);
        listaRegistros = manager1.getRegistros();
        adapter = new AdapterRegReporductivo(getActivity(), listaRegistros);
        lista.setAdapter(adapter);
        btn_add_registo = (Button) rootView.findViewById(R.id.btn_add_reg_reproductivo);
        b_borrar_reg_repro = (Button) rootView.findViewById(R.id.btn_borrar_reg_repro);
        btn_add_registo.setOnClickListener(this);
        b_borrar_reg_repro.setOnClickListener(this);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "Avgardn.ttf");
        btn_add_registo.setTypeface(font);
        b_borrar_reg_repro.setTypeface(font);
        info.setTypeface(font);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add_reg_reproductivo:
                Intent intent = new Intent(getActivity(), IngresarRegReporductivo1.class);
                startActivity(intent);
                break;

            case R.id.btn_borrar_reg_repro:
                manager1.borrarRegistros();
                break;
        }
    }
}