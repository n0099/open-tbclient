package rx.internal.operators;

import com.baidu.tieba.m6c;
import com.baidu.tieba.o6c;
import com.baidu.tieba.xac;
import com.baidu.tieba.y6c;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class SingleFromEmitter$SingleEmitterImpl<T> extends AtomicBoolean implements Object<T> {
    public static final long serialVersionUID = 8082834163465882809L;
    public final m6c<? super T> actual;
    public final SequentialSubscription resource = new SequentialSubscription();

    public SingleFromEmitter$SingleEmitterImpl(m6c<? super T> m6cVar) {
        this.actual = m6cVar;
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
        xac.j(th);
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

    public void setCancellation(y6c y6cVar) {
        setSubscription(new CancellableSubscription(y6cVar));
    }

    public void setSubscription(o6c o6cVar) {
        this.resource.update(o6cVar);
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
