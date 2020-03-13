package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.a.a.n;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class f implements b {
    private final String name;
    private final m<PointF, PointF> nqV;
    private final com.tb.airbnb.lottie.model.a.f nrb;
    private final com.tb.airbnb.lottie.model.a.b nru;

    public f(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.nqV = mVar;
        this.nrb = fVar;
        this.nru = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b dHs() {
        return this.nru;
    }

    public com.tb.airbnb.lottie.model.a.f dHa() {
        return this.nrb;
    }

    public m<PointF, PointF> dGT() {
        return this.nqV;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new n(fVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.nqV + ", size=" + this.nrb + '}';
    }
}
