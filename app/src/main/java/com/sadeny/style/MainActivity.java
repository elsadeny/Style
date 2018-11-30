package com.sadeny.style;

import android.app.SearchManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener,
        CartFragment.OnFragmentInteractionListener,
        SearchView.OnQueryTextListener

{
    //global variables
    private Toolbar tbMainSearch;
    private ListView lvToolbarSearch;

    private void setUpViews() {
        tbMainSearch = (Toolbar)findViewById(R.id.tb_toolbarsearch);
        //lvToolbarSerch =(ListView) findViewById(R.id.lv_toolbarsearch);
        //adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrays);
        //lvToolbarSerch.setAdapter(adapter);
        //setSupportActionBar(tbMainSearch);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstance)
    {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);

        //loading the default fragment __HOME_FRAGMENT_
        loadFragment(new CartFragment());

        BottomNavigationView navigation =(BottomNavigationView) findViewById(R.id.navigation);
        //navigation.setOnNavigationItemSelectedListener(this);
        navigation.setOnNavigationItemSelectedListener(this);

//        setUpViews();
    }



    //function to handle fragment switching
    private boolean loadFragment(Fragment fragment)
    {
        if(fragment != null)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
      Fragment fragment = null;
      int id= item.getItemId();
      fragment = new CartFragment();
      return loadFragment(fragment);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    //inflating the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        MenuItem mSearchmenuItem = menu.findItem(R.id.msearch);
        SearchView searchView = (SearchView) mSearchmenuItem.getActionView();
        searchView.setQueryHint("enter Text");
        searchView.setOnQueryTextListener(this  );
        Log.d("MTDEBUG", "onCreateOptionsMenu: mSearchmenuItem->" + mSearchmenuItem.getActionView());

        return super.onCreateOptionsMenu(menu);
    }
    //function to respond the input event of the menu item
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
