package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class i implements b {
    private final boolean EJ;
    private final Path.FillType Ei;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.d nGE;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.a nGw;
    private final String name;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.tb.airbnb.lottie.model.a.a aVar, @Nullable com.tb.airbnb.lottie.model.a.d dVar) {
        this.name = str;
        this.EJ = z;
        this.Ei = fillType;
        this.nGw = aVar;
        this.nGE = dVar;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.a dOm() {
        return this.nGw;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.d dNM() {
        return this.nGE;
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
