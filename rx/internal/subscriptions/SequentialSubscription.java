package rx.internal.subscriptions;

import com.baidu.tieba.ooc;
import com.baidu.tieba.pjc;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class SequentialSubscription extends AtomicReference<pjc> implements pjc {
    public static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public pjc current() {
        pjc pjcVar = (pjc) super.get();
        if (pjcVar == Unsubscribed.INSTANCE) {
            return ooc.c();
        }
        return pjcVar;
    }

    @Override // com.baidu.tieba.pjc
    public boolean isUnsubscribed() {
        if (get() == Unsubscribed.INSTANCE) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.pjc
    public void unsubscribe() {
        pjc andSet;
        pjc pjcVar = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (pjcVar != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != Unsubscribed.INSTANCE) {
            andSet.unsubscribe();
        }
    }

    public SequentialSubscription(pjc pjcVar) {
        lazySet(pjcVar);
    }

    public boolean replace(pjc pjcVar) {
        pjc pjcVar2;
        do {
            pjcVar2 = get();
            if (pjcVar2 == Unsubscribed.INSTANCE) {
                if (pjcVar != null) {
                    pjcVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(pjcVar2, pjcVar));
        return true;
    }

    public boolean replaceWeak(pjc pjcVar) {
        pjc pjcVar2 = get();
        if (pjcVar2 == Unsubscribed.INSTANCE) {
            if (pjcVar != null) {
                pjcVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(pjcVar2, pjcVar) || get() != Unsubscribed.INSTANCE) {
            return true;
        } else {
            if (pjcVar != null) {
                pjcVar.unsubscribe();
            }
            return false;
        }
    }

    public boolean update(pjc pjcVar) {
        pjc pjcVar2;
        do {
            pjcVar2 = get();
            if (pjcVar2 == Unsubscribed.INSTANCE) {
                if (pjcVar != null) {
                    pjcVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(pjcVar2, pjcVar));
        if (pjcVar2 != null) {
            pjcVar2.unsubscribe();
            return true;
        }
        return true;
    }

    public boolean updateWeak(pjc pjcVar) {
        pjc pjcVar2 = get();
        if (pjcVar2 == Unsubscribed.INSTANCE) {
            if (pjcVar != null) {
                pjcVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(pjcVar2, pjcVar)) {
            return true;
        } else {
            pjc pjcVar3 = get();
            if (pjcVar != null) {
                pjcVar.unsubscribe();
            }
            if (pjcVar3 != Unsubscribed.INSTANCE) {
                return false;
            }
            return true;
        }
    }
}
