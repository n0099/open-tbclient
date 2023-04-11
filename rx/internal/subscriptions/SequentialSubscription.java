package rx.internal.subscriptions;

import com.baidu.tieba.c6b;
import com.baidu.tieba.m1b;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class SequentialSubscription extends AtomicReference<m1b> implements m1b {
    public static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    public m1b current() {
        m1b m1bVar = (m1b) super.get();
        if (m1bVar == Unsubscribed.INSTANCE) {
            return c6b.c();
        }
        return m1bVar;
    }

    @Override // com.baidu.tieba.m1b
    public boolean isUnsubscribed() {
        if (get() == Unsubscribed.INSTANCE) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.m1b
    public void unsubscribe() {
        m1b andSet;
        m1b m1bVar = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (m1bVar != unsubscribed && (andSet = getAndSet(unsubscribed)) != null && andSet != Unsubscribed.INSTANCE) {
            andSet.unsubscribe();
        }
    }

    public SequentialSubscription(m1b m1bVar) {
        lazySet(m1bVar);
    }

    public boolean replace(m1b m1bVar) {
        m1b m1bVar2;
        do {
            m1bVar2 = get();
            if (m1bVar2 == Unsubscribed.INSTANCE) {
                if (m1bVar != null) {
                    m1bVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(m1bVar2, m1bVar));
        return true;
    }

    public boolean replaceWeak(m1b m1bVar) {
        m1b m1bVar2 = get();
        if (m1bVar2 == Unsubscribed.INSTANCE) {
            if (m1bVar != null) {
                m1bVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(m1bVar2, m1bVar) || get() != Unsubscribed.INSTANCE) {
            return true;
        } else {
            if (m1bVar != null) {
                m1bVar.unsubscribe();
            }
            return false;
        }
    }

    public boolean update(m1b m1bVar) {
        m1b m1bVar2;
        do {
            m1bVar2 = get();
            if (m1bVar2 == Unsubscribed.INSTANCE) {
                if (m1bVar != null) {
                    m1bVar.unsubscribe();
                    return false;
                }
                return false;
            }
        } while (!compareAndSet(m1bVar2, m1bVar));
        if (m1bVar2 != null) {
            m1bVar2.unsubscribe();
            return true;
        }
        return true;
    }

    public boolean updateWeak(m1b m1bVar) {
        m1b m1bVar2 = get();
        if (m1bVar2 == Unsubscribed.INSTANCE) {
            if (m1bVar != null) {
                m1bVar.unsubscribe();
            }
            return false;
        } else if (compareAndSet(m1bVar2, m1bVar)) {
            return true;
        } else {
            m1b m1bVar3 = get();
            if (m1bVar != null) {
                m1bVar.unsubscribe();
            }
            if (m1bVar3 != Unsubscribed.INSTANCE) {
                return false;
            }
            return true;
        }
    }
}
