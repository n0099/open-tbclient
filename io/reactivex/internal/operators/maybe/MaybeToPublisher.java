package io.reactivex.internal.operators.maybe;

import io.reactivex.c.h;
import io.reactivex.o;
/* loaded from: classes7.dex */
public enum MaybeToPublisher implements h<o<Object>, org.b.b<Object>> {
    INSTANCE;

    public static <T> h<o<T>, org.b.b<T>> instance() {
        return INSTANCE;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.reactivex.c.h
    public org.b.b<Object> apply(o<Object> oVar) throws Exception {
        return new MaybeToFlowable(oVar);
    }
}
