package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes20.dex */
public class e implements b {
    private final float Gg;
    private final List<com.tb.airbnb.lottie.model.a.b> Gh;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.d pBY;
    private final GradientType pCc;
    private final com.tb.airbnb.lottie.model.a.c pCd;
    private final com.tb.airbnb.lottie.model.a.f pCe;
    private final com.tb.airbnb.lottie.model.a.f pCf;
    private final com.tb.airbnb.lottie.model.a.b pCi;
    private final ShapeStroke.LineCapType pCj;
    private final ShapeStroke.LineJoinType pCk;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b pCl;

    public e(String str, GradientType gradientType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.tb.airbnb.lottie.model.a.b> list, @Nullable com.tb.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.pCc = gradientType;
        this.pCd = cVar;
        this.pBY = dVar;
        this.pCe = fVar;
        this.pCf = fVar2;
        this.pCi = bVar;
        this.pCj = lineCapType;
        this.pCk = lineJoinType;
        this.Gg = f;
        this.Gh = list;
        this.pCl = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType eBt() {
        return this.pCc;
    }

    public com.tb.airbnb.lottie.model.a.c eBu() {
        return this.pCd;
    }

    public com.tb.airbnb.lottie.model.a.d eBo() {
        return this.pBY;
    }

    public com.tb.airbnb.lottie.model.a.f eBv() {
        return this.pCe;
    }

    public com.tb.airbnb.lottie.model.a.f eBw() {
        return this.pCf;
    }

    public com.tb.airbnb.lottie.model.a.b eBx() {
        return this.pCi;
    }

    public ShapeStroke.LineCapType eBy() {
        return this.pCj;
    }

    public ShapeStroke.LineJoinType eBz() {
        return this.pCk;
    }

    public List<com.tb.airbnb.lottie.model.a.b> jX() {
        return this.Gh;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.b eBA() {
        return this.pCl;
    }

    public float jZ() {
        return this.Gg;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.h(gVar, aVar, this);
    }
}
