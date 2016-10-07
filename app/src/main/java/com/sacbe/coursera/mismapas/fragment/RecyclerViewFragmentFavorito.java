package com.sacbe.coursera.mismapas.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sacbe.coursera.mismapas.R;
import com.sacbe.coursera.mismapas.adapter.LugarFavoritoAdaptador;
import com.sacbe.coursera.mismapas.pojo.LugarFavorito;
import com.sacbe.coursera.mismapas.presentador.IRecyclerViewFragmentLugarFavoritoPresenter;
import com.sacbe.coursera.mismapas.presentador.RecyclerViewFragmentLugarFavoritoPresenter;

import java.util.ArrayList;

/**
 * Created by axel on 07/10/2016.
 */

public class RecyclerViewFragmentFavorito extends Fragment implements IRecyclerViewFragmentFavorito {

    //private ArrayList<LugarFavorito> lugaresFavoritos;
    private RecyclerView listalugaresFavoritos;
    private IRecyclerViewFragmentLugarFavoritoPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        listalugaresFavoritos = (RecyclerView) v.findViewById(R.id.rvLugarFavorito);
        presenter = new RecyclerViewFragmentLugarFavoritoPresenter(this, getContext());
        return v;
    }
    
    @Override
    public LugarFavoritoAdaptador crearAdaptador(ArrayList<LugarFavorito> lugaresFavoritos) {
        LugarFavoritoAdaptador adaptador = new LugarFavoritoAdaptador(lugaresFavoritos, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptador(LugarFavoritoAdaptador adaptador) {
        listalugaresFavoritos.setAdapter(adaptador);
    }

    @Override
    public void generarGridLyout() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(),2);
        //glm.setOrientation(LinearLayoutManager.VERTICAL);
        listalugaresFavoritos.setLayoutManager(glm);
    }
}
