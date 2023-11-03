package rx.internal.operators;

import com.baidu.tieba.hjc;
import com.baidu.tieba.pjc;
import com.baidu.tieba.ync;
import com.baidu.tieba.zjc;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableFromEmitter$FromEmitter extends AtomicBoolean implements pjc {
    public static final long serialVersionUID = 5539301318568668881L;
    public final hjc actual;
    public final SequentialSubscription resource = new SequentialSubscription();

    public CompletableFromEmitter$FromEmitter(hjc hjcVar) {
        this.actual = hjcVar;
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
        ync.j(th);
    }

    public void setCancellation(zjc zjcVar) {
        setSubscription(new CancellableSubscription(zjcVar));
    }

    public void setSubscription(pjc pjcVar) {
        this.resource.update(pjcVar);
    }

    @Override // com.baidu.tieba.pjc
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

    @Override // com.baidu.tieba.pjc
    public void unsubscribe() {
        if (compareAndSet(false, true)) {
            this.resource.unsubscribe();
        }
    }
}
