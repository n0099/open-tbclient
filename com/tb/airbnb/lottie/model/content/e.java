package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes5.dex */
public class e implements b {
    private final float Er;
    private final List<com.tb.airbnb.lottie.model.a.b> Es;
    private final com.tb.airbnb.lottie.model.a.d nPm;
    private final GradientType nPq;
    private final com.tb.airbnb.lottie.model.a.c nPr;
    private final com.tb.airbnb.lottie.model.a.f nPs;
    private final com.tb.airbnb.lottie.model.a.f nPt;
    private final com.tb.airbnb.lottie.model.a.b nPw;
    private final ShapeStroke.LineCapType nPx;
    private final ShapeStroke.LineJoinType nPy;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nPz;
    private final String name;

    public e(String str, GradientType gradientType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.tb.airbnb.lottie.model.a.b> list, @Nullable com.tb.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.nPq = gradientType;
        this.nPr = cVar;
        this.nPm = dVar;
        this.nPs = fVar;
        this.nPt = fVar2;
        this.nPw = bVar;
        this.nPx = lineCapType;
        this.nPy = lineJoinType;
        this.Er = f;
        this.Es = list;
        this.nPz = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType dRn() {
        return this.nPq;
    }

    public com.tb.airbnb.lottie.model.a.c dRo() {
        return this.nPr;
    }

    public com.tb.airbnb.lottie.model.a.d dRi() {
        return this.nPm;
    }

    public com.tb.airbnb.lottie.model.a.f dRp() {
        return this.nPs;
    }

    public com.tb.airbnb.lottie.model.a.f dRq() {
        return this.nPt;
    }

    public com.tb.airbnb.lottie.model.a.b dRr() {
        return this.nPw;
    }

    public ShapeStroke.LineCapType dRs() {
        return this.nPx;
    }

    public ShapeStroke.LineJoinType dRt() {
        return this.nPy;
    }

    public List<com.tb.airbnb.lottie.model.a.b> iw() {
        return this.Es;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.b dRu() {
        return this.nPz;
    }

    public float iy() {
        return this.Er;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.h(fVar, aVar, this);
    }
}
