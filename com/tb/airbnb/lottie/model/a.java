package com.tb.airbnb.lottie.model;

import android.graphics.PointF;
import android.support.annotation.RestrictTo;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes6.dex */
public class a {
    private final PointF ho;
    private final PointF hp;
    private final PointF hq;

    public a() {
        this.ho = new PointF();
        this.hp = new PointF();
        this.hq = new PointF();
    }

    public a(PointF pointF, PointF pointF2, PointF pointF3) {
        this.ho = pointF;
        this.hp = pointF2;
        this.hq = pointF3;
    }

    public void f(float f, float f2) {
        this.ho.set(f, f2);
    }

    public PointF ce() {
        return this.ho;
    }

    public void g(float f, float f2) {
        this.hp.set(f, f2);
    }

    public PointF cf() {
        return this.hp;
    }

    public void h(float f, float f2) {
        this.hq.set(f, f2);
    }

    public PointF cg() {
        return this.hq;
    }
}
