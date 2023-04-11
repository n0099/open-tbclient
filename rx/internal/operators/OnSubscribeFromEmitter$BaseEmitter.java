package rx.internal.operators;

import com.baidu.tieba.a2b;
import com.baidu.tieba.b6b;
import com.baidu.tieba.h1b;
import com.baidu.tieba.l1b;
import com.baidu.tieba.m1b;
import com.baidu.tieba.v1b;
import java.util.concurrent.atomic.AtomicLong;
import rx.internal.subscriptions.CancellableSubscription;
/* loaded from: classes9.dex */
public abstract class OnSubscribeFromEmitter$BaseEmitter<T> extends AtomicLong implements Object<T>, h1b, m1b {
    public static final long serialVersionUID = 7326289992464377023L;
    public final l1b<? super T> actual;
    public final b6b serial = new b6b();

    public abstract /* synthetic */ void onNext(T t);

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    public OnSubscribeFromEmitter$BaseEmitter(l1b<? super T> l1bVar) {
        this.actual = l1bVar;
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

    @Override // com.baidu.tieba.h1b
    public final void request(long j) {
        if (a2b.h(j)) {
            a2b.b(this, j);
            onRequested();
        }
    }

    public final void setCancellation(v1b v1bVar) {
        setSubscription(new CancellableSubscription(v1bVar));
    }

    public final void setSubscription(m1b m1bVar) {
        this.serial.a(m1bVar);
    }

    @Override // com.baidu.tieba.m1b
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

    @Override // com.baidu.tieba.m1b
    public final void unsubscribe() {
        this.serial.unsubscribe();
        onUnsubscribed();
    }
}
