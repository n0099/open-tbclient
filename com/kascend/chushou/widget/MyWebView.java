package com.kascend.chushou.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.kascend.chushou.widget.cswebview.CSWebView;
/* loaded from: classes6.dex */
public class MyWebView extends CSWebView {

    /* renamed from: a  reason: collision with root package name */
    long f4249a;

    public MyWebView(Context context) {
        super(context);
        this.f4249a = 0L;
    }

    public MyWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4249a = 0L;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f4249a <= 300) {
                this.f4249a = currentTimeMillis;
                return true;
            }
            this.f4249a = currentTimeMillis;
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
