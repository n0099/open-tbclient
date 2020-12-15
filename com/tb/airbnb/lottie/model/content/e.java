package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes20.dex */
public class e implements b {
    private final float Gg;
    private final List<com.tb.airbnb.lottie.model.a.b> Gh;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.d pCa;
    private final GradientType pCe;
    private final com.tb.airbnb.lottie.model.a.c pCf;
    private final com.tb.airbnb.lottie.model.a.f pCg;
    private final com.tb.airbnb.lottie.model.a.f pCh;
    private final com.tb.airbnb.lottie.model.a.b pCk;
    private final ShapeStroke.LineCapType pCl;
    private final ShapeStroke.LineJoinType pCm;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b pCn;

    public e(String str, GradientType gradientType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.tb.airbnb.lottie.model.a.b> list, @Nullable com.tb.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.pCe = gradientType;
        this.pCf = cVar;
        this.pCa = dVar;
        this.pCg = fVar;
        this.pCh = fVar2;
        this.pCk = bVar;
        this.pCl = lineCapType;
        this.pCm = lineJoinType;
        this.Gg = f;
        this.Gh = list;
        this.pCn = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType eBu() {
        return this.pCe;
    }

    public com.tb.airbnb.lottie.model.a.c eBv() {
        return this.pCf;
    }

    public com.tb.airbnb.lottie.model.a.d eBp() {
        return this.pCa;
    }

    public com.tb.airbnb.lottie.model.a.f eBw() {
        return this.pCg;
    }

    public com.tb.airbnb.lottie.model.a.f eBx() {
        return this.pCh;
    }

    public com.tb.airbnb.lottie.model.a.b eBy() {
        return this.pCk;
    }

    public ShapeStroke.LineCapType eBz() {
        return this.pCl;
    }

    public ShapeStroke.LineJoinType eBA() {
        return this.pCm;
    }

    public List<com.tb.airbnb.lottie.model.a.b> jX() {
        return this.Gh;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.b eBB() {
        return this.pCn;
    }

    public float jZ() {
        return this.Gg;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.h(gVar, aVar, this);
    }
}
