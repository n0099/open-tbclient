package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes5.dex */
public class d extends ViewPager {
    public int a;
    public boolean b;

    public d(@NonNull Context context) {
        super(context);
        this.b = false;
    }

    public d(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.b) {
            return super.canScrollHorizontally(i);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        boolean z;
        if (this.b) {
            int x = (int) motionEvent.getX();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 2) {
                    int i = x - this.a;
                    if (getCurrentItem() == 0 && i > 0) {
                        parent = getParent();
                        z = false;
                    }
                }
                this.a = x;
                return super.dispatchTouchEvent(motionEvent);
            }
            parent = getParent();
            z = true;
            parent.requestDisallowInterceptTouchEvent(z);
            this.a = x;
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.b && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.b && super.onTouchEvent(motionEvent);
    }

    public void setScrollable(boolean z) {
        this.b = z;
    }
}
