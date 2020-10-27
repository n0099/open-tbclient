package com.kascend.chushou.player.ui.food;

import android.content.Context;
import android.view.MotionEvent;
import com.kascend.chushou.widget.cswebview.CSWebView;
/* loaded from: classes6.dex */
public class a extends CSWebView {

    /* renamed from: a  reason: collision with root package name */
    private boolean f4155a;

    public a(Context context) {
        super(context);
        this.f4155a = false;
    }

    public void setEnableTouch(boolean z) {
        this.f4155a = z;
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f4155a && super.onTouchEvent(motionEvent);
    }
}
