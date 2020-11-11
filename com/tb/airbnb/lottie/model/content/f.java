package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.a.a.n;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes16.dex */
public class f implements b {
    private final String name;
    private final com.tb.airbnb.lottie.model.a.b pJN;
    private final m<PointF, PointF> pJo;
    private final com.tb.airbnb.lottie.model.a.f pJu;

    public f(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.pJo = mVar;
        this.pJu = fVar;
        this.pJN = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b ezn() {
        return this.pJN;
    }

    public com.tb.airbnb.lottie.model.a.f eyV() {
        return this.pJu;
    }

    public m<PointF, PointF> eyO() {
        return this.pJo;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new n(gVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.pJo + ", size=" + this.pJu + '}';
    }
}
