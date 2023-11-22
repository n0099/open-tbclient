package rx.internal.operators;

import com.baidu.tieba.akc;
import com.baidu.tieba.ijc;
import com.baidu.tieba.qjc;
import com.baidu.tieba.znc;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableFromEmitter$FromEmitter extends AtomicBoolean implements qjc {
    public static final long serialVersionUID = 5539301318568668881L;
    public final ijc actual;
    public final SequentialSubscription resource = new SequentialSubscription();

    public CompletableFromEmitter$FromEmitter(ijc ijcVar) {
        this.actual = ijcVar;
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
        znc.j(th);
    }

    public void setCancellation(akc akcVar) {
        setSubscription(new CancellableSubscription(akcVar));
    }

    public void setSubscription(qjc qjcVar) {
        this.resource.update(qjcVar);
    }

    @Override // com.baidu.tieba.qjc
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

    @Override // com.baidu.tieba.qjc
    public void unsubscribe() {
        if (compareAndSet(false, true)) {
            this.resource.unsubscribe();
        }
    }
}
