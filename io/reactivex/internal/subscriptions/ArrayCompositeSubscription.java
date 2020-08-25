package io.reactivex.internal.subscriptions;

import io.reactivex.disposables.b;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.b.d;
/* loaded from: classes7.dex */
public final class ArrayCompositeSubscription extends AtomicReferenceArray<d> implements b {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeSubscription(int i) {
        super(i);
    }

    public boolean setResource(int i, d dVar) {
        d dVar2;
        do {
            dVar2 = get(i);
            if (dVar2 == SubscriptionHelper.CANCELLED) {
                if (dVar != null) {
                    dVar.cancel();
                }
                return false;
            }
        } while (!compareAndSet(i, dVar2, dVar));
        if (dVar2 != null) {
            dVar2.cancel();
        }
        return true;
    }

    public d replaceResource(int i, d dVar) {
        d dVar2;
        do {
            dVar2 = get(i);
            if (dVar2 == SubscriptionHelper.CANCELLED) {
                if (dVar != null) {
                    dVar.cancel();
                }
                return null;
            }
        } while (!compareAndSet(i, dVar2, dVar));
        return dVar2;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        d andSet;
        if (get(0) != SubscriptionHelper.CANCELLED) {
            int length = length();
            for (int i = 0; i < length; i++) {
                if (get(i) != SubscriptionHelper.CANCELLED && (andSet = getAndSet(i, SubscriptionHelper.CANCELLED)) != SubscriptionHelper.CANCELLED && andSet != null) {
                    andSet.cancel();
                }
            }
        }
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return get(0) == SubscriptionHelper.CANCELLED;
    }
}
