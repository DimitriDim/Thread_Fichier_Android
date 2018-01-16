package fr.m2i.threaddemo2;

import android.app.Activity;
import android.os.Environment;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Administrateur on 10/01/2018.
 */

//cette classe qui hérite de thread
//executera sa methode Run dans un thread séparer
public class ThreadFichier extends Thread {

    // déclaration de 2 propriétés pour paramétrer le traitement
    //du thread
    //en principe il faudrait passait par des accésseurs

    public String nomFichier;
    public Integer max;
    public Activity act;

    @Override
    public void run() {
        super.run();

        final String nomFichier2 = nomFichier;
        String path = Environment.getExternalStorageDirectory().getAbsolutePath();
        File file = new File(path, nomFichier2);

        try {
            FileOutputStream Stream = new FileOutputStream(file);
            for (Integer i = 0; i < max; i++) {
                Stream.write(i.toString().getBytes());
            }
            Stream.close();
        } catch (Exception ex) {

            act.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(act, "Erreur", Toast.LENGTH_LONG).show();
                }
            });
        }

        //pour ce qui concerne l'ecran il faut passer par
        //runOnUiThread

        act.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(act, "fichier enregistré", Toast.LENGTH_LONG).show();
            }
        });
    }

}
