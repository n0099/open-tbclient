package rx.internal.subscriptions;

import com.baidu.tieba.m1b;
import com.baidu.tieba.m5b;
import com.baidu.tieba.r1b;
import com.baidu.tieba.v1b;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class CancellableSubscription extends AtomicReference<v1b> implements m1b {
    public static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(v1b v1bVar) {
        super(v1bVar);
    }

    @Override // com.baidu.tieba.m1b
    public boolean isUnsubscribed() {
        if (get() == null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.m1b
    public void unsubscribe() {
        v1b andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            try {
                andSet.cancel();
            } catch (Exception e) {
                r1b.e(e);
                m5b.j(e);
            }
        }
    }
}
