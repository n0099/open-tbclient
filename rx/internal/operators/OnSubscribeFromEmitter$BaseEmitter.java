package rx.internal.operators;

import com.baidu.tieba.c8b;
import com.baidu.tieba.gcb;
import com.baidu.tieba.j7b;
import com.baidu.tieba.n7b;
import com.baidu.tieba.o7b;
import com.baidu.tieba.x7b;
import java.util.concurrent.atomic.AtomicLong;
import rx.internal.subscriptions.CancellableSubscription;
/* loaded from: classes10.dex */
public abstract class OnSubscribeFromEmitter$BaseEmitter<T> extends AtomicLong implements Object<T>, j7b, o7b {
    public static final long serialVersionUID = 7326289992464377023L;
    public final n7b<? super T> actual;
    public final gcb serial = new gcb();

    public abstract /* synthetic */ void onNext(T t);

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    public OnSubscribeFromEmitter$BaseEmitter(n7b<? super T> n7bVar) {
        this.actual = n7bVar;
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

    @Override // com.baidu.tieba.j7b
    public final void request(long j) {
        if (c8b.h(j)) {
            c8b.b(this, j);
            onRequested();
        }
    }

    public final void setCancellation(x7b x7bVar) {
        setSubscription(new CancellableSubscription(x7bVar));
    }

    public final void setSubscription(o7b o7bVar) {
        this.serial.a(o7bVar);
    }

    @Override // com.baidu.tieba.o7b
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

    @Override // com.baidu.tieba.o7b
    public final void unsubscribe() {
        this.serial.unsubscribe();
        onUnsubscribed();
    }
}
