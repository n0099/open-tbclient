package rx.internal.operators;

import com.baidu.tieba.hkc;
import com.baidu.tieba.kjc;
import com.baidu.tieba.noc;
import com.baidu.tieba.ojc;
import com.baidu.tieba.pjc;
import com.baidu.tieba.zjc;
import java.util.concurrent.atomic.AtomicLong;
import rx.internal.subscriptions.CancellableSubscription;
/* loaded from: classes2.dex */
public abstract class OnSubscribeFromEmitter$BaseEmitter<T> extends AtomicLong implements Object<T>, kjc, pjc {
    public static final long serialVersionUID = 7326289992464377023L;
    public final ojc<? super T> actual;
    public final noc serial = new noc();

    public abstract /* synthetic */ void onNext(T t);

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    public OnSubscribeFromEmitter$BaseEmitter(ojc<? super T> ojcVar) {
        this.actual = ojcVar;
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

    @Override // com.baidu.tieba.kjc
    public final void request(long j) {
        if (hkc.h(j)) {
            hkc.b(this, j);
            onRequested();
        }
    }

    public final void setCancellation(zjc zjcVar) {
        setSubscription(new CancellableSubscription(zjcVar));
    }

    public final void setSubscription(pjc pjcVar) {
        this.serial.a(pjcVar);
    }

    @Override // com.baidu.tieba.pjc
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

    @Override // com.baidu.tieba.pjc
    public final void unsubscribe() {
        this.serial.unsubscribe();
        onUnsubscribed();
    }
}
