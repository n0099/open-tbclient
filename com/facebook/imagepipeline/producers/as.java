package com.facebook.imagepipeline.producers;
/* loaded from: classes12.dex */
public class as<T> implements aj<T> {
    private final at mvA;
    private final aj<T> myy;

    public as(aj<T> ajVar, at atVar) {
        this.myy = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.mvA = atVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(final k<T> kVar, final ak akVar) {
        final am dBj = akVar.dBj();
        final String id = akVar.getId();
        final aq<T> aqVar = new aq<T>(kVar, dBj, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.as.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void onSuccess(T t) {
                dBj.a(id, "BackgroundThreadHandoffProducer", null);
                as.this.myy.c(kVar, akVar);
            }

            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            protected void aM(T t) {
            }

            @Override // com.facebook.common.b.h
            protected T getResult() throws Exception {
                return null;
            }
        };
        akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.as.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
            public void dxA() {
                aqVar.cancel();
                as.this.mvA.H(aqVar);
            }
        });
        this.mvA.G(aqVar);
    }
}
