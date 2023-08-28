package rx.internal.subscriptions;

import com.baidu.tieba.tcc;
import com.baidu.tieba.w7c;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class SequentialSubscription extends AtomicReference<w7c> implements w7c {
    public static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public w7c current() {
        w7c w7cVar = (w7c) super.get();
        if (w7cVar == Unsubscribed.INSTANCE) {
            return tcc.c();
        }
        return w7cVar;
    }

    @Override // com.baidu.tieba.w7c
    public boolean isUnsubscribed() {
        if (get() == Unsubscribed.INSTANCE) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.w7c
    public void unsubscribe() {
        w7c andSet;
        w7c w7cVar = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (w7cVar != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != Unsubscribed.INSTANCE) {
            andSet.unsubscribe();
        }
    }

    public SequentialSubscription(w7c w7cVar) {
        lazySet(w7cVar);
    }

    public boolean replace(w7c w7cVar) {
        w7c w7cVar2;
        do {
            w7cVar2 = get();
            if (w7cVar2 == Unsubscribed.INSTANCE) {
                if (w7cVar != null) {
                    w7cVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(w7cVar2, w7cVar));
        return true;
    }

    public boolean replaceWeak(w7c w7cVar) {
        w7c w7cVar2 = get();
        if (w7cVar2 == Unsubscribed.INSTANCE) {
            if (w7cVar != null) {
                w7cVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(w7cVar2, w7cVar) || get() != Unsubscribed.INSTANCE) {
            return true;
        } else {
            if (w7cVar != null) {
                w7cVar.unsubscribe();
            }
            return false;
        }
    }

    public boolean update(w7c w7cVar) {
        w7c w7cVar2;
        do {
            w7cVar2 = get();
            if (w7cVar2 == Unsubscribed.INSTANCE) {
                if (w7cVar != null) {
                    w7cVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(w7cVar2, w7cVar));
        if (w7cVar2 != null) {
            w7cVar2.unsubscribe();
            return true;
        }
        return true;
    }

    public boolean updateWeak(w7c w7cVar) {
        w7c w7cVar2 = get();
        if (w7cVar2 == Unsubscribed.INSTANCE) {
            if (w7cVar != null) {
                w7cVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(w7cVar2, w7cVar)) {
            return true;
        } else {
            w7c w7cVar3 = get();
            if (w7cVar != null) {
                w7cVar.unsubscribe();
            }
            if (w7cVar3 != Unsubscribed.INSTANCE) {
                return false;
            }
            return true;
        }
    }
}
