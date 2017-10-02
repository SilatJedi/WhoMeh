package com.silatsaktistudios.whomeh;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.silatsaktistudios.whomeh.Models.Deal;

import java.util.List;

/**
 * Created by SilatJedi on 10/2/17.
 */

public class HistoryListAdapter extends ArrayAdapter<Deal> {

    public HistoryListAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    public HistoryListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Deal> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
//            v = layoutInflater.inflate();
        }

        return v;
    }
}
