package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public class aq<T> implements ai<T> {
    private final ar jHq;
    private final ai<T> jJY;

    public aq(ai<T> aiVar, ar arVar) {
        this.jJY = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.jHq = arVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(final j<T> jVar, final aj ajVar) {
        final al czF = ajVar.czF();
        final String id = ajVar.getId();
        final ao<T> aoVar = new ao<T>(jVar, czF, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.aq.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            public void onSuccess(T t) {
                czF.a(id, "BackgroundThreadHandoffProducer", null);
                aq.this.jJY.a(jVar, ajVar);
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
            public void czL() {
                aoVar.cancel();
                aq.this.jHq.remove(aoVar);
            }
        });
        this.jHq.s(aoVar);
    }
}
