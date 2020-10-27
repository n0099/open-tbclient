package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.a.a.n;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes16.dex */
public class f implements b {
    private final String name;
    private final com.tb.airbnb.lottie.model.a.f pAa;
    private final com.tb.airbnb.lottie.model.a.b pAt;
    private final m<PointF, PointF> pzU;

    public f(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.pzU = mVar;
        this.pAa = fVar;
        this.pAt = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b evy() {
        return this.pAt;
    }

    public com.tb.airbnb.lottie.model.a.f evg() {
        return this.pAa;
    }

    public m<PointF, PointF> euZ() {
        return this.pzU;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new n(fVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.pzU + ", size=" + this.pAa + '}';
    }
}
