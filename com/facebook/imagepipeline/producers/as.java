package com.facebook.imagepipeline.producers;
/* loaded from: classes8.dex */
public class as<T> implements aj<T> {
    private final at nvd;
    private final aj<T> nyd;

    public as(aj<T> ajVar, at atVar) {
        this.nyd = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.nvd = atVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(final k<T> kVar, final ak akVar) {
        final am dVy = akVar.dVy();
        final String id = akVar.getId();
        final aq<T> aqVar = new aq<T>(kVar, dVy, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.as.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void onSuccess(T t) {
                dVy.a(id, "BackgroundThreadHandoffProducer", null);
                as.this.nyd.c(kVar, akVar);
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
            public void dRP() {
                aqVar.cancel();
                as.this.nvd.D(aqVar);
            }
        });
        this.nvd.C(aqVar);
    }
}
