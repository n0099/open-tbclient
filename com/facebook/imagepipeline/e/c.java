package com.facebook.imagepipeline.e;

import com.facebook.imagepipeline.producers.ai;
import com.facebook.imagepipeline.producers.an;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class c<T> extends a<com.facebook.common.references.a<T>> {
    public static <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(ai<com.facebook.common.references.a<T>> aiVar, an anVar, com.facebook.imagepipeline.g.b bVar) {
        return new c(aiVar, anVar, bVar);
    }

    private c(ai<com.facebook.common.references.a<T>> aiVar, an anVar, com.facebook.imagepipeline.g.b bVar) {
        super(aiVar, anVar, bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    @Nullable
    /* renamed from: cHA */
    public com.facebook.common.references.a<T> getResult() {
        return com.facebook.common.references.a.b((com.facebook.common.references.a) super.getResult());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.datasource.AbstractDataSource
    /* renamed from: h */
    public void aB(com.facebook.common.references.a<T> aVar) {
        com.facebook.common.references.a.c((com.facebook.common.references.a<?>) aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.e.a
    /* renamed from: a */
    public void e(com.facebook.common.references.a<T> aVar, boolean z) {
        super.e(com.facebook.common.references.a.b(aVar), z);
    }
}
