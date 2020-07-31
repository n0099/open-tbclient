package io.reactivex.observers;

import io.reactivex.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.m;
import io.reactivex.u;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public class TestObserver<T> extends BaseTestConsumer<T, TestObserver<T>> implements c, io.reactivex.disposables.b, m<T>, u<T>, y<T> {
    private final u<? super T> actual;
    private io.reactivex.internal.a.b<T> nSv;
    private final AtomicReference<io.reactivex.disposables.b> subscription;

    @Override // io.reactivex.c
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        this.nWv = Thread.currentThread();
        if (bVar == null) {
            this.errors.add(new NullPointerException("onSubscribe received a null Subscription"));
        } else if (!this.subscription.compareAndSet(null, bVar)) {
            bVar.dispose();
            if (this.subscription.get() != DisposableHelper.DISPOSED) {
                this.errors.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + bVar));
            }
        } else {
            if (this.nWx != 0 && (bVar instanceof io.reactivex.internal.a.b)) {
                this.nSv = (io.reactivex.internal.a.b) bVar;
                int requestFusion = this.nSv.requestFusion(this.nWx);
                this.nWy = requestFusion;
                if (requestFusion == 1) {
                    this.nWw = true;
                    this.nWv = Thread.currentThread();
                    while (true) {
                        try {
                            T poll = this.nSv.poll();
                            if (poll != null) {
                                this.values.add(poll);
                            } else {
                                this.nWu++;
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
        if (!this.nWw) {
            this.nWw = true;
            if (this.subscription.get() == null) {
                this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.nWv = Thread.currentThread();
        if (this.nWy != 2) {
            this.values.add(t);
            if (t == null) {
                this.errors.add(new NullPointerException("onNext received a null value"));
            }
            this.actual.onNext(t);
            return;
        }
        while (true) {
            try {
                T poll = this.nSv.poll();
                if (poll != null) {
                    this.values.add(poll);
                } else {
                    return;
                }
            } catch (Throwable th) {
                this.errors.add(th);
                this.nSv.dispose();
                return;
            }
        }
    }

    @Override // io.reactivex.c
    public void onError(Throwable th) {
        if (!this.nWw) {
            this.nWw = true;
            if (this.subscription.get() == null) {
                this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.nWv = Thread.currentThread();
            if (th == null) {
                this.errors.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.errors.add(th);
            }
            this.actual.onError(th);
        } finally {
            this.nWt.countDown();
        }
    }

    @Override // io.reactivex.c
    public void onComplete() {
        if (!this.nWw) {
            this.nWw = true;
            if (this.subscription.get() == null) {
                this.errors.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.nWv = Thread.currentThread();
            this.nWu++;
            this.actual.onComplete();
        } finally {
            this.nWt.countDown();
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

    /* loaded from: classes7.dex */
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
