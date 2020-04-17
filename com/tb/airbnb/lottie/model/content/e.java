package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.model.content.ShapeStroke;
import java.util.List;
/* loaded from: classes6.dex */
public class e implements b {
    private final float DN;
    private final List<com.tb.airbnb.lottie.model.a.b> DO;
    private final GradientType mPA;
    private final com.tb.airbnb.lottie.model.a.c mPB;
    private final com.tb.airbnb.lottie.model.a.f mPC;
    private final com.tb.airbnb.lottie.model.a.f mPD;
    private final com.tb.airbnb.lottie.model.a.b mPG;
    private final ShapeStroke.LineCapType mPH;
    private final ShapeStroke.LineJoinType mPI;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b mPJ;
    private final com.tb.airbnb.lottie.model.a.d mPw;
    private final String name;

    public e(String str, GradientType gradientType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List<com.tb.airbnb.lottie.model.a.b> list, @Nullable com.tb.airbnb.lottie.model.a.b bVar2) {
        this.name = str;
        this.mPA = gradientType;
        this.mPB = cVar;
        this.mPw = dVar;
        this.mPC = fVar;
        this.mPD = fVar2;
        this.mPG = bVar;
        this.mPH = lineCapType;
        this.mPI = lineJoinType;
        this.DN = f;
        this.DO = list;
        this.mPJ = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType dBD() {
        return this.mPA;
    }

    public com.tb.airbnb.lottie.model.a.c dBE() {
        return this.mPB;
    }

    public com.tb.airbnb.lottie.model.a.d dBy() {
        return this.mPw;
    }

    public com.tb.airbnb.lottie.model.a.f dBF() {
        return this.mPC;
    }

    public com.tb.airbnb.lottie.model.a.f dBG() {
        return this.mPD;
    }

    public com.tb.airbnb.lottie.model.a.b dBH() {
        return this.mPG;
    }

    public ShapeStroke.LineCapType dBI() {
        return this.mPH;
    }

    public ShapeStroke.LineJoinType dBJ() {
        return this.mPI;
    }

    /* renamed from: if  reason: not valid java name */
    public List<com.tb.airbnb.lottie.model.a.b> m49if() {
        return this.DO;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.b dBK() {
        return this.mPJ;
    }

    public float ih() {
        return this.DN;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.h(fVar, aVar, this);
    }
}
