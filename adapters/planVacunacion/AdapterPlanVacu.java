package com.example.pablosanjuan.core.adapters.planVacunacion;

/**
 * Created by Pablo Sanjuan on 29/05/2015.
 */

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.pablosanjuan.core.R;
import com.example.pablosanjuan.core.db.DbManager_vacunas;
import com.example.pablosanjuan.core.vo.InventarioVO;
import com.example.pablosanjuan.core.vo.VacunaVO;

import java.util.ArrayList;
import java.util.List;

public class AdapterPlanVacu extends BaseAdapter {

    private List<InventarioVO> listaInventarioVOs;
    private LayoutInflater layoutInflater;
    Activity a;


    public AdapterPlanVacu(Activity a, List<InventarioVO> listaInventarioVOs) {
        super();
        this.listaInventarioVOs = new ArrayList<InventarioVO>();
        if (listaInventarioVOs != null){
            this.listaInventarioVOs = listaInventarioVOs;
        }
        layoutInflater = a.getLayoutInflater();
        this.a=a;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listaInventarioVOs.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return listaInventarioVOs.get(arg0);
    }

    @Override
    public long getItemId(int i) {
        return Long.parseLong(listaInventarioVOs.get(i).getId());
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        // TODO Auto-generated method stub

        view = layoutInflater.inflate(R.layout.elemento_planvacu, null);

        String id = listaInventarioVOs.get(position).getId();
        String foto = listaInventarioVOs.get(position).getFoto();
        String nombre = listaInventarioVOs.get(position).getNombre();
        String fecha = listaInventarioVOs.get(position).getFecha();

        ImageView foto_bov = (ImageView) view.findViewById(R.id.imgPlanVacu);
        TextView tv_registro1 = (TextView) view.findViewById(R.id.idPlanVacu);
        TextView tv_registro2 = (TextView) view.findViewById(R.id.nomPlanVacu);
        TextView tv_registro3 = (TextView) view.findViewById(R.id.edadPlanVacu);
        TextView tv_vacu = (TextView) view.findViewById(R.id.vacunasPlanVacu);


        foto_bov.setImageURI(Uri.parse(foto));
        tv_registro1.setText("Id: " + id);
        tv_registro2.setText("Nombre: "+nombre);
        tv_registro3.setText("Fecha Nacimiento: "+fecha);
        try{
            List<VacunaVO> vacunas=new DbManager_vacunas(a).getRegistrosByIdBovino(id);

            if(vacunas!=null){
                for(int i=0;i<vacunas.size();i++){
                    VacunaVO vacu=vacunas.get(i);

                    tv_vacu.setText(tv_vacu.getText()+vacu.getNombreVacuna()+"\n");

                }

            }

        }catch (Exception e){}


        return view;
    }
}
