package com.idatafox.foxbo;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;

public class MainActivity extends AppCompatActivity {

    String result=null;
    HttpURLConnection connection=null;
    BufferedReader reader=null;
    TextView textView=null;
    Button buttonA=null;
    Button buttonB=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView) findViewById(R.id.mytextview);
        buttonA=(Button)findViewById(R.id.button);
        buttonA.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                JSONTask myJsonTask=new JSONTask();
                myJsonTask.execute("http://www.idatafox.com");
            }
        });
        //View backgroundimage = (View) findViewById(R.id.goodA);
       // backgroundimage.setAlpha(0.5);

       /*
        buttonB=(Button)findViewById(R.id.button2);
        buttonB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
              Intent myintent=new Intent(getBaseContext(),LoginActivity.class);

            }
        });
       */


    }



     class JSONTask extends AsyncTask<String,String,String> {

        @Override
        protected String doInBackground(String ... params){


            try{
                URL url=new URL(params[0]);
                connection=(HttpURLConnection)url.openConnection();
                InputStream stream=connection.getInputStream();
                reader=new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer=new StringBuffer();
                String line="";
                while ((line=reader.readLine())!=null){
                    buffer.append(line);
                }

                return buffer.toString();

            }
            catch (MalformedURLException e){
                e.printStackTrace();

            }
            catch(IOException e){

                e.printStackTrace();
            }
            finally{
                if(connection!=null){
                    connection.disconnect();
                }
                try{
                    if(reader!=null){
                        reader.close();
                    }
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }
            return null;
        }
        @Override
        protected  void onPostExecute(String result){
            super.onPostExecute(result);
            textView.setText(result);
        }
    }

    public void displayDialog(View v){
        Intent myintent=new Intent(this,LoginActivity.class);
        startActivity(myintent);
        Log.d(LoginActivity.class.getSimpleName(),"hello");
    }
}

