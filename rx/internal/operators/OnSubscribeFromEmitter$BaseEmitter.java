package rx.internal.operators;

import com.baidu.tieba.a2c;
import com.baidu.tieba.b2c;
import com.baidu.tieba.k2c;
import com.baidu.tieba.q2c;
import com.baidu.tieba.w1c;
import com.baidu.tieba.w6c;
import java.util.concurrent.atomic.AtomicLong;
import rx.internal.subscriptions.CancellableSubscription;
/* loaded from: classes2.dex */
public abstract class OnSubscribeFromEmitter$BaseEmitter<T> extends AtomicLong implements Object<T>, w1c, b2c {
    public static final long serialVersionUID = 7326289992464377023L;
    public final a2c<? super T> actual;
    public final w6c serial = new w6c();

    public abstract /* synthetic */ void onNext(T t);

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    public OnSubscribeFromEmitter$BaseEmitter(a2c<? super T> a2cVar) {
        this.actual = a2cVar;
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

    @Override // com.baidu.tieba.w1c
    public final void request(long j) {
        if (q2c.h(j)) {
            q2c.b(this, j);
            onRequested();
        }
    }

    public final void setCancellation(k2c k2cVar) {
        setSubscription(new CancellableSubscription(k2cVar));
    }

    public final void setSubscription(b2c b2cVar) {
        this.serial.a(b2cVar);
    }

    @Override // com.baidu.tieba.b2c
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

    @Override // com.baidu.tieba.b2c
    public final void unsubscribe() {
        this.serial.unsubscribe();
        onUnsubscribed();
    }
}
