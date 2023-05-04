package rx.internal.operators;

import com.baidu.tieba.e6b;
import com.baidu.tieba.hab;
import com.baidu.tieba.l5b;
import com.baidu.tieba.p5b;
import com.baidu.tieba.q5b;
import com.baidu.tieba.z5b;
import java.util.concurrent.atomic.AtomicLong;
import rx.internal.subscriptions.CancellableSubscription;
/* loaded from: classes9.dex */
public abstract class OnSubscribeFromEmitter$BaseEmitter<T> extends AtomicLong implements Object<T>, l5b, q5b {
    public static final long serialVersionUID = 7326289992464377023L;
    public final p5b<? super T> actual;
    public final hab serial = new hab();

    public abstract /* synthetic */ void onNext(T t);

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    public OnSubscribeFromEmitter$BaseEmitter(p5b<? super T> p5bVar) {
        this.actual = p5bVar;
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

    @Override // com.baidu.tieba.l5b
    public final void request(long j) {
        if (e6b.h(j)) {
            e6b.b(this, j);
            onRequested();
        }
    }

    public final void setCancellation(z5b z5bVar) {
        setSubscription(new CancellableSubscription(z5bVar));
    }

    public final void setSubscription(q5b q5bVar) {
        this.serial.a(q5bVar);
    }

    @Override // com.baidu.tieba.q5b
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

    @Override // com.baidu.tieba.q5b
    public final void unsubscribe() {
        this.serial.unsubscribe();
        onUnsubscribed();
    }
}
