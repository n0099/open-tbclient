package com.facebook.imagepipeline.producers;
/* loaded from: classes18.dex */
public class ar<T> implements aj<Void> {
    private final aj<T> nXr;

    public ar(aj<T> ajVar) {
        this.nXr = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<Void> kVar, ak akVar) {
        this.nXr.c(new n<T, Void>(kVar) { // from class: com.facebook.imagepipeline.producers.ar.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void g(T t, int i) {
                if (Nw(i)) {
                    eds().h(null, i);
                }
            }
        }, akVar);
    }
}
