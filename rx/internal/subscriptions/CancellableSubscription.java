package rx.internal.subscriptions;

import com.baidu.tieba.bdc;
import com.baidu.tieba.rcc;
import com.baidu.tieba.wcc;
import com.baidu.tieba.ygc;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class CancellableSubscription extends AtomicReference<bdc> implements rcc {
    public static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(bdc bdcVar) {
        super(bdcVar);
    }

    @Override // com.baidu.tieba.rcc
    public boolean isUnsubscribed() {
        if (get() == null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.rcc
    public void unsubscribe() {
        bdc andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            try {
                andSet.cancel();
            } catch (Exception e) {
                wcc.e(e);
                ygc.j(e);
            }
        }
    }
}
