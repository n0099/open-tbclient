package rx.internal.subscriptions;

import com.baidu.tieba.pra;
import com.baidu.tieba.zma;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class SequentialSubscription extends AtomicReference<zma> implements zma {
    public static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public zma current() {
        zma zmaVar = (zma) super.get();
        if (zmaVar == Unsubscribed.INSTANCE) {
            return pra.c();
        }
        return zmaVar;
    }

    @Override // com.baidu.tieba.zma
    public boolean isUnsubscribed() {
        if (get() == Unsubscribed.INSTANCE) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.zma
    public void unsubscribe() {
        zma andSet;
        zma zmaVar = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (zmaVar != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != Unsubscribed.INSTANCE) {
            andSet.unsubscribe();
        }
    }

    public SequentialSubscription(zma zmaVar) {
        lazySet(zmaVar);
    }

    public boolean replace(zma zmaVar) {
        zma zmaVar2;
        do {
            zmaVar2 = get();
            if (zmaVar2 == Unsubscribed.INSTANCE) {
                if (zmaVar != null) {
                    zmaVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(zmaVar2, zmaVar));
        return true;
    }

    public boolean replaceWeak(zma zmaVar) {
        zma zmaVar2 = get();
        if (zmaVar2 == Unsubscribed.INSTANCE) {
            if (zmaVar != null) {
                zmaVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(zmaVar2, zmaVar) || get() != Unsubscribed.INSTANCE) {
            return true;
        } else {
            if (zmaVar != null) {
                zmaVar.unsubscribe();
            }
            return false;
        }
    }

    public boolean update(zma zmaVar) {
        zma zmaVar2;
        do {
            zmaVar2 = get();
            if (zmaVar2 == Unsubscribed.INSTANCE) {
                if (zmaVar != null) {
                    zmaVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(zmaVar2, zmaVar));
        if (zmaVar2 != null) {
            zmaVar2.unsubscribe();
            return true;
        }
        return true;
    }

    public boolean updateWeak(zma zmaVar) {
        zma zmaVar2 = get();
        if (zmaVar2 == Unsubscribed.INSTANCE) {
            if (zmaVar != null) {
                zmaVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(zmaVar2, zmaVar)) {
            return true;
        } else {
            zma zmaVar3 = get();
            if (zmaVar != null) {
                zmaVar.unsubscribe();
            }
            if (zmaVar3 != Unsubscribed.INSTANCE) {
                return false;
            }
            return true;
        }
    }
}
