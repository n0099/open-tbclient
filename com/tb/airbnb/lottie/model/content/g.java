package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.o;
import com.tb.airbnb.lottie.model.a.l;
/* loaded from: classes6.dex */
public class g implements b {
    private final String name;
    private final com.tb.airbnb.lottie.model.a.b nri;
    private final com.tb.airbnb.lottie.model.a.b nrj;
    private final l nrk;

    public g(String str, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.nri = bVar;
        this.nrj = bVar2;
        this.nrk = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b dHq() {
        return this.nri;
    }

    public com.tb.airbnb.lottie.model.a.b dHr() {
        return this.nrj;
    }

    public l dHs() {
        return this.nrk;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new o(fVar, aVar, this);
    }
}
