package rx.internal.subscriptions;

import com.baidu.tieba.icb;
import com.baidu.tieba.p7b;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes10.dex */
public final class SequentialSubscription extends AtomicReference<p7b> implements p7b {
    public static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public p7b current() {
        p7b p7bVar = (p7b) super.get();
        if (p7bVar == Unsubscribed.INSTANCE) {
            return icb.c();
        }
        return p7bVar;
    }

    @Override // com.baidu.tieba.p7b
    public boolean isUnsubscribed() {
        if (get() == Unsubscribed.INSTANCE) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.p7b
    public void unsubscribe() {
        p7b andSet;
        p7b p7bVar = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (p7bVar != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != Unsubscribed.INSTANCE) {
            andSet.unsubscribe();
        }
    }

    public SequentialSubscription(p7b p7bVar) {
        lazySet(p7bVar);
    }

    public boolean replace(p7b p7bVar) {
        p7b p7bVar2;
        do {
            p7bVar2 = get();
            if (p7bVar2 == Unsubscribed.INSTANCE) {
                if (p7bVar != null) {
                    p7bVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(p7bVar2, p7bVar));
        return true;
    }

    public boolean replaceWeak(p7b p7bVar) {
        p7b p7bVar2 = get();
        if (p7bVar2 == Unsubscribed.INSTANCE) {
            if (p7bVar != null) {
                p7bVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(p7bVar2, p7bVar) || get() != Unsubscribed.INSTANCE) {
            return true;
        } else {
            if (p7bVar != null) {
                p7bVar.unsubscribe();
            }
            return false;
        }
    }

    public boolean update(p7b p7bVar) {
        p7b p7bVar2;
        do {
            p7bVar2 = get();
            if (p7bVar2 == Unsubscribed.INSTANCE) {
                if (p7bVar != null) {
                    p7bVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(p7bVar2, p7bVar));
        if (p7bVar2 != null) {
            p7bVar2.unsubscribe();
            return true;
        }
        return true;
    }

    public boolean updateWeak(p7b p7bVar) {
        p7b p7bVar2 = get();
        if (p7bVar2 == Unsubscribed.INSTANCE) {
            if (p7bVar != null) {
                p7bVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(p7bVar2, p7bVar)) {
            return true;
        } else {
            p7b p7bVar3 = get();
            if (p7bVar != null) {
                p7bVar.unsubscribe();
            }
            if (p7bVar3 != Unsubscribed.INSTANCE) {
                return false;
            }
            return true;
        }
    }
}
