package rx.internal.operators;

import com.baidu.tieba.jbc;
import com.baidu.tieba.pbc;
import com.baidu.tieba.uac;
import com.baidu.tieba.vfc;
import com.baidu.tieba.yac;
import com.baidu.tieba.zac;
import java.util.concurrent.atomic.AtomicLong;
import rx.internal.subscriptions.CancellableSubscription;
/* loaded from: classes2.dex */
public abstract class OnSubscribeFromEmitter$BaseEmitter<T> extends AtomicLong implements Object<T>, uac, zac {
    public static final long serialVersionUID = 7326289992464377023L;
    public final yac<? super T> actual;
    public final vfc serial = new vfc();

    public abstract /* synthetic */ void onNext(T t);

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    public OnSubscribeFromEmitter$BaseEmitter(yac<? super T> yacVar) {
        this.actual = yacVar;
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

    @Override // com.baidu.tieba.uac
    public final void request(long j) {
        if (pbc.h(j)) {
            pbc.b(this, j);
            onRequested();
        }
    }

    public final void setCancellation(jbc jbcVar) {
        setSubscription(new CancellableSubscription(jbcVar));
    }

    public final void setSubscription(zac zacVar) {
        this.serial.a(zacVar);
    }

    @Override // com.baidu.tieba.zac
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

    @Override // com.baidu.tieba.zac
    public final void unsubscribe() {
        this.serial.unsubscribe();
        onUnsubscribed();
    }
}
