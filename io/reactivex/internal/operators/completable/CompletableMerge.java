package io.reactivex.internal.operators.completable;

import io.reactivex.a;
import io.reactivex.c;
import io.reactivex.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.a.b;
import org.a.d;
/* loaded from: classes25.dex */
public final class CompletableMerge extends a {
    final boolean delayErrors;
    final int maxConcurrency;
    final b<? extends e> source;

    @Override // io.reactivex.a
    public void b(c cVar) {
        this.source.subscribe(new CompletableMergeSubscriber(cVar, this.maxConcurrency, this.delayErrors));
    }

    /* loaded from: classes25.dex */
    static final class CompletableMergeSubscriber extends AtomicInteger implements io.reactivex.disposables.b, j<e> {
        private static final long serialVersionUID = -2108443387387077490L;
        final c actual;
        final boolean delayErrors;
        final int maxConcurrency;
        d s;
        final io.reactivex.disposables.a set = new io.reactivex.disposables.a();
        final AtomicThrowable error = new AtomicThrowable();

        CompletableMergeSubscriber(c cVar, int i, boolean z) {
            this.actual = cVar;
            this.maxConcurrency = i;
            this.delayErrors = z;
            lazySet(1);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.s.cancel();
            this.set.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.set.isDisposed();
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                if (this.maxConcurrency == Integer.MAX_VALUE) {
                    dVar.request(Long.MAX_VALUE);
                } else {
                    dVar.request(this.maxConcurrency);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // org.a.c
        public void onNext(e eVar) {
            getAndIncrement();
            MergeInnerObserver mergeInnerObserver = new MergeInnerObserver();
            this.set.a(mergeInnerObserver);
            eVar.a(mergeInnerObserver);
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (!this.delayErrors) {
                this.set.dispose();
                if (this.error.addThrowable(th)) {
                    if (getAndSet(0) > 0) {
                        this.actual.onError(this.error.terminate());
                        return;
                    }
                    return;
                }
                io.reactivex.e.a.onError(th);
            } else if (this.error.addThrowable(th)) {
                if (decrementAndGet() == 0) {
                    this.actual.onError(this.error.terminate());
                }
            } else {
                io.reactivex.e.a.onError(th);
            }
        }

        @Override // org.a.c
        public void onComplete() {
            if (decrementAndGet() == 0) {
                if (this.error.get() != null) {
                    this.actual.onError(this.error.terminate());
                } else {
                    this.actual.onComplete();
                }
            }
        }

        void innerError(MergeInnerObserver mergeInnerObserver, Throwable th) {
            this.set.c(mergeInnerObserver);
            if (!this.delayErrors) {
                this.s.cancel();
                this.set.dispose();
                if (this.error.addThrowable(th)) {
                    if (getAndSet(0) > 0) {
                        this.actual.onError(this.error.terminate());
                        return;
                    }
                    return;
                }
                io.reactivex.e.a.onError(th);
            } else if (this.error.addThrowable(th)) {
                if (decrementAndGet() == 0) {
                    this.actual.onError(this.error.terminate());
                } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                    this.s.request(1L);
                }
            } else {
                io.reactivex.e.a.onError(th);
            }
        }

        void innerComplete(MergeInnerObserver mergeInnerObserver) {
            this.set.c(mergeInnerObserver);
            if (decrementAndGet() == 0) {
                Throwable th = this.error.get();
                if (th != null) {
                    this.actual.onError(th);
                } else {
                    this.actual.onComplete();
                }
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.s.request(1L);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes25.dex */
        public final class MergeInnerObserver extends AtomicReference<io.reactivex.disposables.b> implements c, io.reactivex.disposables.b {
            private static final long serialVersionUID = 251330541679988317L;

            MergeInnerObserver() {
            }

            @Override // io.reactivex.c
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // io.reactivex.c
            public void onError(Throwable th) {
                CompletableMergeSubscriber.this.innerError(this, th);
            }

            @Override // io.reactivex.c
            public void onComplete() {
                CompletableMergeSubscriber.this.innerComplete(this);
            }

            @Override // io.reactivex.disposables.b
            public boolean isDisposed() {
                return DisposableHelper.isDisposed(get());
            }

            @Override // io.reactivex.disposables.b
            public void dispose() {
                DisposableHelper.dispose(this);
            }
        }
    }
}
