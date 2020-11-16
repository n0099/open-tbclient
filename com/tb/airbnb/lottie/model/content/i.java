package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes17.dex */
public class i implements b {
    private final boolean FF;
    private final Path.FillType Ff;
    private final String name;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.a pKM;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.d pKU;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.tb.airbnb.lottie.model.a.a aVar, @Nullable com.tb.airbnb.lottie.model.a.d dVar) {
        this.name = str;
        this.FF = z;
        this.Ff = fillType;
        this.pKM = aVar;
        this.pKU = dVar;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.a ezs() {
        return this.pKM;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.d eyS() {
        return this.pKU;
    }

    public Path.FillType jQ() {
        return this.Ff;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.f(gVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.FF + '}';
    }
}
