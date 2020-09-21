package com.tb.airbnb.lottie.a.b;

import java.util.Collections;
/* loaded from: classes17.dex */
public class p<K, A> extends a<K, A> {
    private final com.tb.airbnb.lottie.e.b<A> osU;

    public p(com.tb.airbnb.lottie.e.c<A> cVar) {
        super(Collections.emptyList());
        this.osU = new com.tb.airbnb.lottie.e.b<>();
        a(cVar);
    }

    @Override // com.tb.airbnb.lottie.a.b.a
    float jl() {
        return 1.0f;
    }

    @Override // com.tb.airbnb.lottie.a.b.a
    public void iO() {
        if (this.osG != null) {
            super.iO();
        }
    }

    @Override // com.tb.airbnb.lottie.a.b.a
    public A getValue() {
        return this.osG.b(0.0f, 0.0f, null, null, getProgress(), getProgress(), getProgress());
    }

    @Override // com.tb.airbnb.lottie.a.b.a
    A a(com.tb.airbnb.lottie.e.a<K> aVar, float f) {
        return getValue();
    }
}
