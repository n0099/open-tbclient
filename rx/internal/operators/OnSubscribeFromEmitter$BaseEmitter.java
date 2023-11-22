package rx.internal.operators;

import com.baidu.tieba.akc;
import com.baidu.tieba.ikc;
import com.baidu.tieba.ljc;
import com.baidu.tieba.ooc;
import com.baidu.tieba.pjc;
import com.baidu.tieba.qjc;
import java.util.concurrent.atomic.AtomicLong;
import rx.internal.subscriptions.CancellableSubscription;
/* loaded from: classes2.dex */
public abstract class OnSubscribeFromEmitter$BaseEmitter<T> extends AtomicLong implements Object<T>, ljc, qjc {
    public static final long serialVersionUID = 7326289992464377023L;
    public final pjc<? super T> actual;
    public final ooc serial = new ooc();

    public abstract /* synthetic */ void onNext(T t);

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    public OnSubscribeFromEmitter$BaseEmitter(pjc<? super T> pjcVar) {
        this.actual = pjcVar;
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

    @Override // com.baidu.tieba.ljc
    public final void request(long j) {
        if (ikc.h(j)) {
            ikc.b(this, j);
            onRequested();
        }
    }

    public final void setCancellation(akc akcVar) {
        setSubscription(new CancellableSubscription(akcVar));
    }

    public final void setSubscription(qjc qjcVar) {
        this.serial.a(qjcVar);
    }

    @Override // com.baidu.tieba.qjc
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

    @Override // com.baidu.tieba.qjc
    public final void unsubscribe() {
        this.serial.unsubscribe();
        onUnsubscribed();
    }
}
