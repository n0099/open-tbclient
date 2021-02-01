package com.facebook.imagepipeline.producers;
/* loaded from: classes5.dex */
public class ar<T> implements aj<Void> {
    private final aj<T> pLo;

    public ar(aj<T> ajVar) {
        this.pLo = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<Void> kVar, ak akVar) {
        this.pLo.a(new n<T, Void>(kVar) { // from class: com.facebook.imagepipeline.producers.ar.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void f(T t, int i) {
                if (Qj(i)) {
                    ezu().g(null, i);
                }
            }
        }, akVar);
    }
}
