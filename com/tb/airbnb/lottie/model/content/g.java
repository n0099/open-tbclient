package com.tb.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import com.tb.airbnb.lottie.a.a.o;
import com.tb.airbnb.lottie.model.a.l;
/* loaded from: classes6.dex */
public class g implements b {
    private final com.tb.airbnb.lottie.model.a.b mPW;
    private final com.tb.airbnb.lottie.model.a.b mPX;
    private final l mPY;
    private final String name;

    public g(String str, com.tb.airbnb.lottie.model.a.b bVar, com.tb.airbnb.lottie.model.a.b bVar2, l lVar) {
        this.name = str;
        this.mPW = bVar;
        this.mPX = bVar2;
        this.mPY = lVar;
    }

    public String getName() {
        return this.name;
    }

    public com.tb.airbnb.lottie.model.a.b dBR() {
        return this.mPW;
    }

    public com.tb.airbnb.lottie.model.a.b dBS() {
        return this.mPX;
    }

    public l dBT() {
        return this.mPY;
    }

    @Override // com.tb.airbnb.lottie.model.content.b
    @Nullable
    public com.tb.airbnb.lottie.a.a.b a(com.tb.airbnb.lottie.f fVar, com.tb.airbnb.lottie.model.layer.a aVar) {
        return new o(fVar, aVar, this);
    }
}
