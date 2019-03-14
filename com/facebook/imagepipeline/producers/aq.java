package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public class aq<T> implements ai<T> {
    private final ar jHi;
    private final ai<T> jJQ;

    public aq(ai<T> aiVar, ar arVar) {
        this.jJQ = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.jHi = arVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(final j<T> jVar, final aj ajVar) {
        final al czI = ajVar.czI();
        final String id = ajVar.getId();
        final ao<T> aoVar = new ao<T>(jVar, czI, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.aq.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            public void onSuccess(T t) {
                czI.a(id, "BackgroundThreadHandoffProducer", null);
                aq.this.jJQ.a(jVar, ajVar);
            }

            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            protected void aD(T t) {
            }

            @Override // com.facebook.common.b.e
            protected T getResult() throws Exception {
                return null;
            }
        };
        ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.aq.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
            public void czO() {
                aoVar.cancel();
                aq.this.jHi.remove(aoVar);
            }
        });
        this.jHi.s(aoVar);
    }
}
