package com.kwad.sdk.lib.widget.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes6.dex */
public class a extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    public int f36031a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f36032b;

    public a(@NonNull Context context) {
        super(context);
        this.f36032b = false;
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f36032b = false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.f36032b) {
            return super.canScrollHorizontally(i);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        boolean z;
        if (this.f36032b) {
            int x = (int) motionEvent.getX();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 2) {
                    int i = x - this.f36031a;
                    if (getCurrentItem() == 0 && i > 0) {
                        parent = getParent();
                        z = false;
                    }
                }
                this.f36031a = x;
                return super.dispatchTouchEvent(motionEvent);
            }
            parent = getParent();
            z = true;
            parent.requestDisallowInterceptTouchEvent(z);
            this.f36031a = x;
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f36032b && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f36032b && super.onTouchEvent(motionEvent);
    }

    public void setScrollable(boolean z) {
        this.f36032b = z;
    }
}
