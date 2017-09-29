package com.silatsaktistudios.whomeh.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.silatsaktistudios.whomeh.Models.Deal;
import com.silatsaktistudios.whomeh.R;

import io.realm.Realm;

/**
 * Created by SilatJedi on 9/29/17.
 *
 */

public class DealDetailFragment extends Fragment {

    private Deal deal;

    public static DealDetailFragment pastDeal(String id) {
        Realm realm = Realm.getDefaultInstance();
        DealDetailFragment fragment = new DealDetailFragment();
        fragment.deal = realm.where(Deal.class).equalTo("id", id).findFirst();
        return fragment;
    }

    public static DealDetailFragment dailyDeal() {
        Realm realm = Realm.getDefaultInstance();
        DealDetailFragment fragment = new DealDetailFragment();
        fragment.deal = realm.where(Deal.class).findAll().last();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_deal_detail, container, false);

        return v;
    }
}
