package com.kwad.sdk.contentalliance.tube.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes6.dex */
public class TrendTubeEpisodeViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    public final int f33337a;

    /* renamed from: b  reason: collision with root package name */
    public float f33338b;

    /* renamed from: c  reason: collision with root package name */
    public float f33339c;

    public TrendTubeEpisodeViewPager(@NonNull Context context) {
        super(context);
        this.f33337a = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    public TrendTubeEpisodeViewPager(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33337a = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        int action = motionEvent.getAction();
        boolean z = false;
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(false);
            this.f33338b = motionEvent.getRawX();
            this.f33339c = motionEvent.getRawY();
        } else if (action == 2) {
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            float f2 = rawX - this.f33338b;
            float f3 = rawY - this.f33339c;
            if (Math.abs(f2) - Math.abs(f3) > this.f33337a) {
                parent = getParent();
                z = true;
            } else if (Math.abs(f3) - Math.abs(f2) > this.f33337a) {
                parent = getParent();
            }
            parent.requestDisallowInterceptTouchEvent(z);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
