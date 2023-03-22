package rx.internal.operators;

import com.baidu.tieba.esa;
import com.baidu.tieba.jsa;
import com.baidu.tieba.kwa;
import com.baidu.tieba.qra;
import com.baidu.tieba.ura;
import com.baidu.tieba.vra;
import java.util.concurrent.atomic.AtomicLong;
import rx.internal.subscriptions.CancellableSubscription;
/* loaded from: classes9.dex */
public abstract class OnSubscribeFromEmitter$BaseEmitter<T> extends AtomicLong implements Object<T>, qra, vra {
    public static final long serialVersionUID = 7326289992464377023L;
    public final ura<? super T> actual;
    public final kwa serial = new kwa();

    public abstract /* synthetic */ void onNext(T t);

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    public OnSubscribeFromEmitter$BaseEmitter(ura<? super T> uraVar) {
        this.actual = uraVar;
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

    @Override // com.baidu.tieba.qra
    public final void request(long j) {
        if (jsa.h(j)) {
            jsa.b(this, j);
            onRequested();
        }
    }

    public final void setCancellation(esa esaVar) {
        setSubscription(new CancellableSubscription(esaVar));
    }

    public final void setSubscription(vra vraVar) {
        this.serial.a(vraVar);
    }

    @Override // com.baidu.tieba.vra
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

    @Override // com.baidu.tieba.vra
    public final void unsubscribe() {
        this.serial.unsubscribe();
        onUnsubscribed();
    }
}
