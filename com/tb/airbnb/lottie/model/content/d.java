package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes7.dex */
public class d implements b {
    private final Path.FillType EN;
    private final String name;
    private final com.tb.airbnb.lottie.model.a.d oji;
    private final GradientType ojm;
    private final com.tb.airbnb.lottie.model.a.c ojn;
    private final com.tb.airbnb.lottie.model.a.f ojo;
    private final com.tb.airbnb.lottie.model.a.f ojp;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b ojq;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b ojr;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.ojm = gradientType;
        this.EN = fillType;
        this.ojn = cVar;
        this.oji = dVar;
        this.ojo = fVar;
        this.ojp = fVar2;
        this.name = str;
        this.ojq = bVar;
        this.ojr = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType edq() {
        return this.ojm;
    }

    public Path.FillType jO() {
        return this.EN;
    }

    public com.tb.airbnb.lottie.model.a.c edr() {
        return this.ojn;
    }

    public com.tb.airbnb.lottie.model.a.d edl() {
        return this.oji;
    }

    public com.tb.airbnb.lottie.model.a.f eds() {
        return this.ojo;
    }

    public com.tb.airbnb.lottie.model.a.f edt() {
        return this.ojp;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.g(fVar, aVar, this);
    }
}
