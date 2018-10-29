package com.example.student.metropicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int CODE_SELECT_STATION = 1;
    private static final String ACTION_PICK =
            "com.example.student.metropicker.intent.action.PICK_METRO_STATION";
    TextView mSelectedStation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSelectedStation = (TextView) findViewById(R.id.selectedStation);
        mSelectedStation.setText(R.string.no_station_selected_msg);
    }

    public void onClick(View view) {
//        Intent intent = new Intent(this, StationPickActivity.class);
        Intent intent = new Intent(ACTION_PICK);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, CODE_SELECT_STATION);
        } else {
            Toast.makeText(this, R.string.no_activity_msg,
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    Intent data) {
        if (requestCode == CODE_SELECT_STATION) {
            if (resultCode == RESULT_OK) {
                mSelectedStation.setText(data
                        .getStringExtra(StationPickActivity
                                .EXTRA_SELECTED_STATION));
            } else {
                mSelectedStation.setText(
                        R.string.no_station_selected_msg);
            }
        }
    }
}
