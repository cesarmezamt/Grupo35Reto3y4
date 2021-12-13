package usa.reto.reto3.Vista;

import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

import usa.reto.reto3.Modelo.Adaptador;
import usa.reto.reto3.Modelo.BaseDatos.BaseDatosSQLite;
import usa.reto.reto3.Modelo.Entidad;
import usa.reto.reto3.R;

public class FraSucursales extends Fragment {

    ListView listaSucursales;
    Adaptador adaptador;
    View v;
    //BaseDatosSQLite conector = new BaseDatosSQLite(getContext(),"ChaquetasReto",null,1);
    Cursor cursor;

    //private int[] listaimg = {R.drawable.almacen1,R.drawable.almacen2};

    Button btn1;
    Fragment pntmapa;

    Uri img1,img2;

    @Override
    public  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout for this fragment
     }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_fra_sucursales, container, false);
        listaSucursales = (ListView) v.findViewById(R.id.lista_sucursales);
        adaptador = new Adaptador(TablaSucursales(), getContext());
        //adaptador = new Adaptador(GetListItems(), getContext());
        listaSucursales.setAdapter(adaptador);

        btn1= (Button) v.findViewById(R.id.btnmapa);
        pntmapa= new Fra_mapa();


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                Intent i = new Intent(getActivity(), Mapa.class);
                startActivity(i);

                 */

                FragmentManager manager = getParentFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.contenedorpro, pntmapa).addToBackStack(null);
                transaction.commit();

                Toast.makeText(getContext().getApplicationContext(),"Mapas",Toast.LENGTH_LONG).show();
            }
        });

        return v;
    }

    private ArrayList<Entidad> TablaSucursales() {
        ArrayList<Entidad> lista = new ArrayList<>();
        BaseDatosSQLite conector = new BaseDatosSQLite(getActivity(),"ChaquetasReto",null,1);
        SQLiteDatabase leer_bd = conector.getReadableDatabase();
        cursor = leer_bd.rawQuery("SELECT * FROM sucursales", null);
        while(cursor.moveToNext()){
            lista.add(new Entidad(Uri.parse(cursor.getString(0)), cursor.getString(1), cursor.getString(2)));
        }
        return lista;
    }


    private ArrayList<Entidad> GetListItems() {
        //img1 = Uri.parse("android.resource://usa.reto.reto3/"  + R.drawable.almacen1);
        //img2 = Uri.parse("android.resource://usa.reto.reto3/"  + R.drawable.almacen2);

        img1 = Uri.parse("android.resource://usa.reto.reto3/2131230806");
        img2 = Uri.parse("android.resource://usa.reto.reto3/2131230807");

        ArrayList<Entidad> listaItems = new ArrayList<>();
        listaItems.add(new Entidad(img1, "Principal", "Exclusivo sector" + "\n" + "\n" +  "Carrera 15 Nº 85-90"));
        listaItems.add(new Entidad(img2, "Centro", "Cerca de ti" + "\n" + "\n" +"Carrera 31 Nº 26-10"));
        return listaItems;
    }


}