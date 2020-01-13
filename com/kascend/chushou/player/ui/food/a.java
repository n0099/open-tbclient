package com.kascend.chushou.player.ui.food;

import android.content.Context;
import android.view.MotionEvent;
import com.kascend.chushou.widget.cswebview.CSWebView;
/* loaded from: classes4.dex */
public class a extends CSWebView {
    private boolean a;

    public a(Context context) {
        super(context);
        this.a = false;
    }

    public void setEnableTouch(boolean z) {
        this.a = z;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.a && super.onTouchEvent(motionEvent);
    }
}
