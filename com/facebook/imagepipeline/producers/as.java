package com.facebook.imagepipeline.producers;
/* loaded from: classes12.dex */
public class as<T> implements aj<T> {
    private final at mwK;
    private final aj<T> mzI;

    public as(aj<T> ajVar, at atVar) {
        this.mzI = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.mwK = atVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(final k<T> kVar, final ak akVar) {
        final am dBx = akVar.dBx();
        final String id = akVar.getId();
        final aq<T> aqVar = new aq<T>(kVar, dBx, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.as.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void onSuccess(T t) {
                dBx.a(id, "BackgroundThreadHandoffProducer", null);
                as.this.mzI.c(kVar, akVar);
            }

            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            protected void aM(T t) {
            }

            @Override // com.facebook.common.b.h
            protected T getResult() throws Exception {
                return null;
            }
        };
        akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.as.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
            public void dxO() {
                aqVar.cancel();
                as.this.mwK.H(aqVar);
            }
        });
        this.mwK.G(aqVar);
    }
}
