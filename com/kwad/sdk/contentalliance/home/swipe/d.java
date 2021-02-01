package com.kwad.sdk.contentalliance.home.swipe;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes3.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    private boolean f8753a = false;

    protected abstract void a(View view, MotionEvent motionEvent);

    public void a(boolean z) {
        this.f8753a = !z;
    }

    protected abstract boolean b(View view, MotionEvent motionEvent);

    protected abstract boolean c(View view, MotionEvent motionEvent);

    public final void d(View view, MotionEvent motionEvent) {
        if (this.f8753a) {
            return;
        }
        a(view, motionEvent);
    }

    public final boolean e(View view, MotionEvent motionEvent) {
        return !this.f8753a && b(view, motionEvent);
    }

    public final boolean f(View view, MotionEvent motionEvent) {
        return !this.f8753a && c(view, motionEvent);
    }
}
