package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class d implements b {
    private final Path.FillType DG;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.d njC;
    private final GradientType njG;
    private final com.tb.airbnb.lottie.model.a.c njH;
    private final com.tb.airbnb.lottie.model.a.f njI;
    private final com.tb.airbnb.lottie.model.a.f njJ;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b njK;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b njL;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.njG = gradientType;
        this.DG = fillType;
        this.njH = cVar;
        this.njC = dVar;
        this.njI = fVar;
        this.njJ = fVar2;
        this.name = str;
        this.njK = bVar;
        this.njL = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType dIT() {
        return this.njG;
    }

    public Path.FillType hX() {
        return this.DG;
    }

    public com.tb.airbnb.lottie.model.a.c dIU() {
        return this.njH;
    }

    public com.tb.airbnb.lottie.model.a.d dIO() {
        return this.njC;
    }

    public com.tb.airbnb.lottie.model.a.f dIV() {
        return this.njI;
    }

    public com.tb.airbnb.lottie.model.a.f dIW() {
        return this.njJ;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.g(fVar, aVar, this);
    }
}
