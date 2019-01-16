package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public class ap<T> implements ai<T> {
    private final aq irq;
    private final ai<T> itW;

    public ap(ai<T> aiVar, aq aqVar) {
        this.itW = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.irq = aqVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(final j<T> jVar, final aj ajVar) {
        final al caq = ajVar.caq();
        final String id = ajVar.getId();
        final ao<T> aoVar = new ao<T>(jVar, caq, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.ap.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            public void onSuccess(T t) {
                caq.a(id, "BackgroundThreadHandoffProducer", null);
                ap.this.itW.a(jVar, ajVar);
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
            public void caw() {
                aoVar.cancel();
                ap.this.irq.remove(aoVar);
            }
        });
        this.irq.n(aoVar);
    }
}
