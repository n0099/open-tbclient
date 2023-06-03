package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes10.dex */
public class d extends ViewPager {
    public int ara;
    public boolean arb;

    public d(@NonNull Context context) {
        super(context);
        this.arb = false;
    }

    public d(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.arb = false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.arb) {
            return super.canScrollHorizontally(i);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        boolean z;
        if (this.arb) {
            int x = (int) motionEvent.getX();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 2) {
                    int i = x - this.ara;
                    if (getCurrentItem() == 0 && i > 0) {
                        parent = getParent();
                        z = false;
                    }
                }
                this.ara = x;
                return super.dispatchTouchEvent(motionEvent);
            }
            parent = getParent();
            z = true;
            parent.requestDisallowInterceptTouchEvent(z);
            this.ara = x;
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.arb && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.arb && super.onTouchEvent(motionEvent);
    }

    public void setScrollable(boolean z) {
        this.arb = z;
    }
}
