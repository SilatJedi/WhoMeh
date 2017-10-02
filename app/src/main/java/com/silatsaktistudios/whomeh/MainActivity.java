package com.silatsaktistudios.whomeh;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.silatsaktistudios.whomeh.Fragments.DealDetailFragment;
import com.silatsaktistudios.whomeh.Fragments.FragmentHelper;
import com.silatsaktistudios.whomeh.Fragments.HistoryFragment;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity implements GetDealListener {

    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(this);

        AHBottomNavigation bottomNav = (AHBottomNavigation) findViewById(R.id.bottomNav);
        AHBottomNavigationItem dailyDealItem = new AHBottomNavigationItem("Daily Deal", R.drawable.currency_usd);
        AHBottomNavigationItem historyItem = new AHBottomNavigationItem("History", R.drawable.history);

        bottomNav.addItem(dailyDealItem);
        bottomNav.addItem(historyItem);
        if(Build.VERSION.SDK_INT < 23) {
            //set background color
            bottomNav.setDefaultBackgroundColor(getResources().getColor(R.color.mehBlue));
            // Change colors
            bottomNav.setAccentColor(getResources().getColor(R.color.white));
            bottomNav.setInactiveColor(getResources().getColor(R.color.mehBlueUnselect));
        }
        else {
            //set background color
            bottomNav.setDefaultBackgroundColor(getResources().getColor(R.color.mehBlue, null));
            // Change colors
            bottomNav.setAccentColor(getResources().getColor(R.color.white, null));
            bottomNav.setInactiveColor(getResources().getColor(R.color.mehBlueUnselect, null));
        }
        // Force to tint the drawable (useful for font with icon for example)
        bottomNav.setForceTint(true);
        // Manage titles
        bottomNav.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        bottomNav.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                switch (position) {
                    case 0: //daily deal
                        FragmentHelper.setFragment(MainActivity.this, DealDetailFragment.newInstance(null), R.id.fragmentContainer);
                        break;
                    case 1: //history
                        FragmentHelper.setFragment(MainActivity.this, HistoryFragment.newInstance(), R.id.fragmentContainer);
                        break;
                }
                return true;
            }
        });

        API.getFeed(this);
    }

    public void onGetDeal() {
        FragmentHelper.setFragment(MainActivity.this, DealDetailFragment.newInstance(null), R.id.fragmentContainer);
    }
}
