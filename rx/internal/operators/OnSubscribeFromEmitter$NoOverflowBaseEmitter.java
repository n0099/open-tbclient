package rx.internal.operators;

import com.baidu.tieba.k8c;
import com.baidu.tieba.t7c;
/* loaded from: classes2.dex */
public abstract class OnSubscribeFromEmitter$NoOverflowBaseEmitter<T> extends OnSubscribeFromEmitter$BaseEmitter<T> {
    public static final long serialVersionUID = 4127754106204442833L;

    public abstract void onOverflow();

    public OnSubscribeFromEmitter$NoOverflowBaseEmitter(t7c<? super T> t7cVar) {
        super(t7cVar);
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$BaseEmitter
    public void onNext(T t) {
        if (this.actual.isUnsubscribed()) {
            return;
        }
        if (get() != 0) {
            this.actual.onNext(t);
            k8c.g(this, 1L);
            return;
        }
        onOverflow();
    }
}
