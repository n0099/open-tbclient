package com.facebook.imagepipeline.producers;
/* loaded from: classes3.dex */
public class as<T> implements aj<T> {
    private final aj<T> pBf;
    private final at pyh;

    public as(aj<T> ajVar, at atVar) {
        this.pBf = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.pyh = atVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(final k<T> kVar, final ak akVar) {
        final am ewQ = akVar.ewQ();
        final String id = akVar.getId();
        final aq<T> aqVar = new aq<T>(kVar, ewQ, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.as.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void onSuccess(T t) {
                ewQ.b(id, "BackgroundThreadHandoffProducer", null);
                as.this.pBf.a(kVar, akVar);
            }

            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            protected void ba(T t) {
            }

            @Override // com.facebook.common.b.h
            protected T getResult() throws Exception {
                return null;
            }
        };
        akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.as.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
            public void ewW() {
                aqVar.cancel();
                as.this.pyh.C(aqVar);
            }
        });
        this.pyh.B(aqVar);
    }
}
