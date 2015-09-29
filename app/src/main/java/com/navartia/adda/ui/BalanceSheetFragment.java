package com.navartia.adda.ui;

import android.os.Bundle;

import com.navartia.adda.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class BalanceSheetFragment extends UIFragment {
    // Static methods
    public static BalanceSheetFragment newInstance(int id) {
        BalanceSheetFragment fragment = new BalanceSheetFragment();

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

    // ButterKnife injection methods
    @OnClick(R.id.button_income)
    public void clickButtonIncome() {
        //Send message to main activity
        mListener.sendMessage("Income");
    }

    @OnClick(R.id.button_expenses)
    public void clickButtonExpenses() {
        //Send message to main activity
        mListener.sendMessage("Expenses");
    }
}
