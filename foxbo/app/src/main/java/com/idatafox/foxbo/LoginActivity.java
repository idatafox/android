package com.idatafox.foxbo;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void doPostJsonData(View v){

         final String resData=createJSONData();


        new AsyncTask<Void,Void,String>(){

            @Override
            protected String doInBackground(Void... params) {
                return getReponseData(resData);
            }

            @Override
            protected void onPostExecute(String s) {
               TextView tView=(TextView)findViewById(R.id.textView3);
                tView.setText(s);

            }
        }.execute();
         Log.d(LoginActivity.class.getSimpleName(),"doPostJsonData,666666666");
    }

    private String getReponseData(String jValue) {


       HttpPost post = new HttpPost("http://www.idatafox.com/androidTest/aa");
        try {
            StringEntity entity=new StringEntity(jValue);
            post.setEntity(entity);
            post.setHeader("Content-type","application/json");
            DefaultHttpClient client=new DefaultHttpClient();
            BasicResponseHandler handler=new BasicResponseHandler();
            String pValue=client.execute(post,handler);
            return pValue;
        }
        catch(UnsupportedEncodingException e2){
            Log.d("getResponseData",e2.toString());
        }
        catch(IOException e3){
            Log.d("getResponseData",e3.toString());
        }
        return "unable to connect to server";
    }

    public String createJSONData(){
        final JSONObject userList=new JSONObject();
        try{
            userList.put("userAdmin","john");
            userList.put("userAuthor","laffa");
            JSONArray officeAddress = new JSONArray();
            officeAddress.put("Chicago");
            officeAddress.put("DC");
            return userList.toString(1);
        }
        catch (JSONException jException){
           Log.d("createJSONData","can not create json data for you");

        }
        return "can not create JSONData for you ...";
    }
}
