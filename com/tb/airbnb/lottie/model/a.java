package com.tb.airbnb.lottie.model;

import android.graphics.PointF;
import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class a {
    private final PointF Du;
    private final PointF Dv;
    private final PointF Dw;

    public a() {
        this.Du = new PointF();
        this.Dv = new PointF();
        this.Dw = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.Du = pointF;
        this.Dv = pointF2;
        this.Dw = pointF3;
    }

    public void f(float f, float f2) {
        this.Du.set(f, f2);
    }

    public PointF hR() {
        return this.Du;
    }

    public void g(float f, float f2) {
        this.Dv.set(f, f2);
    }

    public PointF hS() {
        return this.Dv;
    }

    public void h(float f, float f2) {
        this.Dw.set(f, f2);
    }

    public PointF hT() {
        return this.Dw;
    }
}
