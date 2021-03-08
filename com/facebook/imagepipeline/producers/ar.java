package com.facebook.imagepipeline.producers;
/* loaded from: classes5.dex */
public class ar<T> implements aj<Void> {
    private final aj<T> pNT;

    public ar(aj<T> ajVar) {
        this.pNT = ajVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(k<Void> kVar, ak akVar) {
        this.pNT.a(new n<T, Void>(kVar) { // from class: com.facebook.imagepipeline.producers.ar.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void e(T t, int i) {
                if (Qo(i)) {
                    ezL().f(null, i);
                }
            }
        }, akVar);
    }
}
