package com.qq.e.ads.nativ.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.qq.e.comm.util.GDTLogger;
/* loaded from: classes7.dex */
public class NativeAdContainer extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public ViewStatusListener f39100a;

    /* renamed from: b  reason: collision with root package name */
    public ViewStatus f39101b;

    /* renamed from: com.qq.e.ads.nativ.widget.NativeAdContainer$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f39102a;

        static {
            int[] iArr = new int[ViewStatus.values().length];
            f39102a = iArr;
            try {
                iArr[ViewStatus.ATTACHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f39102a[ViewStatus.DETACHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public enum ViewStatus {
        INIT,
        ATTACHED,
        DETACHED
    }

    public NativeAdContainer(Context context) {
        super(context);
        this.f39101b = ViewStatus.INIT;
    }

    public NativeAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f39101b = ViewStatus.INIT;
    }

    public NativeAdContainer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f39101b = ViewStatus.INIT;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewStatusListener viewStatusListener = this.f39100a;
        if (viewStatusListener != null) {
            viewStatusListener.onDispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        GDTLogger.d("NativeAdContainer onAttachedToWindow");
        this.f39101b = ViewStatus.ATTACHED;
        ViewStatusListener viewStatusListener = this.f39100a;
        if (viewStatusListener != null) {
            viewStatusListener.onAttachToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        GDTLogger.d("NativeAdContainer onDetachedFromWindow");
        this.f39101b = ViewStatus.DETACHED;
        ViewStatusListener viewStatusListener = this.f39100a;
        if (viewStatusListener != null) {
            viewStatusListener.onDetachFromWindow();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        GDTLogger.d("onWindowFocusChanged: hasWindowFocus: " + z);
        ViewStatusListener viewStatusListener = this.f39100a;
        if (viewStatusListener != null) {
            viewStatusListener.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        GDTLogger.d("onWindowVisibilityChanged: visibility: " + i2);
        ViewStatusListener viewStatusListener = this.f39100a;
        if (viewStatusListener != null) {
            viewStatusListener.onWindowVisibilityChanged(i2);
        }
    }

    public void setViewStatusListener(ViewStatusListener viewStatusListener) {
        this.f39100a = viewStatusListener;
        if (viewStatusListener != null) {
            int i2 = AnonymousClass1.f39102a[this.f39101b.ordinal()];
            if (i2 == 1) {
                this.f39100a.onAttachToWindow();
            } else if (i2 != 2) {
            } else {
                this.f39100a.onDetachFromWindow();
            }
        }
    }
}
