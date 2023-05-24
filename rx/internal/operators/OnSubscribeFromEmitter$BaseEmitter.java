package rx.internal.operators;

import com.baidu.tieba.d8b;
import com.baidu.tieba.hcb;
import com.baidu.tieba.k7b;
import com.baidu.tieba.o7b;
import com.baidu.tieba.p7b;
import com.baidu.tieba.y7b;
import java.util.concurrent.atomic.AtomicLong;
import rx.internal.subscriptions.CancellableSubscription;
/* loaded from: classes10.dex */
public abstract class OnSubscribeFromEmitter$BaseEmitter<T> extends AtomicLong implements Object<T>, k7b, p7b {
    public static final long serialVersionUID = 7326289992464377023L;
    public final o7b<? super T> actual;
    public final hcb serial = new hcb();

    public abstract /* synthetic */ void onNext(T t);

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    public OnSubscribeFromEmitter$BaseEmitter(o7b<? super T> o7bVar) {
        this.actual = o7bVar;
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

    @Override // com.baidu.tieba.k7b
    public final void request(long j) {
        if (d8b.h(j)) {
            d8b.b(this, j);
            onRequested();
        }
    }

    public final void setCancellation(y7b y7bVar) {
        setSubscription(new CancellableSubscription(y7bVar));
    }

    public final void setSubscription(p7b p7bVar) {
        this.serial.a(p7bVar);
    }

    @Override // com.baidu.tieba.p7b
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

    @Override // com.baidu.tieba.p7b
    public final void unsubscribe() {
        this.serial.unsubscribe();
        onUnsubscribed();
    }
}
