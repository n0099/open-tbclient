package io.reactivex.internal.operators.flowable;

import g.d.c;
import io.reactivex.exceptions.MissingBackpressureException;
/* loaded from: classes7.dex */
public final class FlowableCreate$ErrorAsyncEmitter<T> extends FlowableCreate$NoOverflowBaseAsyncEmitter<T> {
    public static final long serialVersionUID = 338953216916120960L;

    public FlowableCreate$ErrorAsyncEmitter(c<? super T> cVar) {
        super(cVar);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$NoOverflowBaseAsyncEmitter
    public void onOverflow() {
        onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
    }
}
