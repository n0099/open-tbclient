package com;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.cloudsdk.social.share.uiwithlayout.ShareDialog;
/* loaded from: classes.dex */
public class v extends GestureDetector.SimpleOnGestureListener {
    final /* synthetic */ ShareDialog fS;

    public v(ShareDialog shareDialog) {
        this.fS = shareDialog;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        EditText editText;
        if (motionEvent2.getY() - motionEvent.getY() <= 100.0f || Math.abs(f2) <= 200.0f) {
            return true;
        }
        editText = this.fS.m;
        ((InputMethodManager) this.fS.getContext().getSystemService("input_method")).hideSoftInputFromWindow(editText.getApplicationWindowToken(), 0);
        return true;
    }
}
