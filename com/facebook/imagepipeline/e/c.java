package com.facebook.imagepipeline.e;

import com.facebook.imagepipeline.producers.aj;
import com.facebook.imagepipeline.producers.ap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public class c<T> extends a<com.facebook.common.references.a<T>> {
    public static <T> com.facebook.datasource.b<com.facebook.common.references.a<T>> a(aj<com.facebook.common.references.a<T>> ajVar, ap apVar, com.facebook.imagepipeline.h.c cVar) {
        return new c(ajVar, apVar, cVar);
    }

    private c(aj<com.facebook.common.references.a<T>> ajVar, ap apVar, com.facebook.imagepipeline.h.c cVar) {
        super(ajVar, apVar, cVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.b
    @Nullable
    /* renamed from: dzU */
    public com.facebook.common.references.a<T> getResult() {
        return com.facebook.common.references.a.b((com.facebook.common.references.a) super.getResult());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.datasource.AbstractDataSource
    /* renamed from: k */
    public void aS(com.facebook.common.references.a<T> aVar) {
        com.facebook.common.references.a.c(aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.imagepipeline.e.a
    /* renamed from: a */
    public void g(com.facebook.common.references.a<T> aVar, int i) {
        super.g(com.facebook.common.references.a.b(aVar), i);
    }
}
