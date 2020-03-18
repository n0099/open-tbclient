package com.tb.airbnb.lottie.a.b;

import java.util.Collections;
/* loaded from: classes6.dex */
public class p<K, A> extends a<K, A> {
    private final com.tb.airbnb.lottie.e.b<A> nsv;

    public p(com.tb.airbnb.lottie.e.c<A> cVar) {
        super(Collections.emptyList());
        this.nsv = new com.tb.airbnb.lottie.e.b<>();
        a(cVar);
    }

    @Override // com.tb.airbnb.lottie.a.b.a
    float bW() {
        return 1.0f;
    }

    @Override // com.tb.airbnb.lottie.a.b.a
    public void bz() {
        if (this.nsh != null) {
            super.bz();
        }
    }

    @Override // com.tb.airbnb.lottie.a.b.a
    public A getValue() {
        return this.nsh.b(0.0f, 0.0f, null, null, getProgress(), getProgress(), getProgress());
    }

    @Override // com.tb.airbnb.lottie.a.b.a
    A a(com.tb.airbnb.lottie.e.a<K> aVar, float f) {
        return getValue();
    }
}
