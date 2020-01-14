package com.facebook.imagepipeline.producers;
/* loaded from: classes10.dex */
public class as<T> implements aj<T> {
    private final at lRs;
    private final aj<T> lUs;

    public as(aj<T> ajVar, at atVar) {
        this.lUs = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lRs = atVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(final k<T> kVar, final ak akVar) {
        final am dqk = akVar.dqk();
        final String id = akVar.getId();
        final aq<T> aqVar = new aq<T>(kVar, dqk, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.as.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void onSuccess(T t) {
                dqk.a(id, "BackgroundThreadHandoffProducer", null);
                as.this.lUs.c(kVar, akVar);
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
            public void dmA() {
                aqVar.cancel();
                as.this.lRs.A(aqVar);
            }
        });
        this.lRs.z(aqVar);
    }
}
