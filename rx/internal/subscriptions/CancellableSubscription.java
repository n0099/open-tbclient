package rx.internal.subscriptions;

import com.baidu.tieba.akc;
import com.baidu.tieba.qjc;
import com.baidu.tieba.vjc;
import com.baidu.tieba.znc;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class CancellableSubscription extends AtomicReference<akc> implements qjc {
    public static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(akc akcVar) {
        super(akcVar);
    }

    @Override // com.baidu.tieba.qjc
    public boolean isUnsubscribed() {
        if (get() == null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.qjc
    public void unsubscribe() {
        akc andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            try {
                andSet.cancel();
            } catch (Exception e) {
                vjc.e(e);
                znc.j(e);
            }
        }
    }
}
