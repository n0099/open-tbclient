package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes16.dex */
public class d implements b {
    private final Path.FillType Ff;
    private final String name;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b pJA;
    private final com.tb.airbnb.lottie.model.a.d pJr;
    private final GradientType pJv;
    private final com.tb.airbnb.lottie.model.a.c pJw;
    private final com.tb.airbnb.lottie.model.a.f pJx;
    private final com.tb.airbnb.lottie.model.a.f pJy;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.b pJz;

    public d(String str, GradientType gradientType, Path.FillType fillType, com.tb.airbnb.lottie.model.a.c cVar, com.tb.airbnb.lottie.model.a.d dVar, com.tb.airbnb.lottie.model.a.f fVar, com.tb.airbnb.lottie.model.a.f fVar2, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2) {
        this.pJv = gradientType;
        this.Ff = fillType;
        this.pJw = cVar;
        this.pJr = dVar;
        this.pJx = fVar;
        this.pJy = fVar2;
        this.name = str;
        this.pJz = bVar;
        this.pJA = bVar2;
    }

    public String getName() {
        return this.name;
    }

    public GradientType eyW() {
        return this.pJv;
    }

    public Path.FillType jQ() {
        return this.Ff;
    }

    public com.tb.airbnb.lottie.model.a.c eyX() {
        return this.pJw;
    }

    public com.tb.airbnb.lottie.model.a.d eyR() {
        return this.pJr;
    }

    public com.tb.airbnb.lottie.model.a.f eyY() {
        return this.pJx;
    }

    public com.tb.airbnb.lottie.model.a.f eyZ() {
        return this.pJy;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.g(gVar, aVar, this);
    }
}
