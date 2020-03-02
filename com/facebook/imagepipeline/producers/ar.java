package com.facebook.imagepipeline.producers;
/* loaded from: classes12.dex */
public class ar<T> implements aj<Void> {
    private final aj<T> lVb;

    public ar(aj<T> ajVar) {
        this.lVb = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<Void> kVar, ak akVar) {
        this.lVb.c(new n<T, Void>(kVar) { // from class: com.facebook.imagepipeline.producers.ar.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void f(T t, int i) {
                if (IJ(i)) {
                    drJ().g(null, i);
                }
            }
        }, akVar);
    }
}
