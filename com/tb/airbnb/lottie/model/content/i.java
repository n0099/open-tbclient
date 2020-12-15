package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes20.dex */
public class i implements b {
    private final Path.FillType FX;
    private final boolean Gx;
    private final String name;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.a pBS;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.d pCa;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.tb.airbnb.lottie.model.a.a aVar, @Nullable com.tb.airbnb.lottie.model.a.d dVar) {
        this.name = str;
        this.Gx = z;
        this.FX = fillType;
        this.pBS = aVar;
        this.pCa = dVar;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.a eBP() {
        return this.pBS;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.d eBp() {
        return this.pCa;
    }

    public Path.FillType jQ() {
        return this.FX;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.f(gVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.Gx + '}';
    }
}
