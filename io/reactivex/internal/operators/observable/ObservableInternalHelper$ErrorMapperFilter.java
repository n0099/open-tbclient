package io.reactivex.internal.operators.observable;

import f.b.k;
import f.b.w.h;
import f.b.w.i;
/* loaded from: classes7.dex */
public enum ObservableInternalHelper$ErrorMapperFilter implements h<k<Object>, Throwable>, i<k<Object>> {
    INSTANCE;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // f.b.w.h
    public Throwable apply(k<Object> kVar) throws Exception {
        return kVar.d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // f.b.w.i
    public boolean test(k<Object> kVar) throws Exception {
        return kVar.e();
    }
}
