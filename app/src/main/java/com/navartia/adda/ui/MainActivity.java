package com.navartia.adda.ui;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.navartia.adda.R;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MainActivity extends Activity implements FragmentInteractionListener, FragmentChangeListener {
    // Adapter for the fragment pages
    SectionsPagerAdapter mSectionsPagerAdapter;

    // Host of the section contents.
    ViewPager mViewPager;

    // Handles fragment changes
    FragmentTransaction ft;

    // Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the adapter that will return a fragment for each sections of the activity
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // FragmentInteractionListener
    @Override
    public void sendMessage(String message) {
        switch(message) {
            case "Income":
                UIFragment income = IncomeFragment.newInstance(R.layout.fragment_income);
                replaceFragment(R.id.dialog_layout, income);
                break;
            case "Expenses":
                UIFragment expenses = ExpensesFragment.newInstance(R.layout.fragment_expenses);
                replaceFragment(R.id.dialog_layout, expenses);
                break;
        }
    }

    @Override
    public void sendMessage(String message, Object data) {
        switch(message) {
            case "Cancel":
                removeFragment((UIFragment) data);
                break;

        }
    }

    // FragmentChangeListener
    @Override
    public void addFragment(int id, UIFragment fragment) {
        ft = getFragmentManager().beginTransaction();
        ft.add(id, fragment);
        ft.commit();

        Log.d("Adda", "Add");
    }

    @Override
    public void replaceFragment(int id, UIFragment fragment) {
        ft = getFragmentManager().beginTransaction();
        ft.replace(id, fragment);
        ft.addToBackStack(null);
        ft.commit();

        Log.d("Adda", "Replace");
    }

    @Override
    public void removeFragment(UIFragment fragment) {
        ft = getFragmentManager().beginTransaction();
        ft.remove(fragment);
        ft.commit();

        Log.d("Adda", "Remove");
    }

    @Override
    public void hideFragment(UIFragment fragment) {
        ft = getFragmentManager().beginTransaction();
        ft.hide(fragment);
        ft.commit();

        Log.d("Adda", "Hide");
    }

    @Override
    public void showFragment(UIFragment fragment) {
        ft = getFragmentManager().beginTransaction();
        ft.show(fragment);
        ft.addToBackStack(null);
        ft.commit();

        Log.d("Adda", "Show");
    }

    // Returns the fragment corresponding to the page position
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        private Map<Integer, String> mFragmentTags;
        private FragmentManager mFragmentManager;

        public SectionsPagerAdapter(FragmentManager fm) {
            // Pass the FragmentManager to super class
            super(fm);

            // Initialize global variables
            mFragmentManager = fm;
            mFragmentTags = new HashMap<Integer, String>();

        }

        // Overridden methods
        @Override
        public Fragment getItem(int position) {
            switch(position % 3) {
                case 0:
                    return BalanceSheetFragment.newInstance(R.layout.fragment_balance_sheet);
                case 1:
                    return BudgetFragment.newInstance(R.layout.fragment_budget);
                case 2:
                    return GoalsFragment.newInstance(R.layout.fragment_goals);
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Object obj = super.instantiateItem(container, position);
            if (obj instanceof Fragment) {
                // record the fragment tag here.
                Fragment f = (Fragment) obj;
                String tag = f.getTag();
                mFragmentTags.put(position, tag);
            }
            return obj;
        }

        public Fragment getFragment(int position) {
            String tag = mFragmentTags.get(position);
            if (tag == null)
                return null;
            return mFragmentManager.findFragmentByTag(tag);
        }
    }
}