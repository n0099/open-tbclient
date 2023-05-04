package rx.internal.subscriptions;

import com.baidu.tieba.q5b;
import com.baidu.tieba.s9b;
import com.baidu.tieba.v5b;
import com.baidu.tieba.z5b;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class CancellableSubscription extends AtomicReference<z5b> implements q5b {
    public static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(z5b z5bVar) {
        super(z5bVar);
    }

    @Override // com.baidu.tieba.q5b
    public boolean isUnsubscribed() {
        if (get() == null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.q5b
    public void unsubscribe() {
        z5b andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            try {
                andSet.cancel();
            } catch (Exception e) {
                v5b.e(e);
                s9b.j(e);
            }
        }
    }
}
