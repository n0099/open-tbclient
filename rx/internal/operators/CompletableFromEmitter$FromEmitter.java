package rx.internal.operators;

import com.baidu.tieba.coc;
import com.baidu.tieba.koc;
import com.baidu.tieba.tsc;
import com.baidu.tieba.uoc;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableFromEmitter$FromEmitter extends AtomicBoolean implements koc {
    public static final long serialVersionUID = 5539301318568668881L;
    public final coc actual;
    public final SequentialSubscription resource = new SequentialSubscription();

    public CompletableFromEmitter$FromEmitter(coc cocVar) {
        this.actual = cocVar;
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
        tsc.j(th);
    }

    public void setCancellation(uoc uocVar) {
        setSubscription(new CancellableSubscription(uocVar));
    }

    public void setSubscription(koc kocVar) {
        this.resource.update(kocVar);
    }

    @Override // com.baidu.tieba.koc
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

    @Override // com.baidu.tieba.koc
    public void unsubscribe() {
        if (compareAndSet(false, true)) {
            this.resource.unsubscribe();
        }
    }
}
