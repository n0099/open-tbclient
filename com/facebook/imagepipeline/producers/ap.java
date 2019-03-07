package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public class ap<T> implements ai<Void> {
    private final ai<T> jJF;

    public ap(ai<T> aiVar) {
        this.jJF = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<Void> jVar, aj ajVar) {
        this.jJF.a(new m<T, Void>(jVar) { // from class: com.facebook.imagepipeline.producers.ap.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void d(T t, boolean z) {
                if (z) {
                    czH().e(null, z);
                }
            }
        }, ajVar);
    }
}
