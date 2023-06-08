package rx.internal.subscriptions;

import com.baidu.tieba.nrb;
import com.baidu.tieba.umb;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class SequentialSubscription extends AtomicReference<umb> implements umb {
    public static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public umb current() {
        umb umbVar = (umb) super.get();
        if (umbVar == Unsubscribed.INSTANCE) {
            return nrb.c();
        }
        return umbVar;
    }

    @Override // com.baidu.tieba.umb
    public boolean isUnsubscribed() {
        if (get() == Unsubscribed.INSTANCE) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.umb
    public void unsubscribe() {
        umb andSet;
        umb umbVar = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (umbVar != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != Unsubscribed.INSTANCE) {
            andSet.unsubscribe();
        }
    }

    public SequentialSubscription(umb umbVar) {
        lazySet(umbVar);
    }

    public boolean replace(umb umbVar) {
        umb umbVar2;
        do {
            umbVar2 = get();
            if (umbVar2 == Unsubscribed.INSTANCE) {
                if (umbVar != null) {
                    umbVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(umbVar2, umbVar));
        return true;
    }

    public boolean replaceWeak(umb umbVar) {
        umb umbVar2 = get();
        if (umbVar2 == Unsubscribed.INSTANCE) {
            if (umbVar != null) {
                umbVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(umbVar2, umbVar) || get() != Unsubscribed.INSTANCE) {
            return true;
        } else {
            if (umbVar != null) {
                umbVar.unsubscribe();
            }
            return false;
        }
    }

    public boolean update(umb umbVar) {
        umb umbVar2;
        do {
            umbVar2 = get();
            if (umbVar2 == Unsubscribed.INSTANCE) {
                if (umbVar != null) {
                    umbVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(umbVar2, umbVar));
        if (umbVar2 != null) {
            umbVar2.unsubscribe();
            return true;
        }
        return true;
    }

    public boolean updateWeak(umb umbVar) {
        umb umbVar2 = get();
        if (umbVar2 == Unsubscribed.INSTANCE) {
            if (umbVar != null) {
                umbVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(umbVar2, umbVar)) {
            return true;
        } else {
            umb umbVar3 = get();
            if (umbVar != null) {
                umbVar.unsubscribe();
            }
            if (umbVar3 != Unsubscribed.INSTANCE) {
                return false;
            }
            return true;
        }
    }
}
