package com.facebook.imagepipeline.producers;
/* loaded from: classes10.dex */
public class as<T> implements aj<T> {
    private final at lRn;
    private final aj<T> lUn;

    public as(aj<T> ajVar, at atVar) {
        this.lUn = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lRn = atVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(final k<T> kVar, final ak akVar) {
        final am dqi = akVar.dqi();
        final String id = akVar.getId();
        final aq<T> aqVar = new aq<T>(kVar, dqi, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.as.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void onSuccess(T t) {
                dqi.a(id, "BackgroundThreadHandoffProducer", null);
                as.this.lUn.c(kVar, akVar);
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
            public void dmy() {
                aqVar.cancel();
                as.this.lRn.A(aqVar);
            }
        });
        this.lRn.z(aqVar);
    }
}
