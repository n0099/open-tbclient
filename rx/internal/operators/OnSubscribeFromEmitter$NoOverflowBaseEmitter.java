package rx.internal.operators;

import com.baidu.tieba.g7c;
import com.baidu.tieba.n6c;
/* loaded from: classes2.dex */
public abstract class OnSubscribeFromEmitter$NoOverflowBaseEmitter<T> extends OnSubscribeFromEmitter$BaseEmitter<T> {
    public static final long serialVersionUID = 4127754106204442833L;

    public abstract void onOverflow();

    public OnSubscribeFromEmitter$NoOverflowBaseEmitter(n6c<? super T> n6cVar) {
        super(n6cVar);
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$BaseEmitter
    public void onNext(T t) {
        if (this.actual.isUnsubscribed()) {
            return;
        }
        if (get() != 0) {
            this.actual.onNext(t);
            g7c.g(this, 1L);
            return;
        }
        onOverflow();
    }
}
