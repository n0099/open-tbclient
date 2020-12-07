package com.facebook.imagepipeline.producers;
/* loaded from: classes15.dex */
public class as<T> implements aj<T> {
    private final at plw;
    private final aj<T> pox;

    public as(aj<T> ajVar, at atVar) {
        this.pox = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.plw = atVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(final k<T> kVar, final ak akVar) {
        final am eww = akVar.eww();
        final String id = akVar.getId();
        final aq<T> aqVar = new aq<T>(kVar, eww, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.as.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void onSuccess(T t) {
                eww.a(id, "BackgroundThreadHandoffProducer", null);
                as.this.pox.a(kVar, akVar);
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
            public void ewC() {
                aqVar.cancel();
                as.this.plw.F(aqVar);
            }
        });
        this.plw.E(aqVar);
    }
}
