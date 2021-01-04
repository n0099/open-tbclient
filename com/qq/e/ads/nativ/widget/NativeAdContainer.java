package com.qq.e.ads.nativ.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes3.dex */
public class NativeAdContainer extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private ViewStatusListener f11802a;

    /* renamed from: b  reason: collision with root package name */
    private ViewStatus f11803b;

    /* loaded from: classes3.dex */
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
        this.f11803b = ViewStatus.INIT;
    }

    public NativeAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11803b = ViewStatus.INIT;
    }

    public NativeAdContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11803b = ViewStatus.INIT;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f11802a != null) {
            this.f11802a.onDispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        GDTLogger.d("NativeAdContainer onAttachedToWindow");
        this.f11803b = ViewStatus.ATTACHED;
        if (this.f11802a != null) {
            this.f11802a.onAttachToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        GDTLogger.d("NativeAdContainer onDetachedFromWindow");
        this.f11803b = ViewStatus.DETACHED;
        if (this.f11802a != null) {
            this.f11802a.onDetachFromWindow();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        GDTLogger.d("onWindowFocusChanged: hasWindowFocus: " + z);
        if (this.f11802a != null) {
            this.f11802a.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        GDTLogger.d("onWindowVisibilityChanged: visibility: " + i);
        if (this.f11802a != null) {
            this.f11802a.onWindowVisibilityChanged(i);
        }
    }

    public void setViewStatusListener(ViewStatusListener viewStatusListener) {
        this.f11802a = viewStatusListener;
        if (this.f11802a != null) {
            switch (this.f11803b) {
                case ATTACHED:
                    this.f11802a.onAttachToWindow();
                    return;
                case DETACHED:
                    this.f11802a.onDetachFromWindow();
                    return;
                default:
                    return;
            }
        }
    }
}
