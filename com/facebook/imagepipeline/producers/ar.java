package com.facebook.imagepipeline.producers;
/* loaded from: classes4.dex */
public class ar<T> implements aj<Void> {
    private final aj<T> ndV;

    public ar(aj<T> ajVar) {
        this.ndV = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<Void> kVar, ak akVar) {
        this.ndV.c(new n<T, Void>(kVar) { // from class: com.facebook.imagepipeline.producers.ar.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void g(T t, int i) {
                if (JH(i)) {
                    dJB().h(null, i);
                }
            }
        }, akVar);
    }
}
