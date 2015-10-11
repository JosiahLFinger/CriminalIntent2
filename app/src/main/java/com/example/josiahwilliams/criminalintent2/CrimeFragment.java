package com.example.josiahwilliams.criminalintent2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;

/**
 * Created by Josiah Williams on 10/5/2015.
 */
public class CrimeFragment extends Fragment {

    private static final String ARG_CRIME_ID = "crime_id";

    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;

    //new method called whenever CrimeFragment needs to create a crimefragment.
    public static CrimeFragment newInstance(UUID crimeId) {
        Bundle args = new Bundle();
        //save crimeId to args
        args.putSerializable(ARG_CRIME_ID, crimeId);

        //create new fragment and give it the id from above argument
        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    //fragment onCreate is public so it can be called by whatever is hosting the fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UUID crimeId = (UUID) getArguments().getSerializable(ARG_CRIME_ID);

        mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //inflates the fragment view and passes in the layout id
        //2nd parameter is the view's parent
        //3rd parameter tells the inflater whether to add the inflated view to the view's parent
        //it's false because i will add the view within the code
        View v = inflater.inflate(R.layout.fragment_crime, container, false);

        mTitleField = (EditText) v.findViewById(R.id.crime_title);
        //sets the titleview
        mTitleField.setText(mCrime.getTitle());
        //listener for whenever user changes the text in the titlefield
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //intentionally left blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //s is user's input and changes the title text
                mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //this one too
            }
        });

        mDateButton = (Button)v.findViewById(R.id.crime_date_button);
        //sets button text to the date
        //formatted for chapter 8 challenge
        mDateButton.setText(android.text.format.DateFormat.format("MMM-dd-yyyy", mCrime.getDate()));
        //button disabled for now
        mDateButton.setEnabled(false);

        mSolvedCheckBox = (CheckBox)v.findViewById(R.id.crime_solved_check_box);
        //set checkbox based on if it's solved
        mSolvedCheckBox.setChecked(mCrime.isSolved());
        //set listener for when checkbox is changed
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Set the crime's solved property
                mCrime.setSolved(isChecked);
            }
        });

        return v;
    }

}
