package com.idatafox.listviewdemo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    String[] data={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};
    ListView l;
    ListView list;
    String[] memeTitles;
    String[] memeDescriptions;
    int[] images={R.drawable.ic_action_cancel,R.drawable.ic_action_copy,R.drawable.ic_action_new_label,R.drawable.ic_action_paste,R.drawable.ic_action_refresh,R.drawable.ic_action_remove,R.drawable.ic_action_cancel,R.drawable.ic_action_copy,R.drawable.ic_action_new_label,R.drawable.ic_action_paste,R.drawable.ic_action_refresh,R.drawable.ic_action_remove};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // l=(ListView)findViewById(R.id.listView);


      //  ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.single_row,R.id.textView,data);

        //l.setAdapter(adapter);


        Resources res=getResources();
        memeTitles=res.getStringArray(R.array.titles);
        memeDescriptions=res.getStringArray(R.array.descriptions);

        list=(ListView)findViewById(R.id.listView);
        VivzAdapter adapter=new VivzAdapter(this,memeTitles,images,memeDescriptions);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               // Toast.makeText(getBaseContext(),memeTitles[position],Toast.LENGTH_LONG).show();
                Intent intentIns=new Intent(getBaseContext(),ActivitySecond.class);
                startActivity(intentIns);


            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

class MyViewHolder
{
    ImageView myImage;
    TextView myTitle;
    TextView myDescription;

    MyViewHolder(View v)
    {
        myImage=(ImageView)v.findViewById(R.id.imageView);
        myTitle=(TextView)v.findViewById(R.id.textView);
        myDescription=(TextView)v.findViewById(R.id.textView2);
    }
}




class VivzAdapter extends ArrayAdapter<String>{

    Context context;
    int[] images;
    String[] titleArray;
    String[] desArray;
    VivzAdapter(Context c,String[] titles,int imgs[],String[] des)
    {
        super(c,R.layout.single_row,R.id.textView,titles);
        context=c;
        this.images=imgs;
        this.titleArray=titles;
        this.desArray=des;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        MyViewHolder holder=null;

        if(row==null)
        {
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=inflater.inflate(R.layout.single_row,parent,false);
            holder=new MyViewHolder(row);
            row.setTag(holder);
            Log.d("Vivz","createing a new row");
        }
        else
        {
            holder=(MyViewHolder)row.getTag();
            Log.d("Vivz", "Recycling stuff.");
        }




        holder.myImage.setImageResource(images[position]);
        holder.myTitle.setText(titleArray[position]);
        holder.myDescription.setText(desArray[position]);


        return row;
    }
}