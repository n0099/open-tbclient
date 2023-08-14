package rx.internal.operators;

import com.baidu.tieba.e1c;
import com.baidu.tieba.l5c;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes2.dex */
public final class OnSubscribeFromEmitter$ErrorEmitter<T> extends OnSubscribeFromEmitter$NoOverflowBaseEmitter<T> {
    public static final long serialVersionUID = 338953216916120960L;
    public boolean done;

    public OnSubscribeFromEmitter$ErrorEmitter(e1c<? super T> e1cVar) {
        super(e1cVar);
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$BaseEmitter
    public void onError(Throwable th) {
        if (this.done) {
            l5c.j(th);
            return;
        }
        this.done = true;
        super.onError(th);
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$NoOverflowBaseEmitter, rx.internal.operators.OnSubscribeFromEmitter$BaseEmitter
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        super.onNext(t);
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$BaseEmitter
    public void onCompleted() {
        if (this.done) {
            return;
        }
        this.done = true;
        super.onCompleted();
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$NoOverflowBaseEmitter
    public void onOverflow() {
        onError(new MissingBackpressureException("fromEmitter: could not emit value due to lack of requests"));
    }
}
