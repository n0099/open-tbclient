package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.o;
import com.tb.airbnb.lottie.model.a.l;
/* loaded from: classes6.dex */
public class g implements b {
    private final String name;
    private final com.tb.airbnb.lottie.model.a.b nti;
    private final com.tb.airbnb.lottie.model.a.b ntj;
    private final l ntk;

    public g(String str, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.nti = bVar;
        this.ntj = bVar2;
        this.ntk = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b dHT() {
        return this.nti;
    }

    public com.tb.airbnb.lottie.model.a.b dHU() {
        return this.ntj;
    }

    public l dHV() {
        return this.ntk;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new o(fVar, aVar, this);
    }
}
