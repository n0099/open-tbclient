package com.facebook.imagepipeline.producers;
/* loaded from: classes12.dex */
public class ar<T> implements aj<Void> {
    private final aj<T> mVS;

    public ar(aj<T> ajVar) {
        this.mVS = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<Void> kVar, ak akVar) {
        this.mVS.c(new n<T, Void>(kVar) { // from class: com.facebook.imagepipeline.producers.ar.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void g(T t, int i) {
                if (Jm(i)) {
                    dGo().h(null, i);
                }
            }
        }, akVar);
    }
}
