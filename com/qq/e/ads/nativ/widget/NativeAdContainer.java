package com.qq.e.ads.nativ.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes4.dex */
public class NativeAdContainer extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private ViewStatusListener f11803a;

    /* renamed from: b  reason: collision with root package name */
    private ViewStatus f11804b;

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
        this.f11804b = ViewStatus.INIT;
    }

    public NativeAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11804b = ViewStatus.INIT;
    }

    public NativeAdContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11804b = ViewStatus.INIT;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f11803a != null) {
            this.f11803a.onDispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        GDTLogger.d("NativeAdContainer onAttachedToWindow");
        this.f11804b = ViewStatus.ATTACHED;
        if (this.f11803a != null) {
            this.f11803a.onAttachToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        GDTLogger.d("NativeAdContainer onDetachedFromWindow");
        this.f11804b = ViewStatus.DETACHED;
        if (this.f11803a != null) {
            this.f11803a.onDetachFromWindow();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        GDTLogger.d("onWindowFocusChanged: hasWindowFocus: " + z);
        if (this.f11803a != null) {
            this.f11803a.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        GDTLogger.d("onWindowVisibilityChanged: visibility: " + i);
        if (this.f11803a != null) {
            this.f11803a.onWindowVisibilityChanged(i);
        }
    }

    public void setViewStatusListener(ViewStatusListener viewStatusListener) {
        this.f11803a = viewStatusListener;
        if (this.f11803a != null) {
            switch (this.f11804b) {
                case ATTACHED:
                    this.f11803a.onAttachToWindow();
                    return;
                case DETACHED:
                    this.f11803a.onDetachFromWindow();
                    return;
                default:
                    return;
            }
        }
    }
}
