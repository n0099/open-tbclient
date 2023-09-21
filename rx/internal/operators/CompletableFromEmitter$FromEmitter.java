package rx.internal.operators;

import com.baidu.tieba.bdc;
import com.baidu.tieba.jcc;
import com.baidu.tieba.rcc;
import com.baidu.tieba.ygc;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableFromEmitter$FromEmitter extends AtomicBoolean implements rcc {
    public static final long serialVersionUID = 5539301318568668881L;
    public final jcc actual;
    public final SequentialSubscription resource = new SequentialSubscription();

    public CompletableFromEmitter$FromEmitter(jcc jccVar) {
        this.actual = jccVar;
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
        ygc.j(th);
    }

    public void setCancellation(bdc bdcVar) {
        setSubscription(new CancellableSubscription(bdcVar));
    }

    public void setSubscription(rcc rccVar) {
        this.resource.update(rccVar);
    }

    @Override // com.baidu.tieba.rcc
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

    @Override // com.baidu.tieba.rcc
    public void unsubscribe() {
        if (compareAndSet(false, true)) {
            this.resource.unsubscribe();
        }
    }
}
