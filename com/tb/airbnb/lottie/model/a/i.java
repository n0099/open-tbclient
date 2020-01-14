package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes5.dex */
public class i implements m<PointF, PointF> {
    private final b npZ;
    private final b nqa;

    public i(b bVar, b bVar2) {
        this.npZ = bVar;
        this.nqa = bVar2;
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> dFG() {
        return new com.tb.airbnb.lottie.a.b.m(this.npZ.dFG(), this.nqa.dFG());
    }
}
