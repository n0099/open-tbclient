package com.facebook.imagepipeline.producers;
/* loaded from: classes25.dex */
public class as<T> implements aj<T> {
    private final at nFa;
    private final aj<T> nIa;

    public as(aj<T> ajVar, at atVar) {
        this.nIa = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.nFa = atVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(final k<T> kVar, final ak akVar) {
        final am dZw = akVar.dZw();
        final String id = akVar.getId();
        final aq<T> aqVar = new aq<T>(kVar, dZw, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.as.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void onSuccess(T t) {
                dZw.a(id, "BackgroundThreadHandoffProducer", null);
                as.this.nIa.c(kVar, akVar);
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
            public void dVN() {
                aqVar.cancel();
                as.this.nFa.D(aqVar);
            }
        });
        this.nFa.C(aqVar);
    }
}
