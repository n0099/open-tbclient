package io.reactivex.internal.operators.flowable;

import f.a.g;
import f.a.w.h;
import f.a.x.c.f;
import f.a.x.h.a;
import g.d.b;
import g.d.c;
import g.d.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class FlowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber<T, R> extends AtomicInteger implements g<T>, d, a<R> {
    public static final long serialVersionUID = -4255299542215038287L;
    public final c<? super R> actual;
    public volatile boolean cancelled;
    public volatile InnerQueuedSubscriber<R> current;
    public volatile boolean done;
    public final ErrorMode errorMode;
    public final h<? super T, ? extends b<? extends R>> mapper;
    public final int maxConcurrency;
    public final int prefetch;
    public d s;
    public final f.a.x.f.a<InnerQueuedSubscriber<R>> subscribers;
    public final AtomicThrowable errors = new AtomicThrowable();
    public final AtomicLong requested = new AtomicLong();

    public FlowableConcatMapEager$ConcatMapEagerDelayErrorSubscriber(c<? super R> cVar, h<? super T, ? extends b<? extends R>> hVar, int i, int i2, ErrorMode errorMode) {
        this.actual = cVar;
        this.mapper = hVar;
        this.maxConcurrency = i;
        this.prefetch = i2;
        this.errorMode = errorMode;
        this.subscribers = new f.a.x.f.a<>(Math.min(i2, i));
    }

    @Override // g.d.d
    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.s.cancel();
        drainAndCancel();
    }

    public void cancelAll() {
        while (true) {
            InnerQueuedSubscriber<R> poll = this.subscribers.poll();
            if (poll == null) {
                return;
            }
            poll.cancel();
        }
    }

    @Override // f.a.x.h.a
    public void drain() {
        InnerQueuedSubscriber<R> innerQueuedSubscriber;
        int i;
        long j;
        boolean z;
        f<R> queue;
        if (getAndIncrement() != 0) {
            return;
        }
        InnerQueuedSubscriber<R> innerQueuedSubscriber2 = this.current;
        c<? super R> cVar = this.actual;
        ErrorMode errorMode = this.errorMode;
        int i2 = 1;
        while (true) {
            long j2 = this.requested.get();
            if (innerQueuedSubscriber2 != null) {
                innerQueuedSubscriber = innerQueuedSubscriber2;
            } else if (errorMode != ErrorMode.END && this.errors.get() != null) {
                cancelAll();
                cVar.onError(this.errors.terminate());
                return;
            } else {
                boolean z2 = this.done;
                innerQueuedSubscriber = this.subscribers.poll();
                if (z2 && innerQueuedSubscriber == null) {
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
            if (innerQueuedSubscriber == null || (queue = innerQueuedSubscriber.queue()) == null) {
                i = i2;
                j = 0;
                z = false;
            } else {
                i = i2;
                j = 0;
                while (j != j2) {
                    if (this.cancelled) {
                        cancelAll();
                        return;
                    } else if (errorMode == ErrorMode.IMMEDIATE && this.errors.get() != null) {
                        this.current = null;
                        innerQueuedSubscriber.cancel();
                        cancelAll();
                        cVar.onError(this.errors.terminate());
                        return;
                    } else {
                        boolean isDone = innerQueuedSubscriber.isDone();
                        try {
                            R poll = queue.poll();
                            boolean z3 = poll == null;
                            if (isDone && z3) {
                                this.current = null;
                                this.s.request(1L);
                                innerQueuedSubscriber = null;
                                z = true;
                                break;
                            } else if (z3) {
                                break;
                            } else {
                                cVar.onNext(poll);
                                j++;
                                innerQueuedSubscriber.requestOne();
                            }
                        } catch (Throwable th) {
                            f.a.u.a.a(th);
                            this.current = null;
                            innerQueuedSubscriber.cancel();
                            cancelAll();
                            cVar.onError(th);
                            return;
                        }
                    }
                }
                z = false;
                if (j == j2) {
                    if (this.cancelled) {
                        cancelAll();
                        return;
                    } else if (errorMode == ErrorMode.IMMEDIATE && this.errors.get() != null) {
                        this.current = null;
                        innerQueuedSubscriber.cancel();
                        cancelAll();
                        cVar.onError(this.errors.terminate());
                        return;
                    } else {
                        boolean isDone2 = innerQueuedSubscriber.isDone();
                        boolean isEmpty = queue.isEmpty();
                        if (isDone2 && isEmpty) {
                            this.current = null;
                            this.s.request(1L);
                            innerQueuedSubscriber = null;
                            z = true;
                        }
                    }
                }
            }
            if (j != 0 && j2 != Long.MAX_VALUE) {
                this.requested.addAndGet(-j);
            }
            if (z) {
                innerQueuedSubscriber2 = innerQueuedSubscriber;
                i2 = i;
            } else {
                i2 = addAndGet(-i);
                if (i2 == 0) {
                    return;
                }
                innerQueuedSubscriber2 = innerQueuedSubscriber;
            }
        }
    }

    public void drainAndCancel() {
        if (getAndIncrement() == 0) {
            do {
                cancelAll();
            } while (decrementAndGet() != 0);
        }
    }

    @Override // f.a.x.h.a
    public void innerComplete(InnerQueuedSubscriber<R> innerQueuedSubscriber) {
        innerQueuedSubscriber.setDone();
        drain();
    }

    @Override // f.a.x.h.a
    public void innerError(InnerQueuedSubscriber<R> innerQueuedSubscriber, Throwable th) {
        if (this.errors.addThrowable(th)) {
            innerQueuedSubscriber.setDone();
            if (this.errorMode != ErrorMode.END) {
                this.s.cancel();
            }
            drain();
            return;
        }
        f.a.a0.a.f(th);
    }

    @Override // f.a.x.h.a
    public void innerNext(InnerQueuedSubscriber<R> innerQueuedSubscriber, R r) {
        if (innerQueuedSubscriber.queue().offer(r)) {
            drain();
            return;
        }
        innerQueuedSubscriber.cancel();
        innerError(innerQueuedSubscriber, new MissingBackpressureException());
    }

    @Override // g.d.c
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        if (this.errors.addThrowable(th)) {
            this.done = true;
            drain();
            return;
        }
        f.a.a0.a.f(th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        try {
            b<? extends R> apply = this.mapper.apply(t);
            f.a.x.b.a.b(apply, "The mapper returned a null Publisher");
            b<? extends R> bVar = apply;
            InnerQueuedSubscriber<R> innerQueuedSubscriber = new InnerQueuedSubscriber<>(this, this.prefetch);
            if (this.cancelled) {
                return;
            }
            this.subscribers.offer(innerQueuedSubscriber);
            if (this.cancelled) {
                return;
            }
            bVar.subscribe(innerQueuedSubscriber);
            if (this.cancelled) {
                innerQueuedSubscriber.cancel();
                drainAndCancel();
            }
        } catch (Throwable th) {
            f.a.u.a.a(th);
            this.s.cancel();
            onError(th);
        }
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
            int i = this.maxConcurrency;
            dVar.request(i == Integer.MAX_VALUE ? Long.MAX_VALUE : i);
        }
    }

    @Override // g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            f.a.x.i.b.a(this.requested, j);
            drain();
        }
    }
}
