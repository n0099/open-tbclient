package com.facebook.imagepipeline.producers;
/* loaded from: classes3.dex */
public class ar<T> implements aj<Void> {
    private final aj<T> pFG;

    public ar(aj<T> ajVar) {
        this.pFG = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<Void> kVar, ak akVar) {
        this.pFG.a(new n<T, Void>(kVar) { // from class: com.facebook.imagepipeline.producers.ar.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void f(T t, int i) {
                if (Rv(i)) {
                    eAU().g(null, i);
                }
            }
        }, akVar);
    }
}
