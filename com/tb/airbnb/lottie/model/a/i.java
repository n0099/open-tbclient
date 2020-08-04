package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes5.dex */
public class i implements m<PointF, PointF> {
    private final b nPe;
    private final b nPf;

    public i(b bVar, b bVar2) {
        this.nPe = bVar;
        this.nPf = bVar2;
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> dRd() {
        return new com.tb.airbnb.lottie.a.b.m(this.nPe.dRd(), this.nPf.dRd());
    }
}
