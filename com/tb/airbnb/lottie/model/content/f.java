package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.a.a.n;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes20.dex */
public class f implements b {
    private final String name;
    private final m<PointF, PointF> pBV;
    private final com.tb.airbnb.lottie.model.a.f pCb;
    private final com.tb.airbnb.lottie.model.a.b pCu;

    public f(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.pBV = mVar;
        this.pCb = fVar;
        this.pCu = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b eBK() {
        return this.pCu;
    }

    public com.tb.airbnb.lottie.model.a.f eBs() {
        return this.pCb;
    }

    public m<PointF, PointF> eBl() {
        return this.pBV;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new n(gVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.pBV + ", size=" + this.pCb + '}';
    }
}
