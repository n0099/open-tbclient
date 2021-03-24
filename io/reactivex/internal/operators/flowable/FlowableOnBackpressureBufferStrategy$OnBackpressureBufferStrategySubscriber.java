package io.reactivex.internal.operators.flowable;

import f.a.g;
import f.a.w.a;
import f.a.x.e.a.h;
import f.a.x.i.b;
import g.d.c;
import g.d.d;
import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class FlowableOnBackpressureBufferStrategy$OnBackpressureBufferStrategySubscriber<T> extends AtomicInteger implements g<T>, d {
    public static final long serialVersionUID = 3240706908776709697L;
    public final c<? super T> actual;
    public final long bufferSize;
    public volatile boolean cancelled;
    public volatile boolean done;
    public Throwable error;
    public final a onOverflow;
    public d s;
    public final BackpressureOverflowStrategy strategy;
    public final AtomicLong requested = new AtomicLong();
    public final Deque<T> deque = new ArrayDeque();

    public FlowableOnBackpressureBufferStrategy$OnBackpressureBufferStrategySubscriber(c<? super T> cVar, a aVar, BackpressureOverflowStrategy backpressureOverflowStrategy, long j) {
        this.actual = cVar;
        this.onOverflow = aVar;
        this.strategy = backpressureOverflowStrategy;
        this.bufferSize = j;
    }

    @Override // g.d.d
    public void cancel() {
        this.cancelled = true;
        this.s.cancel();
        if (getAndIncrement() == 0) {
            clear(this.deque);
        }
    }

    public void clear(Deque<T> deque) {
        synchronized (deque) {
            deque.clear();
        }
    }

    public void drain() {
        boolean isEmpty;
        T poll;
        if (getAndIncrement() != 0) {
            return;
        }
        Deque<T> deque = this.deque;
        c<? super T> cVar = this.actual;
        int i = 1;
        do {
            long j = this.requested.get();
            long j2 = 0;
            while (j2 != j) {
                if (this.cancelled) {
                    clear(deque);
                    return;
                }
                boolean z = this.done;
                synchronized (deque) {
                    poll = deque.poll();
                }
                boolean z2 = poll == null;
                if (z) {
                    Throwable th = this.error;
                    if (th != null) {
                        clear(deque);
                        cVar.onError(th);
                        return;
                    } else if (z2) {
                        cVar.onComplete();
                        return;
                    }
                }
                if (z2) {
                    break;
                }
                cVar.onNext(poll);
                j2++;
            }
            if (j2 == j) {
                if (this.cancelled) {
                    clear(deque);
                    return;
                }
                boolean z3 = this.done;
                synchronized (deque) {
                    isEmpty = deque.isEmpty();
                }
                if (z3) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        clear(deque);
                        cVar.onError(th2);
                        return;
                    } else if (isEmpty) {
                        cVar.onComplete();
                        return;
                    }
                }
            }
            if (j2 != 0) {
                b.e(this.requested, j2);
            }
            i = addAndGet(-i);
        } while (i != 0);
    }

    @Override // g.d.c
    public void onComplete() {
        this.done = true;
        drain();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        if (this.done) {
            f.a.a0.a.f(th);
            return;
        }
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // g.d.c
    public void onNext(T t) {
        boolean z;
        boolean z2;
        if (this.done) {
            return;
        }
        Deque<T> deque = this.deque;
        synchronized (deque) {
            z = false;
            z2 = true;
            if (deque.size() == this.bufferSize) {
                int i = h.f67481a[this.strategy.ordinal()];
                if (i == 1) {
                    deque.pollLast();
                    deque.offer(t);
                } else if (i == 2) {
                    deque.poll();
                    deque.offer(t);
                }
                z = true;
            } else {
                deque.offer(t);
            }
            z2 = false;
        }
        if (!z) {
            if (z2) {
                this.s.cancel();
                onError(new MissingBackpressureException());
                return;
            }
            drain();
            return;
        }
        a aVar = this.onOverflow;
        if (aVar != null) {
            try {
                aVar.run();
            } catch (Throwable th) {
                f.a.u.a.a(th);
                this.s.cancel();
                onError(th);
            }
        }
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
            dVar.request(Long.MAX_VALUE);
        }
    }

    @Override // g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            b.a(this.requested, j);
            drain();
        }
    }
}
