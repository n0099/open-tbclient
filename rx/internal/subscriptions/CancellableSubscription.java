package rx.internal.subscriptions;

import com.baidu.tieba.d2b;
import com.baidu.tieba.u1b;
import com.baidu.tieba.u5b;
import com.baidu.tieba.z1b;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class CancellableSubscription extends AtomicReference<d2b> implements u1b {
    public static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(d2b d2bVar) {
        super(d2bVar);
    }

    @Override // com.baidu.tieba.u1b
    public boolean isUnsubscribed() {
        if (get() == null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.u1b
    public void unsubscribe() {
        d2b andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            try {
                andSet.cancel();
            } catch (Exception e) {
                z1b.e(e);
                u5b.j(e);
            }
        }
    }
}
