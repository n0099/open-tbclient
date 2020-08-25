package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.o;
import com.tb.airbnb.lottie.model.a.l;
/* loaded from: classes7.dex */
public class g implements b {
    private final String name;
    private final com.tb.airbnb.lottie.model.a.b ojF;
    private final com.tb.airbnb.lottie.model.a.b ojG;
    private final l ojH;

    public g(String str, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.ojF = bVar;
        this.ojG = bVar2;
        this.ojH = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b edI() {
        return this.ojF;
    }

    public com.tb.airbnb.lottie.model.a.b edJ() {
        return this.ojG;
    }

    public l edK() {
        return this.ojH;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new o(fVar, aVar, this);
    }
}
