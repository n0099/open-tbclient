package rx.internal.operators;

import com.baidu.tieba.cpc;
import com.baidu.tieba.foc;
import com.baidu.tieba.itc;
import com.baidu.tieba.joc;
import com.baidu.tieba.koc;
import com.baidu.tieba.uoc;
import java.util.concurrent.atomic.AtomicLong;
import rx.internal.subscriptions.CancellableSubscription;
/* loaded from: classes2.dex */
public abstract class OnSubscribeFromEmitter$BaseEmitter<T> extends AtomicLong implements Object<T>, foc, koc {
    public static final long serialVersionUID = 7326289992464377023L;
    public final joc<? super T> actual;
    public final itc serial = new itc();

    public abstract /* synthetic */ void onNext(T t);

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    public OnSubscribeFromEmitter$BaseEmitter(joc<? super T> jocVar) {
        this.actual = jocVar;
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

    @Override // com.baidu.tieba.foc
    public final void request(long j) {
        if (cpc.h(j)) {
            cpc.b(this, j);
            onRequested();
        }
    }

    public final void setCancellation(uoc uocVar) {
        setSubscription(new CancellableSubscription(uocVar));
    }

    public final void setSubscription(koc kocVar) {
        this.serial.a(kocVar);
    }

    @Override // com.baidu.tieba.koc
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

    @Override // com.baidu.tieba.koc
    public final void unsubscribe() {
        this.serial.unsubscribe();
        onUnsubscribed();
    }
}
