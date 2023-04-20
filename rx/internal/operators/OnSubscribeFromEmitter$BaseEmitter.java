package rx.internal.operators;

import com.baidu.tieba.d2b;
import com.baidu.tieba.i2b;
import com.baidu.tieba.j6b;
import com.baidu.tieba.p1b;
import com.baidu.tieba.t1b;
import com.baidu.tieba.u1b;
import java.util.concurrent.atomic.AtomicLong;
import rx.internal.subscriptions.CancellableSubscription;
/* loaded from: classes9.dex */
public abstract class OnSubscribeFromEmitter$BaseEmitter<T> extends AtomicLong implements Object<T>, p1b, u1b {
    public static final long serialVersionUID = 7326289992464377023L;
    public final t1b<? super T> actual;
    public final j6b serial = new j6b();

    public abstract /* synthetic */ void onNext(T t);

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    public OnSubscribeFromEmitter$BaseEmitter(t1b<? super T> t1bVar) {
        this.actual = t1bVar;
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

    @Override // com.baidu.tieba.p1b
    public final void request(long j) {
        if (i2b.h(j)) {
            i2b.b(this, j);
            onRequested();
        }
    }

    public final void setCancellation(d2b d2bVar) {
        setSubscription(new CancellableSubscription(d2bVar));
    }

    public final void setSubscription(u1b u1bVar) {
        this.serial.a(u1bVar);
    }

    @Override // com.baidu.tieba.u1b
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

    @Override // com.baidu.tieba.u1b
    public final void unsubscribe() {
        this.serial.unsubscribe();
        onUnsubscribed();
    }
}
