package usa.reto.reto3.Vista;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import usa.reto.reto3.Controlador.MainActivity;
import usa.reto.reto3.Modelo.Adaptador;
import usa.reto.reto3.Modelo.BaseDatos.BaseDatosSQLite;
import usa.reto.reto3.Modelo.Entidad;
import usa.reto.reto3.R;

public class FraFavoritos extends Fragment {

    View v;
    ListView listafavoritos;
    Adaptador adaptador;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_fra_favoritos, container, false);
        listafavoritos = (ListView) v.findViewById(R.id.lista_favoritos);
        adaptador = new Adaptador(tablafavoritos(), getContext());
        //adaptador = new Adaptador(GetListItems(), getContext());
        listafavoritos.setAdapter(adaptador);
        return v;
    }

    private ArrayList<Entidad> tablafavoritos() {
        ArrayList<Entidad> lista = new ArrayList<>();
        BaseDatosSQLite conector = new BaseDatosSQLite(getContext(),"ChaquetasReto",null,1);
        SQLiteDatabase leer_bd = conector.getReadableDatabase();
        Cursor cursor = leer_bd.rawQuery("SELECT * FROM favoritos", null);
        while(cursor.moveToNext()){
            lista.add(new Entidad(Uri.parse(cursor.getString(0)), cursor.getString(1), cursor.getString(2)));

        }
        return lista;
    }
    /**
    private ArrayList<Entidad> GetListItems() {
        ArrayList<Entidad> listaItems = new ArrayList<>();
        listaItems.add(new Entidad(R.drawable.medidas, "A Medida", "Chaqueta a su medida"));
        listaItems.add(new Entidad(R.drawable.domicilio, "Domicilio", "Llevamos su chaqueta a su casa"));
        return listaItems;
    }*/


}

