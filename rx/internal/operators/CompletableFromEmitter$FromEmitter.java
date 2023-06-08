package rx.internal.operators;

import com.baidu.tieba.dnb;
import com.baidu.tieba.mmb;
import com.baidu.tieba.umb;
import com.baidu.tieba.xqb;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableFromEmitter$FromEmitter extends AtomicBoolean implements umb {
    public static final long serialVersionUID = 5539301318568668881L;
    public final mmb actual;
    public final SequentialSubscription resource = new SequentialSubscription();

    public CompletableFromEmitter$FromEmitter(mmb mmbVar) {
        this.actual = mmbVar;
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
        xqb.j(th);
    }

    public void setCancellation(dnb dnbVar) {
        setSubscription(new CancellableSubscription(dnbVar));
    }

    public void setSubscription(umb umbVar) {
        this.resource.update(umbVar);
    }

    @Override // com.baidu.tieba.umb
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

    @Override // com.baidu.tieba.umb
    public void unsubscribe() {
        if (compareAndSet(false, true)) {
            this.resource.unsubscribe();
        }
    }
}
