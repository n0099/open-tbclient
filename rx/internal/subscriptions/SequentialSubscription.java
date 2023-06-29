package rx.internal.subscriptions;

import com.baidu.tieba.ayb;
import com.baidu.tieba.etb;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class SequentialSubscription extends AtomicReference<etb> implements etb {
    public static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public etb current() {
        etb etbVar = (etb) super.get();
        if (etbVar == Unsubscribed.INSTANCE) {
            return ayb.c();
        }
        return etbVar;
    }

    @Override // com.baidu.tieba.etb
    public boolean isUnsubscribed() {
        if (get() == Unsubscribed.INSTANCE) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.etb
    public void unsubscribe() {
        etb andSet;
        etb etbVar = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (etbVar != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != Unsubscribed.INSTANCE) {
            andSet.unsubscribe();
        }
    }

    public SequentialSubscription(etb etbVar) {
        lazySet(etbVar);
    }

    public boolean replace(etb etbVar) {
        etb etbVar2;
        do {
            etbVar2 = get();
            if (etbVar2 == Unsubscribed.INSTANCE) {
                if (etbVar != null) {
                    etbVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(etbVar2, etbVar));
        return true;
    }

    public boolean replaceWeak(etb etbVar) {
        etb etbVar2 = get();
        if (etbVar2 == Unsubscribed.INSTANCE) {
            if (etbVar != null) {
                etbVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(etbVar2, etbVar) || get() != Unsubscribed.INSTANCE) {
            return true;
        } else {
            if (etbVar != null) {
                etbVar.unsubscribe();
            }
            return false;
        }
    }

    public boolean update(etb etbVar) {
        etb etbVar2;
        do {
            etbVar2 = get();
            if (etbVar2 == Unsubscribed.INSTANCE) {
                if (etbVar != null) {
                    etbVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(etbVar2, etbVar));
        if (etbVar2 != null) {
            etbVar2.unsubscribe();
            return true;
        }
        return true;
    }

    public boolean updateWeak(etb etbVar) {
        etb etbVar2 = get();
        if (etbVar2 == Unsubscribed.INSTANCE) {
            if (etbVar != null) {
                etbVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(etbVar2, etbVar)) {
            return true;
        } else {
            etb etbVar3 = get();
            if (etbVar != null) {
                etbVar.unsubscribe();
            }
            if (etbVar3 != Unsubscribed.INSTANCE) {
                return false;
            }
            return true;
        }
    }
}
