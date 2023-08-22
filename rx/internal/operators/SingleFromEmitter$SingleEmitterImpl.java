package rx.internal.operators;

import com.baidu.tieba.bcc;
import com.baidu.tieba.e8c;
import com.baidu.tieba.s7c;
import com.baidu.tieba.u7c;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class SingleFromEmitter$SingleEmitterImpl<T> extends AtomicBoolean implements Object<T> {
    public static final long serialVersionUID = 8082834163465882809L;
    public final s7c<? super T> actual;
    public final SequentialSubscription resource = new SequentialSubscription();

    public SingleFromEmitter$SingleEmitterImpl(s7c<? super T> s7cVar) {
        this.actual = s7cVar;
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
        bcc.j(th);
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

    public void setCancellation(e8c e8cVar) {
        setSubscription(new CancellableSubscription(e8cVar));
    }

    public void setSubscription(u7c u7cVar) {
        this.resource.update(u7cVar);
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
