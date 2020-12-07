package com.tb.airbnb.lottie.model;

import android.graphics.PointF;
import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes20.dex */
public class a {
    private final PointF Fm;
    private final PointF Fn;
    private final PointF Fo;

    public a() {
        this.Fm = new PointF();
        this.Fn = new PointF();
        this.Fo = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.Fm = pointF;
        this.Fn = pointF2;
        this.Fo = pointF3;
    }

    public void e(float f, float f2) {
        this.Fm.set(f, f2);
    }

    public PointF ju() {
        return this.Fm;
    }

    public void f(float f, float f2) {
        this.Fn.set(f, f2);
    }

    public PointF jv() {
        return this.Fn;
    }

    public void g(float f, float f2) {
        this.Fo.set(f, f2);
    }

    public PointF jw() {
        return this.Fo;
    }
}
