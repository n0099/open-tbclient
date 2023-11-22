package rx.internal.subscriptions;

import com.baidu.tieba.poc;
import com.baidu.tieba.qjc;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class SequentialSubscription extends AtomicReference<qjc> implements qjc {
    public static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public qjc current() {
        qjc qjcVar = (qjc) super.get();
        if (qjcVar == Unsubscribed.INSTANCE) {
            return poc.c();
        }
        return qjcVar;
    }

    @Override // com.baidu.tieba.qjc
    public boolean isUnsubscribed() {
        if (get() == Unsubscribed.INSTANCE) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.qjc
    public void unsubscribe() {
        qjc andSet;
        qjc qjcVar = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (qjcVar != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != Unsubscribed.INSTANCE) {
            andSet.unsubscribe();
        }
    }

    public SequentialSubscription(qjc qjcVar) {
        lazySet(qjcVar);
    }

    public boolean replace(qjc qjcVar) {
        qjc qjcVar2;
        do {
            qjcVar2 = get();
            if (qjcVar2 == Unsubscribed.INSTANCE) {
                if (qjcVar != null) {
                    qjcVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(qjcVar2, qjcVar));
        return true;
    }

    public boolean replaceWeak(qjc qjcVar) {
        qjc qjcVar2 = get();
        if (qjcVar2 == Unsubscribed.INSTANCE) {
            if (qjcVar != null) {
                qjcVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(qjcVar2, qjcVar) || get() != Unsubscribed.INSTANCE) {
            return true;
        } else {
            if (qjcVar != null) {
                qjcVar.unsubscribe();
            }
            return false;
        }
    }

    public boolean update(qjc qjcVar) {
        qjc qjcVar2;
        do {
            qjcVar2 = get();
            if (qjcVar2 == Unsubscribed.INSTANCE) {
                if (qjcVar != null) {
                    qjcVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(qjcVar2, qjcVar));
        if (qjcVar2 != null) {
            qjcVar2.unsubscribe();
            return true;
        }
        return true;
    }

    public boolean updateWeak(qjc qjcVar) {
        qjc qjcVar2 = get();
        if (qjcVar2 == Unsubscribed.INSTANCE) {
            if (qjcVar != null) {
                qjcVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(qjcVar2, qjcVar)) {
            return true;
        } else {
            qjc qjcVar3 = get();
            if (qjcVar != null) {
                qjcVar.unsubscribe();
            }
            if (qjcVar3 != Unsubscribed.INSTANCE) {
                return false;
            }
            return true;
        }
    }
}
