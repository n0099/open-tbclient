package rx.internal.operators;

import com.baidu.tieba.fob;
import com.baidu.tieba.nob;
import com.baidu.tieba.qsb;
import com.baidu.tieba.wob;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableFromEmitter$FromEmitter extends AtomicBoolean implements nob {
    public static final long serialVersionUID = 5539301318568668881L;
    public final fob actual;
    public final SequentialSubscription resource = new SequentialSubscription();

    public CompletableFromEmitter$FromEmitter(fob fobVar) {
        this.actual = fobVar;
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
        qsb.j(th);
    }

    public void setCancellation(wob wobVar) {
        setSubscription(new CancellableSubscription(wobVar));
    }

    public void setSubscription(nob nobVar) {
        this.resource.update(nobVar);
    }

    @Override // com.baidu.tieba.nob
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

    @Override // com.baidu.tieba.nob
    public void unsubscribe() {
        if (compareAndSet(false, true)) {
            this.resource.unsubscribe();
        }
    }
}
