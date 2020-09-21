package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.o;
import com.tb.airbnb.lottie.model.a.l;
/* loaded from: classes17.dex */
public class g implements b {
    private final String name;
    private final com.tb.airbnb.lottie.model.a.b otH;
    private final com.tb.airbnb.lottie.model.a.b otI;
    private final l otJ;

    public g(String str, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.otH = bVar;
        this.otI = bVar2;
        this.otJ = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b ehO() {
        return this.otH;
    }

    public com.tb.airbnb.lottie.model.a.b ehP() {
        return this.otI;
    }

    public l ehQ() {
        return this.otJ;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new o(fVar, aVar, this);
    }
}
