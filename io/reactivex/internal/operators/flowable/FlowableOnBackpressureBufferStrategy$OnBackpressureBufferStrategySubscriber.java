package io.reactivex.internal.operators.flowable;

import f.b.g;
import f.b.w.a;
import f.b.x.e.a.h;
import f.b.x.i.b;
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

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004f, code lost:
        if (r10 != 0) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0053, code lost:
        if (r14.cancelled == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0055, code lost:
        clear(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0058, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0059, code lost:
        r4 = r14.done;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x005b, code lost:
        monitor-enter(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x005c, code lost:
        r5 = r0.isEmpty();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0060, code lost:
        monitor-exit(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0061, code lost:
        if (r4 == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0063, code lost:
        r4 = r14.error;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0065, code lost:
        if (r4 == null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0067, code lost:
        clear(r0);
        r1.onError(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x006d, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x006e, code lost:
        if (r5 == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0070, code lost:
        r1.onComplete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0073, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0079, code lost:
        if (r8 == 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x007b, code lost:
        f.b.x.i.b.e(r14.requested, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0080, code lost:
        r3 = addAndGet(-r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drain() {
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
            while (true) {
                int i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                if (i2 == 0) {
                    break;
                } else if (this.cancelled) {
                    clear(deque);
                    return;
                } else {
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
            }
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
            f.b.a0.a.f(th);
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
                int i = h.f68492a[this.strategy.ordinal()];
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
                f.b.u.a.a(th);
                this.s.cancel();
                onError(th);
            }
        }
    }

    @Override // f.b.g, g.d.c
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
