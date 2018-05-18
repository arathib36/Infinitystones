package com.infinitystones.infinitystones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stonelist extends AppCompatActivity {




    TextView stnlst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stonelist);

        stnlst=(TextView)findViewById(R.id.stnlst);
        readmsg();

    }



    public void readmsg()
    {
        try{
            String Message;
            FileInputStream fileInputStream=openFileInput("Thanos");
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer=new StringBuffer();
            while ((Message=bufferedReader.readLine())!=null) {
                stringBuffer.append(Message + "\n");
            }

            stnlst.setText(stringBuffer.toString());

        }catch (FileNotFoundException e)
        {e.printStackTrace();}
        catch (IOException e)
        {e.printStackTrace();}
    }
}
