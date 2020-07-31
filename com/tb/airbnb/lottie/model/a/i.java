package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes5.dex */
public class i implements m<PointF, PointF> {
    private final b nPc;
    private final b nPd;

    public i(b bVar, b bVar2) {
        this.nPc = bVar;
        this.nPd = bVar2;
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> dRc() {
        return new com.tb.airbnb.lottie.a.b.m(this.nPc.dRc(), this.nPd.dRc());
    }
}
