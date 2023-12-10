package rx.internal.subscriptions;

import com.baidu.tieba.loc;
import com.baidu.tieba.qoc;
import com.baidu.tieba.usc;
import com.baidu.tieba.voc;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class CancellableSubscription extends AtomicReference<voc> implements loc {
    public static final long serialVersionUID = 5718521705281392066L;

    public CancellableSubscription(voc vocVar) {
        super(vocVar);
    }

    @Override // com.baidu.tieba.loc
    public boolean isUnsubscribed() {
        if (get() == null) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.tieba.loc
    public void unsubscribe() {
        voc andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            try {
                andSet.cancel();
            } catch (Exception e) {
                qoc.e(e);
                usc.j(e);
            }
        }
    }
}
