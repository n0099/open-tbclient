package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes17.dex */
public class d implements b {
    private final Path.FillType Ff;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.d pKU;
    private final GradientType pKY;
    private final com.tb.airbnb.lottie.model.a.c pKZ;
    private final com.tb.airbnb.lottie.model.a.f pLa;
    private final com.tb.airbnb.lottie.model.a.f pLb;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b pLc;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b pLd;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.pKY = gradientType;
        this.Ff = fillType;
        this.pKZ = cVar;
        this.pKU = dVar;
        this.pLa = fVar;
        this.pLb = fVar2;
        this.name = str;
        this.pLc = bVar;
        this.pLd = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType eyX() {
        return this.pKY;
    }

    public Path.FillType jQ() {
        return this.Ff;
    }

    public com.tb.airbnb.lottie.model.a.c eyY() {
        return this.pKZ;
    }

    public com.tb.airbnb.lottie.model.a.d eyS() {
        return this.pKU;
    }

    public com.tb.airbnb.lottie.model.a.f eyZ() {
        return this.pLa;
    }

    public com.tb.airbnb.lottie.model.a.f eza() {
        return this.pLb;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.g(gVar, aVar, this);
    }
}
