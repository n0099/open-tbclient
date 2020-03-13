package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class d implements b {
    private final Path.FillType hZ;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.d nqY;
    private final GradientType nrc;
    private final com.tb.airbnb.lottie.model.a.c nrd;
    private final com.tb.airbnb.lottie.model.a.f nre;
    private final com.tb.airbnb.lottie.model.a.f nrf;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nrg;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nrh;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.nrc = gradientType;
        this.hZ = fillType;
        this.nrd = cVar;
        this.nqY = dVar;
        this.nre = fVar;
        this.nrf = fVar2;
        this.name = str;
        this.nrg = bVar;
        this.nrh = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType dHb() {
        return this.nrc;
    }

    public Path.FillType cA() {
        return this.hZ;
    }

    public com.tb.airbnb.lottie.model.a.c dHc() {
        return this.nrd;
    }

    public com.tb.airbnb.lottie.model.a.d dGW() {
        return this.nqY;
    }

    public com.tb.airbnb.lottie.model.a.f dHd() {
        return this.nre;
    }

    public com.tb.airbnb.lottie.model.a.f dHe() {
        return this.nrf;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.g(fVar, aVar, this);
    }
}
