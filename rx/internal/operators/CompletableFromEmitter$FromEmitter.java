package rx.internal.operators;

import com.baidu.tieba.hmb;
import com.baidu.tieba.pmb;
import com.baidu.tieba.sqb;
import com.baidu.tieba.ymb;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableFromEmitter$FromEmitter extends AtomicBoolean implements pmb {
    public static final long serialVersionUID = 5539301318568668881L;
    public final hmb actual;
    public final SequentialSubscription resource = new SequentialSubscription();

    public CompletableFromEmitter$FromEmitter(hmb hmbVar) {
        this.actual = hmbVar;
    }

    public void onError(Throwable th) {
        if (compareAndSet(false, true)) {
            try {
                this.actual.onError(th);
                return;
            } finally {
                this.resource.unsubscribe();
            }
        }
        sqb.j(th);
    }

    public void setCancellation(ymb ymbVar) {
        setSubscription(new CancellableSubscription(ymbVar));
    }

    public void setSubscription(pmb pmbVar) {
        this.resource.update(pmbVar);
    }

    @Override // com.baidu.tieba.pmb
    public boolean isUnsubscribed() {
        return get();
    }

    public void onCompleted() {
        if (compareAndSet(false, true)) {
            try {
                this.actual.onCompleted();
            } finally {
                this.resource.unsubscribe();
            }
        }
    }

    @Override // com.baidu.tieba.pmb
    public void unsubscribe() {
        if (compareAndSet(false, true)) {
            this.resource.unsubscribe();
        }
    }
}
