package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes5.dex */
public class i implements m<PointF, PointF> {
    private final b npU;
    private final b npV;

    public i(b bVar, b bVar2) {
        this.npU = bVar;
        this.npV = bVar2;
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> dFE() {
        return new com.tb.airbnb.lottie.a.b.m(this.npU.dFE(), this.npV.dFE());
    }
}
