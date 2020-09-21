package com.facebook.imagepipeline.producers;
/* loaded from: classes25.dex */
public class ar<T> implements aj<Void> {
    private final aj<T> nIa;

    public ar(aj<T> ajVar) {
        this.nIa = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<Void> kVar, ak akVar) {
        this.nIa.c(new n<T, Void>(kVar) { // from class: com.facebook.imagepipeline.producers.ar.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void g(T t, int i) {
                if (MQ(i)) {
                    dZH().h(null, i);
                }
            }
        }, akVar);
    }
}
