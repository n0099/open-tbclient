package com.facebook.imagepipeline.producers;
/* loaded from: classes8.dex */
public class as<T> implements aj<T> {
    private final at nuL;
    private final aj<T> nxL;

    public as(aj<T> ajVar, at atVar) {
        this.nxL = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.nuL = atVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(final k<T> kVar, final ak akVar) {
        final am dVp = akVar.dVp();
        final String id = akVar.getId();
        final aq<T> aqVar = new aq<T>(kVar, dVp, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.as.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void onSuccess(T t) {
                dVp.a(id, "BackgroundThreadHandoffProducer", null);
                as.this.nxL.c(kVar, akVar);
            }

            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            protected void aP(T t) {
            }

            @Override // com.facebook.common.b.h
            protected T getResult() throws Exception {
                return null;
            }
        };
        akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.as.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
            public void dRG() {
                aqVar.cancel();
                as.this.nuL.D(aqVar);
            }
        });
        this.nuL.C(aqVar);
    }
}
