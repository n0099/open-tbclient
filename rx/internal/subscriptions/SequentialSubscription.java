package rx.internal.subscriptions;

import com.baidu.tieba.wfc;
import com.baidu.tieba.zac;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class SequentialSubscription extends AtomicReference<zac> implements zac {
    public static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public zac current() {
        zac zacVar = (zac) super.get();
        if (zacVar == Unsubscribed.INSTANCE) {
            return wfc.c();
        }
        return zacVar;
    }

    @Override // com.baidu.tieba.zac
    public boolean isUnsubscribed() {
        if (get() == Unsubscribed.INSTANCE) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.zac
    public void unsubscribe() {
        zac andSet;
        zac zacVar = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (zacVar != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != Unsubscribed.INSTANCE) {
            andSet.unsubscribe();
        }
    }

    public SequentialSubscription(zac zacVar) {
        lazySet(zacVar);
    }

    public boolean replace(zac zacVar) {
        zac zacVar2;
        do {
            zacVar2 = get();
            if (zacVar2 == Unsubscribed.INSTANCE) {
                if (zacVar != null) {
                    zacVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(zacVar2, zacVar));
        return true;
    }

    public boolean replaceWeak(zac zacVar) {
        zac zacVar2 = get();
        if (zacVar2 == Unsubscribed.INSTANCE) {
            if (zacVar != null) {
                zacVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(zacVar2, zacVar) || get() != Unsubscribed.INSTANCE) {
            return true;
        } else {
            if (zacVar != null) {
                zacVar.unsubscribe();
            }
            return false;
        }
    }

    public boolean update(zac zacVar) {
        zac zacVar2;
        do {
            zacVar2 = get();
            if (zacVar2 == Unsubscribed.INSTANCE) {
                if (zacVar != null) {
                    zacVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(zacVar2, zacVar));
        if (zacVar2 != null) {
            zacVar2.unsubscribe();
            return true;
        }
        return true;
    }

    public boolean updateWeak(zac zacVar) {
        zac zacVar2 = get();
        if (zacVar2 == Unsubscribed.INSTANCE) {
            if (zacVar != null) {
                zacVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(zacVar2, zacVar)) {
            return true;
        } else {
            zac zacVar3 = get();
            if (zacVar != null) {
                zacVar.unsubscribe();
            }
            if (zacVar3 != Unsubscribed.INSTANCE) {
                return false;
            }
            return true;
        }
    }
}
