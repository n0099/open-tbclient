package com.kwad.sdk.lib.widget.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes4.dex */
public class a extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private int f10462a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f10463b;

    public a(@NonNull Context context) {
        super(context);
        this.f10463b = false;
    }

    public a(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10463b = false;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.f10463b) {
            return super.canScrollHorizontally(i);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f10463b) {
            int x = (int) motionEvent.getX();
            switch (motionEvent.getAction()) {
                case 0:
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                case 2:
                    int i = x - this.f10462a;
                    if (getCurrentItem() == 0 && i > 0) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                    }
                    break;
            }
            this.f10462a = x;
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f10463b && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f10463b && super.onTouchEvent(motionEvent);
    }

    public void setScrollable(boolean z) {
        this.f10463b = z;
    }
}
