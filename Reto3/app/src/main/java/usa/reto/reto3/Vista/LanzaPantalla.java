package usa.reto.reto3.Vista;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;

import usa.reto.reto3.Controlador.MainActivity;
import usa.reto.reto3.Modelo.BaseDatos.BaseDatosSQLite;
import usa.reto.reto3.R;


public class LanzaPantalla extends AppCompatActivity implements Runnable {
    Thread h1;
    BaseDatosSQLite conector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lanza_pantalla);

        ImageView iconomarca = (ImageView) findViewById(R.id.imagenmarca);
        iconomarca.setBackgroundResource(R.drawable.iconomarca);

        AnimationDrawable hacerAnimacion = (AnimationDrawable)iconomarca.getBackground();
        hacerAnimacion.start();

        h1= new Thread(this);
        h1.start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            Intent pasarPantalla = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(pasarPantalla);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        conector = new BaseDatosSQLite(getApplicationContext(),"ChaquetasReto",null,1);
        SQLiteDatabase sqLDatabase = conector.getReadableDatabase();
        conector.onUpgrade(sqLDatabase,1,2);


    }
}