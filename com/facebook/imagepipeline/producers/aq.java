package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public class aq<T> implements ai<T> {
    private final ar khy;
    private final ai<T> kkh;

    public aq(ai<T> aiVar, ar arVar) {
        this.kkh = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.khy = arVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(final j<T> jVar, final aj ajVar) {
        final al cIG = ajVar.cIG();
        final String id = ajVar.getId();
        final ao<T> aoVar = new ao<T>(jVar, cIG, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.aq.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            public void onSuccess(T t) {
                cIG.a(id, "BackgroundThreadHandoffProducer", null);
                aq.this.kkh.a(jVar, ajVar);
            }

            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            protected void aw(T t) {
            }

            @Override // com.facebook.common.b.e
            protected T getResult() throws Exception {
                return null;
            }
        };
        ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.aq.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
            public void cIM() {
                aoVar.cancel();
                aq.this.khy.t(aoVar);
            }
        });
        this.khy.s(aoVar);
    }
}
