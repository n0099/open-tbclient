package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class d implements b {
    private final Path.FillType Ei;
    private final com.tb.airbnb.lottie.model.a.d nGB;
    private final GradientType nGF;
    private final com.tb.airbnb.lottie.model.a.c nGG;
    private final com.tb.airbnb.lottie.model.a.f nGH;
    private final com.tb.airbnb.lottie.model.a.f nGI;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nGJ;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nGK;
    private final String name;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.nGF = gradientType;
        this.Ei = fillType;
        this.nGG = cVar;
        this.nGB = dVar;
        this.nGH = fVar;
        this.nGI = fVar2;
        this.name = str;
        this.nGJ = bVar;
        this.nGK = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType dNN() {
        return this.nGF;
    }

    public Path.FillType ip() {
        return this.Ei;
    }

    public com.tb.airbnb.lottie.model.a.c dNO() {
        return this.nGG;
    }

    public com.tb.airbnb.lottie.model.a.d dNI() {
        return this.nGB;
    }

    public com.tb.airbnb.lottie.model.a.f dNP() {
        return this.nGH;
    }

    public com.tb.airbnb.lottie.model.a.f dNQ() {
        return this.nGI;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.g(fVar, aVar, this);
    }
}
