package rx.internal.operators;

import com.baidu.tieba.etb;
import com.baidu.tieba.kxb;
import com.baidu.tieba.ntb;
import com.baidu.tieba.wsb;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableFromEmitter$FromEmitter extends AtomicBoolean implements etb {
    public static final long serialVersionUID = 5539301318568668881L;
    public final wsb actual;
    public final SequentialSubscription resource = new SequentialSubscription();

    public CompletableFromEmitter$FromEmitter(wsb wsbVar) {
        this.actual = wsbVar;
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
        kxb.j(th);
    }

    public void setCancellation(ntb ntbVar) {
        setSubscription(new CancellableSubscription(ntbVar));
    }

    public void setSubscription(etb etbVar) {
        this.resource.update(etbVar);
    }

    @Override // com.baidu.tieba.etb
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

    @Override // com.baidu.tieba.etb
    public void unsubscribe() {
        if (compareAndSet(false, true)) {
            this.resource.unsubscribe();
        }
    }
}
