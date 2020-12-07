package com.facebook.imagepipeline.producers;
/* loaded from: classes15.dex */
public class ar<T> implements aj<Void> {
    private final aj<T> pox;

    public ar(aj<T> ajVar) {
        this.pox = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<Void> kVar, ak akVar) {
        this.pox.a(new n<T, Void>(kVar) { // from class: com.facebook.imagepipeline.producers.ar.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void g(T t, int i) {
                if (Rh(i)) {
                    ewI().h(null, i);
                }
            }
        }, akVar);
    }
}
