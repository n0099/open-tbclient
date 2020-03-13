package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes6.dex */
public class i implements m<PointF, PointF> {
    private final b nqO;
    private final b nqP;

    public i(b bVar, b bVar2) {
        this.nqO = bVar;
        this.nqP = bVar2;
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> dGQ() {
        return new com.tb.airbnb.lottie.a.b.m(this.nqO.dGQ(), this.nqP.dGQ());
    }
}
