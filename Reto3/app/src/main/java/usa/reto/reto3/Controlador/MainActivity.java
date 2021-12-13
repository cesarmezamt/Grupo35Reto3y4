package usa.reto.reto3.Controlador;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import usa.reto.reto3.R;
import usa.reto.reto3.Vista.FraFavoritos;
import usa.reto.reto3.Vista.FraInicio;
import usa.reto.reto3.Vista.FraProductos;
import usa.reto.reto3.Vista.FraServicios;
import usa.reto.reto3.Vista.FraSucursales;

public class MainActivity extends AppCompatActivity {


    Button btn1, btn2, btn3;
    Fragment pntinicial, pntproducto,pntservicio,pntsucursal,pntfavorito;
    FragmentTransaction pntcambio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //**** icono en barra***//
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_foreground);
        //**** icono en barra***//

        pntinicial= new FraInicio();
        pntproducto = new FraProductos();
        pntservicio = new FraServicios();
        pntsucursal = new FraSucursales();
        pntfavorito = new FraFavoritos();


        getSupportFragmentManager().beginTransaction().add(R.id.contenedorpro, pntinicial).commit();

        //*** def botones ***//

        btn1= (Button) findViewById(R.id.btnproductos);
        btn2= (Button) findViewById(R.id.btnservicios);
        btn3= (Button) findViewById(R.id.btnsucursales);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pntcambio = getSupportFragmentManager().beginTransaction();
                pntcambio.replace(R.id.contenedorpro,pntproducto).commit();
                Toast.makeText(getApplicationContext(),"Nuevos Productos Próximamente",Toast.LENGTH_LONG).show();
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pntcambio = getSupportFragmentManager().beginTransaction();
                pntcambio.replace(R.id.contenedorpro,pntservicio).commit();
                Toast.makeText(getApplicationContext(),"Nuevos Servicios Próximamente",Toast.LENGTH_LONG).show();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pntcambio = getSupportFragmentManager().beginTransaction();
                pntcambio.replace(R.id.contenedorpro,pntsucursal).commit();
                Toast.makeText(getApplicationContext(),"Nuevas Sucursales Próximamente",Toast.LENGTH_LONG).show();
            }
        });

    }


    //**** menu  ***//
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuopciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id ==R.id.inicio){
            pntcambio = getSupportFragmentManager().beginTransaction();
            pntcambio.replace(R.id.contenedorpro,pntinicial).commit();

        }
        if (id ==R.id.productos){
            pntcambio = getSupportFragmentManager().beginTransaction();
            pntcambio.replace(R.id.contenedorpro,pntproducto).commit();

        }
        if (id ==R.id.servicios){
            pntcambio = getSupportFragmentManager().beginTransaction();
            pntcambio.replace(R.id.contenedorpro,pntservicio).commit();

        }
        if (id ==R.id.sucursales){
            pntcambio = getSupportFragmentManager().beginTransaction();
            pntcambio.replace(R.id.contenedorpro,pntsucursal).commit();

        }

        if (id ==R.id.favoritos){
            pntcambio = getSupportFragmentManager().beginTransaction();
            pntcambio.replace(R.id.contenedorpro,pntfavorito).commit();

        }
        return super.onOptionsItemSelected(item);
    }


}
