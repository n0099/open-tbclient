package rx.internal.operators;

import com.baidu.tieba.e6b;
import com.baidu.tieba.p5b;
/* loaded from: classes9.dex */
public abstract class OnSubscribeFromEmitter$NoOverflowBaseEmitter<T> extends OnSubscribeFromEmitter$BaseEmitter<T> {
    public static final long serialVersionUID = 4127754106204442833L;

    public abstract void onOverflow();

    public OnSubscribeFromEmitter$NoOverflowBaseEmitter(p5b<? super T> p5bVar) {
        super(p5bVar);
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$BaseEmitter
    public void onNext(T t) {
        if (this.actual.isUnsubscribed()) {
            return;
        }
        if (get() != 0) {
            this.actual.onNext(t);
            e6b.g(this, 1L);
            return;
        }
        onOverflow();
    }
}
