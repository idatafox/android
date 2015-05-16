package com.idatafox.toolbardemofirst;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class MyActivity extends ActionBarActivity implements android.support.v7.app.ActionBar.TabListener
{


    private Toolbar toolbar;
    private Toolbar secondToolbar;
    ActionBar actionBar;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        toolbar=(Toolbar)findViewById(R.id.topbar);
        setSupportActionBar(toolbar);
        actionBar=getSupportActionBar();

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);


        viewPager=(ViewPager)findViewById(R.id.pager);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));



        viewPager=(ViewPager)findViewById(R.id.pager);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



        ActionBar.Tab tab1=actionBar.newTab();
        tab1.setText("文章");
        tab1.setTabListener(this);




        ActionBar.Tab tab2=actionBar.newTab();

        tab2.setText("视频");
        tab2.setTabListener(this);


        ActionBar.Tab tab3=actionBar.newTab();
        tab3.setText("题库");
        tab3.setTabListener(this);


        actionBar.addTab(tab1);
        actionBar.addTab(tab2);
        actionBar.addTab(tab3);



        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setTitle("Liferay在线课堂");


    }




    public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
       // viewPager.setCurrentItem(tab.getPosition());
    }


    public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }


    public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
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


class MyAdapter extends FragmentPagerAdapter {

    MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment=null;
        if(position==0)
        {
            fragment=new LiferayVideo();
        }
        if(position==1)
        {
            fragment=new LiferayArticle();
        }
        if(position==2)
        {
            fragment=new LiferayTest();
        }        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
