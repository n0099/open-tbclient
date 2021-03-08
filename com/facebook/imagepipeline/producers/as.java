package com.facebook.imagepipeline.producers;
/* loaded from: classes5.dex */
public class as<T> implements aj<T> {
    private final at pKV;
    private final aj<T> pNT;

    public as(aj<T> ajVar, at atVar) {
        this.pNT = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.pKV = atVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void a(final k<T> kVar, final ak akVar) {
        final am ezz = akVar.ezz();
        final String id = akVar.getId();
        final aq<T> aqVar = new aq<T>(kVar, ezz, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.as.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void onSuccess(T t) {
                ezz.b(id, "BackgroundThreadHandoffProducer", null);
                as.this.pNT.a(kVar, akVar);
            }

            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            protected void bc(T t) {
            }

            @Override // com.facebook.common.b.h
            protected T getResult() throws Exception {
                return null;
            }
        };
        akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.as.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
            public void ezF() {
                aqVar.cancel();
                as.this.pKV.z(aqVar);
            }
        });
        this.pKV.y(aqVar);
    }
}
