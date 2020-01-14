package rx.internal.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.k;
import rx.subscriptions.e;
/* loaded from: classes5.dex */
public final class SequentialSubscription extends AtomicReference<k> implements k {
    private static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public SequentialSubscription(k kVar) {
        lazySet(kVar);
    }

    public k current() {
        k kVar = (k) super.get();
        if (kVar == Unsubscribed.INSTANCE) {
            return e.dOn();
        }
        return kVar;
    }

    public boolean update(k kVar) {
        k kVar2;
        do {
            kVar2 = get();
            if (kVar2 == Unsubscribed.INSTANCE) {
                if (kVar != null) {
                    kVar.unsubscribe();
                }
                return false;
            }
        } while (!compareAndSet(kVar2, kVar));
        if (kVar2 != null) {
            kVar2.unsubscribe();
        }
        return true;
    }

    public boolean replace(k kVar) {
        k kVar2;
        do {
            kVar2 = get();
            if (kVar2 == Unsubscribed.INSTANCE) {
                if (kVar != null) {
                    kVar.unsubscribe();
                }
                return false;
            }
        } while (!compareAndSet(kVar2, kVar));
        return true;
    }

    public boolean updateWeak(k kVar) {
        k kVar2 = get();
        if (kVar2 == Unsubscribed.INSTANCE) {
            if (kVar != null) {
                kVar.unsubscribe();
                return false;
            }
            return false;
        } else if (compareAndSet(kVar2, kVar)) {
            return true;
        } else {
            k kVar3 = get();
            if (kVar != null) {
                kVar.unsubscribe();
            }
            return kVar3 == Unsubscribed.INSTANCE;
        }
    }

    public boolean replaceWeak(k kVar) {
        k kVar2 = get();
        if (kVar2 == Unsubscribed.INSTANCE) {
            if (kVar != null) {
                kVar.unsubscribe();
            }
            return false;
        }
        if (!compareAndSet(kVar2, kVar) && get() == Unsubscribed.INSTANCE) {
            if (kVar != null) {
                kVar.unsubscribe();
            }
            return false;
        }
        return true;
    }

    @Override // rx.k
    public void unsubscribe() {
        k andSet;
        if (get() != Unsubscribed.INSTANCE && (andSet = getAndSet(Unsubscribed.INSTANCE)) != null && andSet != Unsubscribed.INSTANCE) {
            andSet.unsubscribe();
        }
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return get() == Unsubscribed.INSTANCE;
    }
}
