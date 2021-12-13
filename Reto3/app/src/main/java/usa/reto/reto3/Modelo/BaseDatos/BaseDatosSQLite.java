package usa.reto.reto3.Modelo.BaseDatos;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.net.Uri;
import androidx.annotation.Nullable;
import usa.reto.reto3.R;

public class BaseDatosSQLite extends SQLiteOpenHelper {
    private SQLiteDatabase sqLDatabase;


    public BaseDatosSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "ChaquetasReto", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /**
        Uri img1, img2, img3, img4, img5, img6, img7, img8, img9, img10,img11;
        img1 = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.cham1);
        img2 = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.cham2);
        img3 = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.cham3);
        img4 = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.chah1);
        img5 = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.chah2);
        img6 = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.chah3);
        img7 = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.medidas);
        img8 = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.domicilio);
        img9 = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.almacen1);
        img10 = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.almacen2);
        img11 = Uri.parse("android.resource://usa.reto.reto3" + R.drawable.ic_icono);
        */
        /**
         //Imagenes productos
         img1 = Uri.parse("android.resource://usa.reto.reto3/2131230824");
         img2 = Uri.parse("android.resource://usa.reto.reto3/2131230825");
         img3 = Uri.parse("android.resource://usa.reto.reto3/2131230826");
         img4 = Uri.parse("android.resource://usa.reto.reto3/2131230821");
         img5 = Uri.parse("android.resource://usa.reto.reto3/2131230822");
         img6 = Uri.parse("android.resource://usa.reto.reto3/2131230823");
         //Imagenes servicios
         img7 = Uri.parse("android.resource://usa.reto.reto3/2131230869");
         img8 = Uri.parse("android.resource://usa.reto.reto3/2131230832");
         //Imagenes sucursales
         img9 = Uri.parse("android.resource://usa.reto.reto3/2131230806");
         img10 = Uri.parse("android.resource://usa.reto.reto3/2131230807");
         */

        // tabla productos

        db.execSQL("CREATE TABLE productos (imagen TEXT, titulo TEXT,descripcion TEXT)");
        // datos de la tabla productos
        db.execSQL("INSERT INTO productos VALUES ('android.resource://usa.reto.reto3/2131230824','Denin Mujer','Chaqueta en denin')" );
        db.execSQL("INSERT INTO productos VALUES ('android.resource://usa.reto.reto3/2131230825','Impermeable Mujer','Chaqueta Impermeable')" );
        db.execSQL("INSERT INTO productos VALUES ('android.resource://usa.reto.reto3/2131230826','Cuero Mujer','Cuero Original')" );
        db.execSQL("INSERT INTO productos VALUES ('android.resource://usa.reto.reto3/2131230821','Denin Hombre','Chaqueta en denin')" );
        db.execSQL("INSERT INTO productos VALUES ('android.resource://usa.reto.reto3/2131230822','Impermeable Hombre','Chaqueta Impermeable')" );
        db.execSQL("INSERT INTO productos VALUES ('android.resource://usa.reto.reto3/2131230823','Cuero Hombre','Cuero Original')" );


        // tabla servicios
        db.execSQL("CREATE TABLE servicios (imagen TEXT, titulo TEXT,descripcion TEXT)");
        // datos de la tabla servicios
        db.execSQL("INSERT INTO servicios VALUES ('android.resource://usa.reto.reto3/2131230869','A Medida','Chaqueta a su medida')" );
        db.execSQL("INSERT INTO servicios VALUES ('android.resource://usa.reto.reto3/2131230832','Domicilio','Llevamos su chaqueta a su casa')" );

        // tabla sucursales
        db.execSQL("CREATE TABLE sucursales (imagen TEXT, titulo TEXT,descripcion TEXT)");
        // datos de la tabla sucursales
        db.execSQL("INSERT INTO sucursales VALUES ('android.resource://usa.reto.reto3/2131230806','Principal','Exclusivo sector   Carrera 15 Nº 85-90')" );
        db.execSQL("INSERT INTO sucursales VALUES ('android.resource://usa.reto.reto3/2131230807','Centro','Cerca de ti    Carrera 31 Nº 26-10')" );

        // tabla favoritos
        db.execSQL("CREATE TABLE favoritos (imagen TEXT, titulo TEXT,descripcion TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS productos");
        db.execSQL("DROP TABLE IF EXISTS servicios");
        db.execSQL("DROP TABLE IF EXISTS sucursales");
        db.execSQL("DROP TABLE IF EXISTS favoritos");
        onCreate(db);
    }






}
