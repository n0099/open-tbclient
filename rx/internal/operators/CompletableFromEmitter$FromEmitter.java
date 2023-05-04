package rx.internal.operators;

import com.baidu.tieba.i5b;
import com.baidu.tieba.q5b;
import com.baidu.tieba.s9b;
import com.baidu.tieba.z5b;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes9.dex */
public final class CompletableFromEmitter$FromEmitter extends AtomicBoolean implements q5b {
    public static final long serialVersionUID = 5539301318568668881L;
    public final i5b actual;
    public final SequentialSubscription resource = new SequentialSubscription();

    public CompletableFromEmitter$FromEmitter(i5b i5bVar) {
        this.actual = i5bVar;
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
        s9b.j(th);
    }

    public void setCancellation(z5b z5bVar) {
        setSubscription(new CancellableSubscription(z5bVar));
    }

    public void setSubscription(q5b q5bVar) {
        this.resource.update(q5bVar);
    }

    @Override // com.baidu.tieba.q5b
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

    @Override // com.baidu.tieba.q5b
    public void unsubscribe() {
        if (compareAndSet(false, true)) {
            this.resource.unsubscribe();
        }
    }
}
