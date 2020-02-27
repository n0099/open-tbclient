package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes6.dex */
public class i implements m<PointF, PointF> {
    private final b nqB;
    private final b nqC;

    public i(b bVar, b bVar2) {
        this.nqB = bVar;
        this.nqC = bVar2;
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> dGN() {
        return new com.tb.airbnb.lottie.a.b.m(this.nqB.dGN(), this.nqC.dGN());
    }
}
