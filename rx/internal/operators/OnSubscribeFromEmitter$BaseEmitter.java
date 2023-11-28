package rx.internal.operators;

import com.baidu.tieba.dpc;
import com.baidu.tieba.goc;
import com.baidu.tieba.jtc;
import com.baidu.tieba.koc;
import com.baidu.tieba.loc;
import com.baidu.tieba.voc;
import java.util.concurrent.atomic.AtomicLong;
import rx.internal.subscriptions.CancellableSubscription;
/* loaded from: classes2.dex */
public abstract class OnSubscribeFromEmitter$BaseEmitter<T> extends AtomicLong implements Object<T>, goc, loc {
    public static final long serialVersionUID = 7326289992464377023L;
    public final koc<? super T> actual;
    public final jtc serial = new jtc();

    public abstract /* synthetic */ void onNext(T t);

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    public OnSubscribeFromEmitter$BaseEmitter(koc<? super T> kocVar) {
        this.actual = kocVar;
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

    @Override // com.baidu.tieba.goc
    public final void request(long j) {
        if (dpc.h(j)) {
            dpc.b(this, j);
            onRequested();
        }
    }

    public final void setCancellation(voc vocVar) {
        setSubscription(new CancellableSubscription(vocVar));
    }

    public final void setSubscription(loc locVar) {
        this.serial.a(locVar);
    }

    @Override // com.baidu.tieba.loc
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

    @Override // com.baidu.tieba.loc
    public final void unsubscribe() {
        this.serial.unsubscribe();
        onUnsubscribed();
    }
}
