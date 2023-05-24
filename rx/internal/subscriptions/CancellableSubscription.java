package rx.internal.subscriptions;

import com.baidu.tieba.p7b;
import com.baidu.tieba.sbb;
import com.baidu.tieba.u7b;
import com.baidu.tieba.y7b;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes10.dex */
public final class CancellableSubscription extends AtomicReference<y7b> implements p7b {
    public static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(y7b y7bVar) {
        super(y7bVar);
    }

    @Override // com.baidu.tieba.p7b
    public boolean isUnsubscribed() {
        if (get() == null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.p7b
    public void unsubscribe() {
        y7b andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            try {
                andSet.cancel();
            } catch (Exception e) {
                u7b.e(e);
                sbb.j(e);
            }
        }
    }
}
