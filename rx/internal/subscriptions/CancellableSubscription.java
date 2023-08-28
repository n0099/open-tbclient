package rx.internal.subscriptions;

import com.baidu.tieba.b8c;
import com.baidu.tieba.dcc;
import com.baidu.tieba.g8c;
import com.baidu.tieba.w7c;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class CancellableSubscription extends AtomicReference<g8c> implements w7c {
    public static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(g8c g8cVar) {
        super(g8cVar);
    }

    @Override // com.baidu.tieba.w7c
    public boolean isUnsubscribed() {
        if (get() == null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.w7c
    public void unsubscribe() {
        g8c andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            try {
                andSet.cancel();
            } catch (Exception e) {
                b8c.e(e);
                dcc.j(e);
            }
        }
    }
}
