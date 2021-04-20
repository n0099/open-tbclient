package io.reactivex.internal.subscriptions;

import f.b.t.b;
import g.d.d;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes7.dex */
public final class ArrayCompositeSubscription extends AtomicReferenceArray<d> implements b {
    public static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeSubscription(int i) {
        super(i);
    }

    @Override // f.b.t.b
    public void dispose() {
        d andSet;
        if (get(0) != SubscriptionHelper.CANCELLED) {
            int length = length();
            for (int i = 0; i < length; i++) {
                d dVar = get(i);
                SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
                if (dVar != subscriptionHelper && (andSet = getAndSet(i, subscriptionHelper)) != SubscriptionHelper.CANCELLED && andSet != null) {
                    andSet.cancel();
                }
            }
        }
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return get(0) == SubscriptionHelper.CANCELLED;
    }

    public d replaceResource(int i, d dVar) {
        d dVar2;
        do {
            dVar2 = get(i);
            if (dVar2 == SubscriptionHelper.CANCELLED) {
                if (dVar != null) {
                    dVar.cancel();
                    return null;
                }
                return null;
            }
        } while (!compareAndSet(i, dVar2, dVar));
        return dVar2;
    }

    public boolean setResource(int i, d dVar) {
        d dVar2;
        do {
            dVar2 = get(i);
            if (dVar2 == SubscriptionHelper.CANCELLED) {
                if (dVar != null) {
                    dVar.cancel();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(i, dVar2, dVar));
        if (dVar2 != null) {
            dVar2.cancel();
            return true;
        }
        return true;
    }
}
