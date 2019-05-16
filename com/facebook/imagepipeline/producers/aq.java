package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public class aq<T> implements ai<T> {
    private final ar jZq;
    private final ai<T> kbY;

    public aq(ai<T> aiVar, ar arVar) {
        this.kbY = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.jZq = arVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(final j<T> jVar, final aj ajVar) {
        final al cHx = ajVar.cHx();
        final String id = ajVar.getId();
        final ao<T> aoVar = new ao<T>(jVar, cHx, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.aq.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            public void onSuccess(T t) {
                cHx.a(id, "BackgroundThreadHandoffProducer", null);
                aq.this.kbY.a(jVar, ajVar);
            }

            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            protected void aB(T t) {
            }

            @Override // com.facebook.common.b.e
            protected T getResult() throws Exception {
                return null;
            }
        };
        ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.aq.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
            public void cHD() {
                aoVar.cancel();
                aq.this.jZq.remove(aoVar);
            }
        });
        this.jZq.u(aoVar);
    }
}
