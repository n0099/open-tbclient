package com.facebook.imagepipeline.producers;
/* loaded from: classes15.dex */
public class as<T> implements aj<T> {
    private final at oWH;
    private final aj<T> oZF;

    public as(aj<T> ajVar, at atVar) {
        this.oZF = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.oWH = atVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(final k<T> kVar, final ak akVar) {
        final am eqU = akVar.eqU();
        final String id = akVar.getId();
        final aq<T> aqVar = new aq<T>(kVar, eqU, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.as.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void onSuccess(T t) {
                eqU.a(id, "BackgroundThreadHandoffProducer", null);
                as.this.oZF.c(kVar, akVar);
            }

            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            protected void aZ(T t) {
            }

            @Override // com.facebook.common.b.h
            protected T getResult() throws Exception {
                return null;
            }
        };
        akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.as.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
            public void enk() {
                aqVar.cancel();
                as.this.oWH.F(aqVar);
            }
        });
        this.oWH.E(aqVar);
    }
}
