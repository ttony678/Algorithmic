package com.fambam.algorithmic.algorithmic;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

// SET WEIGHTTT

public class NewAlgorithmActivity extends AppCompatActivity {
    private Algorithm algorithm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_graphics);

        // TODO Get intent from main activity and load that into Algorithm Fragment
        //Get the drawable identifiers from the intent
        String algoKey = getString(R.string.algo_key);
        String drawKey = getString(R.string.drawables);
        String dataKey = getString(R.string.data);
        Intent callingIntent = getIntent();
        this.algorithm = callingIntent.getParcelableExtra(algoKey);
        int[] drawableIds = callingIntent.getIntArrayExtra(drawKey);
        int[] data = callingIntent.getIntArrayExtra(dataKey);


        // Passing data to fragment through the Bundle() class
        Bundle bundle = new Bundle();
        bundle.putParcelable(algoKey, (Parcelable) this.algorithm);
        bundle.putIntArray(drawKey, drawableIds);
        bundle.putIntArray(dataKey, data);
        AlgorithmFragment algorithmFragment = new AlgorithmFragment();
        algorithmFragment.setArguments(bundle);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.add(R.id.algorithm_fragment, algorithmFragment);
        ft.commit();
    }

    public void swap(View view) {
        /*
        ConstraintLayout baseLayout = findViewById(R.id.graphics_layout);
        ConstraintSet set = new ConstraintSet();
        set.clone(baseLayout);

        if (this.algorithm.hasNext()) {
            set = this.algorithm.next(set);
        }
        TransitionManager.beginDelayedTransition(baseLayout);
        set.applyTo(baseLayout);
        */

        AlgorithmFragment a = (AlgorithmFragment) getFragmentManager().findFragmentById(R.id.algorithm_fragment);
        a.updateTextView();


    }

    public void updateTextView(View view) {
        AlgorithmFragment a = (AlgorithmFragment) getFragmentManager().findFragmentById(R.id.algorithm_fragment);
        a.updateTextView("Helllloooooooo");
    }
}