package rx.internal.subscriptions;

import com.baidu.tieba.gtb;
import com.baidu.tieba.nob;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class SequentialSubscription extends AtomicReference<nob> implements nob {
    public static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public nob current() {
        nob nobVar = (nob) super.get();
        if (nobVar == Unsubscribed.INSTANCE) {
            return gtb.c();
        }
        return nobVar;
    }

    @Override // com.baidu.tieba.nob
    public boolean isUnsubscribed() {
        if (get() == Unsubscribed.INSTANCE) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.nob
    public void unsubscribe() {
        nob andSet;
        nob nobVar = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (nobVar != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != Unsubscribed.INSTANCE) {
            andSet.unsubscribe();
        }
    }

    public SequentialSubscription(nob nobVar) {
        lazySet(nobVar);
    }

    public boolean replace(nob nobVar) {
        nob nobVar2;
        do {
            nobVar2 = get();
            if (nobVar2 == Unsubscribed.INSTANCE) {
                if (nobVar != null) {
                    nobVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(nobVar2, nobVar));
        return true;
    }

    public boolean replaceWeak(nob nobVar) {
        nob nobVar2 = get();
        if (nobVar2 == Unsubscribed.INSTANCE) {
            if (nobVar != null) {
                nobVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(nobVar2, nobVar) || get() != Unsubscribed.INSTANCE) {
            return true;
        } else {
            if (nobVar != null) {
                nobVar.unsubscribe();
            }
            return false;
        }
    }

    public boolean update(nob nobVar) {
        nob nobVar2;
        do {
            nobVar2 = get();
            if (nobVar2 == Unsubscribed.INSTANCE) {
                if (nobVar != null) {
                    nobVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(nobVar2, nobVar));
        if (nobVar2 != null) {
            nobVar2.unsubscribe();
            return true;
        }
        return true;
    }

    public boolean updateWeak(nob nobVar) {
        nob nobVar2 = get();
        if (nobVar2 == Unsubscribed.INSTANCE) {
            if (nobVar != null) {
                nobVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(nobVar2, nobVar)) {
            return true;
        } else {
            nob nobVar3 = get();
            if (nobVar != null) {
                nobVar.unsubscribe();
            }
            if (nobVar3 != Unsubscribed.INSTANCE) {
                return false;
            }
            return true;
        }
    }
}
