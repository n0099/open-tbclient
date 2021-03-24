package io.reactivex.internal.operators.maybe;

import f.a.j;
import f.a.w.h;
import g.d.b;
/* loaded from: classes7.dex */
public enum MaybeToPublisher implements h<j<Object>, b<Object>> {
    INSTANCE;

    public static <T> h<j<T>, b<T>> instance() {
        return INSTANCE;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // f.a.w.h
    public b<Object> apply(j<Object> jVar) throws Exception {
        return new MaybeToFlowable(jVar);
    }
}
