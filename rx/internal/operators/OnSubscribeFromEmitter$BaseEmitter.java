package rx.internal.operators;

import com.baidu.tieba.e8c;
import com.baidu.tieba.k8c;
import com.baidu.tieba.p7c;
import com.baidu.tieba.qcc;
import com.baidu.tieba.t7c;
import com.baidu.tieba.u7c;
import java.util.concurrent.atomic.AtomicLong;
import rx.internal.subscriptions.CancellableSubscription;
/* loaded from: classes2.dex */
public abstract class OnSubscribeFromEmitter$BaseEmitter<T> extends AtomicLong implements Object<T>, p7c, u7c {
    public static final long serialVersionUID = 7326289992464377023L;
    public final t7c<? super T> actual;
    public final qcc serial = new qcc();

    public abstract /* synthetic */ void onNext(T t);

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    public OnSubscribeFromEmitter$BaseEmitter(t7c<? super T> t7cVar) {
        this.actual = t7cVar;
    }

    public void onError(Throwable th) {
        if (this.actual.isUnsubscribed()) {
            return;
        }
        try {
            this.actual.onError(th);
        } finally {
            this.serial.unsubscribe();
        }
    }

    @Override // com.baidu.tieba.p7c
    public final void request(long j) {
        if (k8c.h(j)) {
            k8c.b(this, j);
            onRequested();
        }
    }

    public final void setCancellation(e8c e8cVar) {
        setSubscription(new CancellableSubscription(e8cVar));
    }

    public final void setSubscription(u7c u7cVar) {
        this.serial.a(u7cVar);
    }

    @Override // com.baidu.tieba.u7c
    public final boolean isUnsubscribed() {
        return this.serial.isUnsubscribed();
    }

    public void onCompleted() {
        if (this.actual.isUnsubscribed()) {
            return;
        }
        try {
            this.actual.onCompleted();
        } finally {
            this.serial.unsubscribe();
        }
    }

    public final long requested() {
        return get();
    }

    @Override // com.baidu.tieba.u7c
    public final void unsubscribe() {
        this.serial.unsubscribe();
        onUnsubscribed();
    }
}
