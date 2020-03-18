package com.facebook.imagepipeline.producers;
/* loaded from: classes12.dex */
public class as<T> implements aj<T> {
    private final at lTS;
    private final aj<T> lWS;

    public as(aj<T> ajVar, at atVar) {
        this.lWS = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lTS = atVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(final k<T> kVar, final ak akVar) {
        final am drW = akVar.drW();
        final String id = akVar.getId();
        final aq<T> aqVar = new aq<T>(kVar, drW, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.as.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void onSuccess(T t) {
                drW.a(id, "BackgroundThreadHandoffProducer", null);
                as.this.lWS.c(kVar, akVar);
            }

            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            protected void aR(T t) {
            }

            @Override // com.facebook.common.b.h
            protected T getResult() throws Exception {
                return null;
            }
        };
        akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.as.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
            public void don() {
                aqVar.cancel();
                as.this.lTS.A(aqVar);
            }
        });
        this.lTS.z(aqVar);
    }
}
