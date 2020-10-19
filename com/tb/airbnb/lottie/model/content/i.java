package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes16.dex */
public class i implements b {
    private final boolean FF;
    private final Path.FillType Ff;
    private final String name;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.d oIA;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.a oIs;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.tb.airbnb.lottie.model.a.a aVar, @Nullable com.tb.airbnb.lottie.model.a.d dVar) {
        this.name = str;
        this.FF = z;
        this.Ff = fillType;
        this.oIs = aVar;
        this.oIA = dVar;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.a elC() {
        return this.oIs;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.d elc() {
        return this.oIA;
    }

    public Path.FillType jQ() {
        return this.Ff;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.f(fVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.FF + '}';
    }
}
