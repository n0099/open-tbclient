package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes7.dex */
public class i implements m<PointF, PointF> {
    private final b ojq;
    private final b ojr;

    public i(b bVar, b bVar2) {
        this.ojq = bVar;
        this.ojr = bVar2;
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> edo() {
        return new com.tb.airbnb.lottie.a.b.m(this.ojq.edo(), this.ojr.edo());
    }
}
