package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public class ap<T> implements ai<T> {
    private final aq iqj;
    private final ai<T> isP;

    public ap(ai<T> aiVar, aq aqVar) {
        this.isP = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.iqj = aqVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(final j<T> jVar, final aj ajVar) {
        final al bZI = ajVar.bZI();
        final String id = ajVar.getId();
        final ao<T> aoVar = new ao<T>(jVar, bZI, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.ap.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            public void onSuccess(T t) {
                bZI.a(id, "BackgroundThreadHandoffProducer", null);
                ap.this.isP.a(jVar, ajVar);
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
            public void bZO() {
                aoVar.cancel();
                ap.this.iqj.remove(aoVar);
            }
        });
        this.iqj.n(aoVar);
    }
}
