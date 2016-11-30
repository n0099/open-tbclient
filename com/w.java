package com;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.cloudsdk.social.share.uiwithlayout.ShareDialog;
/* loaded from: classes.dex */
public class w implements View.OnTouchListener {
    final /* synthetic */ ShareDialog dE;
    final /* synthetic */ GestureDetector fT;

    public w(ShareDialog shareDialog, GestureDetector gestureDetector) {
        this.dE = shareDialog;
        this.fT = gestureDetector;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.fT.onTouchEvent(motionEvent);
    }
}
