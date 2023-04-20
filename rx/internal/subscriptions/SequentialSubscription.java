package rx.internal.subscriptions;

import com.baidu.tieba.k6b;
import com.baidu.tieba.u1b;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class SequentialSubscription extends AtomicReference<u1b> implements u1b {
    public static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public u1b current() {
        u1b u1bVar = (u1b) super.get();
        if (u1bVar == Unsubscribed.INSTANCE) {
            return k6b.c();
        }
        return u1bVar;
    }

    @Override // com.baidu.tieba.u1b
    public boolean isUnsubscribed() {
        if (get() == Unsubscribed.INSTANCE) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.u1b
    public void unsubscribe() {
        u1b andSet;
        u1b u1bVar = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (u1bVar != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != Unsubscribed.INSTANCE) {
            andSet.unsubscribe();
        }
    }

    public SequentialSubscription(u1b u1bVar) {
        lazySet(u1bVar);
    }

    public boolean replace(u1b u1bVar) {
        u1b u1bVar2;
        do {
            u1bVar2 = get();
            if (u1bVar2 == Unsubscribed.INSTANCE) {
                if (u1bVar != null) {
                    u1bVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(u1bVar2, u1bVar));
        return true;
    }

    public boolean replaceWeak(u1b u1bVar) {
        u1b u1bVar2 = get();
        if (u1bVar2 == Unsubscribed.INSTANCE) {
            if (u1bVar != null) {
                u1bVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(u1bVar2, u1bVar) || get() != Unsubscribed.INSTANCE) {
            return true;
        } else {
            if (u1bVar != null) {
                u1bVar.unsubscribe();
            }
            return false;
        }
    }

    public boolean update(u1b u1bVar) {
        u1b u1bVar2;
        do {
            u1bVar2 = get();
            if (u1bVar2 == Unsubscribed.INSTANCE) {
                if (u1bVar != null) {
                    u1bVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(u1bVar2, u1bVar));
        if (u1bVar2 != null) {
            u1bVar2.unsubscribe();
            return true;
        }
        return true;
    }

    public boolean updateWeak(u1b u1bVar) {
        u1b u1bVar2 = get();
        if (u1bVar2 == Unsubscribed.INSTANCE) {
            if (u1bVar != null) {
                u1bVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(u1bVar2, u1bVar)) {
            return true;
        } else {
            u1b u1bVar3 = get();
            if (u1bVar != null) {
                u1bVar.unsubscribe();
            }
            if (u1bVar3 != Unsubscribed.INSTANCE) {
                return false;
            }
            return true;
        }
    }
}
