package io.reactivex.subscribers;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.observers.BaseTestConsumer;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;
import org.a.d;
/* loaded from: classes5.dex */
public class TestSubscriber<T> extends BaseTestConsumer<T, TestSubscriber<T>> implements io.reactivex.disposables.b, j<T>, d {
    private final c<? super T> actual;
    private volatile boolean cancelled;
    private final AtomicLong missedRequested;
    private io.reactivex.internal.a.d<T> qs;
    private final AtomicReference<d> subscription;

    @Override // io.reactivex.j, org.a.c
    public void onSubscribe(d dVar) {
        this.pSd = Thread.currentThread();
        if (dVar == null) {
            this.errors.add(new NullPointerException("onSubscribe received a null Subscription"));
        } else if (!this.subscription.compareAndSet(null, dVar)) {
            dVar.cancel();
            if (this.subscription.get() != SubscriptionHelper.CANCELLED) {
                this.errors.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + dVar));
            }
        } else {
            if (this.pSf != 0 && (dVar instanceof io.reactivex.internal.a.d)) {
                this.qs = (io.reactivex.internal.a.d) dVar;
                int requestFusion = this.qs.requestFusion(this.pSf);
                this.pSg = requestFusion;
                if (requestFusion == 1) {
                    this.pSe = true;
                    this.pSd = Thread.currentThread();
                    while (true) {
                        try {
                            T poll = this.qs.poll();
                            if (poll != null) {
                                this.values.add(poll);
                            } else {
                                this.pSc++;
                                return;
                            }
                        } catch (Throwable th) {
                            this.errors.add(th);
                            return;
                        }
                    }
                }
            }
            this.actual.onSubscribe(dVar);
            long andSet = this.missedRequested.getAndSet(0L);
            if (andSet != 0) {
                dVar.request(andSet);
            }
            onStart();
        }
    }

    protected void onStart() {
    }

    @Override // org.a.c
    public void onNext(T t) {
        if (!this.pSe) {
            this.pSe = true;
            if (this.subscription.get() == null) {
                this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.pSd = Thread.currentThread();
        if (this.pSg != 2) {
            this.values.add(t);
            if (t == null) {
                this.errors.add(new NullPointerException("onNext received a null value"));
            }
            this.actual.onNext(t);
            return;
        }
        while (true) {
            try {
                T poll = this.qs.poll();
                if (poll != null) {
                    this.values.add(poll);
                } else {
                    return;
                }
            } catch (Throwable th) {
                this.errors.add(th);
                this.qs.cancel();
                return;
            }
        }
    }

    @Override // org.a.c
    public void onError(Throwable th) {
        if (!this.pSe) {
            this.pSe = true;
            if (this.subscription.get() == null) {
                this.errors.add(new NullPointerException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.pSd = Thread.currentThread();
            this.errors.add(th);
            if (th == null) {
                this.errors.add(new IllegalStateException("onError received a null Throwable"));
            }
            this.actual.onError(th);
        } finally {
            this.pSb.countDown();
        }
    }

    @Override // org.a.c
    public void onComplete() {
        if (!this.pSe) {
            this.pSe = true;
            if (this.subscription.get() == null) {
                this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.pSd = Thread.currentThread();
            this.pSc++;
            this.actual.onComplete();
        } finally {
            this.pSb.countDown();
        }
    }

    @Override // org.a.d
    public final void request(long j) {
        SubscriptionHelper.deferredRequest(this.subscription, this.missedRequested, j);
    }

    @Override // org.a.d
    public final void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            SubscriptionHelper.cancel(this.subscription);
        }
    }

    @Override // io.reactivex.disposables.b
    public final void dispose() {
        cancel();
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        return this.cancelled;
    }

    /* loaded from: classes5.dex */
    enum EmptySubscriber implements j<Object> {
        INSTANCE;

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
        }

        @Override // org.a.c
        public void onNext(Object obj) {
        }

        @Override // org.a.c
        public void onError(Throwable th) {
        }

        @Override // org.a.c
        public void onComplete() {
        }
    }
}
