package rx.internal.subscriptions;

import com.baidu.tieba.b2c;
import com.baidu.tieba.x6c;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class SequentialSubscription extends AtomicReference<b2c> implements b2c {
    public static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public b2c current() {
        b2c b2cVar = (b2c) super.get();
        if (b2cVar == Unsubscribed.INSTANCE) {
            return x6c.c();
        }
        return b2cVar;
    }

    @Override // com.baidu.tieba.b2c
    public boolean isUnsubscribed() {
        if (get() == Unsubscribed.INSTANCE) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.b2c
    public void unsubscribe() {
        b2c andSet;
        b2c b2cVar = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (b2cVar != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != Unsubscribed.INSTANCE) {
            andSet.unsubscribe();
        }
    }

    public SequentialSubscription(b2c b2cVar) {
        lazySet(b2cVar);
    }

    public boolean replace(b2c b2cVar) {
        b2c b2cVar2;
        do {
            b2cVar2 = get();
            if (b2cVar2 == Unsubscribed.INSTANCE) {
                if (b2cVar != null) {
                    b2cVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(b2cVar2, b2cVar));
        return true;
    }

    public boolean replaceWeak(b2c b2cVar) {
        b2c b2cVar2 = get();
        if (b2cVar2 == Unsubscribed.INSTANCE) {
            if (b2cVar != null) {
                b2cVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(b2cVar2, b2cVar) || get() != Unsubscribed.INSTANCE) {
            return true;
        } else {
            if (b2cVar != null) {
                b2cVar.unsubscribe();
            }
            return false;
        }
    }

    public boolean update(b2c b2cVar) {
        b2c b2cVar2;
        do {
            b2cVar2 = get();
            if (b2cVar2 == Unsubscribed.INSTANCE) {
                if (b2cVar != null) {
                    b2cVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(b2cVar2, b2cVar));
        if (b2cVar2 != null) {
            b2cVar2.unsubscribe();
            return true;
        }
        return true;
    }

    public boolean updateWeak(b2c b2cVar) {
        b2c b2cVar2 = get();
        if (b2cVar2 == Unsubscribed.INSTANCE) {
            if (b2cVar != null) {
                b2cVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(b2cVar2, b2cVar)) {
            return true;
        } else {
            b2c b2cVar3 = get();
            if (b2cVar != null) {
                b2cVar.unsubscribe();
            }
            if (b2cVar3 != Unsubscribed.INSTANCE) {
                return false;
            }
            return true;
        }
    }
}
