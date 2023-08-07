package rx.internal.subscriptions;

import com.baidu.tieba.a6c;
import com.baidu.tieba.e1c;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class SequentialSubscription extends AtomicReference<e1c> implements e1c {
    public static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public e1c current() {
        e1c e1cVar = (e1c) super.get();
        if (e1cVar == Unsubscribed.INSTANCE) {
            return a6c.c();
        }
        return e1cVar;
    }

    @Override // com.baidu.tieba.e1c
    public boolean isUnsubscribed() {
        if (get() == Unsubscribed.INSTANCE) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.e1c
    public void unsubscribe() {
        e1c andSet;
        e1c e1cVar = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (e1cVar != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != Unsubscribed.INSTANCE) {
            andSet.unsubscribe();
        }
    }

    public SequentialSubscription(e1c e1cVar) {
        lazySet(e1cVar);
    }

    public boolean replace(e1c e1cVar) {
        e1c e1cVar2;
        do {
            e1cVar2 = get();
            if (e1cVar2 == Unsubscribed.INSTANCE) {
                if (e1cVar != null) {
                    e1cVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(e1cVar2, e1cVar));
        return true;
    }

    public boolean replaceWeak(e1c e1cVar) {
        e1c e1cVar2 = get();
        if (e1cVar2 == Unsubscribed.INSTANCE) {
            if (e1cVar != null) {
                e1cVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(e1cVar2, e1cVar) || get() != Unsubscribed.INSTANCE) {
            return true;
        } else {
            if (e1cVar != null) {
                e1cVar.unsubscribe();
            }
            return false;
        }
    }

    public boolean update(e1c e1cVar) {
        e1c e1cVar2;
        do {
            e1cVar2 = get();
            if (e1cVar2 == Unsubscribed.INSTANCE) {
                if (e1cVar != null) {
                    e1cVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(e1cVar2, e1cVar));
        if (e1cVar2 != null) {
            e1cVar2.unsubscribe();
            return true;
        }
        return true;
    }

    public boolean updateWeak(e1c e1cVar) {
        e1c e1cVar2 = get();
        if (e1cVar2 == Unsubscribed.INSTANCE) {
            if (e1cVar != null) {
                e1cVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(e1cVar2, e1cVar)) {
            return true;
        } else {
            e1c e1cVar3 = get();
            if (e1cVar != null) {
                e1cVar.unsubscribe();
            }
            if (e1cVar3 != Unsubscribed.INSTANCE) {
                return false;
            }
            return true;
        }
    }
}
