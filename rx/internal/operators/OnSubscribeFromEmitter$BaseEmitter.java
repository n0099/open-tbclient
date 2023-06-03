package rx.internal.operators;

import com.baidu.tieba.dnb;
import com.baidu.tieba.hrb;
import com.baidu.tieba.kmb;
import com.baidu.tieba.omb;
import com.baidu.tieba.pmb;
import com.baidu.tieba.ymb;
import java.util.concurrent.atomic.AtomicLong;
import rx.internal.subscriptions.CancellableSubscription;
/* loaded from: classes2.dex */
public abstract class OnSubscribeFromEmitter$BaseEmitter<T> extends AtomicLong implements Object<T>, kmb, pmb {
    public static final long serialVersionUID = 7326289992464377023L;
    public final omb<? super T> actual;
    public final hrb serial = new hrb();

    public abstract /* synthetic */ void onNext(T t);

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    public OnSubscribeFromEmitter$BaseEmitter(omb<? super T> ombVar) {
        this.actual = ombVar;
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

    @Override // com.baidu.tieba.kmb
    public final void request(long j) {
        if (dnb.h(j)) {
            dnb.b(this, j);
            onRequested();
        }
    }

    public final void setCancellation(ymb ymbVar) {
        setSubscription(new CancellableSubscription(ymbVar));
    }

    public final void setSubscription(pmb pmbVar) {
        this.serial.a(pmbVar);
    }

    @Override // com.baidu.tieba.pmb
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

    @Override // com.baidu.tieba.pmb
    public final void unsubscribe() {
        this.serial.unsubscribe();
        onUnsubscribed();
    }
}
