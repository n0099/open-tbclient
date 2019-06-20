package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public class aq<T> implements ai<T> {
    private final ar jZu;
    private final ai<T> kcc;

    public aq(ai<T> aiVar, ar arVar) {
        this.kcc = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.jZu = arVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(final j<T> jVar, final aj ajVar) {
        final al cHy = ajVar.cHy();
        final String id = ajVar.getId();
        final ao<T> aoVar = new ao<T>(jVar, cHy, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.aq.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            public void onSuccess(T t) {
                cHy.a(id, "BackgroundThreadHandoffProducer", null);
                aq.this.kcc.a(jVar, ajVar);
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
            public void cHE() {
                aoVar.cancel();
                aq.this.jZu.remove(aoVar);
            }
        });
        this.jZu.u(aoVar);
    }
}
