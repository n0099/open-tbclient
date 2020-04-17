package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes6.dex */
public class i implements m<PointF, PointF> {
    private final b mPk;
    private final b mPl;

    public i(b bVar, b bVar2) {
        this.mPk = bVar;
        this.mPl = bVar2;
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> dBs() {
        return new com.tb.airbnb.lottie.a.b.m(this.mPk.dBs(), this.mPl.dBs());
    }
}
