package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.o;
import com.tb.airbnb.lottie.model.a.l;
/* loaded from: classes5.dex */
public class g implements b {
    private final String name;
    private final com.tb.airbnb.lottie.model.a.b nqG;
    private final com.tb.airbnb.lottie.model.a.b nqH;
    private final l nqI;

    public g(String str, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.nqG = bVar;
        this.nqH = bVar2;
        this.nqI = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b dGj() {
        return this.nqG;
    }

    public com.tb.airbnb.lottie.model.a.b dGk() {
        return this.nqH;
    }

    public l dGl() {
        return this.nqI;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new o(fVar, aVar, this);
    }
}
