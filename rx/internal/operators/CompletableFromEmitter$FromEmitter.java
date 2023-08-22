package rx.internal.operators;

import com.baidu.tieba.bcc;
import com.baidu.tieba.e8c;
import com.baidu.tieba.m7c;
import com.baidu.tieba.u7c;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableFromEmitter$FromEmitter extends AtomicBoolean implements u7c {
    public static final long serialVersionUID = 5539301318568668881L;
    public final m7c actual;
    public final SequentialSubscription resource = new SequentialSubscription();

    public CompletableFromEmitter$FromEmitter(m7c m7cVar) {
        this.actual = m7cVar;
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
        bcc.j(th);
    }

    public void setCancellation(e8c e8cVar) {
        setSubscription(new CancellableSubscription(e8cVar));
    }

    public void setSubscription(u7c u7cVar) {
        this.resource.update(u7cVar);
    }

    @Override // com.baidu.tieba.u7c
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

    @Override // com.baidu.tieba.u7c
    public void unsubscribe() {
        if (compareAndSet(false, true)) {
            this.resource.unsubscribe();
        }
    }
}
