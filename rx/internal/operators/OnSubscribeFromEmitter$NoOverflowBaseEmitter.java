package rx.internal.operators;

import com.baidu.tieba.d8b;
import com.baidu.tieba.o7b;
/* loaded from: classes10.dex */
public abstract class OnSubscribeFromEmitter$NoOverflowBaseEmitter<T> extends OnSubscribeFromEmitter$BaseEmitter<T> {
    public static final long serialVersionUID = 4127754106204442833L;

    public abstract void onOverflow();

    public OnSubscribeFromEmitter$NoOverflowBaseEmitter(o7b<? super T> o7bVar) {
        super(o7bVar);
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$BaseEmitter
    public void onNext(T t) {
        if (this.actual.isUnsubscribed()) {
            return;
        }
        if (get() != 0) {
            this.actual.onNext(t);
            d8b.g(this, 1L);
            return;
        }
        onOverflow();
    }
}
