package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes20.dex */
public class d implements b {
    private final Path.FillType FX;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.d pCa;
    private final GradientType pCe;
    private final com.tb.airbnb.lottie.model.a.c pCf;
    private final com.tb.airbnb.lottie.model.a.f pCg;
    private final com.tb.airbnb.lottie.model.a.f pCh;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b pCi;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b pCj;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.pCe = gradientType;
        this.FX = fillType;
        this.pCf = cVar;
        this.pCa = dVar;
        this.pCg = fVar;
        this.pCh = fVar2;
        this.name = str;
        this.pCi = bVar;
        this.pCj = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType eBu() {
        return this.pCe;
    }

    public Path.FillType jQ() {
        return this.FX;
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

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.g(gVar, aVar, this);
    }
}
