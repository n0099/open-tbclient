package com;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.cloudsdk.social.share.uiwithlayout.ShareDialog;
/* loaded from: classes.dex */
public class r implements View.OnTouchListener {
    final /* synthetic */ GestureDetector a;
    final /* synthetic */ ShareDialog b;

    public r(ShareDialog shareDialog, GestureDetector gestureDetector) {
        this.b = shareDialog;
        this.a = gestureDetector;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.a.onTouchEvent(motionEvent);
    }
}
