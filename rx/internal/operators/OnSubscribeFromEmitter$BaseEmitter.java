package rx.internal.operators;

import com.baidu.tieba.a1c;
import com.baidu.tieba.a6c;
import com.baidu.tieba.e1c;
import com.baidu.tieba.f1c;
import com.baidu.tieba.o1c;
import com.baidu.tieba.u1c;
import java.util.concurrent.atomic.AtomicLong;
import rx.internal.subscriptions.CancellableSubscription;
/* loaded from: classes2.dex */
public abstract class OnSubscribeFromEmitter$BaseEmitter<T> extends AtomicLong implements Object<T>, a1c, f1c {
    public static final long serialVersionUID = 7326289992464377023L;
    public final e1c<? super T> actual;
    public final a6c serial = new a6c();

    public abstract /* synthetic */ void onNext(T t);

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    public OnSubscribeFromEmitter$BaseEmitter(e1c<? super T> e1cVar) {
        this.actual = e1cVar;
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

    @Override // com.baidu.tieba.a1c
    public final void request(long j) {
        if (u1c.h(j)) {
            u1c.b(this, j);
            onRequested();
        }
    }

    public final void setCancellation(o1c o1cVar) {
        setSubscription(new CancellableSubscription(o1cVar));
    }

    public final void setSubscription(f1c f1cVar) {
        this.serial.a(f1cVar);
    }

    @Override // com.baidu.tieba.f1c
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

    @Override // com.baidu.tieba.f1c
    public final void unsubscribe() {
        this.serial.unsubscribe();
        onUnsubscribed();
    }
}
