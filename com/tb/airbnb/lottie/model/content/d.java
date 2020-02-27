package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class d implements b {
    private final Path.FillType hZ;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.d nqL;
    private final GradientType nqP;
    private final com.tb.airbnb.lottie.model.a.c nqQ;
    private final com.tb.airbnb.lottie.model.a.f nqR;
    private final com.tb.airbnb.lottie.model.a.f nqS;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nqT;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nqU;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.nqP = gradientType;
        this.hZ = fillType;
        this.nqQ = cVar;
        this.nqL = dVar;
        this.nqR = fVar;
        this.nqS = fVar2;
        this.name = str;
        this.nqT = bVar;
        this.nqU = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType dGY() {
        return this.nqP;
    }

    public Path.FillType cA() {
        return this.hZ;
    }

    public com.tb.airbnb.lottie.model.a.c dGZ() {
        return this.nqQ;
    }

    public com.tb.airbnb.lottie.model.a.d dGT() {
        return this.nqL;
    }

    public com.tb.airbnb.lottie.model.a.f dHa() {
        return this.nqR;
    }

    public com.tb.airbnb.lottie.model.a.f dHb() {
        return this.nqS;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.g(fVar, aVar, this);
    }
}
