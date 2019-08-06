package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public class aq<T> implements ai<T> {
    private final ar khG;
    private final ai<T> kkp;

    public aq(ai<T> aiVar, ar arVar) {
        this.kkp = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.khG = arVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(final j<T> jVar, final aj ajVar) {
        final al cKX = ajVar.cKX();
        final String id = ajVar.getId();
        final ao<T> aoVar = new ao<T>(jVar, cKX, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.aq.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            public void onSuccess(T t) {
                cKX.a(id, "BackgroundThreadHandoffProducer", null);
                aq.this.kkp.a(jVar, ajVar);
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
            public void cLd() {
                aoVar.cancel();
                aq.this.khG.remove(aoVar);
            }
        });
        this.khG.v(aoVar);
    }
}
