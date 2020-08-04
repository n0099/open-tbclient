package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes5.dex */
public class d implements b {
    private final Path.FillType Ei;
    private final com.tb.airbnb.lottie.model.a.d nPo;
    private final GradientType nPs;
    private final com.tb.airbnb.lottie.model.a.c nPt;
    private final com.tb.airbnb.lottie.model.a.f nPu;
    private final com.tb.airbnb.lottie.model.a.f nPv;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nPw;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b nPx;
    private final String name;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.nPs = gradientType;
        this.Ei = fillType;
        this.nPt = cVar;
        this.nPo = dVar;
        this.nPu = fVar;
        this.nPv = fVar2;
        this.name = str;
        this.nPw = bVar;
        this.nPx = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType dRo() {
        return this.nPs;
    }

    public Path.FillType ip() {
        return this.Ei;
    }

    public com.tb.airbnb.lottie.model.a.c dRp() {
        return this.nPt;
    }

    public com.tb.airbnb.lottie.model.a.d dRj() {
        return this.nPo;
    }

    public com.tb.airbnb.lottie.model.a.f dRq() {
        return this.nPu;
    }

    public com.tb.airbnb.lottie.model.a.f dRr() {
        return this.nPv;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.g(fVar, aVar, this);
    }
}
