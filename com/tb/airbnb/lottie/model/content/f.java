package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.a.a.n;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class f implements b {
    private final String name;
    private final m<PointF, PointF> nqI;
    private final com.tb.airbnb.lottie.model.a.f nqO;
    private final com.tb.airbnb.lottie.model.a.b nrh;

    public f(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.nqI = mVar;
        this.nqO = fVar;
        this.nrh = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b dHp() {
        return this.nrh;
    }

    public com.tb.airbnb.lottie.model.a.f dGX() {
        return this.nqO;
    }

    public m<PointF, PointF> dGQ() {
        return this.nqI;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new n(fVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.nqI + ", size=" + this.nqO + '}';
    }
}
