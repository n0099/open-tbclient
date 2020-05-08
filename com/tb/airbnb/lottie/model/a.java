package com.tb.airbnb.lottie.model;

import android.graphics.PointF;
import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class a {
    private final PointF CQ;
    private final PointF CV;
    private final PointF CW;

    public a() {
        this.CQ = new PointF();
        this.CV = new PointF();
        this.CW = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.CQ = pointF;
        this.CV = pointF2;
        this.CW = pointF3;
    }

    public void f(float f, float f2) {
        this.CQ.set(f, f2);
    }

    public PointF hB() {
        return this.CQ;
    }

    public void g(float f, float f2) {
        this.CV.set(f, f2);
    }

    public PointF hC() {
        return this.CV;
    }

    public void h(float f, float f2) {
        this.CW.set(f, f2);
    }

    public PointF hD() {
        return this.CW;
    }
}
