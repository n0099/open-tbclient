package com.facebook.imagepipeline.producers;
/* loaded from: classes18.dex */
public class ar<T> implements aj<Void> {
    private final aj<T> oOJ;

    public ar(aj<T> ajVar) {
        this.oOJ = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(k<Void> kVar, ak akVar) {
        this.oOJ.c(new n<T, Void>(kVar) { // from class: com.facebook.imagepipeline.producers.ar.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void g(T t, int i) {
                if (Pn(i)) {
                    enr().h(null, i);
                }
            }
        }, akVar);
    }
}
