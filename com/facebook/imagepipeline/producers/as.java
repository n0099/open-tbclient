package com.facebook.imagepipeline.producers;
/* loaded from: classes18.dex */
public class as<T> implements aj<T> {
    private final at oVe;
    private final aj<T> oYc;

    public as(aj<T> ajVar, at atVar) {
        this.oYc = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.oVe = atVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(final k<T> kVar, final ak akVar) {
        final am eqW = akVar.eqW();
        final String id = akVar.getId();
        final aq<T> aqVar = new aq<T>(kVar, eqW, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.as.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void onSuccess(T t) {
                eqW.a(id, "BackgroundThreadHandoffProducer", null);
                as.this.oYc.c(kVar, akVar);
            }

            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            protected void aY(T t) {
            }

            @Override // com.facebook.common.b.h
            protected T getResult() throws Exception {
                return null;
            }
        };
        akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.as.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
            public void enm() {
                aqVar.cancel();
                as.this.oVe.F(aqVar);
            }
        });
        this.oVe.E(aqVar);
    }
}
