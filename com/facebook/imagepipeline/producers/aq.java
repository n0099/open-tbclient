package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public class aq<T> implements ai<T> {
    private final ar kiq;
    private final ai<T> kkY;

    public aq(ai<T> aiVar, ar arVar) {
        this.kkY = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.kiq = arVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(final j<T> jVar, final aj ajVar) {
        final al cII = ajVar.cII();
        final String id = ajVar.getId();
        final ao<T> aoVar = new ao<T>(jVar, cII, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.aq.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            public void onSuccess(T t) {
                cII.a(id, "BackgroundThreadHandoffProducer", null);
                aq.this.kkY.a(jVar, ajVar);
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
            public void cIO() {
                aoVar.cancel();
                aq.this.kiq.t(aoVar);
            }
        });
        this.kiq.s(aoVar);
    }
}
