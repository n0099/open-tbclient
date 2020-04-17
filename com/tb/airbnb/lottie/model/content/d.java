package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class d implements b {
    private final Path.FillType DC;
    private final GradientType mPA;
    private final com.tb.airbnb.lottie.model.a.c mPB;
    private final com.tb.airbnb.lottie.model.a.f mPC;
    private final com.tb.airbnb.lottie.model.a.f mPD;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b mPE;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b mPF;
    private final com.tb.airbnb.lottie.model.a.d mPw;
    private final String name;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.mPA = gradientType;
        this.DC = fillType;
        this.mPB = cVar;
        this.mPw = dVar;
        this.mPC = fVar;
        this.mPD = fVar2;
        this.name = str;
        this.mPE = bVar;
        this.mPF = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType dBD() {
        return this.mPA;
    }

    public Path.FillType hX() {
        return this.DC;
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

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.g(fVar, aVar, this);
    }
}
