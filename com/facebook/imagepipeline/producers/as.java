package com.facebook.imagepipeline.producers;
/* loaded from: classes12.dex */
public class as<T> implements aj<T> {
    private final at mSO;
    private final aj<T> mVS;

    public as(aj<T> ajVar, at atVar) {
        this.mVS = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.mSO = atVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(final k<T> kVar, final ak akVar) {
        final am dGd = akVar.dGd();
        final String id = akVar.getId();
        final aq<T> aqVar = new aq<T>(kVar, dGd, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.as.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void onSuccess(T t) {
                dGd.a(id, "BackgroundThreadHandoffProducer", null);
                as.this.mVS.c(kVar, akVar);
            }

            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            protected void aN(T t) {
            }

            @Override // com.facebook.common.b.h
            protected T getResult() throws Exception {
                return null;
            }
        };
        akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.as.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
            public void dCu() {
                aqVar.cancel();
                as.this.mSO.H(aqVar);
            }
        });
        this.mSO.G(aqVar);
    }
}
