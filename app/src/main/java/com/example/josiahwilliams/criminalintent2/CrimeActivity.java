package com.example.josiahwilliams.criminalintent2;


import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {

    public static final String EXTRA_CRIME_ID = "com.example.josiahwilliams.cfriminalintent2.crime_id";

    //method builds and adds intent that stores the crime id for the view to get correct information
    public static Intent newIntent(Context packageContext, UUID crimeID) {
        Intent intent = new Intent (packageContext, CrimeActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeID);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }

}
