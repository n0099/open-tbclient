package com;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.cloudsdk.social.share.uiwithlayout.ShareDialog;
/* loaded from: classes.dex */
public class w implements View.OnTouchListener {
    final /* synthetic */ ShareDialog dD;
    final /* synthetic */ GestureDetector fS;

    public w(ShareDialog shareDialog, GestureDetector gestureDetector) {
        this.dD = shareDialog;
        this.fS = gestureDetector;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.fS.onTouchEvent(motionEvent);
    }
}
