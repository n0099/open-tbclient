package com.kwad.sdk.contentalliance.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class KsAdFrameLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final List<GestureDetector> f9019a;

    public KsAdFrameLayout(Context context) {
        this(context, null);
    }

    public KsAdFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public KsAdFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9019a = new ArrayList();
    }

    public void a(GestureDetector gestureDetector) {
        if (gestureDetector == null || this.f9019a.contains(gestureDetector)) {
            return;
        }
        this.f9019a.add(gestureDetector);
    }

    public void b(GestureDetector gestureDetector) {
        if (gestureDetector != null) {
            this.f9019a.remove(gestureDetector);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        Iterator<GestureDetector> it = this.f9019a.iterator();
        while (true) {
            boolean z = dispatchTouchEvent;
            if (!it.hasNext()) {
                return z;
            }
            dispatchTouchEvent = it.next().onTouchEvent(motionEvent) || z;
        }
    }
}
