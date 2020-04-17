package com.facebook.imagepipeline.producers;
/* loaded from: classes12.dex */
public class as<T> implements aj<T> {
    private final at mbF;
    private final aj<T> meD;

    public as(aj<T> ajVar, at atVar) {
        this.meD = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.mbF = atVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(final k<T> kVar, final ak akVar) {
        final am dtU = akVar.dtU();
        final String id = akVar.getId();
        final aq<T> aqVar = new aq<T>(kVar, dtU, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.as.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void onSuccess(T t) {
                dtU.a(id, "BackgroundThreadHandoffProducer", null);
                as.this.meD.c(kVar, akVar);
            }

            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            protected void aH(T t) {
            }

            @Override // com.facebook.common.b.h
            protected T getResult() throws Exception {
                return null;
            }
        };
        akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.as.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
            public void dqk() {
                aqVar.cancel();
                as.this.mbF.F(aqVar);
            }
        });
        this.mbF.E(aqVar);
    }
}
