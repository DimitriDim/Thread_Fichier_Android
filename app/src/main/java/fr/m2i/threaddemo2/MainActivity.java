package fr.m2i.threaddemo2;

import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // question demandé à l'utilisateur, ici aura elle aura le code 1
        ActivityCompat.requestPermissions(this, new String[]
                {Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
    }

    public void creerFichier(View v) {

        ThreadFichier th = new ThreadFichier();
        th.nomFichier = "essai.txt";
        th.max = 1000;
        th.act = this;
        th.start();
    }
}
