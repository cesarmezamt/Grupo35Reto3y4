package usa.reto.reto3.Modelo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import usa.reto.reto3.Controlador.MainActivity;
import usa.reto.reto3.Modelo.BaseDatos.BaseDatosSQLite;
import usa.reto.reto3.R;

public class Adaptador extends BaseAdapter {

    ArrayList<Entidad> lista_items;
    Context context;
    //--coneccion a base--//
    BaseDatosSQLite conectar;

    public Adaptador(ArrayList<Entidad> lista_items, Context context) {
        this.lista_items = lista_items;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lista_items.size(); // Devuelve cuantos elelmentos hay en la lista
    }

    @Override
    public Object getItem(int posicion) {
        return lista_items.get(posicion); // devuelve la posicion del item;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int posicion, View v, ViewGroup viewGroup) {

        Entidad datosItem = (Entidad) getItem(posicion);
        v = LayoutInflater.from(context).inflate(R.layout.item, null);
        //-------------------------------------------------------------------

        TextView titulo = (TextView)v.findViewById(R.id.titulo_colec);
        ImageView imagen = (ImageView)v.findViewById(R.id.imagen1_colec);
        TextView descripcion = (TextView)v.findViewById(R.id.descripcion_colec);
        CheckBox favorito = (CheckBox) v.findViewById(R.id.favorito_colec);
        Button boton =(Button) v.findViewById(R.id.btnseleccion);

        //imagen.setImageResource(datosItem.getImagen());
        imagen.setImageURI(datosItem.getImagen());
        titulo.setText(datosItem.getTitulo());
        descripcion.setText(datosItem.getDescripcion());


        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Uri img1 = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.cham1);
                //Uri uriImage = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.cham2);
                //Uri uriImage = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.cham3);
                //Uri uriImage = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.chah1);
                //Uri uriImage = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.chah2);
                //Uri uriImage = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.chah3);
                //Uri uriImage = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.medidas);
                //Uri uriImage = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.domicilio);
                //Uri uriImage = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.almacen1);
                //Uri uriImage = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.almacen2);
                //Uri uriImage = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.ic_icono);
                //Toast.makeText(context, "imagen: " + img.get(0), Toast.LENGTH_LONG ).show();

                //String imagen;
                //imagen=uriImage.toString();
                //Toast.makeText(context, "imagen:     " +imagen, Toast.LENGTH_LONG ).show();
                /*---------------*/
            }
        });

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(favorito.isChecked()){
                    conectar = new BaseDatosSQLite(context,"ChaquetasReto",null,1);
                    SQLiteDatabase escribir_bd = conectar.getWritableDatabase();
                    //conectar.onUpgrade(escribir_bd,1,2);
                    escribir_bd.execSQL("INSERT INTO favoritos VALUES ('"+ datosItem.getImagen() +"','"+ datosItem.getTitulo()+"','"+ datosItem.getDescripcion()+"')");

                }
                favorito.setChecked(false);
            }
        });

        //-------------------------------------------------------------------
        return v;
    }




}