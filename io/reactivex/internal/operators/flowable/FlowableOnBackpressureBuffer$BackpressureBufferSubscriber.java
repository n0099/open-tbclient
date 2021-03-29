package io.reactivex.internal.operators.flowable;

import f.a.g;
import f.a.w.a;
import f.a.x.c.e;
import f.a.x.i.b;
import g.d.c;
import g.d.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class FlowableOnBackpressureBuffer$BackpressureBufferSubscriber<T> extends BasicIntQueueSubscription<T> implements g<T> {
    public static final long serialVersionUID = -2514538129242366402L;
    public final c<? super T> actual;
    public volatile boolean cancelled;
    public final boolean delayError;
    public volatile boolean done;
    public Throwable error;
    public final a onOverflow;
    public boolean outputFused;
    public final e<T> queue;
    public final AtomicLong requested = new AtomicLong();
    public d s;

    public FlowableOnBackpressureBuffer$BackpressureBufferSubscriber(c<? super T> cVar, int i, boolean z, boolean z2, a aVar) {
        e<T> spscArrayQueue;
        this.actual = cVar;
        this.onOverflow = aVar;
        this.delayError = z2;
        if (z) {
            spscArrayQueue = new f.a.x.f.a<>(i);
        } else {
            spscArrayQueue = new SpscArrayQueue<>(i);
        }
        this.queue = spscArrayQueue;
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, g.d.d
    public void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.s.cancel();
        if (getAndIncrement() == 0) {
            this.queue.clear();
        }
    }

    public boolean checkTerminated(boolean z, boolean z2, c<? super T> cVar) {
        if (this.cancelled) {
            this.queue.clear();
            return true;
        } else if (z) {
            if (this.delayError) {
                if (z2) {
                    Throwable th = this.error;
                    if (th != null) {
                        cVar.onError(th);
                    } else {
                        cVar.onComplete();
                    }
                    return true;
                }
                return false;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                this.queue.clear();
                cVar.onError(th2);
                return true;
            } else if (z2) {
                cVar.onComplete();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.a.x.c.f
    public void clear() {
        this.queue.clear();
    }

    public void drain() {
        int i;
        if (getAndIncrement() == 0) {
            e<T> eVar = this.queue;
            c<? super T> cVar = this.actual;
            int i2 = 1;
            while (!checkTerminated(this.done, eVar.isEmpty(), cVar)) {
                long j = this.requested.get();
                long j2 = 0;
                while (true) {
                    i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                    if (i == 0) {
                        break;
                    }
                    boolean z = this.done;
                    Object obj = (T) eVar.poll();
                    boolean z2 = obj == null;
                    if (checkTerminated(z, z2, cVar)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    cVar.onNext(obj);
                    j2++;
                }
                if (i == 0 && checkTerminated(this.done, eVar.isEmpty(), cVar)) {
                    return;
                }
                if (j2 != 0 && j != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j2);
                }
                i2 = addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
        }
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.a.x.c.f
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override // g.d.c
    public void onComplete() {
        this.done = true;
        if (this.outputFused) {
            this.actual.onComplete();
        } else {
            drain();
        }
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        if (this.outputFused) {
            this.actual.onError(th);
        } else {
            drain();
        }
    }

    @Override // g.d.c
    public void onNext(T t) {
        if (!this.queue.offer(t)) {
            this.s.cancel();
            MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Buffer is full");
            try {
                this.onOverflow.run();
            } catch (Throwable th) {
                f.a.u.a.a(th);
                missingBackpressureException.initCause(th);
            }
            onError(missingBackpressureException);
        } else if (this.outputFused) {
            this.actual.onNext(null);
        } else {
            drain();
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

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.a.x.c.f
    public T poll() throws Exception {
        return this.queue.poll();
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, g.d.d
    public void request(long j) {
        if (this.outputFused || !SubscriptionHelper.validate(j)) {
            return;
        }
        b.a(this.requested, j);
        drain();
    }

    @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, f.a.x.c.c
    public int requestFusion(int i) {
        if ((i & 2) != 0) {
            this.outputFused = true;
            return 2;
        }
        return 0;
    }
}
