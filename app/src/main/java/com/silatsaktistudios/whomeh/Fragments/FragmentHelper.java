package com.silatsaktistudios.whomeh.Fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by SilatJedi on 9/29/17.
 */

public class FragmentHelper {
    /*
    /Example: FragmentHelper.setFragment(MainActivity.this, DemoFragment.newInstance(), R.id.fragment_container);
    */
    public static void setFragment(FragmentActivity activity, Fragment newFragment, int layoutId) {
        FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        ft.replace(layoutId, newFragment)
                .addToBackStack(null)
                .commit();
    }

}
