package rx.internal.subscriptions;

import com.baidu.tieba.nbc;
import com.baidu.tieba.o6c;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class SequentialSubscription extends AtomicReference<o6c> implements o6c {
    public static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public o6c current() {
        o6c o6cVar = (o6c) super.get();
        if (o6cVar == Unsubscribed.INSTANCE) {
            return nbc.c();
        }
        return o6cVar;
    }

    @Override // com.baidu.tieba.o6c
    public boolean isUnsubscribed() {
        if (get() == Unsubscribed.INSTANCE) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.o6c
    public void unsubscribe() {
        o6c andSet;
        o6c o6cVar = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (o6cVar != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != Unsubscribed.INSTANCE) {
            andSet.unsubscribe();
        }
    }

    public SequentialSubscription(o6c o6cVar) {
        lazySet(o6cVar);
    }

    public boolean replace(o6c o6cVar) {
        o6c o6cVar2;
        do {
            o6cVar2 = get();
            if (o6cVar2 == Unsubscribed.INSTANCE) {
                if (o6cVar != null) {
                    o6cVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(o6cVar2, o6cVar));
        return true;
    }

    public boolean replaceWeak(o6c o6cVar) {
        o6c o6cVar2 = get();
        if (o6cVar2 == Unsubscribed.INSTANCE) {
            if (o6cVar != null) {
                o6cVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(o6cVar2, o6cVar) || get() != Unsubscribed.INSTANCE) {
            return true;
        } else {
            if (o6cVar != null) {
                o6cVar.unsubscribe();
            }
            return false;
        }
    }

    public boolean update(o6c o6cVar) {
        o6c o6cVar2;
        do {
            o6cVar2 = get();
            if (o6cVar2 == Unsubscribed.INSTANCE) {
                if (o6cVar != null) {
                    o6cVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(o6cVar2, o6cVar));
        if (o6cVar2 != null) {
            o6cVar2.unsubscribe();
            return true;
        }
        return true;
    }

    public boolean updateWeak(o6c o6cVar) {
        o6c o6cVar2 = get();
        if (o6cVar2 == Unsubscribed.INSTANCE) {
            if (o6cVar != null) {
                o6cVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(o6cVar2, o6cVar)) {
            return true;
        } else {
            o6c o6cVar3 = get();
            if (o6cVar != null) {
                o6cVar.unsubscribe();
            }
            if (o6cVar3 != Unsubscribed.INSTANCE) {
                return false;
            }
            return true;
        }
    }
}
