package com.facebook.imagepipeline.producers;
/* loaded from: classes18.dex */
public class as<T> implements aj<T> {
    private final at oLL;
    private final aj<T> oOJ;

    public as(aj<T> ajVar, at atVar) {
        this.oOJ = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.oLL = atVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(final k<T> kVar, final ak akVar) {
        final am eng = akVar.eng();
        final String id = akVar.getId();
        final aq<T> aqVar = new aq<T>(kVar, eng, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.as.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void onSuccess(T t) {
                eng.a(id, "BackgroundThreadHandoffProducer", null);
                as.this.oOJ.c(kVar, akVar);
            }

            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            protected void aY(T t) {
            }

            @Override // com.facebook.common.b.h
            protected T getResult() throws Exception {
                return null;
            }
        };
        akVar.a(new e() { // from class: com.facebook.imagepipeline.producers.as.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.al
            public void ejw() {
                aqVar.cancel();
                as.this.oLL.F(aqVar);
            }
        });
        this.oLL.E(aqVar);
    }
}
