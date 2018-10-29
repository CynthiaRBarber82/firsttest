package com.example.student.metropicker;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class StationPickActivity extends ListActivity implements AdapterView.OnItemClickListener {

    static final String EXTRA_SELECTED_STATION = "SELECTED_STATION";
    String[] mStations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mStations = getResources().getStringArray(R.array.stations);
        ArrayAdapter<String> aa = new ArrayAdapter<>(this,
                R.layout.list_view,
                mStations);
        getListView().setAdapter(aa);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {

        CharSequence stationSelected = ((TextView) view).getText();
        Intent result = new Intent();
        result.putExtra(EXTRA_SELECTED_STATION, stationSelected);
        setResult(RESULT_OK, result);
        finish();
    }
}

