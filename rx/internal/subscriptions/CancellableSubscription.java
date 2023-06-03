package rx.internal.subscriptions;

import com.baidu.tieba.pmb;
import com.baidu.tieba.sqb;
import com.baidu.tieba.umb;
import com.baidu.tieba.ymb;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class CancellableSubscription extends AtomicReference<ymb> implements pmb {
    public static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(ymb ymbVar) {
        super(ymbVar);
    }

    @Override // com.baidu.tieba.pmb
    public boolean isUnsubscribed() {
        if (get() == null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.pmb
    public void unsubscribe() {
        ymb andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            try {
                andSet.cancel();
            } catch (Exception e) {
                umb.e(e);
                sqb.j(e);
            }
        }
    }
}
