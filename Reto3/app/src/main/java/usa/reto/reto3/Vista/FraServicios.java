package usa.reto.reto3.Vista;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import usa.reto.reto3.Controlador.MainActivity;
import usa.reto.reto3.Modelo.Adaptador;
import usa.reto.reto3.Modelo.BaseDatos.BaseDatosSQLite;
import usa.reto.reto3.Modelo.Entidad;
import usa.reto.reto3.R;

public class FraServicios extends Fragment {

    View v;
    ListView listaServicios;
    Adaptador adaptador;
    Cursor cursor;
    Uri img1,img2;


    //private int[] listaimg = {R.drawable.medidas,R.drawable.domicilio};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_fra_servicios, container, false);
        listaServicios = (ListView) v.findViewById(R.id.lista_servicios);
        adaptador = new Adaptador(TablaServicios(), getContext());
        //adaptador = new Adaptador(GetListItems(), getContext());
        listaServicios.setAdapter(adaptador);

        return v;
    }


    private ArrayList<Entidad> TablaServicios() {
        ArrayList<Entidad> lista = new ArrayList<>();
        BaseDatosSQLite conector = new BaseDatosSQLite(getActivity(),"ChaquetasReto",null,1);
        SQLiteDatabase leer_bd = conector.getReadableDatabase();
        cursor = leer_bd.rawQuery("SELECT * FROM servicios", null);
        while(cursor.moveToNext()){
            lista.add(new Entidad(Uri.parse(cursor.getString(0)), cursor.getString(1), cursor.getString(2)));
        }
        return lista;
    }

    private ArrayList<Entidad> GetListItems() {
        //img1 = Uri.parse("android.resource://usa.reto.reto3/" + R.drawable.medidas);
        //img2 = Uri.parse("android.resource://usa.reto.reto3/" + R.drawable.domicilio);

        img1 = Uri.parse("android.resource://usa.reto.reto3/2131230869");
        img2 = Uri.parse("android.resource://usa.reto.reto3/2131230832");

        ArrayList<Entidad> listaItems = new ArrayList<>();
        listaItems.add(new Entidad(img1, "A Medida", "Chaqueta a su medida"));
        listaItems.add(new Entidad(img2, "Domicilio", "Llevamos su chaqueta a su casa"));
        return listaItems;
        }

    }
