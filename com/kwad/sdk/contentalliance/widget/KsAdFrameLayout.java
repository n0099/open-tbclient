package com.kwad.sdk.contentalliance.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class KsAdFrameLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public final List<GestureDetector> f33993a;

    public KsAdFrameLayout(Context context) {
        this(context, null);
    }

    public KsAdFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KsAdFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f33993a = new ArrayList();
    }

    public void a(GestureDetector gestureDetector) {
        if (gestureDetector == null || this.f33993a.contains(gestureDetector)) {
            return;
        }
        this.f33993a.add(gestureDetector);
    }

    public void b(GestureDetector gestureDetector) {
        if (gestureDetector != null) {
            this.f33993a.remove(gestureDetector);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        for (GestureDetector gestureDetector : this.f33993a) {
            dispatchTouchEvent = gestureDetector.onTouchEvent(motionEvent) || dispatchTouchEvent;
        }
        return dispatchTouchEvent;
    }
}
