package rx.internal.subscriptions;

import com.baidu.tieba.o7b;
import com.baidu.tieba.rbb;
import com.baidu.tieba.t7b;
import com.baidu.tieba.x7b;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes10.dex */
public final class CancellableSubscription extends AtomicReference<x7b> implements o7b {
    public static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(x7b x7bVar) {
        super(x7bVar);
    }

    @Override // com.baidu.tieba.o7b
    public boolean isUnsubscribed() {
        if (get() == null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.o7b
    public void unsubscribe() {
        x7b andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            try {
                andSet.cancel();
            } catch (Exception e) {
                t7b.e(e);
                rbb.j(e);
            }
        }
    }
}
