package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes5.dex */
public class i implements b {
    private final boolean EJ;
    private final Path.FillType Ei;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.a nPe;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.d nPm;
    private final String name;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.tb.airbnb.lottie.model.a.a aVar, @Nullable com.tb.airbnb.lottie.model.a.d dVar) {
        this.name = str;
        this.EJ = z;
        this.Ei = fillType;
        this.nPe = aVar;
        this.nPm = dVar;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.a dRI() {
        return this.nPe;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.d dRi() {
        return this.nPm;
    }

    public Path.FillType ip() {
        return this.Ei;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.f(fVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.EJ + '}';
    }
}
