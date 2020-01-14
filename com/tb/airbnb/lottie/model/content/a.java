package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes5.dex */
public class a implements b {
    private final boolean hS;
    private final String name;
    private final m<PointF, PointF> nqg;
    private final com.tb.airbnb.lottie.model.a.f nqm;

    public a(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, boolean z) {
        this.name = str;
        this.nqg = mVar;
        this.nqm = fVar;
        this.hS = z;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.e(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public m<PointF, PointF> dFJ() {
        return this.nqg;
    }

    public com.tb.airbnb.lottie.model.a.f dFQ() {
        return this.nqm;
    }

    public boolean isReversed() {
        return this.hS;
    }
}
