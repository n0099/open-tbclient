package com.facebook.imagepipeline.producers;
/* loaded from: classes12.dex */
public class as<T> implements aj<T> {
    private final at mbJ;
    private final aj<T> meH;

    public as(aj<T> ajVar, at atVar) {
        this.meH = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.mbJ = atVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(final k<T> kVar, final ak akVar) {
        final am dtR = akVar.dtR();
        final String id = akVar.getId();
        final aq<T> aqVar = new aq<T>(kVar, dtR, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.as.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void onSuccess(T t) {
                dtR.a(id, "BackgroundThreadHandoffProducer", null);
                as.this.meH.c(kVar, akVar);
            }

            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            protected void aI(T t) {
            }

            @Override // com.facebook.common.b.h
            protected T getResult() throws Exception {
                return null;
            }
        };
        akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.as.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
            public void dqh() {
                aqVar.cancel();
                as.this.mbJ.F(aqVar);
            }
        });
        this.mbJ.E(aqVar);
    }
}
