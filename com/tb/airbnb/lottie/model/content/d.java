package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes20.dex */
public class d implements b {
    private final Path.FillType FX;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.d pBY;
    private final GradientType pCc;
    private final com.tb.airbnb.lottie.model.a.c pCd;
    private final com.tb.airbnb.lottie.model.a.f pCe;
    private final com.tb.airbnb.lottie.model.a.f pCf;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b pCg;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b pCh;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.pCc = gradientType;
        this.FX = fillType;
        this.pCd = cVar;
        this.pBY = dVar;
        this.pCe = fVar;
        this.pCf = fVar2;
        this.name = str;
        this.pCg = bVar;
        this.pCh = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType eBt() {
        return this.pCc;
    }

    public Path.FillType jQ() {
        return this.FX;
    }

    public com.tb.airbnb.lottie.model.a.c eBu() {
        return this.pCd;
    }

    public com.tb.airbnb.lottie.model.a.d eBo() {
        return this.pBY;
    }

    public com.tb.airbnb.lottie.model.a.f eBv() {
        return this.pCe;
    }

    public com.tb.airbnb.lottie.model.a.f eBw() {
        return this.pCf;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.g(gVar, aVar, this);
    }
}
