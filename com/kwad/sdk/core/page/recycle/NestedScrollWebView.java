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
/* loaded from: classes4.dex */
public class NestedScrollWebView extends KsAdWebView implements NestedScrollingChild {
    private int c;
    private int d;
    private final int[] e;
    private final int[] f;
    private int g;
    private boolean h;
    private int i;
    private int j;
    private NestedScrollingChildHelper k;
    private VelocityTracker l;
    private int m;

    public NestedScrollWebView(Context context) {
        super(context);
        this.e = new int[2];
        this.f = new int[2];
        a((AttributeSet) null);
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new int[2];
        this.f = new int[2];
        a(attributeSet);
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new int[2];
        this.f = new int[2];
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
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.k.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.k.dispatchNestedPreFling(f, f2);
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
    protected void onMeasure(int i, int i2) {
        if (this.m != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(((getContext() instanceof Activity ? ao.d((Activity) getContext()) : ao.b(getContext())) - (com.kwad.sdk.utils.d.a() ? ao.a(getContext()) : 0)) - this.m, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
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
        boolean z;
        boolean z2;
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            this.g = 0;
        }
        if (this.l == null) {
            this.l = VelocityTracker.obtain();
        }
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        int y = (int) motionEvent.getY();
        motionEvent.offsetLocation(0.0f, this.g);
        switch (actionMasked) {
            case 0:
                this.c = y;
                this.d = (int) motionEvent.getX();
                startNestedScroll(2);
                this.f[0] = 0;
                this.f[1] = 0;
                this.e[0] = 0;
                this.e[1] = 0;
                z2 = super.onTouchEvent(motionEvent);
                this.h = false;
                z = false;
                break;
            case 1:
            case 3:
                this.l.addMovement(motionEvent);
                this.l.computeCurrentVelocity(1000, this.j);
                float f = -VelocityTrackerCompat.getYVelocity(this.l, MotionEventCompat.getPointerId(motionEvent, actionIndex));
                if (Math.abs(f) > this.i && !dispatchNestedPreFling(0.0f, f) && hasNestedScrollingParent()) {
                    dispatchNestedFling(0.0f, f, true);
                }
                boolean onTouchEvent = super.onTouchEvent(motionEvent);
                stopNestedScroll();
                if (Math.abs(motionEvent.getY() - this.c) < 10.0f && Math.abs(motionEvent.getX() - this.d) < 10.0f) {
                    g();
                }
                z = true;
                z2 = onTouchEvent;
                break;
            case 2:
                int i = this.c - y;
                if (dispatchNestedPreScroll(0, i, this.f, this.e)) {
                    i -= this.f[1];
                    obtain.offsetLocation(0.0f, this.e[1]);
                    this.g += this.e[1];
                }
                int scrollY = getScrollY();
                this.c = y - this.e[1];
                int max = Math.max(0, scrollY + i);
                int i2 = i - (max - scrollY);
                if (dispatchNestedScroll(0, max - i2, 0, i2, this.e)) {
                    this.c -= this.e[1];
                    obtain.offsetLocation(0.0f, this.e[1]);
                    this.g += this.e[1];
                }
                if (Math.abs(this.f[1]) < 5 && Math.abs(this.e[1]) < 5) {
                    if (this.h) {
                        this.h = false;
                        z2 = false;
                    } else {
                        z2 = super.onTouchEvent(obtain);
                    }
                    obtain.recycle();
                    z = false;
                    break;
                } else if (!this.h) {
                    this.h = true;
                    super.onTouchEvent(MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0));
                    z = false;
                    z2 = false;
                    break;
                }
                break;
            case 4:
            default:
                z = false;
                z2 = false;
                break;
            case 5:
                stopNestedScroll();
                z2 = super.onTouchEvent(motionEvent);
                z = false;
                break;
        }
        if (!z) {
            this.l.addMovement(motionEvent);
        }
        return z2;
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
