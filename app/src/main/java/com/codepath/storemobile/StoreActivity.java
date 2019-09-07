package com.codepath.storemobile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import fragments.FragmentClient;
import fragments.FragmentCommande;
import fragments.FragmentItems;

public class StoreActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_store );

        final FragmentManager fragmentManager = getSupportFragmentManager();

        bottomNavigationView = findViewById( R.id.bottom_navigation );


        bottomNavigationView.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                Fragment fragment;
                switch (menuItem.getItemId()) {
                    case R.id.action_items:
                        fragment = new FragmentItems();
                        // Toast.makeText( MainActivity.this, "Home", Toast.LENGTH_SHORT ).show();
                        break;
                    case R.id.action_commande:
                        fragment = new FragmentCommande();
                        // Toast.makeText( MainActivity.this, "Compose", Toast.LENGTH_SHORT ).show();
                        break;
                    case R.id.action_client:
                    default:

                        fragment = new FragmentClient();
                        // Toast.makeText( MainActivity.this, "Profile", Toast.LENGTH_SHORT ).show();
                        break;
                }
                fragmentManager.beginTransaction().replace( R.id.flContainer, fragment ).commit();
                return false;
            }
        } );
    }
}
