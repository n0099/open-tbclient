package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes16.dex */
public class e implements b {
    private final float Fo;
    private final List<com.tb.airbnb.lottie.model.a.b> Fp;
    private final String name;
    private final GradientType pAb;
    private final com.tb.airbnb.lottie.model.a.c pAc;
    private final com.tb.airbnb.lottie.model.a.f pAd;
    private final com.tb.airbnb.lottie.model.a.f pAe;
    private final com.tb.airbnb.lottie.model.a.b pAh;
    private final ShapeStroke.LineCapType pAi;
    private final ShapeStroke.LineJoinType pAj;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b pAk;
    private final com.tb.airbnb.lottie.model.a.d pzX;

    public e(String str, GradientType gradientType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.tb.airbnb.lottie.model.a.b> list, @Nullable com.tb.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.pAb = gradientType;
        this.pAc = cVar;
        this.pzX = dVar;
        this.pAd = fVar;
        this.pAe = fVar2;
        this.pAh = bVar;
        this.pAi = lineCapType;
        this.pAj = lineJoinType;
        this.Fo = f;
        this.Fp = list;
        this.pAk = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType evh() {
        return this.pAb;
    }

    public com.tb.airbnb.lottie.model.a.c evi() {
        return this.pAc;
    }

    public com.tb.airbnb.lottie.model.a.d evc() {
        return this.pzX;
    }

    public com.tb.airbnb.lottie.model.a.f evj() {
        return this.pAd;
    }

    public com.tb.airbnb.lottie.model.a.f evk() {
        return this.pAe;
    }

    public com.tb.airbnb.lottie.model.a.b evl() {
        return this.pAh;
    }

    public ShapeStroke.LineCapType evm() {
        return this.pAi;
    }

    public ShapeStroke.LineJoinType evn() {
        return this.pAj;
    }

    public List<com.tb.airbnb.lottie.model.a.b> jX() {
        return this.Fp;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.b evo() {
        return this.pAk;
    }

    public float jZ() {
        return this.Fo;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.h(fVar, aVar, this);
    }
}
