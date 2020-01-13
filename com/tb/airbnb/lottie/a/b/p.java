package com.tb.airbnb.lottie.a.b;

import java.util.Collections;
/* loaded from: classes5.dex */
public class p<K, A> extends a<K, A> {
    private final com.tb.airbnb.lottie.e.b<A> npO;

    public p(com.tb.airbnb.lottie.e.c<A> cVar) {
        super(Collections.emptyList());
        this.npO = new com.tb.airbnb.lottie.e.b<>();
        a(cVar);
    }

    @Override // com.tb.airbnb.lottie.a.b.a
    float bV() {
        return 1.0f;
    }

    @Override // com.tb.airbnb.lottie.a.b.a
    public void by() {
        if (this.npA != null) {
            super.by();
        }
    }

    @Override // com.tb.airbnb.lottie.a.b.a
    public A getValue() {
        return this.npA.b(0.0f, 0.0f, null, null, getProgress(), getProgress(), getProgress());
    }

    @Override // com.tb.airbnb.lottie.a.b.a
    A a(com.tb.airbnb.lottie.e.a<K> aVar, float f) {
        return getValue();
    }
}
