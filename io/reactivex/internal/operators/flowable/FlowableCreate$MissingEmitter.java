package io.reactivex.internal.operators.flowable;

import g.d.c;
/* loaded from: classes7.dex */
public final class FlowableCreate$MissingEmitter<T> extends FlowableCreate$BaseEmitter<T> {
    public static final long serialVersionUID = 3776720187248809713L;

    public FlowableCreate$MissingEmitter(c<? super T> cVar) {
        super(cVar);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter, f.a.d
    public void onNext(T t) {
        long j;
        if (isCancelled()) {
            return;
        }
        if (t != null) {
            this.actual.onNext(t);
            do {
                j = get();
                if (j == 0) {
                    return;
                }
            } while (!compareAndSet(j, j - 1));
            return;
        }
        onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
    }
}
