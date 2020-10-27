package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes16.dex */
public class d implements b {
    private final Path.FillType Ff;
    private final String name;
    private final GradientType pAb;
    private final com.tb.airbnb.lottie.model.a.c pAc;
    private final com.tb.airbnb.lottie.model.a.f pAd;
    private final com.tb.airbnb.lottie.model.a.f pAe;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b pAf;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b pAg;
    private final com.tb.airbnb.lottie.model.a.d pzX;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.pAb = gradientType;
        this.Ff = fillType;
        this.pAc = cVar;
        this.pzX = dVar;
        this.pAd = fVar;
        this.pAe = fVar2;
        this.name = str;
        this.pAf = bVar;
        this.pAg = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType evh() {
        return this.pAb;
    }

    public Path.FillType jQ() {
        return this.Ff;
    }

    public com.tb.airbnb.lottie.model.a.c evi() {
        return this.pAc;
    }

    public com.tb.airbnb.lottie.model.a.d evc() {
        return this.pzX;
    }

    public com.tb.airbnb.lottie.model.a.f evj() {
        return this.pAd;
    }

    public com.tb.airbnb.lottie.model.a.f evk() {
        return this.pAe;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.g(fVar, aVar, this);
    }
}
