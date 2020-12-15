package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.a.a.n;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes20.dex */
public class f implements b {
    private final String name;
    private final m<PointF, PointF> pBX;
    private final com.tb.airbnb.lottie.model.a.f pCd;
    private final com.tb.airbnb.lottie.model.a.b pCw;

    public f(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.pBX = mVar;
        this.pCd = fVar;
        this.pCw = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b eBL() {
        return this.pCw;
    }

    public com.tb.airbnb.lottie.model.a.f eBt() {
        return this.pCd;
    }

    public m<PointF, PointF> eBm() {
        return this.pBX;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new n(gVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.pBX + ", size=" + this.pCd + '}';
    }
}
