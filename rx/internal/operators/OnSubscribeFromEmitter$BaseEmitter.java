package rx.internal.operators;

import com.baidu.tieba.bdc;
import com.baidu.tieba.hdc;
import com.baidu.tieba.mcc;
import com.baidu.tieba.nhc;
import com.baidu.tieba.qcc;
import com.baidu.tieba.rcc;
import java.util.concurrent.atomic.AtomicLong;
import rx.internal.subscriptions.CancellableSubscription;
/* loaded from: classes2.dex */
public abstract class OnSubscribeFromEmitter$BaseEmitter<T> extends AtomicLong implements Object<T>, mcc, rcc {
    public static final long serialVersionUID = 7326289992464377023L;
    public final qcc<? super T> actual;
    public final nhc serial = new nhc();

    public abstract /* synthetic */ void onNext(T t);

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    public OnSubscribeFromEmitter$BaseEmitter(qcc<? super T> qccVar) {
        this.actual = qccVar;
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

    @Override // com.baidu.tieba.mcc
    public final void request(long j) {
        if (hdc.h(j)) {
            hdc.b(this, j);
            onRequested();
        }
    }

    public final void setCancellation(bdc bdcVar) {
        setSubscription(new CancellableSubscription(bdcVar));
    }

    public final void setSubscription(rcc rccVar) {
        this.serial.a(rccVar);
    }

    @Override // com.baidu.tieba.rcc
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

    @Override // com.baidu.tieba.rcc
    public final void unsubscribe() {
        this.serial.unsubscribe();
        onUnsubscribed();
    }
}
