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
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        setContentView(R.layout.activity_main);



    }
    public void IncVolume(View view) {
        if (!mCIR.hasIrEmitter()) {
            Log.e(TAG, "No IR Emitter found\n");
            return;
        }
        ConsumerIrManager.CarrierFrequencyRange[] freqs = mCIR.getCarrierFrequencies();
        for (ConsumerIrManager.CarrierFrequencyRange range : freqs) {
           Log.d(TAG,String.format("    %d - %d\n", range.getMinFrequency(),
                   range.getMaxFrequency()));
        }
    }
    public void DecVolume(View view) {

    }
}
