package com;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.cloudsdk.social.share.uiwithlayout.ShareDialog;
/* loaded from: classes.dex */
public class w implements View.OnTouchListener {
    final /* synthetic */ ShareDialog lp;
    final /* synthetic */ GestureDetector nI;

    public w(ShareDialog shareDialog, GestureDetector gestureDetector) {
        this.lp = shareDialog;
        this.nI = gestureDetector;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.nI.onTouchEvent(motionEvent);
    }
}
