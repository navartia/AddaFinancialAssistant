package com.navartia.adda.ui;

import android.os.Bundle;

import com.navartia.adda.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

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

    @OnClick(R.id.button_income_cancel)
    public void clickButtonCancel() {
        // Send message to the activity
        mListener.sendMessage("Cancel", this);
    }
}
