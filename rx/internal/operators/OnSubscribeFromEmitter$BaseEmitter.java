package rx.internal.operators;

import com.baidu.tieba.bpb;
import com.baidu.tieba.ftb;
import com.baidu.tieba.iob;
import com.baidu.tieba.mob;
import com.baidu.tieba.nob;
import com.baidu.tieba.wob;
import java.util.concurrent.atomic.AtomicLong;
import rx.internal.subscriptions.CancellableSubscription;
/* loaded from: classes2.dex */
public abstract class OnSubscribeFromEmitter$BaseEmitter<T> extends AtomicLong implements Object<T>, iob, nob {
    public static final long serialVersionUID = 7326289992464377023L;
    public final mob<? super T> actual;
    public final ftb serial = new ftb();

    public abstract /* synthetic */ void onNext(T t);

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    public OnSubscribeFromEmitter$BaseEmitter(mob<? super T> mobVar) {
        this.actual = mobVar;
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

    @Override // com.baidu.tieba.iob
    public final void request(long j) {
        if (bpb.h(j)) {
            bpb.b(this, j);
            onRequested();
        }
    }

    public final void setCancellation(wob wobVar) {
        setSubscription(new CancellableSubscription(wobVar));
    }

    public final void setSubscription(nob nobVar) {
        this.serial.a(nobVar);
    }

    @Override // com.baidu.tieba.nob
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

    @Override // com.baidu.tieba.nob
    public final void unsubscribe() {
        this.serial.unsubscribe();
        onUnsubscribed();
    }
}
