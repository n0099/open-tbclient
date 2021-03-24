package io.reactivex.internal.operators.flowable;

import f.a.x.i.b;
import g.d.c;
/* loaded from: classes7.dex */
public abstract class FlowableCreate$NoOverflowBaseAsyncEmitter<T> extends FlowableCreate$BaseEmitter<T> {
    public static final long serialVersionUID = 4127754106204442833L;

    public FlowableCreate$NoOverflowBaseAsyncEmitter(c<? super T> cVar) {
        super(cVar);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter, f.a.d
    public final void onNext(T t) {
        if (isCancelled()) {
            return;
        }
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        } else if (get() != 0) {
            this.actual.onNext(t);
            b.e(this, 1L);
        } else {
            onOverflow();
        }
    }

    public abstract void onOverflow();
}
