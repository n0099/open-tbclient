package rx.internal.operators;

import com.baidu.tieba.h7b;
import com.baidu.tieba.p7b;
import com.baidu.tieba.sbb;
import com.baidu.tieba.y7b;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes10.dex */
public final class CompletableFromEmitter$FromEmitter extends AtomicBoolean implements p7b {
    public static final long serialVersionUID = 5539301318568668881L;
    public final h7b actual;
    public final SequentialSubscription resource = new SequentialSubscription();

    public CompletableFromEmitter$FromEmitter(h7b h7bVar) {
        this.actual = h7bVar;
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
        sbb.j(th);
    }

    public void setCancellation(y7b y7bVar) {
        setSubscription(new CancellableSubscription(y7bVar));
    }

    public void setSubscription(p7b p7bVar) {
        this.resource.update(p7bVar);
    }

    @Override // com.baidu.tieba.p7b
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

    @Override // com.baidu.tieba.p7b
    public void unsubscribe() {
        if (compareAndSet(false, true)) {
            this.resource.unsubscribe();
        }
    }
}
