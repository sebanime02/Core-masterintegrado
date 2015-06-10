package com.example.pablosanjuan.core.adapters;

/**
 * Created by Pablo Sanjuan on 29/05/2015.
 */

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.pablosanjuan.core.R;
import com.example.pablosanjuan.core.vo.RegReproductivoVO;

import java.util.ArrayList;
import java.util.List;

public class AdapterRegReporductivo extends BaseAdapter {

    private List<RegReproductivoVO> listaReproductivoVOs;
    private LayoutInflater layoutInflater;


    public AdapterRegReporductivo(Activity a, List<RegReproductivoVO> listaReproductivoVOs) {
        super();
        this.listaReproductivoVOs = new ArrayList<RegReproductivoVO>();
        if (listaReproductivoVOs != null){
            this.listaReproductivoVOs = listaReproductivoVOs;
        }
        layoutInflater = a.getLayoutInflater();
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listaReproductivoVOs.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return listaReproductivoVOs.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        // TODO Auto-generated method stub

        view = layoutInflater.inflate(R.layout.elemento_reg_reproductivo, null);

        String id = listaReproductivoVOs.get(position).getId_Bovinos();
        //String foto = listaReproductivoVOs.get(position).getFoto();
        String nombre = listaReproductivoVOs.get(position).getNombre();
        String fecha_monte = listaReproductivoVOs.get(position).getFecha_Monte();
        String fecha_parto = listaReproductivoVOs.get(position).getFecha_Parto();

        ImageView foto_bov = (ImageView) view.findViewById(R.id.foto_perfil_bovino);
        TextView tv_registro1 = (TextView) view.findViewById(R.id.registro1);
        TextView tv_registro2 = (TextView) view.findViewById(R.id.registro2);
        TextView tv_registro3 = (TextView) view.findViewById(R.id.registro3);
        TextView tv_registro4 = (TextView) view.findViewById(R.id.registro4);


        //foto_bov.setImageURI(Uri.parse(foto));
        tv_registro1.setText("Id: "+id);
        tv_registro2.setText("nombre: "+nombre);
        tv_registro3.setText("fecha_monte: "+fecha_monte);
        tv_registro4.setText("fecha_parto: "+fecha_parto);

        return view;
    }
}
