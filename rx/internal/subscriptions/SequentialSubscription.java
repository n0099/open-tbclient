package rx.internal.subscriptions;

import com.baidu.tieba.b6c;
import com.baidu.tieba.f1c;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class SequentialSubscription extends AtomicReference<f1c> implements f1c {
    public static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public f1c current() {
        f1c f1cVar = (f1c) super.get();
        if (f1cVar == Unsubscribed.INSTANCE) {
            return b6c.c();
        }
        return f1cVar;
    }

    @Override // com.baidu.tieba.f1c
    public boolean isUnsubscribed() {
        if (get() == Unsubscribed.INSTANCE) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.f1c
    public void unsubscribe() {
        f1c andSet;
        f1c f1cVar = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (f1cVar != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != Unsubscribed.INSTANCE) {
            andSet.unsubscribe();
        }
    }

    public SequentialSubscription(f1c f1cVar) {
        lazySet(f1cVar);
    }

    public boolean replace(f1c f1cVar) {
        f1c f1cVar2;
        do {
            f1cVar2 = get();
            if (f1cVar2 == Unsubscribed.INSTANCE) {
                if (f1cVar != null) {
                    f1cVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(f1cVar2, f1cVar));
        return true;
    }

    public boolean replaceWeak(f1c f1cVar) {
        f1c f1cVar2 = get();
        if (f1cVar2 == Unsubscribed.INSTANCE) {
            if (f1cVar != null) {
                f1cVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(f1cVar2, f1cVar) || get() != Unsubscribed.INSTANCE) {
            return true;
        } else {
            if (f1cVar != null) {
                f1cVar.unsubscribe();
            }
            return false;
        }
    }

    public boolean update(f1c f1cVar) {
        f1c f1cVar2;
        do {
            f1cVar2 = get();
            if (f1cVar2 == Unsubscribed.INSTANCE) {
                if (f1cVar != null) {
                    f1cVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(f1cVar2, f1cVar));
        if (f1cVar2 != null) {
            f1cVar2.unsubscribe();
            return true;
        }
        return true;
    }

    public boolean updateWeak(f1c f1cVar) {
        f1c f1cVar2 = get();
        if (f1cVar2 == Unsubscribed.INSTANCE) {
            if (f1cVar != null) {
                f1cVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(f1cVar2, f1cVar)) {
            return true;
        } else {
            f1c f1cVar3 = get();
            if (f1cVar != null) {
                f1cVar.unsubscribe();
            }
            if (f1cVar3 != Unsubscribed.INSTANCE) {
                return false;
            }
            return true;
        }
    }
}
