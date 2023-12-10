package rx.internal.operators;

import com.baidu.tieba.doc;
import com.baidu.tieba.loc;
import com.baidu.tieba.usc;
import com.baidu.tieba.voc;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;
/* loaded from: classes2.dex */
public final class CompletableFromEmitter$FromEmitter extends AtomicBoolean implements loc {
    public static final long serialVersionUID = 5539301318568668881L;
    public final doc actual;
    public final SequentialSubscription resource = new SequentialSubscription();

    public CompletableFromEmitter$FromEmitter(doc docVar) {
        this.actual = docVar;
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
        usc.j(th);
    }

    public void setCancellation(voc vocVar) {
        setSubscription(new CancellableSubscription(vocVar));
    }

    public void setSubscription(loc locVar) {
        this.resource.update(locVar);
    }

    @Override // com.baidu.tieba.loc
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

    @Override // com.baidu.tieba.loc
    public void unsubscribe() {
        if (compareAndSet(false, true)) {
            this.resource.unsubscribe();
        }
    }
}
