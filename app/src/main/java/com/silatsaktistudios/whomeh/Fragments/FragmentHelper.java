package com.silatsaktistudios.whomeh.Fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by SilatJedi on 9/29/17.
 *
 */

public class FragmentHelper {

    public static void setFragment(FragmentActivity activity, Fragment newFragment, int layoutId) {
        FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        ft.replace(layoutId, newFragment)
                .addToBackStack(null)
                .commit();
    }

}
