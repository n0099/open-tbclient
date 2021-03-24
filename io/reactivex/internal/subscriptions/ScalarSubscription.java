package io.reactivex.internal.subscriptions;

import f.a.x.c.d;
import g.d.c;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class ScalarSubscription<T> extends AtomicInteger implements d<T> {
    public static final int CANCELLED = 2;
    public static final int NO_REQUEST = 0;
    public static final int REQUESTED = 1;
    public static final long serialVersionUID = -3830916580126663321L;
    public final c<? super T> subscriber;
    public final T value;

    public ScalarSubscription(c<? super T> cVar, T t) {
        this.subscriber = cVar;
        this.value = t;
    }

    @Override // g.d.d
    public void cancel() {
        lazySet(2);
    }

    @Override // f.a.x.c.f
    public void clear() {
        lazySet(1);
    }

    public boolean isCancelled() {
        return get() == 2;
    }

    @Override // f.a.x.c.f
    public boolean isEmpty() {
        return get() != 0;
    }

    @Override // f.a.x.c.f
    public boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // f.a.x.c.f
    public T poll() {
        if (get() == 0) {
            lazySet(1);
            return this.value;
        }
        return null;
    }

    /* JADX DEBUG: Type inference failed for r3v1. Raw type applied. Possible types: T, ? super T */
    @Override // g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j) && compareAndSet(0, 1)) {
            c<? super T> cVar = this.subscriber;
            cVar.onNext((T) this.value);
            if (get() != 2) {
                cVar.onComplete();
            }
        }
    }

    @Override // f.a.x.c.c
    public int requestFusion(int i) {
        return i & 1;
    }

    public boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
