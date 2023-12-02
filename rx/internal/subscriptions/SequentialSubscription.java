package rx.internal.subscriptions;

import com.baidu.tieba.jtc;
import com.baidu.tieba.koc;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class SequentialSubscription extends AtomicReference<koc> implements koc {
    public static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public koc current() {
        koc kocVar = (koc) super.get();
        if (kocVar == Unsubscribed.INSTANCE) {
            return jtc.c();
        }
        return kocVar;
    }

    @Override // com.baidu.tieba.koc
    public boolean isUnsubscribed() {
        if (get() == Unsubscribed.INSTANCE) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.koc
    public void unsubscribe() {
        koc andSet;
        koc kocVar = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (kocVar != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != Unsubscribed.INSTANCE) {
            andSet.unsubscribe();
        }
    }

    public SequentialSubscription(koc kocVar) {
        lazySet(kocVar);
    }

    public boolean replace(koc kocVar) {
        koc kocVar2;
        do {
            kocVar2 = get();
            if (kocVar2 == Unsubscribed.INSTANCE) {
                if (kocVar != null) {
                    kocVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(kocVar2, kocVar));
        return true;
    }

    public boolean replaceWeak(koc kocVar) {
        koc kocVar2 = get();
        if (kocVar2 == Unsubscribed.INSTANCE) {
            if (kocVar != null) {
                kocVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(kocVar2, kocVar) || get() != Unsubscribed.INSTANCE) {
            return true;
        } else {
            if (kocVar != null) {
                kocVar.unsubscribe();
            }
            return false;
        }
    }

    public boolean update(koc kocVar) {
        koc kocVar2;
        do {
            kocVar2 = get();
            if (kocVar2 == Unsubscribed.INSTANCE) {
                if (kocVar != null) {
                    kocVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(kocVar2, kocVar));
        if (kocVar2 != null) {
            kocVar2.unsubscribe();
            return true;
        }
        return true;
    }

    public boolean updateWeak(koc kocVar) {
        koc kocVar2 = get();
        if (kocVar2 == Unsubscribed.INSTANCE) {
            if (kocVar != null) {
                kocVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(kocVar2, kocVar)) {
            return true;
        } else {
            koc kocVar3 = get();
            if (kocVar != null) {
                kocVar.unsubscribe();
            }
            if (kocVar3 != Unsubscribed.INSTANCE) {
                return false;
            }
            return true;
        }
    }
}
