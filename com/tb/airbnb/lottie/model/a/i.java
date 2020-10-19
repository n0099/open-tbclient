package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes16.dex */
public class i implements m<PointF, PointF> {
    private final b oIq;
    private final b oIr;

    public i(b bVar, b bVar2) {
        this.oIq = bVar;
        this.oIr = bVar2;
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> ekW() {
        return new com.tb.airbnb.lottie.a.b.m(this.oIq.ekW(), this.oIr.ekW());
    }
}
