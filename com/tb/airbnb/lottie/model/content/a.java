package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes17.dex */
public class a implements b {
    private final boolean Fc;
    private final String name;
    private final m<PointF, PointF> pKR;
    private final com.tb.airbnb.lottie.model.a.f pKX;

    public a(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, boolean z) {
        this.name = str;
        this.pKR = mVar;
        this.pKX = fVar;
        this.Fc = z;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.e(gVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public m<PointF, PointF> eyP() {
        return this.pKR;
    }

    public com.tb.airbnb.lottie.model.a.f eyW() {
        return this.pKX;
    }

    public boolean isReversed() {
        return this.Fc;
    }
}
