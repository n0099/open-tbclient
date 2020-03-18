package io.reactivex.internal.operators.completable;

import io.reactivex.a;
import io.reactivex.c;
import io.reactivex.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.a.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.a.b;
import org.a.d;
/* loaded from: classes7.dex */
public final class CompletableConcat extends a {
    final b<? extends e> nyl;
    final int prefetch;

    @Override // io.reactivex.a
    public void b(c cVar) {
        this.nyl.subscribe(new CompletableConcatSubscriber(cVar, this.prefetch));
    }

    /* loaded from: classes7.dex */
    static final class CompletableConcatSubscriber extends AtomicInteger implements io.reactivex.disposables.b, j<e> {
        private static final long serialVersionUID = 9032184911934499404L;
        volatile boolean active;
        final c actual;
        int consumed;
        volatile boolean done;
        final int limit;
        final int prefetch;
        g<e> queue;
        d s;
        int sourceFused;
        final ConcatInnerObserver inner = new ConcatInnerObserver(this);
        final AtomicBoolean once = new AtomicBoolean();

        CompletableConcatSubscriber(c cVar, int i) {
            this.actual = cVar;
            this.prefetch = i;
            this.limit = i - (i >> 2);
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                long j = this.prefetch == Integer.MAX_VALUE ? Long.MAX_VALUE : this.prefetch;
                if (dVar instanceof io.reactivex.internal.a.d) {
                    io.reactivex.internal.a.d dVar2 = (io.reactivex.internal.a.d) dVar;
                    int requestFusion = dVar2.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceFused = requestFusion;
                        this.queue = dVar2;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceFused = requestFusion;
                        this.queue = dVar2;
                        this.actual.onSubscribe(this);
                        dVar.request(j);
                        return;
                    }
                }
                if (this.prefetch == Integer.MAX_VALUE) {
                    this.queue = new io.reactivex.internal.queue.a(io.reactivex.g.dJD());
                } else {
                    this.queue = new SpscArrayQueue(this.prefetch);
                }
                this.actual.onSubscribe(this);
                dVar.request(j);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // org.a.c
        public void onNext(e eVar) {
            if (this.sourceFused == 0 && !this.queue.offer(eVar)) {
                onError(new MissingBackpressureException());
            } else {
                drain();
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.once.compareAndSet(false, true)) {
                DisposableHelper.dispose(this.inner);
                this.actual.onError(th);
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.s.cancel();
            DisposableHelper.dispose(this.inner);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.inner.get());
        }

        void drain() {
            if (getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.active) {
                        boolean z = this.done;
                        try {
                            e poll = this.queue.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                if (this.once.compareAndSet(false, true)) {
                                    this.actual.onComplete();
                                    return;
                                }
                                return;
                            } else if (!z2) {
                                this.active = true;
                                poll.a(this.inner);
                                request();
                            }
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.H(th);
                            innerError(th);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        void request() {
            if (this.sourceFused != 1) {
                int i = this.consumed + 1;
                if (i == this.limit) {
                    this.consumed = 0;
                    this.s.request(i);
                    return;
                }
                this.consumed = i;
            }
        }

        void innerError(Throwable th) {
            if (this.once.compareAndSet(false, true)) {
                this.s.cancel();
                this.actual.onError(th);
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        void innerComplete() {
            this.active = false;
            drain();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes7.dex */
        public static final class ConcatInnerObserver extends AtomicReference<io.reactivex.disposables.b> implements c {
            private static final long serialVersionUID = -5454794857847146511L;
            final CompletableConcatSubscriber parent;

            ConcatInnerObserver(CompletableConcatSubscriber completableConcatSubscriber) {
                this.parent = completableConcatSubscriber;
            }

            @Override // io.reactivex.c
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.replace(this, bVar);
            }

            @Override // io.reactivex.c
            public void onError(Throwable th) {
                this.parent.innerError(th);
            }

            @Override // io.reactivex.c
            public void onComplete() {
                this.parent.innerComplete();
            }
        }
    }
}
