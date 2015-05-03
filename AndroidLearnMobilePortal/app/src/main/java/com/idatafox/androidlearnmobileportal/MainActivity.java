package com.idatafox.androidlearnmobileportal;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity {



    String[] data={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};
    ListView l;
    ListView list;
    String[] memeTitles;
    String[] memeDescriptions;
    int[] images={R.drawable.ic_action_directions,R.drawable.ic_action_group,R.drawable.ic_action_person,R.drawable.ic_action_reply,R.drawable.ic_action_send_now,R.drawable.ic_action_split,R.drawable.ic_action_view_as_grid,R.drawable.ic_action_split,R.drawable.ic_action_group,R.drawable.ic_action_group,R.drawable.ic_action_group,R.drawable.ic_action_group};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Resources res=getResources();
        memeTitles=res.getStringArray(R.array.titles);
        memeDescriptions=res.getStringArray(R.array.descriptions);

        list=(ListView)findViewById(R.id.listView);
        VivzAdapter adapter=new VivzAdapter(this,memeTitles,images,memeDescriptions);

        list.setAdapter(adapter);
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




class VivzAdapter extends ArrayAdapter<String> {

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
            Log.d("Vivz", "createing a new row");
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