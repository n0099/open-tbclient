package rx.internal.operators;

import com.baidu.tieba.d2b;
import com.baidu.tieba.m1b;
import com.baidu.tieba.u1b;
import com.baidu.tieba.u5b;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes9.dex */
public final class CompletableFromEmitter$FromEmitter extends AtomicBoolean implements u1b {
    public static final long serialVersionUID = 5539301318568668881L;
    public final m1b actual;
    public final SequentialSubscription resource = new SequentialSubscription();

    public CompletableFromEmitter$FromEmitter(m1b m1bVar) {
        this.actual = m1bVar;
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
        u5b.j(th);
    }

    public void setCancellation(d2b d2bVar) {
        setSubscription(new CancellableSubscription(d2bVar));
    }

    public void setSubscription(u1b u1bVar) {
        this.resource.update(u1bVar);
    }

    @Override // com.baidu.tieba.u1b
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

    @Override // com.baidu.tieba.u1b
    public void unsubscribe() {
        if (compareAndSet(false, true)) {
            this.resource.unsubscribe();
        }
    }
}
