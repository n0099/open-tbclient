package com.kwad.sdk.contentalliance.tube.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes5.dex */
public class TrendTubeEpisodeViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private final int f9299a;

    /* renamed from: b  reason: collision with root package name */
    private float f9300b;
    private float c;

    public TrendTubeEpisodeViewPager(@NonNull Context context) {
        super(context);
        this.f9299a = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public TrendTubeEpisodeViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9299a = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                getParent().requestDisallowInterceptTouchEvent(false);
                this.f9300b = motionEvent.getRawX();
                this.c = motionEvent.getRawY();
                break;
            case 2:
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                float f = rawX - this.f9300b;
                float f2 = rawY - this.c;
                if (Math.abs(f) - Math.abs(f2) <= this.f9299a) {
                    if (Math.abs(f2) - Math.abs(f) > this.f9299a) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                    }
                } else {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
