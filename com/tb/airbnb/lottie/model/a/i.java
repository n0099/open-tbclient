package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes6.dex */
public class i implements m<PointF, PointF> {
    private final b nqD;
    private final b nqE;

    public i(b bVar, b bVar2) {
        this.nqD = bVar;
        this.nqE = bVar2;
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> dGP() {
        return new com.tb.airbnb.lottie.a.b.m(this.nqD.dGP(), this.nqE.dGP());
    }
}
