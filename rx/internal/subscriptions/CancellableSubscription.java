package rx.internal.subscriptions;

import com.baidu.tieba.o6c;
import com.baidu.tieba.t6c;
import com.baidu.tieba.xac;
import com.baidu.tieba.y6c;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class CancellableSubscription extends AtomicReference<y6c> implements o6c {
    public static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(y6c y6cVar) {
        super(y6cVar);
    }

    @Override // com.baidu.tieba.o6c
    public boolean isUnsubscribed() {
        if (get() == null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.o6c
    public void unsubscribe() {
        y6c andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            try {
                andSet.cancel();
            } catch (Exception e) {
                t6c.e(e);
                xac.j(e);
            }
        }
    }
}
