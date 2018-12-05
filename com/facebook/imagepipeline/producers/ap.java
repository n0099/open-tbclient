package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public class ap<T> implements ai<T> {
    private final aq imY;
    private final ai<T> ipF;

    public ap(ai<T> aiVar, aq aqVar) {
        this.ipF = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.imY = aqVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(final j<T> jVar, final aj ajVar) {
        final al bYS = ajVar.bYS();
        final String id = ajVar.getId();
        final ao<T> aoVar = new ao<T>(jVar, bYS, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.ap.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            public void onSuccess(T t) {
                bYS.a(id, "BackgroundThreadHandoffProducer", null);
                ap.this.ipF.a(jVar, ajVar);
            }

            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            protected void an(T t) {
            }

            @Override // com.facebook.common.b.e
            protected T getResult() throws Exception {
                return null;
            }
        };
        ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.ap.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
            public void bYY() {
                aoVar.cancel();
                ap.this.imY.remove(aoVar);
            }
        });
        this.imY.n(aoVar);
    }
}
