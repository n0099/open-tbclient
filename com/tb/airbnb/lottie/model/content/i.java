package com.tb.airbnb.lottie.model.content;

import android.graphics.Path;
import android.support.annotation.Nullable;
/* loaded from: classes6.dex */
public class i implements b {
    private final Path.FillType DC;
    private final boolean Ef;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.a mPo;
    @Nullable
    private final com.tb.airbnb.lottie.model.a.d mPw;
    private final String name;

    public i(String str, boolean z, Path.FillType fillType, @Nullable com.tb.airbnb.lottie.model.a.a aVar, @Nullable com.tb.airbnb.lottie.model.a.d dVar) {
        this.name = str;
        this.Ef = z;
        this.DC = fillType;
        this.mPo = aVar;
        this.mPw = dVar;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.a dBY() {
        return this.mPo;
    }

    @Nullable
    public com.tb.airbnb.lottie.model.a.d dBy() {
        return this.mPw;
    }

    public Path.FillType hX() {
        return this.DC;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new com.tb.airbnb.lottie.a.a.f(fVar, aVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.Ef + '}';
    }
}
