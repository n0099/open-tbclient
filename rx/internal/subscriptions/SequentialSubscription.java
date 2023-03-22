package rx.internal.subscriptions;

import com.baidu.tieba.lwa;
import com.baidu.tieba.vra;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class SequentialSubscription extends AtomicReference<vra> implements vra {
    public static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public vra current() {
        vra vraVar = (vra) super.get();
        if (vraVar == Unsubscribed.INSTANCE) {
            return lwa.c();
        }
        return vraVar;
    }

    @Override // com.baidu.tieba.vra
    public boolean isUnsubscribed() {
        if (get() == Unsubscribed.INSTANCE) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.vra
    public void unsubscribe() {
        vra andSet;
        vra vraVar = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (vraVar != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != Unsubscribed.INSTANCE) {
            andSet.unsubscribe();
        }
    }

    public SequentialSubscription(vra vraVar) {
        lazySet(vraVar);
    }

    public boolean replace(vra vraVar) {
        vra vraVar2;
        do {
            vraVar2 = get();
            if (vraVar2 == Unsubscribed.INSTANCE) {
                if (vraVar != null) {
                    vraVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(vraVar2, vraVar));
        return true;
    }

    public boolean replaceWeak(vra vraVar) {
        vra vraVar2 = get();
        if (vraVar2 == Unsubscribed.INSTANCE) {
            if (vraVar != null) {
                vraVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(vraVar2, vraVar) || get() != Unsubscribed.INSTANCE) {
            return true;
        } else {
            if (vraVar != null) {
                vraVar.unsubscribe();
            }
            return false;
        }
    }

    public boolean update(vra vraVar) {
        vra vraVar2;
        do {
            vraVar2 = get();
            if (vraVar2 == Unsubscribed.INSTANCE) {
                if (vraVar != null) {
                    vraVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(vraVar2, vraVar));
        if (vraVar2 != null) {
            vraVar2.unsubscribe();
            return true;
        }
        return true;
    }

    public boolean updateWeak(vra vraVar) {
        vra vraVar2 = get();
        if (vraVar2 == Unsubscribed.INSTANCE) {
            if (vraVar != null) {
                vraVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(vraVar2, vraVar)) {
            return true;
        } else {
            vra vraVar3 = get();
            if (vraVar != null) {
                vraVar.unsubscribe();
            }
            if (vraVar3 != Unsubscribed.INSTANCE) {
                return false;
            }
            return true;
        }
    }
}
