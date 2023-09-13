package rx.internal.operators;

import com.baidu.tieba.pbc;
import com.baidu.tieba.yac;
/* loaded from: classes2.dex */
public abstract class OnSubscribeFromEmitter$NoOverflowBaseEmitter<T> extends OnSubscribeFromEmitter$BaseEmitter<T> {
    public static final long serialVersionUID = 4127754106204442833L;

    public abstract void onOverflow();

    public OnSubscribeFromEmitter$NoOverflowBaseEmitter(yac<? super T> yacVar) {
        super(yacVar);
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$BaseEmitter
    public void onNext(T t) {
        if (this.actual.isUnsubscribed()) {
            return;
        }
        if (get() != 0) {
            this.actual.onNext(t);
            pbc.g(this, 1L);
            return;
        }
        onOverflow();
    }
}
