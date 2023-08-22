package rx.internal.subscriptions;

import com.baidu.tieba.bcc;
import com.baidu.tieba.e8c;
import com.baidu.tieba.u7c;
import com.baidu.tieba.z7c;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class CancellableSubscription extends AtomicReference<e8c> implements u7c {
    public static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(e8c e8cVar) {
        super(e8cVar);
    }

    @Override // com.baidu.tieba.u7c
    public boolean isUnsubscribed() {
        if (get() == null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.u7c
    public void unsubscribe() {
        e8c andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            try {
                andSet.cancel();
            } catch (Exception e) {
                z7c.e(e);
                bcc.j(e);
            }
        }
    }
}
