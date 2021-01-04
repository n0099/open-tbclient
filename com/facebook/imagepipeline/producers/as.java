package com.facebook.imagepipeline.producers;
/* loaded from: classes5.dex */
public class as<T> implements aj<T> {
    private final at pBb;
    private final aj<T> pDZ;

    public as(aj<T> ajVar, at atVar) {
        this.pDZ = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.pBb = atVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(final k<T> kVar, final ak akVar) {
        final am eAe = akVar.eAe();
        final String id = akVar.getId();
        final aq<T> aqVar = new aq<T>(kVar, eAe, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.as.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.e
            public void onSuccess(T t) {
                eAe.b(id, "BackgroundThreadHandoffProducer", null);
                as.this.pDZ.a(kVar, akVar);
            }

            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.e
            protected void ba(T t) {
            }

            @Override // com.facebook.common.b.e
            protected T getResult() throws Exception {
                return null;
            }
        };
        akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.as.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
            public void eAk() {
                aqVar.cancel();
                as.this.pBb.C(aqVar);
            }
        });
        this.pBb.B(aqVar);
    }
}
