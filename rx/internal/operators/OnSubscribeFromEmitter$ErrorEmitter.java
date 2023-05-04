package rx.internal.operators;

import com.baidu.tieba.p5b;
import com.baidu.tieba.s9b;
import rx.exceptions.MissingBackpressureException;
/* loaded from: classes9.dex */
public final class OnSubscribeFromEmitter$ErrorEmitter<T> extends OnSubscribeFromEmitter$NoOverflowBaseEmitter<T> {
    public static final long serialVersionUID = 338953216916120960L;
    public boolean done;

    public OnSubscribeFromEmitter$ErrorEmitter(p5b<? super T> p5bVar) {
        super(p5bVar);
    }

    @Override // rx.internal.operators.OnSubscribeFromEmitter$BaseEmitter
    public void onError(Throwable th) {
        if (this.done) {
            s9b.j(th);
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
