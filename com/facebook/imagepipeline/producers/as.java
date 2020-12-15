package com.facebook.imagepipeline.producers;
/* loaded from: classes15.dex */
public class as<T> implements aj<T> {
    private final at ply;
    private final aj<T> poz;

    public as(aj<T> ajVar, at atVar) {
        this.poz = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.ply = atVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(final k<T> kVar, final ak akVar) {
        final am ewx = akVar.ewx();
        final String id = akVar.getId();
        final aq<T> aqVar = new aq<T>(kVar, ewx, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.as.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void onSuccess(T t) {
                ewx.a(id, "BackgroundThreadHandoffProducer", null);
                as.this.poz.a(kVar, akVar);
            }

            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            protected void aZ(T t) {
            }

            @Override // com.facebook.common.b.h
            protected T getResult() throws Exception {
                return null;
            }
        };
        akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.as.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
            public void ewD() {
                aqVar.cancel();
                as.this.ply.F(aqVar);
            }
        });
        this.ply.E(aqVar);
    }
}
