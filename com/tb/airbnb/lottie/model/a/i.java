package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes6.dex */
public class i implements m<PointF, PointF> {
    private final b nsB;
    private final b nsC;

    public i(b bVar, b bVar2) {
        this.nsB = bVar;
        this.nsC = bVar2;
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> dHq() {
        return new com.tb.airbnb.lottie.a.b.m(this.nsB.dHq(), this.nsC.dHq());
    }
}
