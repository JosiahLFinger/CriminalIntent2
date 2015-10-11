package com.example.josiahwilliams.criminalintent2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by Josiah Williams on 10/8/2015.
 */
public abstract class SingleFragmentActivity extends FragmentActivity{

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        //call getSupportFragmentManager because this uses the support library
        FragmentManager fm = getSupportFragmentManager();
        //create fragment for the manager to manage
        //if the fragment is in the list, Fragment manager will use it
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        //if there is no fragment, creates one and a new fragment transaction to add it to the list
        if (fragment == null) {
            //TODO why dont you work???            fragment = new createFragment();
            //create a new fragment transaction
            fm.beginTransaction()
                    //include one add operation
                    .add(R.id.fragment_container, fragment)
                            //then commit it
                    .commit();
        }

    }

}
