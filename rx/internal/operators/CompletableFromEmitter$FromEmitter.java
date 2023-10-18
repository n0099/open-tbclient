package rx.internal.operators;

import com.baidu.tieba.g6c;
import com.baidu.tieba.o6c;
import com.baidu.tieba.xac;
import com.baidu.tieba.y6c;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableFromEmitter$FromEmitter extends AtomicBoolean implements o6c {
    public static final long serialVersionUID = 5539301318568668881L;
    public final g6c actual;
    public final SequentialSubscription resource = new SequentialSubscription();

    public CompletableFromEmitter$FromEmitter(g6c g6cVar) {
        this.actual = g6cVar;
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
        xac.j(th);
    }

    public void setCancellation(y6c y6cVar) {
        setSubscription(new CancellableSubscription(y6cVar));
    }

    public void setSubscription(o6c o6cVar) {
        this.resource.update(o6cVar);
    }

    @Override // com.baidu.tieba.o6c
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

    @Override // com.baidu.tieba.o6c
    public void unsubscribe() {
        if (compareAndSet(false, true)) {
            this.resource.unsubscribe();
        }
    }
}
