package org.sucareto.androidhidkeyboard;

import android.annotation.SuppressLint;
import android.view.HapticFeedbackConstants;
import android.view.MotionEvent;
import android.view.View;

public class KeyOnTouch implements View.OnTouchListener {
    private HidController hid;

    public KeyOnTouch(HidController hid) {
        this.hid = hid;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouch(View v, MotionEvent e) {
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN -> {
                v.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_PRESS);
                hid.kPress((byte) Integer.parseInt(v.getTag().toString(), 16));
            }
            case MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                hid.kRelease((byte) Integer.parseInt(v.getTag().toString(), 16));
            }
        }
        return false;
    }
}