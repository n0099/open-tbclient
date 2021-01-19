package com.facebook.imagepipeline.producers;
/* loaded from: classes3.dex */
public class ar<T> implements aj<Void> {
    private final aj<T> pBg;

    public ar(aj<T> ajVar) {
        this.pBg = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<Void> kVar, ak akVar) {
        this.pBg.a(new n<T, Void>(kVar) { // from class: com.facebook.imagepipeline.producers.ar.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void f(T t, int i) {
                if (PO(i)) {
                    exc().g(null, i);
                }
            }
        }, akVar);
    }
}
