package rx.internal.subscriptions;

import h.k;
import h.u.e;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class SequentialSubscription extends AtomicReference<k> implements k {
    public static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public k current() {
        k kVar = (k) super.get();
        return kVar == Unsubscribed.INSTANCE ? e.c() : kVar;
    }

    @Override // h.k
    public boolean isUnsubscribed() {
        return get() == Unsubscribed.INSTANCE;
    }

    public boolean replace(k kVar) {
        k kVar2;
        do {
            kVar2 = get();
            if (kVar2 == Unsubscribed.INSTANCE) {
                if (kVar != null) {
                    kVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(kVar2, kVar));
        return true;
    }

    public boolean replaceWeak(k kVar) {
        k kVar2 = get();
        if (kVar2 == Unsubscribed.INSTANCE) {
            if (kVar != null) {
                kVar.unsubscribe();
            }
            return false;
        } else if (!compareAndSet(kVar2, kVar) && get() == Unsubscribed.INSTANCE) {
            if (kVar != null) {
                kVar.unsubscribe();
            }
            return false;
        } else {
            return true;
        }
    }

    @Override // h.k
    public void unsubscribe() {
        k andSet;
        k kVar = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (kVar == unsubscribed || (andSet = getAndSet(unsubscribed)) == null || andSet == Unsubscribed.INSTANCE) {
            return;
        }
        andSet.unsubscribe();
    }

    public boolean update(k kVar) {
        k kVar2;
        do {
            kVar2 = get();
            if (kVar2 == Unsubscribed.INSTANCE) {
                if (kVar != null) {
                    kVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(kVar2, kVar));
        if (kVar2 != null) {
            kVar2.unsubscribe();
            return true;
        }
        return true;
    }

    public boolean updateWeak(k kVar) {
        k kVar2 = get();
        if (kVar2 == Unsubscribed.INSTANCE) {
            if (kVar != null) {
                kVar.unsubscribe();
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

    public SequentialSubscription(k kVar) {
        lazySet(kVar);
    }
}
