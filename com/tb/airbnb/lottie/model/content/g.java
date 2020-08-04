package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.o;
import com.tb.airbnb.lottie.model.a.l;
/* loaded from: classes5.dex */
public class g implements b {
    private final com.tb.airbnb.lottie.model.a.b nPL;
    private final com.tb.airbnb.lottie.model.a.b nPM;
    private final l nPN;
    private final String name;

    public g(String str, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.nPL = bVar;
        this.nPM = bVar2;
        this.nPN = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b dRG() {
        return this.nPL;
    }

    public com.tb.airbnb.lottie.model.a.b dRH() {
        return this.nPM;
    }

    public l dRI() {
        return this.nPN;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new o(fVar, aVar, this);
    }
}
