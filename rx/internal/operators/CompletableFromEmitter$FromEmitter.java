package rx.internal.operators;

import com.baidu.tieba.e1c;
import com.baidu.tieba.k5c;
import com.baidu.tieba.n1c;
import com.baidu.tieba.w0c;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableFromEmitter$FromEmitter extends AtomicBoolean implements e1c {
    public static final long serialVersionUID = 5539301318568668881L;
    public final w0c actual;
    public final SequentialSubscription resource = new SequentialSubscription();

    public CompletableFromEmitter$FromEmitter(w0c w0cVar) {
        this.actual = w0cVar;
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
        k5c.j(th);
    }

    public void setCancellation(n1c n1cVar) {
        setSubscription(new CancellableSubscription(n1cVar));
    }

    public void setSubscription(e1c e1cVar) {
        this.resource.update(e1cVar);
    }

    @Override // com.baidu.tieba.e1c
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

    @Override // com.baidu.tieba.e1c
    public void unsubscribe() {
        if (compareAndSet(false, true)) {
            this.resource.unsubscribe();
        }
    }
}
