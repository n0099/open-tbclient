package com.tb.airbnb.lottie.model;

import android.graphics.PointF;
import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class a {
    private final PointF CP;
    private final PointF CQ;
    private final PointF CT;

    public a() {
        this.CP = new PointF();
        this.CQ = new PointF();
        this.CT = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.CP = pointF;
        this.CQ = pointF2;
        this.CT = pointF3;
    }

    public void f(float f, float f2) {
        this.CP.set(f, f2);
    }

    public PointF hB() {
        return this.CP;
    }

    public void g(float f, float f2) {
        this.CQ.set(f, f2);
    }

    public PointF hC() {
        return this.CQ;
    }

    public void h(float f, float f2) {
        this.CT.set(f, f2);
    }

    public PointF hD() {
        return this.CT;
    }
}
