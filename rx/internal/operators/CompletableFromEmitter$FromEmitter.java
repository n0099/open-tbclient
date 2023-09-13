package rx.internal.operators;

import com.baidu.tieba.gfc;
import com.baidu.tieba.jbc;
import com.baidu.tieba.rac;
import com.baidu.tieba.zac;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableFromEmitter$FromEmitter extends AtomicBoolean implements zac {
    public static final long serialVersionUID = 5539301318568668881L;
    public final rac actual;
    public final SequentialSubscription resource = new SequentialSubscription();

    public CompletableFromEmitter$FromEmitter(rac racVar) {
        this.actual = racVar;
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
        gfc.j(th);
    }

    public void setCancellation(jbc jbcVar) {
        setSubscription(new CancellableSubscription(jbcVar));
    }

    public void setSubscription(zac zacVar) {
        this.resource.update(zacVar);
    }

    @Override // com.baidu.tieba.zac
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

    @Override // com.baidu.tieba.zac
    public void unsubscribe() {
        if (compareAndSet(false, true)) {
            this.resource.unsubscribe();
        }
    }
}
