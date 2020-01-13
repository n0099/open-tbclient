package com.facebook.imagepipeline.producers;
/* loaded from: classes10.dex */
public class ar<T> implements aj<Void> {
    private final aj<T> lUn;

    public ar(aj<T> ajVar) {
        this.lUn = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<Void> kVar, ak akVar) {
        this.lUn.c(new n<T, Void>(kVar) { // from class: com.facebook.imagepipeline.producers.ar.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void f(T t, int i) {
                if (IE(i)) {
                    dqt().g(null, i);
                }
            }
        }, akVar);
    }
}
