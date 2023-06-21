package rx.internal.subscriptions;

import com.baidu.tieba.nob;
import com.baidu.tieba.qsb;
import com.baidu.tieba.sob;
import com.baidu.tieba.wob;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class CancellableSubscription extends AtomicReference<wob> implements nob {
    public static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(wob wobVar) {
        super(wobVar);
    }

    @Override // com.baidu.tieba.nob
    public boolean isUnsubscribed() {
        if (get() == null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.nob
    public void unsubscribe() {
        wob andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            try {
                andSet.cancel();
            } catch (Exception e) {
                sob.e(e);
                qsb.j(e);
            }
        }
    }
}
