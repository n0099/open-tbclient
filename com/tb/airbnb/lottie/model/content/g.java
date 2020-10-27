package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.o;
import com.tb.airbnb.lottie.model.a.l;
/* loaded from: classes16.dex */
public class g implements b {
    private final String name;
    private final com.tb.airbnb.lottie.model.a.b pAu;
    private final com.tb.airbnb.lottie.model.a.b pAv;
    private final l pAw;

    public g(String str, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.pAu = bVar;
        this.pAv = bVar2;
        this.pAw = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b evz() {
        return this.pAu;
    }

    public com.tb.airbnb.lottie.model.a.b evA() {
        return this.pAv;
    }

    public l evB() {
        return this.pAw;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new o(fVar, aVar, this);
    }
}
