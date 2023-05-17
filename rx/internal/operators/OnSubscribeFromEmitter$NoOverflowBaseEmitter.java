package rx.internal.operators;

import com.baidu.tieba.c8b;
import com.baidu.tieba.n7b;
/* loaded from: classes10.dex */
public abstract class OnSubscribeFromEmitter$NoOverflowBaseEmitter<T> extends OnSubscribeFromEmitter$BaseEmitter<T> {
    public static final long serialVersionUID = 4127754106204442833L;

    public abstract void onOverflow();

    public OnSubscribeFromEmitter$NoOverflowBaseEmitter(n7b<? super T> n7bVar) {
        super(n7bVar);
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$BaseEmitter
    public void onNext(T t) {
        if (this.actual.isUnsubscribed()) {
            return;
        }
        if (get() != 0) {
            this.actual.onNext(t);
            c8b.g(this, 1L);
            return;
        }
        onOverflow();
    }
}
