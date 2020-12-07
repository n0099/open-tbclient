package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes20.dex */
public class a implements b {
    private final boolean FT;
    private final String name;
    private final m<PointF, PointF> pBV;
    private final com.tb.airbnb.lottie.model.a.f pCb;

    public a(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, boolean z) {
        this.name = str;
        this.pBV = mVar;
        this.pCb = fVar;
        this.FT = z;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.e(gVar, aVar, this);
    }

    public String getName() {
        return this.name;
    }

    public m<PointF, PointF> eBl() {
        return this.pBV;
    }

    public com.tb.airbnb.lottie.model.a.f eBs() {
        return this.pCb;
    }

    public boolean isReversed() {
        return this.FT;
    }
}
