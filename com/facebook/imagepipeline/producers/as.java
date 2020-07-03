package com.facebook.imagepipeline.producers;
/* loaded from: classes12.dex */
public class as<T> implements aj<T> {
    private final at mSL;
    private final aj<T> mVP;

    public as(aj<T> ajVar, at atVar) {
        this.mVP = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.mSL = atVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(final k<T> kVar, final ak akVar) {
        final am dFZ = akVar.dFZ();
        final String id = akVar.getId();
        final aq<T> aqVar = new aq<T>(kVar, dFZ, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.as.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void onSuccess(T t) {
                dFZ.a(id, "BackgroundThreadHandoffProducer", null);
                as.this.mVP.c(kVar, akVar);
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
            public void dCq() {
                aqVar.cancel();
                as.this.mSL.H(aqVar);
            }
        });
        this.mSL.G(aqVar);
    }
}
