package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes16.dex */
public class a implements b {
    private final boolean Fc;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.f pAa;
    private final m<PointF, PointF> pzU;

    public a(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, boolean z) {
        this.name = str;
        this.pzU = mVar;
        this.pAa = fVar;
        this.Fc = z;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.e(fVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public m<PointF, PointF> euZ() {
        return this.pzU;
    }

    public com.tb.airbnb.lottie.model.a.f evg() {
        return this.pAa;
    }

    public boolean isReversed() {
        return this.Fc;
    }
}
