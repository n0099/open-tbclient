package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.a.a.n;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes5.dex */
public class f implements b {
    private final com.tb.airbnb.lottie.model.a.b nPI;
    private final m<PointF, PointF> nPj;
    private final com.tb.airbnb.lottie.model.a.f nPp;
    private final String name;

    public f(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.nPj = mVar;
        this.nPp = fVar;
        this.nPI = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b dRE() {
        return this.nPI;
    }

    public com.tb.airbnb.lottie.model.a.f dRm() {
        return this.nPp;
    }

    public m<PointF, PointF> dRf() {
        return this.nPj;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new n(fVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.nPj + ", size=" + this.nPp + '}';
    }
}
