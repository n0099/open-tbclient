package rx.internal.operators;

import com.baidu.tieba.yac;
/* loaded from: classes2.dex */
public final class OnSubscribeFromEmitter$NoneEmitter<T> extends OnSubscribeFromEmitter$BaseEmitter<T> {
    public static final long serialVersionUID = 3776720187248809713L;

    public OnSubscribeFromEmitter$NoneEmitter(yac<? super T> yacVar) {
        super(yacVar);
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$BaseEmitter
    public void onNext(T t) {
        long j;
        if (this.actual.isUnsubscribed()) {
            return;
        }
        this.actual.onNext(t);
        do {
            j = get();
            if (j == 0) {
                return;
            }
        } while (!compareAndSet(j, j - 1));
    }
}
