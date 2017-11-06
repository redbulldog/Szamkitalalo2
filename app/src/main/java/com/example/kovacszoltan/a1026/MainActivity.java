package com.example.kovacszoltan.a1026;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    private ImageView hearth1, hearth2, hearth3, hearth4, hearth5;
    private Button minus, plus, kuld;
    private TextView szam_kiiratas;
    private int szam = 0, kitalalando_szam = 0;
    private AlertDialog.Builder alert_nyert;
    private AlertDialog.Builder alert_vesztett;
    private int elet = 5;
    public void new_game(){
        szam_kiiratas.setText("0");
        szam = 0;
        elet = 5;
        Random r = new Random();
        kitalalando_szam = r.nextInt(50) + 1;
        hearth5.setImageResource(R.drawable.heart2);
        hearth4.setImageResource(R.drawable.heart2);
        hearth3.setImageResource(R.drawable.heart2);
        hearth2.setImageResource(R.drawable.heart2);
        hearth1.setImageResource(R.drawable.heart2);
    }
    public void teszt(){
        if (kitalalando_szam>szam) {
            Toast toast = Toast.makeText(getApplicationContext(), "Feljebb", Toast.LENGTH_SHORT);
            toast.show();
        } else if (kitalalando_szam<szam)
        {
            Toast toast2 = Toast.makeText(getApplicationContext(), "Lejjebb", Toast.LENGTH_SHORT);
            toast2.show();
        }
    }


    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        alert_nyert = new AlertDialog.Builder(MainActivity.this);
        alert_vesztett = new AlertDialog.Builder(MainActivity.this);

        alert_nyert.setTitle("Gratulálunk, nyertél!")
                .setMessage("Újra akarod kezdeni a játékot?")
                .setPositiveButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        new_game();
                    }
                })
                .setCancelable(false)
                .create();
        alert_vesztett.setTitle("Vesztettél!")
                .setMessage("Újra akarod kezdeni a játékot?")
                .setPositiveButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        new_game();
                    }
                })
                .setCancelable(false)
                .create();




        hearth1 = (ImageView) findViewById(R.id.imageView_hearth1);
        hearth2 = (ImageView) findViewById(R.id.imageView_hearth2);
        hearth3 = (ImageView) findViewById(R.id.imageView_hearth3);
        hearth4 = (ImageView) findViewById(R.id.imageView_hearth4);
        hearth5 = (ImageView) findViewById(R.id.imageView_hearth5);
        minus = (Button) findViewById(R.id.button_minus);
        plus = (Button) findViewById(R.id.button_plus);
        kuld = (Button) findViewById(R.id.button_send);
        szam_kiiratas = (TextView) findViewById(R.id.textView_szam);
        Random r = new Random();
        kitalalando_szam = r.nextInt(50) + 1;



        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (szam < 50) {
                    szam++;
                }
                szam_kiiratas.setText(String.valueOf(szam));
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (szam > 0) {
                    szam--;
                }
                szam_kiiratas.setText(String.valueOf(szam));
            }
        });

        kuld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (szam == kitalalando_szam) {
                    alert_nyert.show();
                } else if (elet > 0){
                    switch (elet){
                        case 5:
                            elet = 4;
                            hearth5.setImageResource(R.drawable.heart1);
                            teszt();
                            break;
                        case 4:
                            elet = 3;
                            hearth4.setImageResource(R.drawable.heart1);
                            teszt();
                            break;
                        case 3:
                            elet = 2;
                            hearth3.setImageResource(R.drawable.heart1);
                            teszt();
                            break;
                        case 2:
                            elet = 1;
                            hearth2.setImageResource(R.drawable.heart1);
                            teszt();
                            break;
                        case 1:
                            hearth1.setImageResource(R.drawable.heart1);
                            alert_vesztett.show();
                            elet = 0;
                            break;
                    }
                }
            }
        });


    }
}
