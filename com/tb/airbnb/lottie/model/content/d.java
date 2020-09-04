package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes7.dex */
public class d implements b {
    private final Path.FillType EN;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.d ojA;
    private final GradientType ojE;
    private final com.tb.airbnb.lottie.model.a.c ojF;
    private final com.tb.airbnb.lottie.model.a.f ojG;
    private final com.tb.airbnb.lottie.model.a.f ojH;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b ojI;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b ojJ;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.ojE = gradientType;
        this.EN = fillType;
        this.ojF = cVar;
        this.ojA = dVar;
        this.ojG = fVar;
        this.ojH = fVar2;
        this.name = str;
        this.ojI = bVar;
        this.ojJ = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType edz() {
        return this.ojE;
    }

    public Path.FillType jO() {
        return this.EN;
    }

    public com.tb.airbnb.lottie.model.a.c edA() {
        return this.ojF;
    }

    public com.tb.airbnb.lottie.model.a.d edu() {
        return this.ojA;
    }

    public com.tb.airbnb.lottie.model.a.f edB() {
        return this.ojG;
    }

    public com.tb.airbnb.lottie.model.a.f edC() {
        return this.ojH;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.g(fVar, aVar, this);
    }
}
