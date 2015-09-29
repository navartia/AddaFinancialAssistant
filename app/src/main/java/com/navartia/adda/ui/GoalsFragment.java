package com.navartia.adda.ui;

import android.os.Bundle;

import butterknife.ButterKnife;

public class GoalsFragment extends UIFragment {
    // Static methods
    public static GoalsFragment newInstance(int id) {
        GoalsFragment fragment = new GoalsFragment();

        Bundle args = new Bundle();
        args.putInt("id", id);
        fragment.setArguments(args);

        return fragment;
    }

    // Inherited methods
    @Override
    protected void bindView() {
        // Bind ButterKnife
        ButterKnife.bind(this, view);
    }
}
