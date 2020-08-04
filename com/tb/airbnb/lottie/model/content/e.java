package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes5.dex */
public class e implements b {
    private final float Er;
    private final List<com.tb.airbnb.lottie.model.a.b> Es;
    private final ShapeStroke.LineJoinType nPA;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nPB;
    private final com.tb.airbnb.lottie.model.a.d nPo;
    private final GradientType nPs;
    private final com.tb.airbnb.lottie.model.a.c nPt;
    private final com.tb.airbnb.lottie.model.a.f nPu;
    private final com.tb.airbnb.lottie.model.a.f nPv;
    private final com.tb.airbnb.lottie.model.a.b nPy;
    private final ShapeStroke.LineCapType nPz;
    private final String name;

    public e(String str, GradientType gradientType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.tb.airbnb.lottie.model.a.b> list, @Nullable com.tb.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.nPs = gradientType;
        this.nPt = cVar;
        this.nPo = dVar;
        this.nPu = fVar;
        this.nPv = fVar2;
        this.nPy = bVar;
        this.nPz = lineCapType;
        this.nPA = lineJoinType;
        this.Er = f;
        this.Es = list;
        this.nPB = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType dRo() {
        return this.nPs;
    }

    public com.tb.airbnb.lottie.model.a.c dRp() {
        return this.nPt;
    }

    public com.tb.airbnb.lottie.model.a.d dRj() {
        return this.nPo;
    }

    public com.tb.airbnb.lottie.model.a.f dRq() {
        return this.nPu;
    }

    public com.tb.airbnb.lottie.model.a.f dRr() {
        return this.nPv;
    }

    public com.tb.airbnb.lottie.model.a.b dRs() {
        return this.nPy;
    }

    public ShapeStroke.LineCapType dRt() {
        return this.nPz;
    }

    public ShapeStroke.LineJoinType dRu() {
        return this.nPA;
    }

    public List<com.tb.airbnb.lottie.model.a.b> iw() {
        return this.Es;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.b dRv() {
        return this.nPB;
    }

    public float iy() {
        return this.Er;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.h(fVar, aVar, this);
    }
}
