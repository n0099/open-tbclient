package rx.internal.operators;

import com.baidu.tieba.e1b;
import com.baidu.tieba.m1b;
import com.baidu.tieba.m5b;
import com.baidu.tieba.v1b;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes9.dex */
public final class CompletableFromEmitter$FromEmitter extends AtomicBoolean implements m1b {
    public static final long serialVersionUID = 5539301318568668881L;
    public final e1b actual;
    public final SequentialSubscription resource = new SequentialSubscription();

    public CompletableFromEmitter$FromEmitter(e1b e1bVar) {
        this.actual = e1bVar;
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
        m5b.j(th);
    }

    public void setCancellation(v1b v1bVar) {
        setSubscription(new CancellableSubscription(v1bVar));
    }

    public void setSubscription(m1b m1bVar) {
        this.resource.update(m1bVar);
    }

    @Override // com.baidu.tieba.m1b
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

    @Override // com.baidu.tieba.m1b
    public void unsubscribe() {
        if (compareAndSet(false, true)) {
            this.resource.unsubscribe();
        }
    }
}
