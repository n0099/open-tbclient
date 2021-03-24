package rx.internal.operators;

import h.c;
import h.k;
import h.n.d;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes7.dex */
public final class CompletableFromEmitter$FromEmitter extends AtomicBoolean implements k {
    public static final long serialVersionUID = 5539301318568668881L;
    public final c actual;
    public final SequentialSubscription resource = new SequentialSubscription();

    public CompletableFromEmitter$FromEmitter(c cVar) {
        this.actual = cVar;
    }

    @Override // h.k
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

    public void onError(Throwable th) {
        if (compareAndSet(false, true)) {
            try {
                this.actual.onError(th);
                return;
            } finally {
                this.resource.unsubscribe();
            }
        }
        h.r.c.j(th);
    }

    public void setCancellation(d dVar) {
        setSubscription(new CancellableSubscription(dVar));
    }

    public void setSubscription(k kVar) {
        this.resource.update(kVar);
    }

    @Override // h.k
    public void unsubscribe() {
        if (compareAndSet(false, true)) {
            this.resource.unsubscribe();
        }
    }
}
