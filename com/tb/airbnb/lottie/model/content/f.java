package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.a.a.n;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes5.dex */
public class f implements b {
    private final com.tb.airbnb.lottie.model.a.b nPK;
    private final m<PointF, PointF> nPl;
    private final com.tb.airbnb.lottie.model.a.f nPr;
    private final String name;

    public f(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.nPl = mVar;
        this.nPr = fVar;
        this.nPK = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b dRF() {
        return this.nPK;
    }

    public com.tb.airbnb.lottie.model.a.f dRn() {
        return this.nPr;
    }

    public m<PointF, PointF> dRg() {
        return this.nPl;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new n(fVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.nPl + ", size=" + this.nPr + '}';
    }
}
