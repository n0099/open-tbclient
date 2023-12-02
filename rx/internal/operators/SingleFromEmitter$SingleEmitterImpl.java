package rx.internal.operators;

import com.baidu.tieba.ioc;
import com.baidu.tieba.koc;
import com.baidu.tieba.tsc;
import com.baidu.tieba.uoc;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class SingleFromEmitter$SingleEmitterImpl<T> extends AtomicBoolean implements Object<T> {
    public static final long serialVersionUID = 8082834163465882809L;
    public final ioc<? super T> actual;
    public final SequentialSubscription resource = new SequentialSubscription();

    public SingleFromEmitter$SingleEmitterImpl(ioc<? super T> iocVar) {
        this.actual = iocVar;
    }

    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException();
        }
        if (compareAndSet(false, true)) {
            try {
                this.actual.b(th);
                return;
            } finally {
                this.resource.unsubscribe();
            }
        }
        tsc.j(th);
    }

    public void onSuccess(T t) {
        if (compareAndSet(false, true)) {
            try {
                this.actual.c(t);
            } finally {
                this.resource.unsubscribe();
            }
        }
    }

    public void setCancellation(uoc uocVar) {
        setSubscription(new CancellableSubscription(uocVar));
    }

    public void setSubscription(koc kocVar) {
        this.resource.update(kocVar);
    }

    public boolean isUnsubscribed() {
        return get();
    }

    public void unsubscribe() {
        if (compareAndSet(false, true)) {
            this.resource.unsubscribe();
        }
    }
}
