package rx.internal.operators;

import com.baidu.tieba.ina;
import com.baidu.tieba.nna;
import com.baidu.tieba.ora;
import com.baidu.tieba.uma;
import com.baidu.tieba.yma;
import com.baidu.tieba.zma;
import java.util.concurrent.atomic.AtomicLong;
import rx.internal.subscriptions.CancellableSubscription;
/* loaded from: classes9.dex */
public abstract class OnSubscribeFromEmitter$BaseEmitter<T> extends AtomicLong implements Object<T>, uma, zma {
    public static final long serialVersionUID = 7326289992464377023L;
    public final yma<? super T> actual;
    public final ora serial = new ora();

    public abstract /* synthetic */ void onNext(T t);

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    public OnSubscribeFromEmitter$BaseEmitter(yma<? super T> ymaVar) {
        this.actual = ymaVar;
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

    @Override // com.baidu.tieba.uma
    public final void request(long j) {
        if (nna.h(j)) {
            nna.b(this, j);
            onRequested();
        }
    }

    public final void setCancellation(ina inaVar) {
        setSubscription(new CancellableSubscription(inaVar));
    }

    public final void setSubscription(zma zmaVar) {
        this.serial.a(zmaVar);
    }

    @Override // com.baidu.tieba.zma
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

    @Override // com.baidu.tieba.zma
    public final void unsubscribe() {
        this.serial.unsubscribe();
        onUnsubscribed();
    }
}
