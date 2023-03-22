package rx.internal.operators;

import com.baidu.tieba.esa;
import com.baidu.tieba.nra;
import com.baidu.tieba.vra;
import com.baidu.tieba.vva;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes9.dex */
public final class CompletableFromEmitter$FromEmitter extends AtomicBoolean implements vra {
    public static final long serialVersionUID = 5539301318568668881L;
    public final nra actual;
    public final SequentialSubscription resource = new SequentialSubscription();

    public CompletableFromEmitter$FromEmitter(nra nraVar) {
        this.actual = nraVar;
    }

    public void onError(Throwable th) {
        if (compareAndSet(false, true)) {
            try {
                this.actual.onError(th);
                return;
            } finally {
                this.resource.unsubscribe();
            }
        }
        vva.j(th);
    }

    public void setCancellation(esa esaVar) {
        setSubscription(new CancellableSubscription(esaVar));
    }

    public void setSubscription(vra vraVar) {
        this.resource.update(vraVar);
    }

    @Override // com.baidu.tieba.vra
    public boolean isUnsubscribed() {
        return get();
    }

    public void onCompleted() {
        if (compareAndSet(false, true)) {
            try {
                this.actual.onCompleted();
            } finally {
                this.resource.unsubscribe();
            }
        }
    }

    @Override // com.baidu.tieba.vra
    public void unsubscribe() {
        if (compareAndSet(false, true)) {
            this.resource.unsubscribe();
        }
    }
}
