package com.company.alex.compartirfoto;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);

        Uri uri = Uri.fromFile(new File("/storage/emulated/0/Pictures/mifoto.jpg"));

        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);

        //chooser

        startActivity(Intent.createChooser(shareIntent, "ENVIAR FOTO POR..."));
        shareIntent.setType("image/jpeg");
        startActivity(shareIntent);*/

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send");
        sendIntent.setType("text/plain"); //le digo el tupo
        sendIntent.setPackage("com.whatsapp"); //Le digo en que paquete lo quiero enviar
        startActivity(sendIntent);

        /**
         * PARA COMPARTIR UNA LISTA DE FOTOS
         */
        ArrayList<Uri> array_uris = new ArrayList<>();
        array_uris.add(Uri.fromFile(new File("rutafoto")));
        array_uris.add(Uri.fromFile(new File("rutafoto2")));
        array_uris.add(Uri.fromFile(new File("rutafoto3")));

        Intent sharemultiple = new Intent();
        sharemultiple.setAction(Intent.ACTION_SEND_MULTIPLE);

        sharemultiple.putParcelableArrayListExtra(Intent.EXTRA_STREAM, array_uris);
        sharemultiple.setType("image/*");//imagen de cualquier tipo
        startActivity(sharemultiple);


    }
}
