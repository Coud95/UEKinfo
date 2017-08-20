package pl.coud.uekinfo;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!isNetworkAvailable()) {
            Toast.makeText(this, "Brak połączenia z Internetem.\nPewne funkcjonalności nie będą działać.",
                    Toast.LENGTH_LONG).show();
        }
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.main_container, new HomeFragment());
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("UEKinfo");
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_id:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new HomeFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Aktualności");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.map_id:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new MapFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Plan kampusu");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.deanery_id:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new DeaneryFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Dziekanaty");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.year_id:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new YearFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Organizacja roku");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.wifi_id:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, new WiFiFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Wi-Fi dla studentów");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.schedule_id:
                        Intent intent = getPackageManager().getLaunchIntentForPackage("pl.konradwaniolka.uekplan");
                        if (intent != null) {
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        } else {
                            intent = new Intent(Intent.ACTION_VIEW);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.setData(Uri.parse("market://details?id=" + "pl.konradwaniolka.uekplan"));
                            startActivity(intent);
                        }
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.deanery_site_id:
                        Uri wd_url = Uri.parse("https://wd.uek.krakow.pl");
                        Intent intent1 = new Intent(Intent.ACTION_VIEW, wd_url);
                        startActivity(intent1);
                        getSupportActionBar().setTitle("Wirtualna Uczelnia UEK");
                        break;

                    case R.id.moodle_id:
                        Uri moodle_url = Uri.parse("https://e-uczelnia.uek.krakow.pl");
                        Intent intent2 = new Intent(Intent.ACTION_VIEW, moodle_url);
                        startActivity(intent2);
                        getSupportActionBar().setTitle("e-Uczelnia UEK");
                        break;

                    case R.id.language_id:
                        Uri cj_url = Uri.parse("https://cj.uek.krakow.pl");
                        Intent intent3 = new Intent(Intent.ACTION_VIEW, cj_url);
                        startActivity(intent3);
                        getSupportActionBar().setTitle("Centrum Językowe UEK");
                        break;
                }
                return true;
            }
        });
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
