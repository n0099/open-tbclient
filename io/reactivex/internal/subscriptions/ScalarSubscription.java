package io.reactivex.internal.subscriptions;

import io.reactivex.internal.a.d;
import java.util.concurrent.atomic.AtomicInteger;
import org.a.c;
/* loaded from: classes6.dex */
public final class ScalarSubscription<T> extends AtomicInteger implements d<T> {
    static final int CANCELLED = 2;
    static final int NO_REQUEST = 0;
    static final int REQUESTED = 1;
    private static final long serialVersionUID = -3830916580126663321L;
    final c<? super T> subscriber;
    final T value;

    public ScalarSubscription(c<? super T> cVar, T t) {
        this.subscriber = cVar;
        this.value = t;
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: T, ? super T */
    @Override // org.a.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j) && compareAndSet(0, 1)) {
            c<? super T> cVar = this.subscriber;
            cVar.onNext((T) this.value);
            if (get() != 2) {
                cVar.onComplete();
            }
        }
    }

    @Override // org.a.d
    public void cancel() {
        lazySet(2);
    }

    public boolean isCancelled() {
        return get() == 2;
    }

    @Override // io.reactivex.internal.a.f
    public boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.internal.a.f
    public T poll() {
        if (get() == 0) {
            lazySet(1);
            return this.value;
        }
        return null;
    }

    @Override // io.reactivex.internal.a.f
    public boolean isEmpty() {
        return get() != 0;
    }

    @Override // io.reactivex.internal.a.f
    public void clear() {
        lazySet(1);
    }

    @Override // io.reactivex.internal.a.c
    public int requestFusion(int i) {
        return i & 1;
    }
}
