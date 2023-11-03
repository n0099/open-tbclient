package rx.internal.subscriptions;

import com.baidu.tieba.pjc;
import com.baidu.tieba.ujc;
import com.baidu.tieba.ync;
import com.baidu.tieba.zjc;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class CancellableSubscription extends AtomicReference<zjc> implements pjc {
    public static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(zjc zjcVar) {
        super(zjcVar);
    }

    @Override // com.baidu.tieba.pjc
    public boolean isUnsubscribed() {
        if (get() == null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.pjc
    public void unsubscribe() {
        zjc andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            try {
                andSet.cancel();
            } catch (Exception e) {
                ujc.e(e);
                ync.j(e);
            }
        }
    }
}
