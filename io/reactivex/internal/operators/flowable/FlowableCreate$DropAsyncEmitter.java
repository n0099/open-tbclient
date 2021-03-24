package io.reactivex.internal.operators.flowable;

import g.d.c;
/* loaded from: classes7.dex */
public final class FlowableCreate$DropAsyncEmitter<T> extends FlowableCreate$NoOverflowBaseAsyncEmitter<T> {
    public static final long serialVersionUID = 8360058422307496563L;

    public FlowableCreate$DropAsyncEmitter(c<? super T> cVar) {
        super(cVar);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$NoOverflowBaseAsyncEmitter
    public void onOverflow() {
    }
}
