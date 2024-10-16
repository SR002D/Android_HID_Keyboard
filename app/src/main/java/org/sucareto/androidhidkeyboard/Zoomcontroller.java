package org.sucareto.androidhidkeyboard;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Zoomcontroller extends AppCompatActivity {
    HidController hid = new HidController();

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("controller", "onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoomcontroller);

        KeyOnTouch keyOnTouch = new KeyOnTouch(hid);
        String packageName = getPackageName();

        for (int i = 1; i <= 12; i++) {
            int resId = getResources().getIdentifier("c" + i, "id", packageName);
            if (resId != 0) {
                findViewById(resId).setOnTouchListener(keyOnTouch);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (hid.kInit()) {
            Toast.makeText(this, R.string.msg_e_hid, Toast.LENGTH_LONG).show();
        }
    }
}
