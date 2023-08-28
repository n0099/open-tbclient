package rx.internal.operators;

import com.baidu.tieba.dcc;
import com.baidu.tieba.g8c;
import com.baidu.tieba.o7c;
import com.baidu.tieba.w7c;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableFromEmitter$FromEmitter extends AtomicBoolean implements w7c {
    public static final long serialVersionUID = 5539301318568668881L;
    public final o7c actual;
    public final SequentialSubscription resource = new SequentialSubscription();

    public CompletableFromEmitter$FromEmitter(o7c o7cVar) {
        this.actual = o7cVar;
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
        dcc.j(th);
    }

    public void setCancellation(g8c g8cVar) {
        setSubscription(new CancellableSubscription(g8cVar));
    }

    public void setSubscription(w7c w7cVar) {
        this.resource.update(w7cVar);
    }

    @Override // com.baidu.tieba.w7c
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

    @Override // com.baidu.tieba.w7c
    public void unsubscribe() {
        if (compareAndSet(false, true)) {
            this.resource.unsubscribe();
        }
    }
}
