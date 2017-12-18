package com.scibots.scibot.butturemo;

import android.content.Context;
import android.hardware.ConsumerIrManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    ConsumerIrManager mCIR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCIR = (ConsumerIrManager) getSystemService(Context.CONSUMER_IR_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
        setContentView(R.layout.activity_main);



    }
    public void IncVolume(View view) {
        if (!mCIR.hasIrEmitter()) {
            Log.e(TAG, "No IR Emitter found\n");
            return;
        }
        int[] pattern = {625, 4453, 625, 1614, 625, 1588, 625, 1614, 625, 442, 625, 442, 625,
                468, 625, 442, 625, 494, 572, 1614, 625, 1588, 625, 1614, 625, 494, 572, 442, 651,
                442, 625, 442, 625, 442, 625, 1614, 625, 1588, 442, 1588, 625, 442, 625, 494, 598,
                442, 625, 442, 625, 520, 572, 442, 625, 442, 625, 442, 651, 1588, 625, 1614, 625,
                1588, 625, 1614, 625, 1588, 625, 48958};
        mCIR.transmit(38400, pattern);
    }
    public void DecVolume(View view) {
        if (!mCIR.hasIrEmitter()) {
            Log.e(TAG, "No IR Emitter found\n");
            return;
        }

        int[] pattern = {442, 4453, 625, 1614, 625, 1588, 625, 1614, 625, 442, 625, 442, 625,
                468, 625, 442, 625, 494, 572, 1614, 625, 1588, 625, 1614, 625, 494, 572, 442, 651,
                442, 625, 442, 625, 442, 625, 1614, 625, 1588, 442, 1588, 625, 442, 625, 494, 598,
                442, 625, 442, 625, 520, 572, 442, 625, 442, 625, 442, 651, 1588, 625, 1614, 625,
                1588, 625, 1614, 625, 1588, 625, 48958};
        mCIR.transmit(38400, pattern);

    }
}
