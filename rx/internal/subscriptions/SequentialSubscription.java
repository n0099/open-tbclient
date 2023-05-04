package rx.internal.subscriptions;

import com.baidu.tieba.iab;
import com.baidu.tieba.q5b;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class SequentialSubscription extends AtomicReference<q5b> implements q5b {
    public static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public q5b current() {
        q5b q5bVar = (q5b) super.get();
        if (q5bVar == Unsubscribed.INSTANCE) {
            return iab.c();
        }
        return q5bVar;
    }

    @Override // com.baidu.tieba.q5b
    public boolean isUnsubscribed() {
        if (get() == Unsubscribed.INSTANCE) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.q5b
    public void unsubscribe() {
        q5b andSet;
        q5b q5bVar = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (q5bVar != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != Unsubscribed.INSTANCE) {
            andSet.unsubscribe();
        }
    }

    public SequentialSubscription(q5b q5bVar) {
        lazySet(q5bVar);
    }

    public boolean replace(q5b q5bVar) {
        q5b q5bVar2;
        do {
            q5bVar2 = get();
            if (q5bVar2 == Unsubscribed.INSTANCE) {
                if (q5bVar != null) {
                    q5bVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(q5bVar2, q5bVar));
        return true;
    }

    public boolean replaceWeak(q5b q5bVar) {
        q5b q5bVar2 = get();
        if (q5bVar2 == Unsubscribed.INSTANCE) {
            if (q5bVar != null) {
                q5bVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(q5bVar2, q5bVar) || get() != Unsubscribed.INSTANCE) {
            return true;
        } else {
            if (q5bVar != null) {
                q5bVar.unsubscribe();
            }
            return false;
        }
    }

    public boolean update(q5b q5bVar) {
        q5b q5bVar2;
        do {
            q5bVar2 = get();
            if (q5bVar2 == Unsubscribed.INSTANCE) {
                if (q5bVar != null) {
                    q5bVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(q5bVar2, q5bVar));
        if (q5bVar2 != null) {
            q5bVar2.unsubscribe();
            return true;
        }
        return true;
    }

    public boolean updateWeak(q5b q5bVar) {
        q5b q5bVar2 = get();
        if (q5bVar2 == Unsubscribed.INSTANCE) {
            if (q5bVar != null) {
                q5bVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(q5bVar2, q5bVar)) {
            return true;
        } else {
            q5b q5bVar3 = get();
            if (q5bVar != null) {
                q5bVar.unsubscribe();
            }
            if (q5bVar3 != Unsubscribed.INSTANCE) {
                return false;
            }
            return true;
        }
    }
}
