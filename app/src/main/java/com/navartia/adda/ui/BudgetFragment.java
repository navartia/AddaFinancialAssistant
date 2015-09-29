package com.navartia.adda.ui;

import android.os.Bundle;
import android.util.Log;

import butterknife.ButterKnife;

public class BudgetFragment extends UIFragment {
    // Static methods
    public static BudgetFragment newInstance(int id) {
        BudgetFragment fragment = new BudgetFragment();

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
