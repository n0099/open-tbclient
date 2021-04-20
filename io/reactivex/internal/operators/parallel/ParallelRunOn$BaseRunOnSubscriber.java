package io.reactivex.internal.operators.parallel;

import f.b.a0.a;
import f.b.g;
import f.b.p;
import f.b.x.i.b;
import g.d.d;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public abstract class ParallelRunOn$BaseRunOnSubscriber<T> extends AtomicInteger implements g<T>, d, Runnable {
    public static final long serialVersionUID = 9222303586456402150L;
    public volatile boolean cancelled;
    public int consumed;
    public volatile boolean done;
    public Throwable error;
    public final int limit;
    public final int prefetch;
    public final SpscArrayQueue<T> queue;
    public final AtomicLong requested = new AtomicLong();
    public d s;
    public final p.c worker;

    public ParallelRunOn$BaseRunOnSubscriber(int i, SpscArrayQueue<T> spscArrayQueue, p.c cVar) {
        this.prefetch = i;
        this.queue = spscArrayQueue;
        this.limit = i - (i >> 2);
        this.worker = cVar;
    }

    @Override // g.d.d
    public final void cancel() {
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        this.s.cancel();
        this.worker.dispose();
        if (getAndIncrement() == 0) {
            this.queue.clear();
        }
    }

    @Override // g.d.c
    public final void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        schedule();
    }

    @Override // g.d.c
    public final void onError(Throwable th) {
        if (this.done) {
            a.f(th);
            return;
        }
        this.error = th;
        this.done = true;
        schedule();
    }

    @Override // g.d.c
    public final void onNext(T t) {
        if (this.done) {
            return;
        }
        if (!this.queue.offer(t)) {
            this.s.cancel();
            onError(new MissingBackpressureException("Queue is full?!"));
            return;
        }
        schedule();
    }

    @Override // f.b.g, g.d.c
    public abstract /* synthetic */ void onSubscribe(d dVar);

    @Override // g.d.d
    public final void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            b.a(this.requested, j);
            schedule();
        }
    }

    public final void schedule() {
        if (getAndIncrement() == 0) {
            this.worker.b(this);
        }
    }
}
