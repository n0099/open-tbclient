package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public class aq<T> implements ai<T> {
    private final ar jGD;
    private final ai<T> jJl;

    public aq(ai<T> aiVar, ar arVar) {
        this.jJl = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.jGD = arVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(final j<T> jVar, final aj ajVar) {
        final al czB = ajVar.czB();
        final String id = ajVar.getId();
        final ao<T> aoVar = new ao<T>(jVar, czB, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.aq.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            public void onSuccess(T t) {
                czB.a(id, "BackgroundThreadHandoffProducer", null);
                aq.this.jJl.a(jVar, ajVar);
            }

            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            protected void az(T t) {
            }

            @Override // com.facebook.common.b.e
            protected T getResult() throws Exception {
                return null;
            }
        };
        ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.aq.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
            public void czH() {
                aoVar.cancel();
                aq.this.jGD.remove(aoVar);
            }
        });
        this.jGD.s(aoVar);
    }
}
