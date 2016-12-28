package com.xzw.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ViewFlipper;

/**
 * Created by daniel.xiao on 2016/12/28.
 */

public class FourthActivity extends Activity{

    ViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fourth_activity);
        flipper = (ViewFlipper) findViewById(R.id.flipper);
        flipper.startFlipping();
    }
}
