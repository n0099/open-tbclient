package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.o;
import com.tb.airbnb.lottie.model.a.l;
/* loaded from: classes6.dex */
public class g implements b {
    private final com.tb.airbnb.lottie.model.a.b nGY;
    private final com.tb.airbnb.lottie.model.a.b nGZ;
    private final l nHa;
    private final String name;

    public g(String str, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.nGY = bVar;
        this.nGZ = bVar2;
        this.nHa = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b dOf() {
        return this.nGY;
    }

    public com.tb.airbnb.lottie.model.a.b dOg() {
        return this.nGZ;
    }

    public l dOh() {
        return this.nHa;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new o(fVar, aVar, this);
    }
}
