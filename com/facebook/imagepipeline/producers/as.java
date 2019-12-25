package com.facebook.imagepipeline.producers;
/* loaded from: classes9.dex */
public class as<T> implements aj<T> {
    private final at lNB;
    private final aj<T> lQz;

    public as(aj<T> ajVar, at atVar) {
        this.lQz = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lNB = atVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(final k<T> kVar, final ak akVar) {
        final am doY = akVar.doY();
        final String id = akVar.getId();
        final aq<T> aqVar = new aq<T>(kVar, doY, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.as.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void onSuccess(T t) {
                doY.a(id, "BackgroundThreadHandoffProducer", null);
                as.this.lQz.c(kVar, akVar);
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
            public void dlt() {
                aqVar.cancel();
                as.this.lNB.A(aqVar);
            }
        });
        this.lNB.z(aqVar);
    }
}
