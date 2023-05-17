package rx.internal.operators;

import com.baidu.tieba.g7b;
import com.baidu.tieba.o7b;
import com.baidu.tieba.rbb;
import com.baidu.tieba.x7b;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes10.dex */
public final class CompletableFromEmitter$FromEmitter extends AtomicBoolean implements o7b {
    public static final long serialVersionUID = 5539301318568668881L;
    public final g7b actual;
    public final SequentialSubscription resource = new SequentialSubscription();

    public CompletableFromEmitter$FromEmitter(g7b g7bVar) {
        this.actual = g7bVar;
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
        rbb.j(th);
    }

    public void setCancellation(x7b x7bVar) {
        setSubscription(new CancellableSubscription(x7bVar));
    }

    public void setSubscription(o7b o7bVar) {
        this.resource.update(o7bVar);
    }

    @Override // com.baidu.tieba.o7b
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

    @Override // com.baidu.tieba.o7b
    public void unsubscribe() {
        if (compareAndSet(false, true)) {
            this.resource.unsubscribe();
        }
    }
}
