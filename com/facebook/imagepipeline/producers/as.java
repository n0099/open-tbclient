package com.facebook.imagepipeline.producers;
/* loaded from: classes4.dex */
public class as<T> implements aj<T> {
    private final at naT;
    private final aj<T> ndT;

    public as(aj<T> ajVar, at atVar) {
        this.ndT = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.naT = atVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(final k<T> kVar, final ak akVar) {
        final am dJp = akVar.dJp();
        final String id = akVar.getId();
        final aq<T> aqVar = new aq<T>(kVar, dJp, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.as.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void onSuccess(T t) {
                dJp.a(id, "BackgroundThreadHandoffProducer", null);
                as.this.ndT.c(kVar, akVar);
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
            public void dFG() {
                aqVar.cancel();
                as.this.naT.G(aqVar);
            }
        });
        this.naT.F(aqVar);
    }
}
