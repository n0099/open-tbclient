package rx.internal.operators;

import com.baidu.tieba.i2b;
import com.baidu.tieba.t1b;
/* loaded from: classes9.dex */
public abstract class OnSubscribeFromEmitter$NoOverflowBaseEmitter<T> extends OnSubscribeFromEmitter$BaseEmitter<T> {
    public static final long serialVersionUID = 4127754106204442833L;

    public abstract void onOverflow();

    public OnSubscribeFromEmitter$NoOverflowBaseEmitter(t1b<? super T> t1bVar) {
        super(t1bVar);
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$BaseEmitter
    public void onNext(T t) {
        if (this.actual.isUnsubscribed()) {
            return;
        }
        if (get() != 0) {
            this.actual.onNext(t);
            i2b.g(this, 1L);
            return;
        }
        onOverflow();
    }
}
