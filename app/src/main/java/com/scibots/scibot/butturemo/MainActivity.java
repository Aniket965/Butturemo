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
        int[] pattern = {8800, 4600, 450, 650, 450, 700, 450, 650, 450, 700, 400, 700, 450, 650, 450, 700, 400, 1800, 450, 1800, 400, 1850, 400, 1850, 400, 1850, 400, 1800, 400, 1850, 400, 1850, 400, 700, 400, 750, 400, 1850, 350, 750, 400, 750, 350, 700, 450, 700, 400, 700, 400, 750, 400, 1850, 350, 750, 400, 1850, 400, 1850, 400, 1800, 450, 1800, 400, 1850, 400, 1800, 400};
        mCIR.transmit(38400, pattern);
    }
    public void DecVolume(View view) {
        if (!mCIR.hasIrEmitter()) {
            Log.e(TAG, "No IR Emitter found\n");
            return;
        }

        int[] pattern = {8800, 4600, 450, 700, 450, 650, 450, 700, 400, 700, 450, 650, 450, 700, 400, 700, 400, 1850, 400, 1850, 400, 1850, 400, 1850, 400, 1800, 400, 1850, 400, 1800, 450, 1800, 400, 750, 400, 1850, 350, 1850, 450, 700, 400, 700, 400, 750, 350, 750, 400, 700, 400, 750, 350, 800, 350, 700, 400, 1900, 350, 1900, 350, 1850, 400, 1850, 350, 1900, 350, 1900, 300};
        mCIR.transmit(38400, pattern);

    }
}
