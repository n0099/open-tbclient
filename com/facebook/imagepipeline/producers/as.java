package com.facebook.imagepipeline.producers;
/* loaded from: classes18.dex */
public class as<T> implements aj<T> {
    private final at nUt;
    private final aj<T> nXr;

    public as(aj<T> ajVar, at atVar) {
        this.nXr = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.nUt = atVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(final k<T> kVar, final ak akVar) {
        final am edh = akVar.edh();
        final String id = akVar.getId();
        final aq<T> aqVar = new aq<T>(kVar, edh, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.as.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void onSuccess(T t) {
                edh.a(id, "BackgroundThreadHandoffProducer", null);
                as.this.nXr.c(kVar, akVar);
            }

            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            protected void aU(T t) {
            }

            @Override // com.facebook.common.b.h
            protected T getResult() throws Exception {
                return null;
            }
        };
        akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.as.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
            public void dZy() {
                aqVar.cancel();
                as.this.nUt.D(aqVar);
            }
        });
        this.nUt.C(aqVar);
    }
}
