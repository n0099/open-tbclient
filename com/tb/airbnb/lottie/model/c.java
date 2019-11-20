package com.tb.airbnb.lottie.model;

import android.graphics.PointF;
/* loaded from: classes6.dex */
public class c {
    private final PointF fC;
    private final PointF fD;
    private final PointF fE;

    public c() {
        this.fC = new PointF();
        this.fD = new PointF();
        this.fE = new PointF();
    }

    public c(PointF pointF, PointF pointF2, PointF pointF3) {
        this.fC = pointF;
        this.fD = pointF2;
        this.fE = pointF3;
    }

    public void f(float f, float f2) {
        this.fC.set(f, f2);
    }

    public PointF bS() {
        return this.fC;
    }

    public void g(float f, float f2) {
        this.fD.set(f, f2);
    }

    public PointF bT() {
        return this.fD;
    }

    public void h(float f, float f2) {
        this.fE.set(f, f2);
    }

    public PointF bU() {
        return this.fE;
    }
}
