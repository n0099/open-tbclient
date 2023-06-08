package rx.internal.subscriptions;

import com.baidu.tieba.dnb;
import com.baidu.tieba.umb;
import com.baidu.tieba.xqb;
import com.baidu.tieba.zmb;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class CancellableSubscription extends AtomicReference<dnb> implements umb {
    public static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(dnb dnbVar) {
        super(dnbVar);
    }

    @Override // com.baidu.tieba.umb
    public boolean isUnsubscribed() {
        if (get() == null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.umb
    public void unsubscribe() {
        dnb andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            try {
                andSet.cancel();
            } catch (Exception e) {
                zmb.e(e);
                xqb.j(e);
            }
        }
    }
}
