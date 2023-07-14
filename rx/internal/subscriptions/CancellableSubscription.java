package rx.internal.subscriptions;

import com.baidu.tieba.b2c;
import com.baidu.tieba.g2c;
import com.baidu.tieba.h6c;
import com.baidu.tieba.k2c;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class CancellableSubscription extends AtomicReference<k2c> implements b2c {
    public static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(k2c k2cVar) {
        super(k2cVar);
    }

    @Override // com.baidu.tieba.b2c
    public boolean isUnsubscribed() {
        if (get() == null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.b2c
    public void unsubscribe() {
        k2c andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            try {
                andSet.cancel();
            } catch (Exception e) {
                g2c.e(e);
                h6c.j(e);
            }
        }
    }
}
