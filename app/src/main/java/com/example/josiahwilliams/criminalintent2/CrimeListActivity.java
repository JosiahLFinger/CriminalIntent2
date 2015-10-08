package com.example.josiahwilliams.criminalintent2;

import android.support.v4.app.Fragment;

/**
 * Created by Josiah Williams on 10/8/2015.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }

}
