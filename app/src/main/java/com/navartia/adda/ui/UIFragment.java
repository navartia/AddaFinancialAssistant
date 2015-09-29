package com.navartia.adda.ui;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public abstract class UIFragment extends Fragment {
    protected FragmentInteractionListener mListener;
    protected View view;
    protected int id;

    // Abstract methods
    protected abstract void bindView();

    // Fragment methods
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Fragment creation
        super.onCreate(savedInstanceState);

        id = getArguments().getInt("id", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(id, container, false);

        bindView();

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (FragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement FragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    // Public methods
    public int getViewId() {
        // Returns fragment id
        return id;
    }
}
