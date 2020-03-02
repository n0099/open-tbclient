package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.a.a.n;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class f implements b {
    private final String name;
    private final m<PointF, PointF> nqK;
    private final com.tb.airbnb.lottie.model.a.f nqQ;
    private final com.tb.airbnb.lottie.model.a.b nrj;

    public f(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.nqK = mVar;
        this.nqQ = fVar;
        this.nrj = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b dHr() {
        return this.nrj;
    }

    public com.tb.airbnb.lottie.model.a.f dGZ() {
        return this.nqQ;
    }

    public m<PointF, PointF> dGS() {
        return this.nqK;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new n(fVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.nqK + ", size=" + this.nqQ + '}';
    }
}
