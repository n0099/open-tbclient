package com.kwad.sdk.lib.widget.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes7.dex */
public class a extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    public int f36738a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f36739b;

    public a(@NonNull Context context) {
        super(context);
        this.f36739b = false;
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36739b = false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean canScrollHorizontally(int i2) {
        if (this.f36739b) {
            return super.canScrollHorizontally(i2);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        boolean z;
        if (this.f36739b) {
            int x = (int) motionEvent.getX();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 2) {
                    int i2 = x - this.f36738a;
                    if (getCurrentItem() == 0 && i2 > 0) {
                        parent = getParent();
                        z = false;
                    }
                }
                this.f36738a = x;
                return super.dispatchTouchEvent(motionEvent);
            }
            parent = getParent();
            z = true;
            parent.requestDisallowInterceptTouchEvent(z);
            this.f36738a = x;
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f36739b && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f36739b && super.onTouchEvent(motionEvent);
    }

    public void setScrollable(boolean z) {
        this.f36739b = z;
    }
}
