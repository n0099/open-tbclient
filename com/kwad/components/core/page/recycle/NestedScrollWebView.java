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
import com.kwad.sdk.core.webview.KsAdWebView;
/* loaded from: classes10.dex */
public class NestedScrollWebView extends KsAdWebView implements NestedScrollingChild {
    public final int[] PA;
    public final int[] PB;
    public int PC;
    public boolean PD;
    public int PE;
    public int PF;
    public NestedScrollingChildHelper PG;
    public VelocityTracker PH;
    public int PI;
    public int Py;
    public int Pz;

    public NestedScrollWebView(Context context) {
        super(context);
        this.PA = new int[2];
        this.PB = new int[2];
        pH();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.PG.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.PG.startNestedScroll(i);
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.PA = new int[2];
        this.PB = new int[2];
        pH();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.PG.dispatchNestedPreFling(f, f2);
    }

    public NestedScrollWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.PA = new int[2];
        this.PB = new int[2];
        pH();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.PG.dispatchNestedFling(f, f2, z);
    }

    private void pH() {
        this.PI = 0;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.PG = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        this.PF = viewConfiguration.getScaledMaximumFlingVelocity();
        this.PE = viewConfiguration.getScaledMinimumFlingVelocity();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.PG.hasNestedScrollingParent();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.PG.isNestedScrollingEnabled();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.PG.stopNestedScroll();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.PG.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // com.kwad.sdk.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (!hasFocus()) {
            requestFocus();
        }
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.PG.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int screenHeight;
        if (this.PI != 0) {
            if (com.kwad.components.core.s.d.qP()) {
                i3 = com.kwad.sdk.d.a.a.getStatusBarHeight(getContext());
            } else {
                i3 = 0;
            }
            if (getContext() instanceof Activity) {
                screenHeight = com.kwad.sdk.d.a.a.e((Activity) getContext());
            } else {
                screenHeight = com.kwad.sdk.d.a.a.getScreenHeight(getContext());
            }
            i2 = View.MeasureSpec.makeMeasureSpec((screenHeight - i3) - this.PI, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // com.kwad.sdk.core.webview.KsAdWebView, android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent;
        int[] iArr;
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        boolean z = false;
        if (actionMasked == 0) {
            this.PC = 0;
        }
        if (this.PH == null) {
            this.PH = VelocityTracker.obtain();
        }
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        int y = (int) motionEvent.getY();
        motionEvent.offsetLocation(0.0f, this.PC);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 5) {
                            stopNestedScroll();
                            onTouchEvent = super.onTouchEvent(motionEvent);
                        }
                        onTouchEvent = false;
                    }
                } else {
                    int i = this.Py - y;
                    if (dispatchNestedPreScroll(0, i, this.PB, this.PA)) {
                        i -= this.PB[1];
                        obtain.offsetLocation(0.0f, this.PA[1]);
                        this.PC += this.PA[1];
                    }
                    int scrollY = getScrollY();
                    this.Py = y - this.PA[1];
                    int max = Math.max(0, scrollY + i);
                    int i2 = i - (max - scrollY);
                    if (dispatchNestedScroll(0, max - i2, 0, i2, this.PA)) {
                        this.Py = this.Py - this.PA[1];
                        obtain.offsetLocation(0.0f, iArr[1]);
                        this.PC += this.PA[1];
                    }
                    if (Math.abs(this.PB[1]) < 5 && Math.abs(this.PA[1]) < 5) {
                        if (this.PD) {
                            this.PD = false;
                            onTouchEvent = false;
                        } else {
                            onTouchEvent = super.onTouchEvent(obtain);
                        }
                        obtain.recycle();
                    } else {
                        if (!this.PD) {
                            this.PD = true;
                            super.onTouchEvent(MotionEvent.obtain(0L, 0L, 3, 0.0f, 0.0f, 0));
                        }
                        onTouchEvent = false;
                    }
                }
            }
            this.PH.addMovement(motionEvent);
            this.PH.computeCurrentVelocity(1000, this.PF);
            float f = -VelocityTrackerCompat.getYVelocity(this.PH, MotionEventCompat.getPointerId(motionEvent, actionIndex));
            if (Math.abs(f) > this.PE && !dispatchNestedPreFling(0.0f, f) && hasNestedScrollingParent()) {
                dispatchNestedFling(0.0f, f, true);
            }
            boolean onTouchEvent2 = super.onTouchEvent(motionEvent);
            stopNestedScroll();
            if (Math.abs(motionEvent.getY() - this.Py) < 10.0f) {
                Math.abs(motionEvent.getX() - this.Pz);
            }
            onTouchEvent = onTouchEvent2;
            z = true;
        } else {
            this.Py = y;
            this.Pz = (int) motionEvent.getX();
            startNestedScroll(2);
            int[] iArr2 = this.PB;
            iArr2[0] = 0;
            iArr2[1] = 0;
            int[] iArr3 = this.PA;
            iArr3[0] = 0;
            iArr3[1] = 0;
            onTouchEvent = super.onTouchEvent(motionEvent);
            this.PD = false;
        }
        if (!z) {
            this.PH.addMovement(motionEvent);
        }
        return onTouchEvent;
    }
}
