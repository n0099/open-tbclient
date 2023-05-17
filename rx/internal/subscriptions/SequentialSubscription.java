package rx.internal.subscriptions;

import com.baidu.tieba.hcb;
import com.baidu.tieba.o7b;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes10.dex */
public final class SequentialSubscription extends AtomicReference<o7b> implements o7b {
    public static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public o7b current() {
        o7b o7bVar = (o7b) super.get();
        if (o7bVar == Unsubscribed.INSTANCE) {
            return hcb.c();
        }
        return o7bVar;
    }

    @Override // com.baidu.tieba.o7b
    public boolean isUnsubscribed() {
        if (get() == Unsubscribed.INSTANCE) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.o7b
    public void unsubscribe() {
        o7b andSet;
        o7b o7bVar = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (o7bVar != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != Unsubscribed.INSTANCE) {
            andSet.unsubscribe();
        }
    }

    public SequentialSubscription(o7b o7bVar) {
        lazySet(o7bVar);
    }

    public boolean replace(o7b o7bVar) {
        o7b o7bVar2;
        do {
            o7bVar2 = get();
            if (o7bVar2 == Unsubscribed.INSTANCE) {
                if (o7bVar != null) {
                    o7bVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(o7bVar2, o7bVar));
        return true;
    }

    public boolean replaceWeak(o7b o7bVar) {
        o7b o7bVar2 = get();
        if (o7bVar2 == Unsubscribed.INSTANCE) {
            if (o7bVar != null) {
                o7bVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(o7bVar2, o7bVar) || get() != Unsubscribed.INSTANCE) {
            return true;
        } else {
            if (o7bVar != null) {
                o7bVar.unsubscribe();
            }
            return false;
        }
    }

    public boolean update(o7b o7bVar) {
        o7b o7bVar2;
        do {
            o7bVar2 = get();
            if (o7bVar2 == Unsubscribed.INSTANCE) {
                if (o7bVar != null) {
                    o7bVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(o7bVar2, o7bVar));
        if (o7bVar2 != null) {
            o7bVar2.unsubscribe();
            return true;
        }
        return true;
    }

    public boolean updateWeak(o7b o7bVar) {
        o7b o7bVar2 = get();
        if (o7bVar2 == Unsubscribed.INSTANCE) {
            if (o7bVar != null) {
                o7bVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(o7bVar2, o7bVar)) {
            return true;
        } else {
            o7b o7bVar3 = get();
            if (o7bVar != null) {
                o7bVar.unsubscribe();
            }
            if (o7bVar3 != Unsubscribed.INSTANCE) {
                return false;
            }
            return true;
        }
    }
}
