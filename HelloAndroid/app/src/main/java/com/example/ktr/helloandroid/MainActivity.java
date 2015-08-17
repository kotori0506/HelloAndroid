package com.example.ktr.helloandroid;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.test.ActivityUnitTestCase;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;


public class MainActivity extends Activity implements SeekBar.OnSeekBarChangeListener {

    private Button buttonPushMe;
    private ImageView imageAndroid;

    private SeekBar seekBarRed;
    private SeekBar seekBargreen;
    private SeekBar seekBarblue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPushMe = (Button) findViewById(R.id.btn_pushme);
        buttonPushMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonPushMe.setText("Pushed!!");
                imageAndroid.setImageResource(R.drawable.androidtst2);
            }
        });

        imageAndroid=(ImageView) findViewById(R.id.iv_android);

        seekBarRed=(SeekBar) findViewById(R.id.sb_red);
        seekBarRed.setOnSeekBarChangeListener(this);

        seekBargreen=(SeekBar) findViewById(R.id.sb_green);
        seekBargreen.setOnSeekBarChangeListener(this);

        seekBarblue=(SeekBar) findViewById(R.id.sb_blue);
        seekBarblue.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar,int progress,boolean fromUser){
        int red=seekBarRed.getProgress();
        int green=seekBargreen.getProgress();
        int blue=seekBarblue.getProgress();
        imageAndroid.setColorFilter(Color.rgb(red, green, blue), PorterDuff.Mode.LIGHTEN);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
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
}
