package rx.internal.operators;

import com.baidu.tieba.d1c;
import com.baidu.tieba.e1c;
import com.baidu.tieba.n1c;
import com.baidu.tieba.t1c;
import com.baidu.tieba.z0c;
import com.baidu.tieba.z5c;
import java.util.concurrent.atomic.AtomicLong;
import rx.internal.subscriptions.CancellableSubscription;
/* loaded from: classes2.dex */
public abstract class OnSubscribeFromEmitter$BaseEmitter<T> extends AtomicLong implements Object<T>, z0c, e1c {
    public static final long serialVersionUID = 7326289992464377023L;
    public final d1c<? super T> actual;
    public final z5c serial = new z5c();

    public abstract /* synthetic */ void onNext(T t);

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    public OnSubscribeFromEmitter$BaseEmitter(d1c<? super T> d1cVar) {
        this.actual = d1cVar;
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

    @Override // com.baidu.tieba.z0c
    public final void request(long j) {
        if (t1c.h(j)) {
            t1c.b(this, j);
            onRequested();
        }
    }

    public final void setCancellation(n1c n1cVar) {
        setSubscription(new CancellableSubscription(n1cVar));
    }

    public final void setSubscription(e1c e1cVar) {
        this.serial.a(e1cVar);
    }

    @Override // com.baidu.tieba.e1c
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

    @Override // com.baidu.tieba.e1c
    public final void unsubscribe() {
        this.serial.unsubscribe();
        onUnsubscribed();
    }
}
