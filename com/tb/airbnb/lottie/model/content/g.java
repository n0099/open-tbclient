package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.o;
import com.tb.airbnb.lottie.model.a.l;
/* loaded from: classes6.dex */
public class g implements b {
    private final com.tb.airbnb.lottie.model.a.b nHb;
    private final com.tb.airbnb.lottie.model.a.b nHc;
    private final l nHd;
    private final String name;

    public g(String str, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.nHb = bVar;
        this.nHc = bVar2;
        this.nHd = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b dOj() {
        return this.nHb;
    }

    public com.tb.airbnb.lottie.model.a.b dOk() {
        return this.nHc;
    }

    public l dOl() {
        return this.nHd;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new o(fVar, aVar, this);
    }
}
