package rx.internal.subscriptions;

import com.baidu.tieba.etb;
import com.baidu.tieba.jtb;
import com.baidu.tieba.kxb;
import com.baidu.tieba.ntb;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class CancellableSubscription extends AtomicReference<ntb> implements etb {
    public static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(ntb ntbVar) {
        super(ntbVar);
    }

    @Override // com.baidu.tieba.etb
    public boolean isUnsubscribed() {
        if (get() == null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.etb
    public void unsubscribe() {
        ntb andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            try {
                andSet.cancel();
            } catch (Exception e) {
                jtb.e(e);
                kxb.j(e);
            }
        }
    }
}
