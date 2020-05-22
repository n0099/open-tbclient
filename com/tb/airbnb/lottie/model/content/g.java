package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.o;
import com.tb.airbnb.lottie.model.a.l;
/* loaded from: classes6.dex */
public class g implements b {
    private final String name;
    private final com.tb.airbnb.lottie.model.a.b njZ;
    private final com.tb.airbnb.lottie.model.a.b nka;
    private final l nkb;

    public g(String str, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.njZ = bVar;
        this.nka = bVar2;
        this.nkb = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b dJl() {
        return this.njZ;
    }

    public com.tb.airbnb.lottie.model.a.b dJm() {
        return this.nka;
    }

    public l dJn() {
        return this.nkb;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new o(fVar, aVar, this);
    }
}
