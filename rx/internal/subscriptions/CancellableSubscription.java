package rx.internal.subscriptions;

import com.baidu.tieba.e1c;
import com.baidu.tieba.j1c;
import com.baidu.tieba.k5c;
import com.baidu.tieba.n1c;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class CancellableSubscription extends AtomicReference<n1c> implements e1c {
    public static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(n1c n1cVar) {
        super(n1cVar);
    }

    @Override // com.baidu.tieba.e1c
    public boolean isUnsubscribed() {
        if (get() == null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.e1c
    public void unsubscribe() {
        n1c andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            try {
                andSet.cancel();
            } catch (Exception e) {
                j1c.e(e);
                k5c.j(e);
            }
        }
    }
}
