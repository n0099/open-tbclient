package rx.internal.subscriptions;

import com.baidu.tieba.rcc;
import com.baidu.tieba.u7c;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class SequentialSubscription extends AtomicReference<u7c> implements u7c {
    public static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public u7c current() {
        u7c u7cVar = (u7c) super.get();
        if (u7cVar == Unsubscribed.INSTANCE) {
            return rcc.c();
        }
        return u7cVar;
    }

    @Override // com.baidu.tieba.u7c
    public boolean isUnsubscribed() {
        if (get() == Unsubscribed.INSTANCE) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.u7c
    public void unsubscribe() {
        u7c andSet;
        u7c u7cVar = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (u7cVar != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != Unsubscribed.INSTANCE) {
            andSet.unsubscribe();
        }
    }

    public SequentialSubscription(u7c u7cVar) {
        lazySet(u7cVar);
    }

    public boolean replace(u7c u7cVar) {
        u7c u7cVar2;
        do {
            u7cVar2 = get();
            if (u7cVar2 == Unsubscribed.INSTANCE) {
                if (u7cVar != null) {
                    u7cVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(u7cVar2, u7cVar));
        return true;
    }

    public boolean replaceWeak(u7c u7cVar) {
        u7c u7cVar2 = get();
        if (u7cVar2 == Unsubscribed.INSTANCE) {
            if (u7cVar != null) {
                u7cVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(u7cVar2, u7cVar) || get() != Unsubscribed.INSTANCE) {
            return true;
        } else {
            if (u7cVar != null) {
                u7cVar.unsubscribe();
            }
            return false;
        }
    }

    public boolean update(u7c u7cVar) {
        u7c u7cVar2;
        do {
            u7cVar2 = get();
            if (u7cVar2 == Unsubscribed.INSTANCE) {
                if (u7cVar != null) {
                    u7cVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(u7cVar2, u7cVar));
        if (u7cVar2 != null) {
            u7cVar2.unsubscribe();
            return true;
        }
        return true;
    }

    public boolean updateWeak(u7c u7cVar) {
        u7c u7cVar2 = get();
        if (u7cVar2 == Unsubscribed.INSTANCE) {
            if (u7cVar != null) {
                u7cVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(u7cVar2, u7cVar)) {
            return true;
        } else {
            u7c u7cVar3 = get();
            if (u7cVar != null) {
                u7cVar.unsubscribe();
            }
            if (u7cVar3 != Unsubscribed.INSTANCE) {
                return false;
            }
            return true;
        }
    }
}
