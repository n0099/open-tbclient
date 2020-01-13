package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.a.a.n;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes5.dex */
public class f implements b {
    private final String name;
    private final com.tb.airbnb.lottie.model.a.b nqA;
    private final m<PointF, PointF> nqb;
    private final com.tb.airbnb.lottie.model.a.f nqh;

    public f(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.nqb = mVar;
        this.nqh = fVar;
        this.nqA = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b dGg() {
        return this.nqA;
    }

    public com.tb.airbnb.lottie.model.a.f dFO() {
        return this.nqh;
    }

    public m<PointF, PointF> dFH() {
        return this.nqb;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new n(fVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.nqb + ", size=" + this.nqh + '}';
    }
}
