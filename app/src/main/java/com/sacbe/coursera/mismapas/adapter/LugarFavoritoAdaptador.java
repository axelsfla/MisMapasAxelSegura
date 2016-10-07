package com.sacbe.coursera.mismapas.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.sacbe.coursera.mismapas.MainActivity;
import com.sacbe.coursera.mismapas.MapsActivity;
import com.sacbe.coursera.mismapas.R;
import com.sacbe.coursera.mismapas.pojo.LugarFavorito;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by axel on 07/10/2016.
 */

public class LugarFavoritoAdaptador extends  RecyclerView.Adapter<LugarFavoritoAdaptador.LugarFavoritoViewHolder> {
    private ArrayList<LugarFavorito> lugaresFavoritos;
    private Activity activity;

    public LugarFavoritoAdaptador(ArrayList<LugarFavorito> lugaresFavoritos, Activity activity){
        this.lugaresFavoritos=lugaresFavoritos;
        this.activity=activity;
    }

    //Inflar el layout y lo pasará al view holder para obtener los views
    @Override
    public LugarFavoritoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_foto_lugarFavorito, parent, false);
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_lugares_favoritos, parent, false);
        return new LugarFavoritoViewHolder(v);
    }

    //asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final LugarFavoritoViewHolder lugarFavoritoViewHolder, int position) {
        final LugarFavorito lugarFavorito  = lugaresFavoritos.get(position);
        lugarFavoritoViewHolder.imgLugarFavoritoCV.setImageResource(lugarFavorito.getFoto());

        /*
            Picasso.with(activity)
                .load(LugarFavorito.getUrlFoto())
                .placeholder(R.drawable.unam_pumas)
                .into(lugarFavoritoViewHolder.imgLugarFavoritoCVFrg);
        */

        lugarFavoritoViewHolder.tvNombreCV.setText(String.valueOf(lugarFavorito.getNombre()));

        lugarFavoritoViewHolder.imgLugarFavoritoCV.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                //Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, MapsActivity.class);
                intent.putExtra(activity.getResources().getString(R.string.pNombre), lugarFavorito.getNombre());
                intent.putExtra(activity.getResources().getString(R.string.pFoto), lugarFavorito.getFoto());
                intent.putExtra(activity.getResources().getString(R.string.pLatitud), lugarFavorito.getLatitud());
                intent.putExtra(activity.getResources().getString(R.string.pLongitud), lugarFavorito.getLongitud());
                intent.putExtra(activity.getResources().getString(R.string.pMarcador), lugarFavorito.getMarcador());
                activity.startActivity(intent);
                //activity.finish();
            }
        });

    }

    public int getItemCount() {//Cantidad de elementos que contiene la lista
        return lugaresFavoritos.size();
    }

    public static class LugarFavoritoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgLugarFavoritoCV;
        private TextView tvNombreCV;

        public LugarFavoritoViewHolder(View itemView) {
            super(itemView);
            imgLugarFavoritoCV = (ImageView) itemView.findViewById(R.id.imgLugarFavoritoCV);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
        }
    }
}
