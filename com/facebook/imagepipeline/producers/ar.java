package com.facebook.imagepipeline.producers;
/* loaded from: classes12.dex */
public class ar<T> implements aj<Void> {
    private final aj<T> myy;

    public ar(aj<T> ajVar) {
        this.myy = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<Void> kVar, ak akVar) {
        this.myy.c(new n<T, Void>(kVar) { // from class: com.facebook.imagepipeline.producers.ar.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void g(T t, int i) {
                if (Id(i)) {
                    dBu().h(null, i);
                }
            }
        }, akVar);
    }
}
