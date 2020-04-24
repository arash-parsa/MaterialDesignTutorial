package com.example.materialdesigntutorial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation_main);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_home:
                    FragmentTransaction fragmentTransaction1= getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.frame_main_fragmentContainer,new FragmentMain());
                    fragmentTransaction1.commit();
                    break;
                    case R.id.menu_nearby:
                        FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction2.replace(R.id.frame_main_fragmentContainer,new NearbyFragment());
                        fragmentTransaction2.commit();
                        break;
                    case R.id.menu_recents:
                        FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction3.replace(R.id.frame_main_fragmentContainer,new RecentsFragment());
                        fragmentTransaction3.commit();
                        break;
                }

                return true;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.menu_home);

        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {

            }
        });

    }
}
