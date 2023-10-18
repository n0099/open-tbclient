package rx.internal.operators;

import com.baidu.tieba.g7c;
import com.baidu.tieba.j6c;
import com.baidu.tieba.mbc;
import com.baidu.tieba.n6c;
import com.baidu.tieba.o6c;
import com.baidu.tieba.y6c;
import java.util.concurrent.atomic.AtomicLong;
import rx.internal.subscriptions.CancellableSubscription;
/* loaded from: classes2.dex */
public abstract class OnSubscribeFromEmitter$BaseEmitter<T> extends AtomicLong implements Object<T>, j6c, o6c {
    public static final long serialVersionUID = 7326289992464377023L;
    public final n6c<? super T> actual;
    public final mbc serial = new mbc();

    public abstract /* synthetic */ void onNext(T t);

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    public OnSubscribeFromEmitter$BaseEmitter(n6c<? super T> n6cVar) {
        this.actual = n6cVar;
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

    @Override // com.baidu.tieba.j6c
    public final void request(long j) {
        if (g7c.h(j)) {
            g7c.b(this, j);
            onRequested();
        }
    }

    public final void setCancellation(y6c y6cVar) {
        setSubscription(new CancellableSubscription(y6cVar));
    }

    public final void setSubscription(o6c o6cVar) {
        this.serial.a(o6cVar);
    }

    @Override // com.baidu.tieba.o6c
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

    @Override // com.baidu.tieba.o6c
    public final void unsubscribe() {
        this.serial.unsubscribe();
        onUnsubscribed();
    }
}
