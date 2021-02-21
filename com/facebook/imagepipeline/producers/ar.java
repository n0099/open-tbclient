package com.facebook.imagepipeline.producers;
/* loaded from: classes5.dex */
public class ar<T> implements aj<Void> {
    private final aj<T> pLO;

    public ar(aj<T> ajVar) {
        this.pLO = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<Void> kVar, ak akVar) {
        this.pLO.a(new n<T, Void>(kVar) { // from class: com.facebook.imagepipeline.producers.ar.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void f(T t, int i) {
                if (Qk(i)) {
                    ezC().g(null, i);
                }
            }
        }, akVar);
    }
}
