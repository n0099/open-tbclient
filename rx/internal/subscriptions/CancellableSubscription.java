package rx.internal.subscriptions;

import com.baidu.tieba.koc;
import com.baidu.tieba.poc;
import com.baidu.tieba.tsc;
import com.baidu.tieba.uoc;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class CancellableSubscription extends AtomicReference<uoc> implements koc {
    public static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(uoc uocVar) {
        super(uocVar);
    }

    @Override // com.baidu.tieba.koc
    public boolean isUnsubscribed() {
        if (get() == null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.koc
    public void unsubscribe() {
        uoc andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            try {
                andSet.cancel();
            } catch (Exception e) {
                poc.e(e);
                tsc.j(e);
            }
        }
    }
}
