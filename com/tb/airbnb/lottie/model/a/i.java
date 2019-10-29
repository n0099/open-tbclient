package com.tb.airbnb.lottie.model.a;

import android.graphics.PointF;
/* loaded from: classes6.dex */
public class i implements m<PointF, PointF> {
    private final b ktU;
    private final b ktV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, b bVar2) {
        this.ktU = bVar;
        this.ktV = bVar2;
    }

    @Override // com.tb.airbnb.lottie.model.a.m
    public com.tb.airbnb.lottie.a.b.a<PointF, PointF> cLn() {
        return new com.tb.airbnb.lottie.a.b.m(this.ktU.cLn(), this.ktV.cLn());
    }
}
