package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.o;
import com.tb.airbnb.lottie.model.a.l;
/* loaded from: classes16.dex */
public class g implements b {
    private final String name;
    private final com.tb.airbnb.lottie.model.a.b pJO;
    private final com.tb.airbnb.lottie.model.a.b pJP;
    private final l pJQ;

    public g(String str, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.pJO = bVar;
        this.pJP = bVar2;
        this.pJQ = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b ezo() {
        return this.pJO;
    }

    public com.tb.airbnb.lottie.model.a.b ezp() {
        return this.pJP;
    }

    public l ezq() {
        return this.pJQ;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.g gVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new o(gVar, aVar, this);
    }
}
