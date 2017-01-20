package com;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.cloudsdk.social.share.uiwithlayout.ShareDialog;
/* loaded from: classes.dex */
public class w implements View.OnTouchListener {
    final /* synthetic */ ShareDialog dC;
    final /* synthetic */ GestureDetector fQ;

    public w(ShareDialog shareDialog, GestureDetector gestureDetector) {
        this.dC = shareDialog;
        this.fQ = gestureDetector;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.fQ.onTouchEvent(motionEvent);
    }
}
