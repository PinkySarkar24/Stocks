package com.example.stocks;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.AdapterView;
import android.view.View.OnFocusChangeListener;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.lang.String;
import android.widget.Button;
import android.content.Intent;
import android.view.View.OnClickListener;



public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

        ListView myList;
        SearchView mySearch;
        ArrayList<String>list;
        ArrayAdapter<String>adapter;
        MenuItem click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();

        click=(MenuItem) findViewById(R.id.home);
        String date_n = new SimpleDateFormat( "MMM dd", Locale.getDefault()).format(new Date());

        TextView tv_date=findViewById(R.id.date);
        tv_date.setText(date_n);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myList=(ListView)findViewById(R.id.myList);
        mySearch=(SearchView)findViewById(R.id.mySearch);


        list=new ArrayList<String>();
        list.add("Aamra Networks Limited"); list.add("AB Bank Limited "); list.add("ACI Limited"); list.add("The ACME Laboratories Limited"); list.add("Advent Pharma Limited"); list.add("Agni Systems Ltd."); list.add("Agrani Insurance Co. Ltd.");
        list.add("Asia Insurance Limited "); list.add("Apex Foods Limited "); list.add("Aziz Pipes Ltd");
        list.add("Bangas Ltd."); list.add("Bank Asia Ltd."); list.add("Bata Shoe Company (Bangladesh) Limited"); list.add("British American Tobacco bangladesh Company Limited"); list.add("BBS Cables Limited"); list.add("Bangladesh Services Ltd. "); list.add("Bangladesh Export Import Company Ltd");
        list.add("Bashundhara Paper Mills Limited"); list.add("BRAC Bank Ltd."); list.add("BSRM Steels Limited"); list.add("Beximco Pharmaceuticals Ltd."); list.add("Beximco Synthetics Ltd. "); list.add("Daffodil Computers Ltd."); list.add("Delta Spinners Ltd."); list.add("Dhaka Electric Supply Company Ltd");
        list.add("Dhaka Bank Ltd."); list.add("Dhaka Insurance Limited"); list.add("Dutch-Bangla Bank Ltd."); list.add("Eastern Insurance Company Ltd."); list.add("Eastern Lubricants Ltd."); list.add("Eastern Bank Ltd."); list.add("Eastern Housing Limited"); list.add("Export Import (Exim) Bank of Bangladesh Limited");
        list.add("Familytex (BD) Limited"); list.add("First Security Islami Bank Limited"); list.add("Fortune Shoes Limited"); list.add("Fu-Wang Ceramic Industries Ltd. "); list.add("Fu Wang Food Ltd."); list.add("Golden Harvest Agro Industries Ltd."); list.add("GlaxoSmithKline(GSK) Bangladesh Ltd"); list.add("Grameenphone Ltd.");
        list.add("Hakkani Pulp & Paper Mills Ltd. "); list.add("Hamid Fabrics Limited"); list.add("The IBN SINA Pharmaceutical Industry Ltd. "); list.add("Indo-Bangla Pharmaceuticals Limited"); list.add("IFAD Autos Limited"); list.add("IFIC Bank Ltd."); list.add("Jamuna Bank Ltd."); list.add("Janata Insurance Company Ltd. ");
        list.add("Karnaphuli Insurance Company Ltd"); list.add("Keya Cosmetics Ltd."); list.add("LankaBangla Finance Ltd"); list.add("Marico Bangladesh Limited "); list.add("Marico Bangladesh Limited "); list.add("Northern Jute Manufacturing Co. Ltd."); list.add("Nurani Dyeing & Sweater Limited"); list.add("Olympic Accessories Limited");
        list.add("Orion Pharma Ltd. "); list.add("Pacific Denims Limited "); list.add("Peoples Insurance Company Ltd."); list.add("Pioneer Insurance Comapny Ltd."); list.add("Prime Bank Ltd."); list.add("Pubali Bank Ltd."); list.add("Quasem Industries Ltd."); list.add("Regent Textile Mills Limited");
        list.add("Renata Ltd."); list.add("Rupali Bank Ltd"); list.add("Rupali Life Insurance Company Limited"); list.add("Sinobangla Industries Ltd"); list.add("Shahjibazar Power Co. Ltd."); list.add("Sunlife Insurance Company Limited "); list.add("10 Years BGT Bond Issued 04.03.2009"); list.add("10 Years 8.5% BGT Bond Issued 040405");
        list.add("United Commercial Bank Ltd."); list.add("Union Capital Limited"); list.add("Uttara Bank Limited"); list.add("Vanguard AML BD Finance Mutual Fund One"); list.add("Vanguard AML Rupali Bank Balanced Fund"); list.add("VFS Thread Dyeing Limited"); list.add("Yeakin Polymer Limited"); list.add("Wata Chemicals Limited");
        list.add("Western Marine Shipyard Limited "); list.add("Yeakin Polymer Limited "); list.add("Zaheen Spinning Limited"); list.add("Zahintex Industries Limited"); list.add("Zeal Bangla Sugar Mills Ltd.");

        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        myList.setAdapter(adapter);
        list=new ArrayList<String>();
        mySearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {


        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
