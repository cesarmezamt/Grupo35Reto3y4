package usa.reto.reto3.Vista;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import java.util.ArrayList;

import usa.reto.reto3.Controlador.MainActivity;
import usa.reto.reto3.Modelo.Adaptador;
import usa.reto.reto3.Modelo.BaseDatos.BaseDatosSQLite;
import usa.reto.reto3.Modelo.Entidad;
import usa.reto.reto3.R;

public class FraProductos extends Fragment {

    View v;
    ListView listaProductos;
    Adaptador adaptador;

    Uri img1, img2, img3, img4, img5, img6;

    Cursor cursor;
    //private int[] listaimg = {R.drawable.cham1,R.drawable.cham2,R.drawable.cham3,R.drawable.chah1,R.drawable.chah2,R.drawable.chah3};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_fra_productos, container, false);
        listaProductos = (ListView) v.findViewById(R.id.lista_productos);
        adaptador = new Adaptador(TablaProductos(), getContext());
        //adaptador = new Adaptador(GetListItems(), getContext());
        listaProductos.setAdapter(adaptador);
        return v;
    }

    private ArrayList<Entidad> TablaProductos() {

        ArrayList<Entidad> lista = new ArrayList<>();
        BaseDatosSQLite conector = new BaseDatosSQLite(getContext(),"ChaquetasReto",null, 1);
        SQLiteDatabase leer_bd = conector.getReadableDatabase();
        cursor = leer_bd.rawQuery("SELECT * FROM productos", null);
        while(cursor.moveToNext()){
             lista.add(new Entidad(Uri.parse(cursor.getString(0)), cursor.getString(1), cursor.getString(2)));
        }
        return lista;
    }


    private ArrayList<Entidad> GetListItems(){

        /**
        img1 = Uri.parse("android.resource://usa.reto.reto3/" + R.drawable.cham1);
        img2 = Uri.parse("android.resource://usa.reto.reto3/" + R.drawable.cham2);
        img3 = Uri.parse("android.resource://usa.reto.reto3/" + R.drawable.cham3);
        img4 = Uri.parse("android.resource://usa.reto.reto3/" + R.drawable.chah1);
        img5 = Uri.parse("android.resource://usa.reto.reto3/" + R.drawable.chah2);
        img6 = Uri.parse("android.resource://usa.reto.reto3/" + R.drawable.chah3);
        */

        img1 = Uri.parse("android.resource://usa.reto.reto3/2131230824");
        img2 = Uri.parse("android.resource://usa.reto.reto3/2131230825");
        img3 = Uri.parse("android.resource://usa.reto.reto3/2131230826");
        img4 = Uri.parse("android.resource://usa.reto.reto3/2131230821");
        img5 = Uri.parse("android.resource://usa.reto.reto3/2131230822");
        img6 = Uri.parse("android.resource://usa.reto.reto3/2131230823");


        ArrayList<Entidad> listaItems = new ArrayList<>();
        listaItems.add(new Entidad(img1, "Denin Mujer", "Chaqueta en denin"));
        listaItems.add(new Entidad(img2, "Impermeable Mujer", "Chaqueta Impermeable"));
        listaItems.add(new Entidad(img3, "Cuero Mujer", "Cuero Original"));
        listaItems.add(new Entidad(img4, "Denin Hombre", "Chaqueta en denin"));
        listaItems.add(new Entidad(img5, "Impermeable Hombre", "Chaqueta Impermeable"));
        listaItems.add(new Entidad(img6, "Cuero Hombre", "Cuero Original"));
        return listaItems;
    }


}