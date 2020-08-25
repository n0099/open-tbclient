package com.tb.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.tb.airbnb.lottie.a.a.n;
import com.tb.airbnb.lottie.model.a.m;
/* loaded from: classes7.dex */
public class f implements b {
    private final String name;
    private final com.tb.airbnb.lottie.model.a.b ojE;
    private final m<PointF, PointF> ojf;
    private final com.tb.airbnb.lottie.model.a.f ojl;

    public f(String str, m<PointF, PointF> mVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.b bVar) {
        this.name = str;
        this.ojf = mVar;
        this.ojl = fVar;
        this.ojE = bVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b edH() {
        return this.ojE;
    }

    public com.tb.airbnb.lottie.model.a.f edp() {
        return this.ojl;
    }

    public m<PointF, PointF> edi() {
        return this.ojf;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new n(fVar, aVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.ojf + ", size=" + this.ojl + '}';
    }
}
