package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.o;
import com.tb.airbnb.lottie.model.a.l;
/* loaded from: classes6.dex */
public class g implements b {
    private final String name;
    private final com.tb.airbnb.lottie.model.a.b nlj;
    private final com.tb.airbnb.lottie.model.a.b nlk;
    private final l nll;

    public g(String str, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.nlj = bVar;
        this.nlk = bVar2;
        this.nll = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b dJz() {
        return this.nlj;
    }

    public com.tb.airbnb.lottie.model.a.b dJA() {
        return this.nlk;
    }

    public l dJB() {
        return this.nll;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new o(fVar, aVar, this);
    }
}
