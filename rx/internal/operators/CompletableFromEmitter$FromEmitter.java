package rx.internal.operators;

import com.baidu.tieba.b2c;
import com.baidu.tieba.h6c;
import com.baidu.tieba.k2c;
import com.baidu.tieba.t1c;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableFromEmitter$FromEmitter extends AtomicBoolean implements b2c {
    public static final long serialVersionUID = 5539301318568668881L;
    public final t1c actual;
    public final SequentialSubscription resource = new SequentialSubscription();

    public CompletableFromEmitter$FromEmitter(t1c t1cVar) {
        this.actual = t1cVar;
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
        h6c.j(th);
    }

    public void setCancellation(k2c k2cVar) {
        setSubscription(new CancellableSubscription(k2cVar));
    }

    public void setSubscription(b2c b2cVar) {
        this.resource.update(b2cVar);
    }

    @Override // com.baidu.tieba.b2c
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

    @Override // com.baidu.tieba.b2c
    public void unsubscribe() {
        if (compareAndSet(false, true)) {
            this.resource.unsubscribe();
        }
    }
}
