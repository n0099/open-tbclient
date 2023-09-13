package rx.internal.subscriptions;

import com.baidu.tieba.ebc;
import com.baidu.tieba.gfc;
import com.baidu.tieba.jbc;
import com.baidu.tieba.zac;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class CancellableSubscription extends AtomicReference<jbc> implements zac {
    public static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(jbc jbcVar) {
        super(jbcVar);
    }

    @Override // com.baidu.tieba.zac
    public boolean isUnsubscribed() {
        if (get() == null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.zac
    public void unsubscribe() {
        jbc andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            try {
                andSet.cancel();
            } catch (Exception e) {
                ebc.e(e);
                gfc.j(e);
            }
        }
    }
}
