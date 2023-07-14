package com.kwad.components.core.page.recycle;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.VelocityTrackerCompat;
import com.kwad.components.core.webview.KsAdWebView;
/* loaded from: classes10.dex */
public class NestedScrollWebView extends KsAdWebView implements NestedScrollingChild {
    public int GI;
    public int GJ;
    public final int[] GK;
    public final int[] GL;
    public int GM;
    public boolean GN;
    public int GO;
    public int GP;
    public NestedScrollingChildHelper GQ;
    public VelocityTracker GR;
    public int GS;

    public NestedScrollWebView(Context context) {
        super(context);
        this.GK = new int[2];
        this.GL = new int[2];
        nX();
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.GK = new int[2];
        this.GL = new int[2];
        nX();
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.GK = new int[2];
        this.GL = new int[2];
        nX();
    }

    private void nX() {
        this.GS = 0;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.GQ = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        this.GP = viewConfiguration.getScaledMaximumFlingVelocity();
        this.GO = viewConfiguration.getScaledMinimumFlingVelocity();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.GQ.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.GQ.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.GQ.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.GQ.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.GQ.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.GQ.isNestedScrollingEnabled();
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.GS != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(((getContext() instanceof Activity ? com.kwad.sdk.b.kwai.a.d((Activity) getContext()) : com.kwad.sdk.b.kwai.a.getScreenHeight(getContext())) - (com.kwad.components.core.m.e.oB() ? com.kwad.sdk.b.kwai.a.aH(getContext()) : 0)) - this.GS, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // com.kwad.components.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
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
            this.GM = 0;
        }
        if (this.GR == null) {
            this.GR = VelocityTracker.obtain();
        }
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        int y = (int) motionEvent.getY();
        motionEvent.offsetLocation(0.0f, this.GM);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i = this.GI - y;
                    if (dispatchNestedPreScroll(0, i, this.GL, this.GK)) {
                        i -= this.GL[1];
                        obtain.offsetLocation(0.0f, this.GK[1]);
                        this.GM += this.GK[1];
                    }
                    int scrollY = getScrollY();
                    this.GI = y - this.GK[1];
                    int max = Math.max(0, scrollY + i);
                    int i2 = i - (max - scrollY);
                    if (dispatchNestedScroll(0, max - i2, 0, i2, this.GK)) {
                        this.GI = this.GI - this.GK[1];
                        obtain.offsetLocation(0.0f, iArr[1]);
                        this.GM += this.GK[1];
                    }
                    if (Math.abs(this.GL[1]) >= 5 || Math.abs(this.GK[1]) >= 5) {
                        if (!this.GN) {
                            this.GN = true;
                            super.onTouchEvent(MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0));
                        }
                        onTouchEvent = false;
                    } else {
                        if (this.GN) {
                            this.GN = false;
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
            this.GR.addMovement(motionEvent);
            this.GR.computeCurrentVelocity(1000, this.GP);
            float f = -VelocityTrackerCompat.getYVelocity(this.GR, MotionEventCompat.getPointerId(motionEvent, actionIndex));
            if (Math.abs(f) > this.GO && !dispatchNestedPreFling(0.0f, f) && hasNestedScrollingParent()) {
                dispatchNestedFling(0.0f, f, true);
            }
            boolean onTouchEvent2 = super.onTouchEvent(motionEvent);
            stopNestedScroll();
            if (Math.abs(motionEvent.getY() - this.GI) < 10.0f) {
                Math.abs(motionEvent.getX() - this.GJ);
            }
            onTouchEvent = onTouchEvent2;
            z = true;
        } else {
            this.GI = y;
            this.GJ = (int) motionEvent.getX();
            startNestedScroll(2);
            int[] iArr2 = this.GL;
            iArr2[0] = 0;
            iArr2[1] = 0;
            int[] iArr3 = this.GK;
            iArr3[0] = 0;
            iArr3[1] = 0;
            onTouchEvent = super.onTouchEvent(motionEvent);
            this.GN = false;
        }
        if (!z) {
            this.GR.addMovement(motionEvent);
        }
        return onTouchEvent;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.GQ.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.GQ.startNestedScroll(i);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.GQ.stopNestedScroll();
    }
}
