package com.facebook.imagepipeline.producers;
/* loaded from: classes5.dex */
public class as<T> implements aj<T> {
    private final at pIq;
    private final aj<T> pLo;

    public as(aj<T> ajVar, at atVar) {
        this.pLo = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.pIq = atVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(final k<T> kVar, final ak akVar) {
        final am ezi = akVar.ezi();
        final String id = akVar.getId();
        final aq<T> aqVar = new aq<T>(kVar, ezi, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.as.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void onSuccess(T t) {
                ezi.b(id, "BackgroundThreadHandoffProducer", null);
                as.this.pLo.a(kVar, akVar);
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
            public void ezo() {
                aqVar.cancel();
                as.this.pIq.A(aqVar);
            }
        });
        this.pIq.z(aqVar);
    }
}
