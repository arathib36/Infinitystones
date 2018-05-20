package com.infinitystones.infinitystones;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    String [] items = new String[100];
    int arr[]={0,0,0,0,0,0};
    int i=-1,j,k,t=0,ch,temp=0;
    String strText = "\n";

    Button stone,rst,list;
    TextView infstn,rslt,desc;

    private Stones mStones = new Stones();
    private int mStonesLength = mStones.mStones.length;
    Random r;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = new Random();


        stone = (Button) findViewById(R.id.stone);
        rst = (Button) findViewById(R.id.rst);
        list = (Button) findViewById(R.id.list);

        infstn = (TextView) findViewById(R.id.infstn);
        rslt = (TextView) findViewById(R.id.rslt);
        desc = (TextView) findViewById(R.id.desc);


        stone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                k = r.nextInt(mStonesLength);
                rslt.setText(mStones.getStones(k));
                temp=0;
                for(ch=0;ch<=i;ch++)
                {
                    if (items[ch].equals(mStones.getitems(k))) {
                        temp++;
                        break;
                    }
                }

                if(ch==-1||temp==0)
                {items[++i] = mStones.getitems(k);
                    writ(items[i]);}

                stone.setBackgroundColor((Color.parseColor(mStones.getcolor(k))));


                arr[k]++;

                for (j = 0; j < 6; j++) {
                    if (arr[j] == 0) {
                        t++;
                        break;
                    }
                }

                if(t==0)
                {congrats();}
                else
                {t=0;}



            }

        });


        rst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stone.setBackgroundColor((Color.parseColor("#C0C0C0")));
                rslt.setText("");
                rese();


            }
        });


        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,Stonelist.class);
                startActivity(intent);


            }
        });




    }

    private void rese() {
        for(j=0;j<=i;j++) {
            items[j] = null;
            }
        for (j = 0; j < 6; j++)
        {arr[j]=0;}
        i=-1;

        String filenam="Thanos";
        try {
            FileOutputStream fileOutputStream = openFileOutput(filenam, MODE_PRIVATE);

            fileOutputStream.close();
            Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_LONG).show();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }

        catch (IOException e)
        {e.printStackTrace();
        }



    }

    private void congrats() {

        rese();
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder
                .setMessage("Congrats!!You have collected all the Stones!")
                .setCancelable(false)
                .setPositiveButton("CONTINUE",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                finish();
                            }
                        })

                .setNegativeButton("EXIT",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialogBuilder.show();




        }

        public void writ(String at)
        {String Message=at;
        String filenam="Thanos";
        try {
            FileOutputStream fileOutputStream = openFileOutput(filenam, MODE_APPEND);
            fileOutputStream.write(Message.getBytes());
            fileOutputStream.write(strText.getBytes());
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(), "Stored", Toast.LENGTH_LONG).show();
        }
        catch(FileNotFoundException e)
            {
                e.printStackTrace();
            }

         catch (IOException e)
         {e.printStackTrace();
        }

        }





}
