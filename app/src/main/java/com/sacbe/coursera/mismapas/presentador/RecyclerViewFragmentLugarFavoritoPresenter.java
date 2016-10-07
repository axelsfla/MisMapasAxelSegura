package com.sacbe.coursera.mismapas.presentador;

import android.content.Context;

import com.sacbe.coursera.mismapas.R;
import com.sacbe.coursera.mismapas.fragment.IRecyclerViewFragmentFavorito;
import com.sacbe.coursera.mismapas.pojo.LugarFavorito;

import java.util.ArrayList;

/**
 * Created by axel on 07/10/2016.
 */

public class RecyclerViewFragmentLugarFavoritoPresenter implements IRecyclerViewFragmentLugarFavoritoPresenter{

    private IRecyclerViewFragmentFavorito iRecyclerViewFragmentFavorito;
    private Context context;
    private ArrayList<LugarFavorito> lugaresFavoritos;

    public RecyclerViewFragmentLugarFavoritoPresenter(IRecyclerViewFragmentFavorito iRecyclerViewFragmentFavorito, Context context) {
        this.iRecyclerViewFragmentFavorito = iRecyclerViewFragmentFavorito;
        this.context = context;
        obtenerLugaresFavoritos();
    }

    @Override
    public void mostrarLugaresFavoritosRV() {
        iRecyclerViewFragmentFavorito.inicializarAdaptador(iRecyclerViewFragmentFavorito.crearAdaptador(lugaresFavoritos));
        iRecyclerViewFragmentFavorito.generarGridLyout();
    }

    @Override
    public void obtenerLugaresFavoritos() {
        lugaresFavoritos = new ArrayList<>();

        LugarFavorito lugar = new LugarFavorito();
        lugar.setNombre("Zócalo DF.");
        lugar.setLatitud(19.432604764493);
        lugar.setLongitud(-99.13322082909848d);
        lugar.setFoto(R.drawable.zocalo_mexicodf);
        //lugar.setMarcador(R.drawable.flag_mx48);
        lugar.setMarcador(R.drawable.mexico_48);

        lugaresFavoritos.add(lugar);

        lugar = new LugarFavorito();
        lugar.setNombre("Ciudad Universitaria.");
        lugar.setLatitud(19.33341044254755);
        lugar.setLongitud(-99.1874221844086);
        lugar.setFoto(R.drawable.unam);
        //lugar.setMarcador(R.drawable.graduation48);
        lugar.setMarcador(R.drawable.graduation_cap_48);

        lugaresFavoritos.add(lugar);

        lugar = new LugarFavorito();
        lugar.setNombre("Castillo de Chapultepec.");
        lugar.setLatitud(19.420439705598707);
        lugar.setLongitud(-99.18193499999995);
        lugar.setFoto(R.drawable.castillochapultepec);
        //lugar.setMarcador(R.drawable.castillo48);
        lugar.setMarcador(R.drawable.palace_50);

        lugaresFavoritos.add(lugar);

        lugar = new LugarFavorito();
        lugar.setNombre("Xochimilco.");
        lugar.setLatitud(19.286880036552677);
        lugar.setLongitud(-99.1021988797912);
        lugar.setFoto(R.drawable.xochimilco);
        //lugar.setMarcador(R.drawable.canoa48);
        lugar.setMarcador(R.drawable.dinghy_48);

        lugaresFavoritos.add(lugar);

        mostrarLugaresFavoritosRV();

    }
}
