package com.navartia.adda.ui;

public interface FragmentChangeListener {
    void addFragment(int id, UIFragment fragment);
    void replaceFragment(int id, UIFragment fragment);
    void hideFragment(UIFragment fragment);
    void showFragment(UIFragment fragment);
}
