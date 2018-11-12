package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public class ap<T> implements ai<T> {
    private final aq ifN;
    private final ai<T> iit;

    public ap(ai<T> aiVar, aq aqVar) {
        this.iit = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.ifN = aqVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(final j<T> jVar, final aj ajVar) {
        final al bWM = ajVar.bWM();
        final String id = ajVar.getId();
        final ao<T> aoVar = new ao<T>(jVar, bWM, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.ap.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            public void onSuccess(T t) {
                bWM.a(id, "BackgroundThreadHandoffProducer", null);
                ap.this.iit.a(jVar, ajVar);
            }

            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            protected void am(T t) {
            }

            @Override // com.facebook.common.b.e
            protected T getResult() throws Exception {
                return null;
            }
        };
        ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ap.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
            public void bWS() {
                aoVar.cancel();
                ap.this.ifN.remove(aoVar);
            }
        });
        this.ifN.m(aoVar);
    }
}
