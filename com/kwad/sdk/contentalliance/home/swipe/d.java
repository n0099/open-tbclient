package com.kwad.sdk.contentalliance.home.swipe;

import android.view.MotionEvent;
import android.view.View;
/* loaded from: classes6.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public boolean f33406a = false;

    public abstract void a(View view, MotionEvent motionEvent);

    public void a(boolean z) {
        this.f33406a = !z;
    }

    public abstract boolean b(View view, MotionEvent motionEvent);

    public abstract boolean c(View view, MotionEvent motionEvent);

    public final void d(View view, MotionEvent motionEvent) {
        if (this.f33406a) {
            return;
        }
        a(view, motionEvent);
    }

    public final boolean e(View view, MotionEvent motionEvent) {
        return !this.f33406a && b(view, motionEvent);
    }

    public final boolean f(View view, MotionEvent motionEvent) {
        return !this.f33406a && c(view, motionEvent);
    }
}
