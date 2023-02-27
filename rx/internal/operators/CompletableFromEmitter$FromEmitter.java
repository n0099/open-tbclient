package rx.internal.operators;

import com.baidu.tieba.ina;
import com.baidu.tieba.rma;
import com.baidu.tieba.zma;
import com.baidu.tieba.zqa;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes9.dex */
public final class CompletableFromEmitter$FromEmitter extends AtomicBoolean implements zma {
    public static final long serialVersionUID = 5539301318568668881L;
    public final rma actual;
    public final SequentialSubscription resource = new SequentialSubscription();

    public CompletableFromEmitter$FromEmitter(rma rmaVar) {
        this.actual = rmaVar;
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
        zqa.j(th);
    }

    public void setCancellation(ina inaVar) {
        setSubscription(new CancellableSubscription(inaVar));
    }

    public void setSubscription(zma zmaVar) {
        this.resource.update(zmaVar);
    }

    @Override // com.baidu.tieba.zma
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

    @Override // com.baidu.tieba.zma
    public void unsubscribe() {
        if (compareAndSet(false, true)) {
            this.resource.unsubscribe();
        }
    }
}
