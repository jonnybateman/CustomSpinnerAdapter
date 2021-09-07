/*------------------------------------------------------------------------------------------
 |              Class: CustomSpinnerAdapter.java
 |             Author: Jon Bateman
 |            Version: 1.0.1
 |
 |            Purpose: Custom adapter class for spinner item control.
 |
 |      Inherits from: ArrayAdapter.class
 |
 |         Interfaces: N/A
 |
 | Intent/Bundle Args: N/A
 +------------------------------------------------------------------------------------------
 |          Constants: N/A
 +------------------------------------------------------------------------------------------
 |       Constructors: CustomSpinnerAdapter(Context context, int textViewResourceId,
 |                             List<String> objects) {}
 |                         - context: interface to global information on the app environment.
 |                         - textViewResourceId: the identifier for the spinner item layout
 |                                               xml file.
 |                         - objects: list of strings each of which make up a single spinner
 |                                    item.
 +----------------------------------------------------------------------------------------*/
package com.cquelsoft.custom_spinner_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class CustomSpinnerAdapter extends ArrayAdapter<String> {

    private final List<String> objects;

    public CustomSpinnerAdapter(Context context, int textViewResourceId, List<String> objects) {
        super(context, textViewResourceId, objects);
        this.objects = objects;
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, parent);
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, parent);
    }

    private View getCustomView(int position, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View row = inflater.inflate(R.layout.custom_spinner_item, parent, false);

        // Setup the TextView for the current spinner item
        TextView spinnerItem = row.findViewById(R.id.spinnerTxtItem);
        spinnerItem.setText(objects.get(position));

        // Create a divider to separate spinner items.
        ImageView imgView = row.findViewById(R.id.imgView);
        imgView.setImageResource(R.drawable.spinner_divider);

        return row;
    }
}
