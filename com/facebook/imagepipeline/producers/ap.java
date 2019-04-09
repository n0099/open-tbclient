package com.facebook.imagepipeline.producers;
/* loaded from: classes2.dex */
public class ap<T> implements ai<Void> {
    private final ai<T> jJl;

    public ap(ai<T> aiVar) {
        this.jJl = aiVar;
    }

    @Override // com.facebook.imagepipeline.producers.ai
    public void a(j<Void> jVar, aj ajVar) {
        this.jJl.a(new m<T, Void>(jVar) { // from class: com.facebook.imagepipeline.producers.ap.1
            @Override // com.facebook.imagepipeline.producers.b
            protected void d(T t, boolean z) {
                if (z) {
                    czN().e(null, z);
                }
            }
        }, ajVar);
    }
}
