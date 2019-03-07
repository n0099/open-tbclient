package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public class aq<T> implements ai<T> {
    private final ar jGX;
    private final ai<T> jJF;

    public aq(ai<T> aiVar, ar arVar) {
        this.jJF = (ai) com.facebook.common.internal.g.checkNotNull(aiVar);
        this.jGX = arVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(final j<T> jVar, final aj ajVar) {
        final al czv = ajVar.czv();
        final String id = ajVar.getId();
        final ao<T> aoVar = new ao<T>(jVar, czv, "BackgroundThreadHandoffProducer", id) { // from class: com.facebook.imagepipeline.producers.aq.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            public void onSuccess(T t) {
                czv.a(id, "BackgroundThreadHandoffProducer", null);
                aq.this.jJF.a(jVar, ajVar);
            }

            @Override // com.facebook.imagepipeline.producers.ao, com.facebook.common.b.e
            protected void aC(T t) {
            }

            @Override // com.facebook.common.b.e
            protected T getResult() throws Exception {
                return null;
            }
        };
        ajVar.a(new e() { // from class: com.facebook.imagepipeline.producers.aq.2
            @Override // com.facebook.imagepipeline.producers.e, com.facebook.imagepipeline.producers.ak
            public void czB() {
                aoVar.cancel();
                aq.this.jGX.remove(aoVar);
            }
        });
        this.jGX.s(aoVar);
    }
}
