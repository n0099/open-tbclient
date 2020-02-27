package com.facebook.imagepipeline.producers;
/* loaded from: classes12.dex */
public class as<T> implements aj<T> {
    private final at lRZ;
    private final aj<T> lUZ;

    public as(aj<T> ajVar, at atVar) {
        this.lUZ = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lRZ = atVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(final k<T> kVar, final ak akVar) {
        final am drw = akVar.drw();
        final String id = akVar.getId();
        final aq<T> aqVar = new aq<T>(kVar, drw, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.as.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void onSuccess(T t) {
                drw.a(id, "BackgroundThreadHandoffProducer", null);
                as.this.lUZ.c(kVar, akVar);
            }

            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            protected void aR(T t) {
            }

            @Override // com.facebook.common.b.h
            protected T getResult() throws Exception {
                return null;
            }
        };
        akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.as.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
            public void dnN() {
                aqVar.cancel();
                as.this.lRZ.A(aqVar);
            }
        });
        this.lRZ.z(aqVar);
    }
}
