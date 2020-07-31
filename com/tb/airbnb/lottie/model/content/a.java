package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes5.dex */
public class a implements b {
    private final boolean Ef;
    private final m<PointF, PointF> nPj;
    private final com.tb.airbnb.lottie.model.a.f nPp;
    private final String name;

    public a(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, boolean z) {
        this.name = str;
        this.nPj = mVar;
        this.nPp = fVar;
        this.Ef = z;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.e(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public m<PointF, PointF> dRf() {
        return this.nPj;
    }

    public com.tb.airbnb.lottie.model.a.f dRm() {
        return this.nPp;
    }

    public boolean isReversed() {
        return this.Ef;
    }
}
