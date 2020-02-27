package com.kascend.chushou.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.kascend.chushou.widget.cswebview.CSWebView;
/* loaded from: classes5.dex */
public class MyWebView extends CSWebView {
    long a;

    public MyWebView(Context context) {
        super(context);
        this.a = 0L;
    }

    public MyWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0L;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.a <= 300) {
                this.a = currentTimeMillis;
                return true;
            }
            this.a = currentTimeMillis;
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
