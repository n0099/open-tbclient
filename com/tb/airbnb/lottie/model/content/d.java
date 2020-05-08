package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class d implements b {
    private final Path.FillType DG;
    private final GradientType mPD;
    private final com.tb.airbnb.lottie.model.a.c mPE;
    private final com.tb.airbnb.lottie.model.a.f mPF;
    private final com.tb.airbnb.lottie.model.a.f mPG;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b mPH;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b mPI;
    private final com.tb.airbnb.lottie.model.a.d mPz;
    private final String name;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.mPD = gradientType;
        this.DG = fillType;
        this.mPE = cVar;
        this.mPz = dVar;
        this.mPF = fVar;
        this.mPG = fVar2;
        this.name = str;
        this.mPH = bVar;
        this.mPI = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType dBz() {
        return this.mPD;
    }

    public Path.FillType hX() {
        return this.DG;
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

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.g(fVar, aVar, this);
    }
}
