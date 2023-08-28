package rx.internal.operators;

import com.baidu.tieba.g8c;
import com.baidu.tieba.m8c;
import com.baidu.tieba.r7c;
import com.baidu.tieba.scc;
import com.baidu.tieba.v7c;
import com.baidu.tieba.w7c;
import java.util.concurrent.atomic.AtomicLong;
import rx.internal.subscriptions.CancellableSubscription;
/* loaded from: classes2.dex */
public abstract class OnSubscribeFromEmitter$BaseEmitter<T> extends AtomicLong implements Object<T>, r7c, w7c {
    public static final long serialVersionUID = 7326289992464377023L;
    public final v7c<? super T> actual;
    public final scc serial = new scc();

    public abstract /* synthetic */ void onNext(T t);

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    public OnSubscribeFromEmitter$BaseEmitter(v7c<? super T> v7cVar) {
        this.actual = v7cVar;
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

    @Override // com.baidu.tieba.r7c
    public final void request(long j) {
        if (m8c.h(j)) {
            m8c.b(this, j);
            onRequested();
        }
    }

    public final void setCancellation(g8c g8cVar) {
        setSubscription(new CancellableSubscription(g8cVar));
    }

    public final void setSubscription(w7c w7cVar) {
        this.serial.a(w7cVar);
    }

    @Override // com.baidu.tieba.w7c
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

    @Override // com.baidu.tieba.w7c
    public final void unsubscribe() {
        this.serial.unsubscribe();
        onUnsubscribed();
    }
}
