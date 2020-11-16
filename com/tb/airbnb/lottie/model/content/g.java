package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.o;
import com.tb.airbnb.lottie.model.a.l;
/* loaded from: classes17.dex */
public class g implements b {
    private final String name;
    private final com.tb.airbnb.lottie.model.a.b pLr;
    private final com.tb.airbnb.lottie.model.a.b pLs;
    private final l pLt;

    public g(String str, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.pLr = bVar;
        this.pLs = bVar2;
        this.pLt = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b ezp() {
        return this.pLr;
    }

    public com.tb.airbnb.lottie.model.a.b ezq() {
        return this.pLs;
    }

    public l ezr() {
        return this.pLt;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new o(gVar, aVar, this);
    }
}
