package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class d implements b {
    private final Path.FillType Ei;
    private final com.tb.airbnb.lottie.model.a.d nGE;
    private final GradientType nGI;
    private final com.tb.airbnb.lottie.model.a.c nGJ;
    private final com.tb.airbnb.lottie.model.a.f nGK;
    private final com.tb.airbnb.lottie.model.a.f nGL;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nGM;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nGN;
    private final String name;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.nGI = gradientType;
        this.Ei = fillType;
        this.nGJ = cVar;
        this.nGE = dVar;
        this.nGK = fVar;
        this.nGL = fVar2;
        this.name = str;
        this.nGM = bVar;
        this.nGN = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType dNR() {
        return this.nGI;
    }

    public Path.FillType ip() {
        return this.Ei;
    }

    public com.tb.airbnb.lottie.model.a.c dNS() {
        return this.nGJ;
    }

    public com.tb.airbnb.lottie.model.a.d dNM() {
        return this.nGE;
    }

    public com.tb.airbnb.lottie.model.a.f dNT() {
        return this.nGK;
    }

    public com.tb.airbnb.lottie.model.a.f dNU() {
        return this.nGL;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.g(fVar, aVar, this);
    }
}
