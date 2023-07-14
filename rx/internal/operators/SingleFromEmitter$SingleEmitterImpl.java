package rx.internal.operators;

import com.baidu.tieba.b2c;
import com.baidu.tieba.h6c;
import com.baidu.tieba.k2c;
import com.baidu.tieba.z1c;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class SingleFromEmitter$SingleEmitterImpl<T> extends AtomicBoolean implements Object<T> {
    public static final long serialVersionUID = 8082834163465882809L;
    public final z1c<? super T> actual;
    public final SequentialSubscription resource = new SequentialSubscription();

    public SingleFromEmitter$SingleEmitterImpl(z1c<? super T> z1cVar) {
        this.actual = z1cVar;
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
        h6c.j(th);
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

    public void setCancellation(k2c k2cVar) {
        setSubscription(new CancellableSubscription(k2cVar));
    }

    public void setSubscription(b2c b2cVar) {
        this.resource.update(b2cVar);
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
