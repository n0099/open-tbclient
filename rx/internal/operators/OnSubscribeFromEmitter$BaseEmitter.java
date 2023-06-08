package rx.internal.operators;

import com.baidu.tieba.dnb;
import com.baidu.tieba.inb;
import com.baidu.tieba.mrb;
import com.baidu.tieba.pmb;
import com.baidu.tieba.tmb;
import com.baidu.tieba.umb;
import java.util.concurrent.atomic.AtomicLong;
import rx.internal.subscriptions.CancellableSubscription;
/* loaded from: classes2.dex */
public abstract class OnSubscribeFromEmitter$BaseEmitter<T> extends AtomicLong implements Object<T>, pmb, umb {
    public static final long serialVersionUID = 7326289992464377023L;
    public final tmb<? super T> actual;
    public final mrb serial = new mrb();

    public abstract /* synthetic */ void onNext(T t);

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    public OnSubscribeFromEmitter$BaseEmitter(tmb<? super T> tmbVar) {
        this.actual = tmbVar;
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

    @Override // com.baidu.tieba.pmb
    public final void request(long j) {
        if (inb.h(j)) {
            inb.b(this, j);
            onRequested();
        }
    }

    public final void setCancellation(dnb dnbVar) {
        setSubscription(new CancellableSubscription(dnbVar));
    }

    public final void setSubscription(umb umbVar) {
        this.serial.a(umbVar);
    }

    @Override // com.baidu.tieba.umb
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

    @Override // com.baidu.tieba.umb
    public final void unsubscribe() {
        this.serial.unsubscribe();
        onUnsubscribed();
    }
}
