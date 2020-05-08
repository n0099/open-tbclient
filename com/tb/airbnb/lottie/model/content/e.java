package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes6.dex */
public class e implements b {
    private final float DR;
    private final List<com.tb.airbnb.lottie.model.a.b> DS;
    private final GradientType mPD;
    private final com.tb.airbnb.lottie.model.a.c mPE;
    private final com.tb.airbnb.lottie.model.a.f mPF;
    private final com.tb.airbnb.lottie.model.a.f mPG;
    private final com.tb.airbnb.lottie.model.a.b mPJ;
    private final ShapeStroke.LineCapType mPK;
    private final ShapeStroke.LineJoinType mPL;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b mPM;
    private final com.tb.airbnb.lottie.model.a.d mPz;
    private final String name;

    public e(String str, GradientType gradientType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.tb.airbnb.lottie.model.a.b> list, @Nullable com.tb.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.mPD = gradientType;
        this.mPE = cVar;
        this.mPz = dVar;
        this.mPF = fVar;
        this.mPG = fVar2;
        this.mPJ = bVar;
        this.mPK = lineCapType;
        this.mPL = lineJoinType;
        this.DR = f;
        this.DS = list;
        this.mPM = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType dBz() {
        return this.mPD;
    }

    public com.tb.airbnb.lottie.model.a.c dBA() {
        return this.mPE;
    }

    public com.tb.airbnb.lottie.model.a.d dBu() {
        return this.mPz;
    }

    public com.tb.airbnb.lottie.model.a.f dBB() {
        return this.mPF;
    }

    public com.tb.airbnb.lottie.model.a.f dBC() {
        return this.mPG;
    }

    public com.tb.airbnb.lottie.model.a.b dBD() {
        return this.mPJ;
    }

    public ShapeStroke.LineCapType dBE() {
        return this.mPK;
    }

    public ShapeStroke.LineJoinType dBF() {
        return this.mPL;
    }

    /* renamed from: if  reason: not valid java name */
    public List<com.tb.airbnb.lottie.model.a.b> m49if() {
        return this.DS;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.b dBG() {
        return this.mPM;
    }

    public float ih() {
        return this.DR;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.h(fVar, aVar, this);
    }
}
