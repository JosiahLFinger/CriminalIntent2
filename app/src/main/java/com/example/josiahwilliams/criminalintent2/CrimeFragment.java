package com.example.josiahwilliams.criminalintent2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by Josiah Williams on 10/5/2015.
 */
public class CrimeFragment extends Fragment {

    private Crime mCrime;
    private EditText mTitleField;

    @Override
    //fragment onCreate is public so it can be called by whatever is hosting the fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mCrime = new Crime();

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

        return v;
    }

}
