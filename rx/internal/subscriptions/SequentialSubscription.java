package rx.internal.subscriptions;

import com.baidu.tieba.irb;
import com.baidu.tieba.pmb;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class SequentialSubscription extends AtomicReference<pmb> implements pmb {
    public static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public pmb current() {
        pmb pmbVar = (pmb) super.get();
        if (pmbVar == Unsubscribed.INSTANCE) {
            return irb.c();
        }
        return pmbVar;
    }

    @Override // com.baidu.tieba.pmb
    public boolean isUnsubscribed() {
        if (get() == Unsubscribed.INSTANCE) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.pmb
    public void unsubscribe() {
        pmb andSet;
        pmb pmbVar = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (pmbVar != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != Unsubscribed.INSTANCE) {
            andSet.unsubscribe();
        }
    }

    public SequentialSubscription(pmb pmbVar) {
        lazySet(pmbVar);
    }

    public boolean replace(pmb pmbVar) {
        pmb pmbVar2;
        do {
            pmbVar2 = get();
            if (pmbVar2 == Unsubscribed.INSTANCE) {
                if (pmbVar != null) {
                    pmbVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(pmbVar2, pmbVar));
        return true;
    }

    public boolean replaceWeak(pmb pmbVar) {
        pmb pmbVar2 = get();
        if (pmbVar2 == Unsubscribed.INSTANCE) {
            if (pmbVar != null) {
                pmbVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(pmbVar2, pmbVar) || get() != Unsubscribed.INSTANCE) {
            return true;
        } else {
            if (pmbVar != null) {
                pmbVar.unsubscribe();
            }
            return false;
        }
    }

    public boolean update(pmb pmbVar) {
        pmb pmbVar2;
        do {
            pmbVar2 = get();
            if (pmbVar2 == Unsubscribed.INSTANCE) {
                if (pmbVar != null) {
                    pmbVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(pmbVar2, pmbVar));
        if (pmbVar2 != null) {
            pmbVar2.unsubscribe();
            return true;
        }
        return true;
    }

    public boolean updateWeak(pmb pmbVar) {
        pmb pmbVar2 = get();
        if (pmbVar2 == Unsubscribed.INSTANCE) {
            if (pmbVar != null) {
                pmbVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(pmbVar2, pmbVar)) {
            return true;
        } else {
            pmb pmbVar3 = get();
            if (pmbVar != null) {
                pmbVar.unsubscribe();
            }
            if (pmbVar3 != Unsubscribed.INSTANCE) {
                return false;
            }
            return true;
        }
    }
}
