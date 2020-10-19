package io.reactivex.observers;

import io.reactivex.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.u;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes17.dex */
public class TestObserver<T> extends BaseTestConsumer<T, TestObserver<T>> implements c, io.reactivex.disposables.b, m<T>, u<T>, y<T> {
    private final u<? super T> actual;
    private io.reactivex.internal.a.b<T> oLK;
    private final AtomicReference<io.reactivex.disposables.b> subscription;

    @Override // io.reactivex.c
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        this.oPJ = Thread.currentThread();
        if (bVar == null) {
            this.errors.add(new NullPointerException("onSubscribe received a null Subscription"));
        } else if (!this.subscription.compareAndSet(null, bVar)) {
            bVar.dispose();
            if (this.subscription.get() != DisposableHelper.DISPOSED) {
                this.errors.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + bVar));
            }
        } else {
            if (this.oPL != 0 && (bVar instanceof io.reactivex.internal.a.b)) {
                this.oLK = (io.reactivex.internal.a.b) bVar;
                int requestFusion = this.oLK.requestFusion(this.oPL);
                this.oPM = requestFusion;
                if (requestFusion == 1) {
                    this.oPK = true;
                    this.oPJ = Thread.currentThread();
                    while (true) {
                        try {
                            T poll = this.oLK.poll();
                            if (poll != null) {
                                this.values.add(poll);
                            } else {
                                this.oPI++;
                                this.subscription.lazySet(DisposableHelper.DISPOSED);
                                return;
                            }
                        } catch (Throwable th) {
                            this.errors.add(th);
                            return;
                        }
                    }
                }
            }
            this.actual.onSubscribe(bVar);
        }
    }

    @Override // io.reactivex.u
    public void onNext(T t) {
        if (!this.oPK) {
            this.oPK = true;
            if (this.subscription.get() == null) {
                this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.oPJ = Thread.currentThread();
        if (this.oPM != 2) {
            this.values.add(t);
            if (t == null) {
                this.errors.add(new NullPointerException("onNext received a null value"));
            }
            this.actual.onNext(t);
            return;
        }
        while (true) {
            try {
                T poll = this.oLK.poll();
                if (poll != null) {
                    this.values.add(poll);
                } else {
                    return;
                }
            } catch (Throwable th) {
                this.errors.add(th);
                this.oLK.dispose();
                return;
            }
        }
    }

    @Override // io.reactivex.c
    public void onError(Throwable th) {
        if (!this.oPK) {
            this.oPK = true;
            if (this.subscription.get() == null) {
                this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.oPJ = Thread.currentThread();
            if (th == null) {
                this.errors.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.errors.add(th);
            }
            this.actual.onError(th);
        } finally {
            this.oPH.countDown();
        }
    }

    @Override // io.reactivex.c
    public void onComplete() {
        if (!this.oPK) {
            this.oPK = true;
            if (this.subscription.get() == null) {
                this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.oPJ = Thread.currentThread();
            this.oPI++;
            this.actual.onComplete();
        } finally {
            this.oPH.countDown();
        }
    }

    @Override // io.reactivex.disposables.b
    public final void dispose() {
        DisposableHelper.dispose(this.subscription);
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        return DisposableHelper.isDisposed(this.subscription.get());
    }

    @Override // io.reactivex.m
    public void onSuccess(T t) {
        onNext(t);
        onComplete();
    }

    /* loaded from: classes17.dex */
    enum EmptyObserver implements u<Object> {
        INSTANCE;

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
        }

        @Override // io.reactivex.u
        public void onNext(Object obj) {
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
        }

        @Override // io.reactivex.u
        public void onComplete() {
        }
    }
}
