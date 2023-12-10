package rx.internal.subscriptions;

import com.baidu.tieba.ktc;
import com.baidu.tieba.loc;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class SequentialSubscription extends AtomicReference<loc> implements loc {
    public static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public loc current() {
        loc locVar = (loc) super.get();
        if (locVar == Unsubscribed.INSTANCE) {
            return ktc.c();
        }
        return locVar;
    }

    @Override // com.baidu.tieba.loc
    public boolean isUnsubscribed() {
        if (get() == Unsubscribed.INSTANCE) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.loc
    public void unsubscribe() {
        loc andSet;
        loc locVar = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (locVar != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != Unsubscribed.INSTANCE) {
            andSet.unsubscribe();
        }
    }

    public SequentialSubscription(loc locVar) {
        lazySet(locVar);
    }

    public boolean replace(loc locVar) {
        loc locVar2;
        do {
            locVar2 = get();
            if (locVar2 == Unsubscribed.INSTANCE) {
                if (locVar != null) {
                    locVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(locVar2, locVar));
        return true;
    }

    public boolean replaceWeak(loc locVar) {
        loc locVar2 = get();
        if (locVar2 == Unsubscribed.INSTANCE) {
            if (locVar != null) {
                locVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(locVar2, locVar) || get() != Unsubscribed.INSTANCE) {
            return true;
        } else {
            if (locVar != null) {
                locVar.unsubscribe();
            }
            return false;
        }
    }

    public boolean update(loc locVar) {
        loc locVar2;
        do {
            locVar2 = get();
            if (locVar2 == Unsubscribed.INSTANCE) {
                if (locVar != null) {
                    locVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(locVar2, locVar));
        if (locVar2 != null) {
            locVar2.unsubscribe();
            return true;
        }
        return true;
    }

    public boolean updateWeak(loc locVar) {
        loc locVar2 = get();
        if (locVar2 == Unsubscribed.INSTANCE) {
            if (locVar != null) {
                locVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(locVar2, locVar)) {
            return true;
        } else {
            loc locVar3 = get();
            if (locVar != null) {
                locVar.unsubscribe();
            }
            if (locVar3 != Unsubscribed.INSTANCE) {
                return false;
            }
            return true;
        }
    }
}
