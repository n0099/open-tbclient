package rx.internal.operators;

import h.f;
import h.j;
import h.k;
import h.o.a.a;
import h.u.d;
import java.util.concurrent.atomic.AtomicLong;
import rx.internal.subscriptions.CancellableSubscription;
/* loaded from: classes8.dex */
public abstract class OnSubscribeFromEmitter$BaseEmitter<T> extends AtomicLong implements Object<T>, f, k {
    public static final long serialVersionUID = 7326289992464377023L;
    public final j<? super T> actual;
    public final d serial = new d();

    public OnSubscribeFromEmitter$BaseEmitter(j<? super T> jVar) {
        this.actual = jVar;
    }

    @Override // h.k
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

    public abstract /* synthetic */ void onNext(T t);

    public void onRequested() {
    }

    public void onUnsubscribed() {
    }

    @Override // h.f
    public final void request(long j) {
        if (a.h(j)) {
            a.b(this, j);
            onRequested();
        }
    }

    public final long requested() {
        return get();
    }

    public final void setCancellation(h.n.d dVar) {
        setSubscription(new CancellableSubscription(dVar));
    }

    public final void setSubscription(k kVar) {
        this.serial.a(kVar);
    }

    @Override // h.k
    public final void unsubscribe() {
        this.serial.unsubscribe();
        onUnsubscribed();
    }
}
