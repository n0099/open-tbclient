package rx.internal.subscriptions;

import com.baidu.tieba.ohc;
import com.baidu.tieba.rcc;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class SequentialSubscription extends AtomicReference<rcc> implements rcc {
    public static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public rcc current() {
        rcc rccVar = (rcc) super.get();
        if (rccVar == Unsubscribed.INSTANCE) {
            return ohc.c();
        }
        return rccVar;
    }

    @Override // com.baidu.tieba.rcc
    public boolean isUnsubscribed() {
        if (get() == Unsubscribed.INSTANCE) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.rcc
    public void unsubscribe() {
        rcc andSet;
        rcc rccVar = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (rccVar != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != Unsubscribed.INSTANCE) {
            andSet.unsubscribe();
        }
    }

    public SequentialSubscription(rcc rccVar) {
        lazySet(rccVar);
    }

    public boolean replace(rcc rccVar) {
        rcc rccVar2;
        do {
            rccVar2 = get();
            if (rccVar2 == Unsubscribed.INSTANCE) {
                if (rccVar != null) {
                    rccVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(rccVar2, rccVar));
        return true;
    }

    public boolean replaceWeak(rcc rccVar) {
        rcc rccVar2 = get();
        if (rccVar2 == Unsubscribed.INSTANCE) {
            if (rccVar != null) {
                rccVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(rccVar2, rccVar) || get() != Unsubscribed.INSTANCE) {
            return true;
        } else {
            if (rccVar != null) {
                rccVar.unsubscribe();
            }
            return false;
        }
    }

    public boolean update(rcc rccVar) {
        rcc rccVar2;
        do {
            rccVar2 = get();
            if (rccVar2 == Unsubscribed.INSTANCE) {
                if (rccVar != null) {
                    rccVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(rccVar2, rccVar));
        if (rccVar2 != null) {
            rccVar2.unsubscribe();
            return true;
        }
        return true;
    }

    public boolean updateWeak(rcc rccVar) {
        rcc rccVar2 = get();
        if (rccVar2 == Unsubscribed.INSTANCE) {
            if (rccVar != null) {
                rccVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(rccVar2, rccVar)) {
            return true;
        } else {
            rcc rccVar3 = get();
            if (rccVar != null) {
                rccVar.unsubscribe();
            }
            if (rccVar3 != Unsubscribed.INSTANCE) {
                return false;
            }
            return true;
        }
    }
}
