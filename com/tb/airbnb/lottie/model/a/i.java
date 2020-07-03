package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes6.dex */
public class i implements m<PointF, PointF> {
    private final b nGr;
    private final b nGs;

    public i(b bVar, b bVar2) {
        this.nGr = bVar;
        this.nGs = bVar2;
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> dNC() {
        return new com.tb.airbnb.lottie.a.b.m(this.nGr.dNC(), this.nGs.dNC());
    }
}
