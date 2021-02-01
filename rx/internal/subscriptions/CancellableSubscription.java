package rx.internal.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.c.c;
import rx.exceptions.a;
import rx.functions.d;
import rx.k;
/* loaded from: classes5.dex */
public final class CancellableSubscription extends AtomicReference<d> implements k {
    private static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(d dVar) {
        super(dVar);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return get() == null;
    }

    @Override // rx.k
    public void unsubscribe() {
        d andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            try {
                andSet.cancel();
            } catch (Exception e) {
                a.N(e);
                c.onError(e);
            }
        }
    }
}
