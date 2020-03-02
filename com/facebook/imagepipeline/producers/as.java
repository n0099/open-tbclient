package com.facebook.imagepipeline.producers;
/* loaded from: classes12.dex */
public class as<T> implements aj<T> {
    private final at lSb;
    private final aj<T> lVb;

    public as(aj<T> ajVar, at atVar) {
        this.lVb = (aj) com.facebook.common.internal.g.checkNotNull(ajVar);
        this.lSb = atVar;
    }

    @Override // com.facebook.imagepipeline.producers.aj
    public void c(final k<T> kVar, final ak akVar) {
        final am dry = akVar.dry();
        final String id = akVar.getId();
        final aq<T> aqVar = new aq<T>(kVar, dry, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.as.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.aq, com.facebook.common.b.h
            public void onSuccess(T t) {
                dry.a(id, "BackgroundThreadHandoffProducer", null);
                as.this.lVb.c(kVar, akVar);
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
            public void dnP() {
                aqVar.cancel();
                as.this.lSb.A(aqVar);
            }
        });
        this.lSb.z(aqVar);
    }
}
