package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.o;
import com.tb.airbnb.lottie.model.a.l;
/* loaded from: classes20.dex */
public class g implements b {
    private final String name;
    private final com.tb.airbnb.lottie.model.a.b pCv;
    private final com.tb.airbnb.lottie.model.a.b pCw;
    private final l pCx;

    public g(String str, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.pCv = bVar;
        this.pCw = bVar2;
        this.pCx = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b eBL() {
        return this.pCv;
    }

    public com.tb.airbnb.lottie.model.a.b eBM() {
        return this.pCw;
    }

    public l eBN() {
        return this.pCx;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new o(gVar, aVar, this);
    }
}
