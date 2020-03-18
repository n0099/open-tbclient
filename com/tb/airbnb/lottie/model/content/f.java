package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.a.a.n;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes6.dex */
public class f implements b {
    private final String name;
    private final m<PointF, PointF> nsI;
    private final com.tb.airbnb.lottie.model.a.f nsO;
    private final com.tb.airbnb.lottie.model.a.b nth;

    public f(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.nsI = mVar;
        this.nsO = fVar;
        this.nth = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b dHS() {
        return this.nth;
    }

    public com.tb.airbnb.lottie.model.a.f dHA() {
        return this.nsO;
    }

    public m<PointF, PointF> dHt() {
        return this.nsI;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new n(fVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.nsI + ", size=" + this.nsO + '}';
    }
}
