package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.o;
import com.tb.airbnb.lottie.model.a.l;
/* loaded from: classes6.dex */
public class g implements b {
    private final com.tb.airbnb.lottie.model.a.b mPT;
    private final com.tb.airbnb.lottie.model.a.b mPU;
    private final l mPV;
    private final String name;

    public g(String str, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.mPT = bVar;
        this.mPU = bVar2;
        this.mPV = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b dBV() {
        return this.mPT;
    }

    public com.tb.airbnb.lottie.model.a.b dBW() {
        return this.mPU;
    }

    public l dBX() {
        return this.mPV;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new o(fVar, aVar, this);
    }
}
