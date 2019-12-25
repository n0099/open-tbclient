package com.facebook.imagepipeline.producers;
/* loaded from: classes9.dex */
public class ar<T> implements aj<Void> {
    private final aj<T> lQz;

    public ar(aj<T> ajVar) {
        this.lQz = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<Void> kVar, ak akVar) {
        this.lQz.c(new n<T, Void>(kVar) { // from class: com.facebook.imagepipeline.producers.ar.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void f(T t, int i) {
                if (Iv(i)) {
                    dpj().g(null, i);
                }
            }
        }, akVar);
    }
}
