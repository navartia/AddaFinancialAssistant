package com.navartia.adda.ui;


import android.os.Bundle;

import butterknife.ButterKnife;

public class ExpensesFragment extends UIFragment {
    // Static methods
    public static ExpensesFragment newInstance(int id) {
        ExpensesFragment fragment = new ExpensesFragment();

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
