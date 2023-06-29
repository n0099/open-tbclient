package rx.internal.operators;

import com.baidu.tieba.dtb;
import com.baidu.tieba.etb;
import com.baidu.tieba.ntb;
import com.baidu.tieba.ttb;
import com.baidu.tieba.zsb;
import com.baidu.tieba.zxb;
import java.util.concurrent.atomic.AtomicLong;
import rx.internal.subscriptions.CancellableSubscription;
/* loaded from: classes2.dex */
public abstract class OnSubscribeFromEmitter$BaseEmitter<T> extends AtomicLong implements Object<T>, zsb, etb {
    public static final long serialVersionUID = 7326289992464377023L;
    public final dtb<? super T> actual;
    public final zxb serial = new zxb();

    public abstract /* synthetic */ void onNext(T t);

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    public OnSubscribeFromEmitter$BaseEmitter(dtb<? super T> dtbVar) {
        this.actual = dtbVar;
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

    @Override // com.baidu.tieba.zsb
    public final void request(long j) {
        if (ttb.h(j)) {
            ttb.b(this, j);
            onRequested();
        }
    }

    public final void setCancellation(ntb ntbVar) {
        setSubscription(new CancellableSubscription(ntbVar));
    }

    public final void setSubscription(etb etbVar) {
        this.serial.a(etbVar);
    }

    @Override // com.baidu.tieba.etb
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

    @Override // com.baidu.tieba.etb
    public final void unsubscribe() {
        this.serial.unsubscribe();
        onUnsubscribed();
    }
}
