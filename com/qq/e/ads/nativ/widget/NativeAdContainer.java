package com.qq.e.ads.nativ.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes4.dex */
public class NativeAdContainer extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private ViewStatusListener f7537a;
    private ViewStatus b;

    /* loaded from: classes4.dex */
    private enum ViewStatus {
        INIT,
        ATTACHED,
        DETACHED
    }

    static {
        NativeAdContainer.class.getSimpleName();
    }

    public NativeAdContainer(Context context) {
        super(context);
        this.b = ViewStatus.INIT;
    }

    public NativeAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = ViewStatus.INIT;
    }

    public NativeAdContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = ViewStatus.INIT;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f7537a != null) {
            this.f7537a.onDispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        GDTLogger.d("NativeAdContainer onAttachedToWindow");
        this.b = ViewStatus.ATTACHED;
        if (this.f7537a != null) {
            this.f7537a.onAttachToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        GDTLogger.d("NativeAdContainer onDetachedFromWindow");
        this.b = ViewStatus.DETACHED;
        if (this.f7537a != null) {
            this.f7537a.onDetachFromWindow();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        GDTLogger.d("onWindowFocusChanged: hasWindowFocus: " + z);
        if (this.f7537a != null) {
            this.f7537a.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        GDTLogger.d("onWindowVisibilityChanged: visibility: " + i);
        if (this.f7537a != null) {
            this.f7537a.onWindowVisibilityChanged(i);
        }
    }

    public void setViewStatusListener(ViewStatusListener viewStatusListener) {
        this.f7537a = viewStatusListener;
        if (this.f7537a != null) {
            switch (this.b) {
                case ATTACHED:
                    this.f7537a.onAttachToWindow();
                    return;
                case DETACHED:
                    this.f7537a.onDetachFromWindow();
                    return;
                default:
                    return;
            }
        }
    }
}
