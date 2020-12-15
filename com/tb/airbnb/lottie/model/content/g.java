package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.o;
import com.tb.airbnb.lottie.model.a.l;
/* loaded from: classes20.dex */
public class g implements b {
    private final String name;
    private final com.tb.airbnb.lottie.model.a.b pCx;
    private final com.tb.airbnb.lottie.model.a.b pCy;
    private final l pCz;

    public g(String str, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.pCx = bVar;
        this.pCy = bVar2;
        this.pCz = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b eBM() {
        return this.pCx;
    }

    public com.tb.airbnb.lottie.model.a.b eBN() {
        return this.pCy;
    }

    public l eBO() {
        return this.pCz;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new o(gVar, aVar, this);
    }
}
