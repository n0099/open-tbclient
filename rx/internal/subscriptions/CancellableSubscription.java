package rx.internal.subscriptions;

import com.baidu.tieba.f1c;
import com.baidu.tieba.k1c;
import com.baidu.tieba.l5c;
import com.baidu.tieba.o1c;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class CancellableSubscription extends AtomicReference<o1c> implements f1c {
    public static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(o1c o1cVar) {
        super(o1cVar);
    }

    @Override // com.baidu.tieba.f1c
    public boolean isUnsubscribed() {
        if (get() == null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.f1c
    public void unsubscribe() {
        o1c andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            try {
                andSet.cancel();
            } catch (Exception e) {
                k1c.e(e);
                l5c.j(e);
            }
        }
    }
}
