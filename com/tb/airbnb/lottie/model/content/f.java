package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.a.a.n;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes17.dex */
public class f implements b {
    private final String name;
    private final m<PointF, PointF> pKR;
    private final com.tb.airbnb.lottie.model.a.f pKX;
    private final com.tb.airbnb.lottie.model.a.b pLq;

    public f(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.pKR = mVar;
        this.pKX = fVar;
        this.pLq = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b ezo() {
        return this.pLq;
    }

    public com.tb.airbnb.lottie.model.a.f eyW() {
        return this.pKX;
    }

    public m<PointF, PointF> eyP() {
        return this.pKR;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new n(gVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.pKR + ", size=" + this.pKX + '}';
    }
}
