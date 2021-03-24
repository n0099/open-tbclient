package com.kwad.sdk.core.page.recycle;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.WebViewClient;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.VelocityTrackerCompat;
import com.kwad.sdk.core.page.widget.webview.KsAdWebView;
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class NestedScrollWebView extends KsAdWebView implements NestedScrollingChild {

    /* renamed from: c  reason: collision with root package name */
    public int f33920c;

    /* renamed from: d  reason: collision with root package name */
    public int f33921d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f33922e;

    /* renamed from: f  reason: collision with root package name */
    public final int[] f33923f;

    /* renamed from: g  reason: collision with root package name */
    public int f33924g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f33925h;
    public int i;
    public int j;
    public NestedScrollingChildHelper k;
    public VelocityTracker l;
    public int m;

    public NestedScrollWebView(Context context) {
        super(context);
        this.f33922e = new int[2];
        this.f33923f = new int[2];
        a((AttributeSet) null);
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33922e = new int[2];
        this.f33923f = new int[2];
        a(attributeSet);
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33922e = new int[2];
        this.f33923f = new int[2];
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        this.m = 0;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.k = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        this.j = viewConfiguration.getScaledMaximumFlingVelocity();
        this.i = viewConfiguration.getScaledMinimumFlingVelocity();
    }

    private void g() {
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.k.dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.k.dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.k.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.k.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.k.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.k.isNestedScrollingEnabled();
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.m != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(((getContext() instanceof Activity ? ao.d((Activity) getContext()) : ao.b(getContext())) - (com.kwad.sdk.utils.d.a() ? ao.a(getContext()) : 0)) - this.m, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // com.kwad.sdk.core.page.widget.webview.KsAdWebView, android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (hasFocus()) {
            return;
        }
        requestFocus();
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent;
        int[] iArr;
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        boolean z = false;
        if (actionMasked == 0) {
            this.f33924g = 0;
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        int y = (int) motionEvent.getY();
        motionEvent.offsetLocation(0.0f, this.f33924g);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i = this.f33920c - y;
                    if (dispatchNestedPreScroll(0, i, this.f33923f, this.f33922e)) {
                        i -= this.f33923f[1];
                        obtain.offsetLocation(0.0f, this.f33922e[1]);
                        this.f33924g += this.f33922e[1];
                    }
                    int scrollY = getScrollY();
                    this.f33920c = y - this.f33922e[1];
                    int max = Math.max(0, scrollY + i);
                    int i2 = i - (max - scrollY);
                    if (dispatchNestedScroll(0, max - i2, 0, i2, this.f33922e)) {
                        this.f33920c = this.f33920c - this.f33922e[1];
                        obtain.offsetLocation(0.0f, iArr[1]);
                        this.f33924g += this.f33922e[1];
                    }
                    if (Math.abs(this.f33923f[1]) >= 5 || Math.abs(this.f33922e[1]) >= 5) {
                        if (!this.f33925h) {
                            this.f33925h = true;
                            super.onTouchEvent(MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0));
                        }
                        onTouchEvent = false;
                    } else {
                        if (this.f33925h) {
                            this.f33925h = false;
                            onTouchEvent = false;
                        } else {
                            onTouchEvent = super.onTouchEvent(obtain);
                        }
                        obtain.recycle();
                    }
                } else if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        stopNestedScroll();
                        onTouchEvent = super.onTouchEvent(motionEvent);
                    }
                    onTouchEvent = false;
                }
            }
            this.l.addMovement(motionEvent);
            this.l.computeCurrentVelocity(1000, this.j);
            float f2 = -VelocityTrackerCompat.getYVelocity(this.l, MotionEventCompat.getPointerId(motionEvent, actionIndex));
            if (Math.abs(f2) > this.i && !dispatchNestedPreFling(0.0f, f2) && hasNestedScrollingParent()) {
                dispatchNestedFling(0.0f, f2, true);
            }
            boolean onTouchEvent2 = super.onTouchEvent(motionEvent);
            stopNestedScroll();
            if (Math.abs(motionEvent.getY() - this.f33920c) < 10.0f && Math.abs(motionEvent.getX() - this.f33921d) < 10.0f) {
                g();
            }
            onTouchEvent = onTouchEvent2;
            z = true;
        } else {
            this.f33920c = y;
            this.f33921d = (int) motionEvent.getX();
            startNestedScroll(2);
            int[] iArr2 = this.f33923f;
            iArr2[0] = 0;
            iArr2[1] = 0;
            int[] iArr3 = this.f33922e;
            iArr3[0] = 0;
            iArr3[1] = 0;
            onTouchEvent = super.onTouchEvent(motionEvent);
            this.f33925h = false;
        }
        if (!z) {
            this.l.addMovement(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.k.setNestedScrollingEnabled(z);
    }

    @Override // android.webkit.WebView
    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.k.startNestedScroll(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.k.stopNestedScroll();
    }
}
