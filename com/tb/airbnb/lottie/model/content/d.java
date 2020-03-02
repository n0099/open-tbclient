package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class d implements b {
    private final Path.FillType hZ;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.d nqN;
    private final GradientType nqR;
    private final com.tb.airbnb.lottie.model.a.c nqS;
    private final com.tb.airbnb.lottie.model.a.f nqT;
    private final com.tb.airbnb.lottie.model.a.f nqU;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nqV;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nqW;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.nqR = gradientType;
        this.hZ = fillType;
        this.nqS = cVar;
        this.nqN = dVar;
        this.nqT = fVar;
        this.nqU = fVar2;
        this.name = str;
        this.nqV = bVar;
        this.nqW = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType dHa() {
        return this.nqR;
    }

    public Path.FillType cA() {
        return this.hZ;
    }

    public com.tb.airbnb.lottie.model.a.c dHb() {
        return this.nqS;
    }

    public com.tb.airbnb.lottie.model.a.d dGV() {
        return this.nqN;
    }

    public com.tb.airbnb.lottie.model.a.f dHc() {
        return this.nqT;
    }

    public com.tb.airbnb.lottie.model.a.f dHd() {
        return this.nqU;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.g(fVar, aVar, this);
    }
}
