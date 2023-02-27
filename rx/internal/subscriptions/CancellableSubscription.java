package rx.internal.subscriptions;

import com.baidu.tieba.ena;
import com.baidu.tieba.ina;
import com.baidu.tieba.zma;
import com.baidu.tieba.zqa;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class CancellableSubscription extends AtomicReference<ina> implements zma {
    public static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(ina inaVar) {
        super(inaVar);
    }

    @Override // com.baidu.tieba.zma
    public boolean isUnsubscribed() {
        if (get() == null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.zma
    public void unsubscribe() {
        ina andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            try {
                andSet.cancel();
            } catch (Exception e) {
                ena.e(e);
                zqa.j(e);
            }
        }
    }
}
