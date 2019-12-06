package com.example.timestableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        final ListView listView = (ListView) findViewById(R.id.Listview);

                int progress = 10;

        seekBar.setProgress(progress);
            seekBar.setMax(20);

            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                    int min = 1;
                        int timestable ;

                        if ( i < min) {
                            timestable = min;
                            seekBar.setProgress(min);
                        }
                        else {
                            timestable = i;
                            seekBar.setProgress(timestable);
                        }

                    ArrayList<String> arrayList = new ArrayList<String>();

                    for (int j = 1; j <=10 ; j++) {

                        arrayList.add(Integer.toString(j * timestable));
                    }

                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this
                            ,android.R.layout.select_dialog_item,arrayList);

                    listView.setAdapter(arrayAdapter);

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }
                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
    }
}
