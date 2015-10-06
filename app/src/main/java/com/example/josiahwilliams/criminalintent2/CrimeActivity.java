package com.example.josiahwilliams.criminalintent2;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class CrimeActivity extends FragmentActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime);

        //call getSupportFragmentManager because this uses the support library
        FragmentManager fm = getSupportFragmentManager();
        //create fragment for the manager to manage
        //if the fragment is in the list, Fragment manager will use it
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        //if there is no fragment, creates one and a new fragment transaction to add it to the list
        if (fragment == null) {
            fragment = new CrimeFragment();
            //create a new fragment transaction
            fm.beginTransaction()
                    //include one add operation
                    .add(R.id.fragment_container, fragment)
                    //then commit it
                    .commit();
        }

    }

}
