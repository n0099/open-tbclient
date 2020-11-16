package com.facebook.imagepipeline.producers;
/* loaded from: classes15.dex */
public class ar<T> implements aj<Void> {
    private final aj<T> oZF;

    public ar(aj<T> ajVar) {
        this.oZF = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<Void> kVar, ak akVar) {
        this.oZF.c(new n<T, Void>(kVar) { // from class: com.facebook.imagepipeline.producers.ar.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void g(T t, int i) {
                if (Ql(i)) {
                    erf().h(null, i);
                }
            }
        }, akVar);
    }
}
