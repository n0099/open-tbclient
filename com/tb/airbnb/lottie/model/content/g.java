package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.o;
import com.tb.airbnb.lottie.model.a.l;
/* loaded from: classes5.dex */
public class g implements b {
    private final String name;
    private final com.tb.airbnb.lottie.model.a.b nqB;
    private final com.tb.airbnb.lottie.model.a.b nqC;
    private final l nqD;

    public g(String str, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.nqB = bVar;
        this.nqC = bVar2;
        this.nqD = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b dGh() {
        return this.nqB;
    }

    public com.tb.airbnb.lottie.model.a.b dGi() {
        return this.nqC;
    }

    public l dGj() {
        return this.nqD;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new o(fVar, aVar, this);
    }
}
