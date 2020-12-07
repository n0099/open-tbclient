package io.reactivex.internal.operators.maybe;

import io.reactivex.b.h;
import io.reactivex.o;
/* loaded from: classes9.dex */
public enum MaybeToPublisher implements h<o<Object>, org.a.b<Object>> {
    INSTANCE;

    public static <T> h<o<T>, org.a.b<T>> instance() {
        return INSTANCE;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.reactivex.b.h
    public org.a.b<Object> apply(o<Object> oVar) throws Exception {
        return new MaybeToFlowable(oVar);
    }
}
