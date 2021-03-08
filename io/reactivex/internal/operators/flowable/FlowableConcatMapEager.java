package io.reactivex.internal.operators.flowable;

import io.reactivex.b.h;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.a.f;
import io.reactivex.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.a.d;
/* loaded from: classes6.dex */
public final class FlowableConcatMapEager<T, R> extends a<T, R> {
    final ErrorMode errorMode;
    final h<? super T, ? extends org.a.b<? extends R>> mapper;
    final int maxConcurrency;
    final int prefetch;

    @Override // io.reactivex.g
    protected void a(org.a.c<? super R> cVar) {
        this.qoY.a((j) new ConcatMapEagerDelayErrorSubscriber(cVar, this.mapper, this.maxConcurrency, this.prefetch, this.errorMode));
    }

    /* loaded from: classes6.dex */
    static final class ConcatMapEagerDelayErrorSubscriber<T, R> extends AtomicInteger implements io.reactivex.internal.subscribers.c<R>, j<T>, d {
        private static final long serialVersionUID = -4255299542215038287L;
        final org.a.c<? super R> actual;
        volatile boolean cancelled;
        volatile InnerQueuedSubscriber<R> current;
        volatile boolean done;
        final ErrorMode errorMode;
        final h<? super T, ? extends org.a.b<? extends R>> mapper;
        final int maxConcurrency;
        final int prefetch;
        d s;
        final io.reactivex.internal.queue.a<InnerQueuedSubscriber<R>> subscribers;
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicLong requested = new AtomicLong();

        ConcatMapEagerDelayErrorSubscriber(org.a.c<? super R> cVar, h<? super T, ? extends org.a.b<? extends R>> hVar, int i, int i2, ErrorMode errorMode) {
            this.actual = cVar;
            this.mapper = hVar;
            this.maxConcurrency = i;
            this.prefetch = i2;
            this.errorMode = errorMode;
            this.subscribers = new io.reactivex.internal.queue.a<>(Math.min(i2, i));
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(this.maxConcurrency == Integer.MAX_VALUE ? Long.MAX_VALUE : this.maxConcurrency);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            try {
                org.a.b bVar = (org.a.b) io.reactivex.internal.functions.a.n(this.mapper.apply(t), "The mapper returned a null Publisher");
                InnerQueuedSubscriber<R> innerQueuedSubscriber = new InnerQueuedSubscriber<>(this, this.prefetch);
                if (!this.cancelled) {
                    this.subscribers.offer(innerQueuedSubscriber);
                    if (!this.cancelled) {
                        bVar.subscribe(innerQueuedSubscriber);
                        if (this.cancelled) {
                            innerQueuedSubscriber.cancel();
                            drainAndCancel();
                        }
                    }
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.N(th);
                this.s.cancel();
                onError(th);
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.errors.addThrowable(th)) {
                this.done = true;
                drain();
                return;
            }
            io.reactivex.d.a.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.a.d
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.s.cancel();
                drainAndCancel();
            }
        }

        void drainAndCancel() {
            if (getAndIncrement() == 0) {
                do {
                    cancelAll();
                } while (decrementAndGet() != 0);
            }
        }

        void cancelAll() {
            while (true) {
                InnerQueuedSubscriber<R> poll = this.subscribers.poll();
                if (poll != null) {
                    poll.cancel();
                } else {
                    return;
                }
            }
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
                drain();
            }
        }

        @Override // io.reactivex.internal.subscribers.c
        public void innerNext(InnerQueuedSubscriber<R> innerQueuedSubscriber, R r) {
            if (innerQueuedSubscriber.queue().offer(r)) {
                drain();
                return;
            }
            innerQueuedSubscriber.cancel();
            innerError(innerQueuedSubscriber, new MissingBackpressureException());
        }

        @Override // io.reactivex.internal.subscribers.c
        public void innerError(InnerQueuedSubscriber<R> innerQueuedSubscriber, Throwable th) {
            if (this.errors.addThrowable(th)) {
                innerQueuedSubscriber.setDone();
                if (this.errorMode != ErrorMode.END) {
                    this.s.cancel();
                }
                drain();
                return;
            }
            io.reactivex.d.a.onError(th);
        }

        @Override // io.reactivex.internal.subscribers.c
        public void innerComplete(InnerQueuedSubscriber<R> innerQueuedSubscriber) {
            innerQueuedSubscriber.setDone();
            drain();
        }

        @Override // io.reactivex.internal.subscribers.c
        public void drain() {
            f<R> queue;
            if (getAndIncrement() == 0) {
                int i = 1;
                InnerQueuedSubscriber<R> innerQueuedSubscriber = this.current;
                org.a.c<? super R> cVar = this.actual;
                ErrorMode errorMode = this.errorMode;
                while (true) {
                    long j = this.requested.get();
                    long j2 = 0;
                    if (innerQueuedSubscriber == null) {
                        if (errorMode != ErrorMode.END && this.errors.get() != null) {
                            cancelAll();
                            cVar.onError(this.errors.terminate());
                            return;
                        }
                        boolean z = this.done;
                        innerQueuedSubscriber = this.subscribers.poll();
                        if (z && innerQueuedSubscriber == null) {
                            Throwable terminate = this.errors.terminate();
                            if (terminate != null) {
                                cVar.onError(terminate);
                                return;
                            } else {
                                cVar.onComplete();
                                return;
                            }
                        } else if (innerQueuedSubscriber != null) {
                            this.current = innerQueuedSubscriber;
                        }
                    }
                    InnerQueuedSubscriber<R> innerQueuedSubscriber2 = innerQueuedSubscriber;
                    boolean z2 = false;
                    if (innerQueuedSubscriber2 != null && (queue = innerQueuedSubscriber2.queue()) != null) {
                        while (true) {
                            if (j2 == j) {
                                break;
                            } else if (this.cancelled) {
                                cancelAll();
                                return;
                            } else if (errorMode == ErrorMode.IMMEDIATE && this.errors.get() != null) {
                                this.current = null;
                                innerQueuedSubscriber2.cancel();
                                cancelAll();
                                cVar.onError(this.errors.terminate());
                                return;
                            } else {
                                boolean isDone = innerQueuedSubscriber2.isDone();
                                try {
                                    R poll = queue.poll();
                                    boolean z3 = poll == null;
                                    if (isDone && z3) {
                                        innerQueuedSubscriber2 = null;
                                        this.current = null;
                                        this.s.request(1L);
                                        z2 = true;
                                        break;
                                    } else if (z3) {
                                        break;
                                    } else {
                                        cVar.onNext(poll);
                                        j2++;
                                        innerQueuedSubscriber2.requestOne();
                                    }
                                } catch (Throwable th) {
                                    io.reactivex.exceptions.a.N(th);
                                    this.current = null;
                                    innerQueuedSubscriber2.cancel();
                                    cancelAll();
                                    cVar.onError(th);
                                    return;
                                }
                            }
                        }
                        if (j2 == j) {
                            if (this.cancelled) {
                                cancelAll();
                                return;
                            } else if (errorMode == ErrorMode.IMMEDIATE && this.errors.get() != null) {
                                this.current = null;
                                innerQueuedSubscriber2.cancel();
                                cancelAll();
                                cVar.onError(this.errors.terminate());
                                return;
                            } else {
                                boolean isDone2 = innerQueuedSubscriber2.isDone();
                                boolean isEmpty = queue.isEmpty();
                                if (isDone2 && isEmpty) {
                                    innerQueuedSubscriber = null;
                                    this.current = null;
                                    this.s.request(1L);
                                    z2 = true;
                                    if (j2 != 0 && j != Long.MAX_VALUE) {
                                        this.requested.addAndGet(-j2);
                                    }
                                    if (z2 && (i = addAndGet(-i)) == 0) {
                                        return;
                                    }
                                }
                            }
                        }
                    }
                    innerQueuedSubscriber = innerQueuedSubscriber2;
                    if (j2 != 0) {
                        this.requested.addAndGet(-j2);
                    }
                    if (z2) {
                    }
                }
            }
        }
    }
}
