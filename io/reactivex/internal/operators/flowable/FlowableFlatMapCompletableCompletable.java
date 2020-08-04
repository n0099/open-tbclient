package io.reactivex.internal.operators.flowable;

import io.reactivex.c.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableFlatMapCompletableCompletable<T> extends io.reactivex.a {
    final boolean delayErrors;
    final h<? super T, ? extends io.reactivex.e> mapper;
    final int maxConcurrency;
    final io.reactivex.g<T> nSG;

    @Override // io.reactivex.a
    protected void b(io.reactivex.c cVar) {
        this.nSG.a((j) new FlatMapCompletableMainSubscriber(cVar, this.mapper, this.delayErrors, this.maxConcurrency));
    }

    /* loaded from: classes7.dex */
    static final class FlatMapCompletableMainSubscriber<T> extends AtomicInteger implements io.reactivex.disposables.b, j<T> {
        private static final long serialVersionUID = 8443155186132538303L;
        final io.reactivex.c actual;
        final boolean delayErrors;
        volatile boolean disposed;
        final h<? super T, ? extends io.reactivex.e> mapper;
        final int maxConcurrency;
        org.a.d s;
        final AtomicThrowable errors = new AtomicThrowable();
        final io.reactivex.disposables.a set = new io.reactivex.disposables.a();

        FlatMapCompletableMainSubscriber(io.reactivex.c cVar, h<? super T, ? extends io.reactivex.e> hVar, boolean z, int i) {
            this.actual = cVar;
            this.mapper = hVar;
            this.delayErrors = z;
            this.maxConcurrency = i;
            lazySet(1);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                int i = this.maxConcurrency;
                if (i == Integer.MAX_VALUE) {
                    dVar.request(Long.MAX_VALUE);
                } else {
                    dVar.request(i);
                }
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            try {
                io.reactivex.e eVar = (io.reactivex.e) io.reactivex.internal.functions.a.k(this.mapper.apply(t), "The mapper returned a null CompletableSource");
                getAndIncrement();
                InnerObserver innerObserver = new InnerObserver();
                if (!this.disposed && this.set.a(innerObserver)) {
                    eVar.a(innerObserver);
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.K(th);
                this.s.cancel();
                onError(th);
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                if (this.delayErrors) {
                    if (decrementAndGet() == 0) {
                        this.actual.onError(this.errors.terminate());
                        return;
                    } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                        this.s.request(1L);
                        return;
                    } else {
                        return;
                    }
                }
                dispose();
                if (getAndSet(0) > 0) {
                    this.actual.onError(this.errors.terminate());
                    return;
                }
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable terminate = this.errors.terminate();
                if (terminate != null) {
                    this.actual.onError(terminate);
                } else {
                    this.actual.onComplete();
                }
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.s.request(1L);
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.disposed = true;
            this.s.cancel();
            this.set.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.set.isDisposed();
        }

        void innerComplete(FlatMapCompletableMainSubscriber<T>.InnerObserver innerObserver) {
            this.set.c(innerObserver);
            onComplete();
        }

        void innerError(FlatMapCompletableMainSubscriber<T>.InnerObserver innerObserver, Throwable th) {
            this.set.c(innerObserver);
            onError(th);
        }

        /* loaded from: classes7.dex */
        final class InnerObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.c, io.reactivex.disposables.b {
            private static final long serialVersionUID = 8606673141535671828L;

            InnerObserver() {
            }

            @Override // io.reactivex.c
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // io.reactivex.c
            public void onComplete() {
                FlatMapCompletableMainSubscriber.this.innerComplete(this);
            }

            @Override // io.reactivex.c
            public void onError(Throwable th) {
                FlatMapCompletableMainSubscriber.this.innerError(this, th);
            }

            @Override // io.reactivex.disposables.b
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.disposables.b
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }
        }
    }
}
