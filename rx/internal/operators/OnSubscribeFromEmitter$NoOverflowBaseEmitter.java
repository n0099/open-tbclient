package rx.internal.operators;

import h.j;
import h.o.a.a;
/* loaded from: classes7.dex */
public abstract class OnSubscribeFromEmitter$NoOverflowBaseEmitter<T> extends OnSubscribeFromEmitter$BaseEmitter<T> {
    public static final long serialVersionUID = 4127754106204442833L;

    public OnSubscribeFromEmitter$NoOverflowBaseEmitter(j<? super T> jVar) {
        super(jVar);
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$BaseEmitter
    public void onNext(T t) {
        if (this.actual.isUnsubscribed()) {
            return;
        }
        if (get() != 0) {
            this.actual.onNext(t);
            a.g(this, 1L);
            return;
        }
        onOverflow();
    }

    public abstract void onOverflow();
}
