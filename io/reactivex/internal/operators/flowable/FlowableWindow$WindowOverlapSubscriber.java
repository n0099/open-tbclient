package io.reactivex.internal.operators.flowable;

import f.a.e;
import f.a.g;
import f.a.x.f.a;
import f.a.x.i.b;
import g.d.c;
import g.d.d;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.UnicastProcessor;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public final class FlowableWindow$WindowOverlapSubscriber<T> extends AtomicInteger implements g<T>, d, Runnable {
    public static final long serialVersionUID = 2428527070996323976L;
    public final c<? super e<T>> actual;
    public final int bufferSize;
    public volatile boolean cancelled;
    public volatile boolean done;
    public Throwable error;
    public final AtomicBoolean firstRequest;
    public long index;
    public final AtomicBoolean once;
    public long produced;
    public final a<UnicastProcessor<T>> queue;
    public final AtomicLong requested;
    public d s;
    public final long size;
    public final long skip;
    public final ArrayDeque<UnicastProcessor<T>> windows;
    public final AtomicInteger wip;

    public FlowableWindow$WindowOverlapSubscriber(c<? super e<T>> cVar, long j, long j2, int i) {
        super(1);
        this.actual = cVar;
        this.size = j;
        this.skip = j2;
        this.queue = new a<>(i);
        this.windows = new ArrayDeque<>();
        this.once = new AtomicBoolean();
        this.firstRequest = new AtomicBoolean();
        this.requested = new AtomicLong();
        this.wip = new AtomicInteger();
        this.bufferSize = i;
    }

    @Override // g.d.d
    public void cancel() {
        this.cancelled = true;
        if (this.once.compareAndSet(false, true)) {
            run();
        }
    }

    public boolean checkTerminated(boolean z, boolean z2, c<?> cVar, a<?> aVar) {
        if (this.cancelled) {
            aVar.clear();
            return true;
        } else if (z) {
            Throwable th = this.error;
            if (th != null) {
                aVar.clear();
                cVar.onError(th);
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

    public void drain() {
        if (this.wip.getAndIncrement() != 0) {
            return;
        }
        c<? super e<T>> cVar = this.actual;
        a<UnicastProcessor<T>> aVar = this.queue;
        int i = 1;
        do {
            long j = this.requested.get();
            long j2 = 0;
            while (j2 != j) {
                boolean z = this.done;
                UnicastProcessor<T> poll = aVar.poll();
                boolean z2 = poll == null;
                if (checkTerminated(z, z2, cVar, aVar)) {
                    return;
                }
                if (z2) {
                    break;
                }
                cVar.onNext(poll);
                j2++;
            }
            if (j2 == j && checkTerminated(this.done, aVar.isEmpty(), cVar, aVar)) {
                return;
            }
            if (j2 != 0 && j != Long.MAX_VALUE) {
                this.requested.addAndGet(-j2);
            }
            i = this.wip.addAndGet(-i);
        } while (i != 0);
    }

    @Override // g.d.c
    public void onComplete() {
        if (this.done) {
            return;
        }
        Iterator<UnicastProcessor<T>> it = this.windows.iterator();
        while (it.hasNext()) {
            it.next().onComplete();
        }
        this.windows.clear();
        this.done = true;
        drain();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        if (this.done) {
            f.a.a0.a.f(th);
            return;
        }
        Iterator<UnicastProcessor<T>> it = this.windows.iterator();
        while (it.hasNext()) {
            it.next().onError(th);
        }
        this.windows.clear();
        this.error = th;
        this.done = true;
        drain();
    }

    @Override // g.d.c
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        long j = this.index;
        if (j == 0 && !this.cancelled) {
            getAndIncrement();
            UnicastProcessor<T> f2 = UnicastProcessor.f(this.bufferSize, this);
            this.windows.offer(f2);
            this.queue.offer(f2);
            drain();
        }
        long j2 = j + 1;
        Iterator<UnicastProcessor<T>> it = this.windows.iterator();
        while (it.hasNext()) {
            it.next().onNext(t);
        }
        long j3 = this.produced + 1;
        if (j3 == this.size) {
            this.produced = j3 - this.skip;
            UnicastProcessor<T> poll = this.windows.poll();
            if (poll != null) {
                poll.onComplete();
            }
        } else {
            this.produced = j3;
        }
        if (j2 == this.skip) {
            this.index = 0L;
        } else {
            this.index = j2;
        }
    }

    @Override // f.a.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            b.a(this.requested, j);
            if (!this.firstRequest.get() && this.firstRequest.compareAndSet(false, true)) {
                this.s.request(b.c(this.size, b.d(this.skip, j - 1)));
            } else {
                this.s.request(b.d(this.skip, j));
            }
            drain();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (decrementAndGet() == 0) {
            this.s.cancel();
        }
    }
}
