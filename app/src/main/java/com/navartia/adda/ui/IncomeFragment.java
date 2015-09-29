package com.navartia.adda.ui;

import android.os.Bundle;

import butterknife.ButterKnife;

public class IncomeFragment extends UIFragment {
    // Static methods
    public static IncomeFragment newInstance(int id) {
        IncomeFragment fragment = new IncomeFragment();

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
