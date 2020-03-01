package com.thorschmidt.curso.atmconsulting;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_services, R.id.nav_clients, R.id.nav_contact, R.id.nav_about)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    private void sendEmail() {
        String cel = "tel:+5511989910000";
        String image = "https://images.pexels.com/photos/556416/pexels-photo-556416.jpeg";
        String address = "https://www.google.com/maps/place/Darmstadt/@49.8748969,8.5143959,11z/data=!3m1!4b1!4m5!3m4!1s0x47bd70641173cdd9:0x422435029b0c5f0!8m2!3d49.8728445!4d8.6512184";
        //Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(cel));
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(image));
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(address));
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"service@atmconsulting.com","client@atmconsulting.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "App Contact");
        intent.putExtra(Intent.EXTRA_TEXT, "Automatic Message");

        // set MIME type
        //intent.setType("text/plain");
        //intent.setType("image/*");
        //intent.setType("application/pdf");
        intent.setType("message/rfc822");

        startActivity(Intent.createChooser(intent,"Share"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
