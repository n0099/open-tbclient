package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes5.dex */
public class d implements b {
    private final Path.FillType Ei;
    private final com.tb.airbnb.lottie.model.a.d nPm;
    private final GradientType nPq;
    private final com.tb.airbnb.lottie.model.a.c nPr;
    private final com.tb.airbnb.lottie.model.a.f nPs;
    private final com.tb.airbnb.lottie.model.a.f nPt;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nPu;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nPv;
    private final String name;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.nPq = gradientType;
        this.Ei = fillType;
        this.nPr = cVar;
        this.nPm = dVar;
        this.nPs = fVar;
        this.nPt = fVar2;
        this.name = str;
        this.nPu = bVar;
        this.nPv = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType dRn() {
        return this.nPq;
    }

    public Path.FillType ip() {
        return this.Ei;
    }

    public com.tb.airbnb.lottie.model.a.c dRo() {
        return this.nPr;
    }

    public com.tb.airbnb.lottie.model.a.d dRi() {
        return this.nPm;
    }

    public com.tb.airbnb.lottie.model.a.f dRp() {
        return this.nPs;
    }

    public com.tb.airbnb.lottie.model.a.f dRq() {
        return this.nPt;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.g(fVar, aVar, this);
    }
}
