package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes17.dex */
public class i implements b {
    private final Path.FillType EN;
    private final boolean Fo;
    private final String name;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.a otc;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.d otk;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.tb.airbnb.lottie.model.a.a aVar, @Nullable com.tb.airbnb.lottie.model.a.d dVar) {
        this.name = str;
        this.Fo = z;
        this.EN = fillType;
        this.otc = aVar;
        this.otk = dVar;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.a ehR() {
        return this.otc;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.d ehr() {
        return this.otk;
    }

    public Path.FillType jP() {
        return this.EN;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.f(fVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.Fo + '}';
    }
}
