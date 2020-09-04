package com.facebook.imagepipeline.producers;
/* loaded from: classes8.dex */
public class ar<T> implements aj<Void> {
    private final aj<T> nyd;

    public ar(aj<T> ajVar) {
        this.nyd = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<Void> kVar, ak akVar) {
        this.nyd.c(new n<T, Void>(kVar) { // from class: com.facebook.imagepipeline.producers.ar.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void g(T t, int i) {
                if (Ml(i)) {
                    dVJ().h(null, i);
                }
            }
        }, akVar);
    }
}
