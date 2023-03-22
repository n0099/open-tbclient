package rx.internal.subscriptions;

import com.baidu.tieba.asa;
import com.baidu.tieba.esa;
import com.baidu.tieba.vra;
import com.baidu.tieba.vva;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class CancellableSubscription extends AtomicReference<esa> implements vra {
    public static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(esa esaVar) {
        super(esaVar);
    }

    @Override // com.baidu.tieba.vra
    public boolean isUnsubscribed() {
        if (get() == null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.vra
    public void unsubscribe() {
        esa andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            try {
                andSet.cancel();
            } catch (Exception e) {
                asa.e(e);
                vva.j(e);
            }
        }
    }
}
