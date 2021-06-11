package rx.internal.subscriptions;

import h.k;
import h.m.a;
import h.n.d;
import h.r.c;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class CancellableSubscription extends AtomicReference<d> implements k {
    public static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(d dVar) {
        super(dVar);
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return get() == null;
    }

    @Override // h.k
    public void unsubscribe() {
        d andSet;
        if (get() == null || (andSet = getAndSet(null)) == null) {
            return;
        }
        try {
            andSet.cancel();
        } catch (Exception e2) {
            a.e(e2);
            c.j(e2);
        }
    }
}
