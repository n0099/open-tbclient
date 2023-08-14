package rx.internal.operators;

import com.baidu.tieba.f1c;
import com.baidu.tieba.l5c;
import com.baidu.tieba.o1c;
import com.baidu.tieba.x0c;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableFromEmitter$FromEmitter extends AtomicBoolean implements f1c {
    public static final long serialVersionUID = 5539301318568668881L;
    public final x0c actual;
    public final SequentialSubscription resource = new SequentialSubscription();

    public CompletableFromEmitter$FromEmitter(x0c x0cVar) {
        this.actual = x0cVar;
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
        l5c.j(th);
    }

    public void setCancellation(o1c o1cVar) {
        setSubscription(new CancellableSubscription(o1cVar));
    }

    public void setSubscription(f1c f1cVar) {
        this.resource.update(f1cVar);
    }

    @Override // com.baidu.tieba.f1c
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

    @Override // com.baidu.tieba.f1c
    public void unsubscribe() {
        if (compareAndSet(false, true)) {
            this.resource.unsubscribe();
        }
    }
}
