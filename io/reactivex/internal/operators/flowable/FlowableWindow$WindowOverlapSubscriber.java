package io.reactivex.internal.operators.flowable;

import f.b.e;
import f.b.g;
import f.b.x.f.a;
import f.b.x.i.b;
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

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
        if (r10 != 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0046, code lost:
        if (checkTerminated(r14.done, r1.isEmpty(), r0, r1) == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0048, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:
        if (r8 == 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
        if (r4 == Long.MAX_VALUE) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0056, code lost:
        r14.requested.addAndGet(-r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005c, code lost:
        r3 = r14.wip.addAndGet(-r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
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
            while (true) {
                int i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                if (i2 == 0) {
                    break;
                }
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
            f.b.a0.a.f(th);
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

    @Override // f.b.g, g.d.c
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
