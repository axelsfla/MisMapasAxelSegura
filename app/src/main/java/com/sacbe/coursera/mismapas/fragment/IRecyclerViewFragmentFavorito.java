package com.sacbe.coursera.mismapas.fragment;

import com.sacbe.coursera.mismapas.adapter.LugarFavoritoAdaptador;
import com.sacbe.coursera.mismapas.pojo.LugarFavorito;

import java.util.ArrayList;

/**
 * Created by axel on 07/10/2016.
 */

public interface IRecyclerViewFragmentFavorito {

    public LugarFavoritoAdaptador crearAdaptador(ArrayList<LugarFavorito> lugaresFavoritos);

    public void inicializarAdaptador(LugarFavoritoAdaptador adaptador);

    public void generarGridLyout();

}
