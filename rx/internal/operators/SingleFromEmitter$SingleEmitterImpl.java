package rx.internal.operators;

import com.baidu.tieba.esa;
import com.baidu.tieba.tra;
import com.baidu.tieba.vra;
import com.baidu.tieba.vva;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes9.dex */
public final class SingleFromEmitter$SingleEmitterImpl<T> extends AtomicBoolean implements Object<T> {
    public static final long serialVersionUID = 8082834163465882809L;
    public final tra<? super T> actual;
    public final SequentialSubscription resource = new SequentialSubscription();

    public SingleFromEmitter$SingleEmitterImpl(tra<? super T> traVar) {
        this.actual = traVar;
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
        vva.j(th);
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

    public void setCancellation(esa esaVar) {
        setSubscription(new CancellableSubscription(esaVar));
    }

    public void setSubscription(vra vraVar) {
        this.resource.update(vraVar);
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
