package rx.internal.operators;

import com.baidu.tieba.dtb;
import com.baidu.tieba.ttb;
/* loaded from: classes2.dex */
public abstract class OnSubscribeFromEmitter$NoOverflowBaseEmitter<T> extends OnSubscribeFromEmitter$BaseEmitter<T> {
    public static final long serialVersionUID = 4127754106204442833L;

    public abstract void onOverflow();

    public OnSubscribeFromEmitter$NoOverflowBaseEmitter(dtb<? super T> dtbVar) {
        super(dtbVar);
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$BaseEmitter
    public void onNext(T t) {
        if (this.actual.isUnsubscribed()) {
            return;
        }
        if (get() != 0) {
            this.actual.onNext(t);
            ttb.g(this, 1L);
            return;
        }
        onOverflow();
    }
}
