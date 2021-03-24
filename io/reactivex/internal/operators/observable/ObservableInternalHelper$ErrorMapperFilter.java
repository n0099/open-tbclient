package io.reactivex.internal.operators.observable;

import f.a.k;
import f.a.w.h;
import f.a.w.i;
/* loaded from: classes7.dex */
public enum ObservableInternalHelper$ErrorMapperFilter implements h<k<Object>, Throwable>, i<k<Object>> {
    INSTANCE;

    /* JADX DEBUG: Method merged with bridge method */
    @Override // f.a.w.h
    public Throwable apply(k<Object> kVar) throws Exception {
        return kVar.d();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // f.a.w.i
    public boolean test(k<Object> kVar) throws Exception {
        return kVar.e();
    }
}
