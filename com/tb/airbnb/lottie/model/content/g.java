package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.o;
import com.tb.airbnb.lottie.model.a.l;
/* loaded from: classes6.dex */
public class g implements b {
    private final String name;
    private final com.tb.airbnb.lottie.model.a.b nrv;
    private final com.tb.airbnb.lottie.model.a.b nrw;
    private final l nrx;

    public g(String str, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.nrv = bVar;
        this.nrw = bVar2;
        this.nrx = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b dHt() {
        return this.nrv;
    }

    public com.tb.airbnb.lottie.model.a.b dHu() {
        return this.nrw;
    }

    public l dHv() {
        return this.nrx;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new o(fVar, aVar, this);
    }
}
