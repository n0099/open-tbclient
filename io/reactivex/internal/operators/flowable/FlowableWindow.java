package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.j;
import io.reactivex.processors.UnicastProcessor;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes17.dex */
public final class FlowableWindow<T> extends a<T, io.reactivex.g<T>> {
    final int bufferSize;
    final long size;
    final long skip;

    @Override // io.reactivex.g
    public void a(org.a.c<? super io.reactivex.g<T>> cVar) {
        if (this.skip == this.size) {
            this.oLT.a((j) new WindowExactSubscriber(cVar, this.size, this.bufferSize));
        } else if (this.skip > this.size) {
            this.oLT.a((j) new WindowSkipSubscriber(cVar, this.size, this.skip, this.bufferSize));
        } else {
            this.oLT.a((j) new WindowOverlapSubscriber(cVar, this.size, this.skip, this.bufferSize));
        }
    }

    /* loaded from: classes17.dex */
    static final class WindowExactSubscriber<T> extends AtomicInteger implements j<T>, Runnable, org.a.d {
        private static final long serialVersionUID = -2365647875069161133L;
        final org.a.c<? super io.reactivex.g<T>> actual;
        final int bufferSize;
        long index;
        final AtomicBoolean once;
        org.a.d s;
        final long size;
        UnicastProcessor<T> window;

        WindowExactSubscriber(org.a.c<? super io.reactivex.g<T>> cVar, long j, int i) {
            super(1);
            this.actual = cVar;
            this.size = j;
            this.once = new AtomicBoolean();
            this.bufferSize = i;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            long j = this.index;
            UnicastProcessor<T> unicastProcessor = this.window;
            if (j == 0) {
                getAndIncrement();
                unicastProcessor = UnicastProcessor.c(this.bufferSize, this);
                this.window = unicastProcessor;
                this.actual.onNext(unicastProcessor);
            }
            long j2 = j + 1;
            unicastProcessor.onNext(t);
            if (j2 == this.size) {
                this.index = 0L;
                this.window = null;
                unicastProcessor.onComplete();
                return;
            }
            this.index = j2;
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            UnicastProcessor<T> unicastProcessor = this.window;
            if (unicastProcessor != null) {
                this.window = null;
                unicastProcessor.onError(th);
            }
            this.actual.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            UnicastProcessor<T> unicastProcessor = this.window;
            if (unicastProcessor != null) {
                this.window = null;
                unicastProcessor.onComplete();
            }
            this.actual.onComplete();
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                this.s.request(io.reactivex.internal.util.b.N(this.size, j));
            }
        }

        @Override // org.a.d
        public void cancel() {
            if (this.once.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.s.cancel();
            }
        }
    }

    /* loaded from: classes17.dex */
    static final class WindowSkipSubscriber<T> extends AtomicInteger implements j<T>, Runnable, org.a.d {
        private static final long serialVersionUID = -8792836352386833856L;
        final org.a.c<? super io.reactivex.g<T>> actual;
        final int bufferSize;
        final AtomicBoolean firstRequest;
        long index;
        final AtomicBoolean once;
        org.a.d s;
        final long size;
        final long skip;
        UnicastProcessor<T> window;

        WindowSkipSubscriber(org.a.c<? super io.reactivex.g<T>> cVar, long j, long j2, int i) {
            super(1);
            this.actual = cVar;
            this.size = j;
            this.skip = j2;
            this.once = new AtomicBoolean();
            this.firstRequest = new AtomicBoolean();
            this.bufferSize = i;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            long j = this.index;
            UnicastProcessor<T> unicastProcessor = this.window;
            if (j == 0) {
                getAndIncrement();
                unicastProcessor = UnicastProcessor.c(this.bufferSize, this);
                this.window = unicastProcessor;
                this.actual.onNext(unicastProcessor);
            }
            long j2 = j + 1;
            if (unicastProcessor != null) {
                unicastProcessor.onNext(t);
            }
            if (j2 == this.size) {
                this.window = null;
                unicastProcessor.onComplete();
            }
            if (j2 == this.skip) {
                this.index = 0L;
            } else {
                this.index = j2;
            }
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            UnicastProcessor<T> unicastProcessor = this.window;
            if (unicastProcessor != null) {
                this.window = null;
                unicastProcessor.onError(th);
            }
            this.actual.onError(th);
        }

        @Override // org.a.c
        public void onComplete() {
            UnicastProcessor<T> unicastProcessor = this.window;
            if (unicastProcessor != null) {
                this.window = null;
                unicastProcessor.onComplete();
            }
            this.actual.onComplete();
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                if (!this.firstRequest.get() && this.firstRequest.compareAndSet(false, true)) {
                    this.s.request(io.reactivex.internal.util.b.M(io.reactivex.internal.util.b.N(this.size, j), io.reactivex.internal.util.b.N(this.skip - this.size, j - 1)));
                    return;
                }
                this.s.request(io.reactivex.internal.util.b.N(this.skip, j));
            }
        }

        @Override // org.a.d
        public void cancel() {
            if (this.once.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.s.cancel();
            }
        }
    }

    /* loaded from: classes17.dex */
    static final class WindowOverlapSubscriber<T> extends AtomicInteger implements j<T>, Runnable, org.a.d {
        private static final long serialVersionUID = 2428527070996323976L;
        final org.a.c<? super io.reactivex.g<T>> actual;
        final int bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        Throwable error;
        final AtomicBoolean firstRequest;
        long index;
        final AtomicBoolean once;
        long produced;
        final io.reactivex.internal.queue.a<UnicastProcessor<T>> queue;
        final AtomicLong requested;
        org.a.d s;
        final long size;
        final long skip;
        final ArrayDeque<UnicastProcessor<T>> windows;
        final AtomicInteger wip;

        WindowOverlapSubscriber(org.a.c<? super io.reactivex.g<T>> cVar, long j, long j2, int i) {
            super(1);
            this.actual = cVar;
            this.size = j;
            this.skip = j2;
            this.queue = new io.reactivex.internal.queue.a<>(i);
            this.windows = new ArrayDeque<>();
            this.once = new AtomicBoolean();
            this.firstRequest = new AtomicBoolean();
            this.requested = new AtomicLong();
            this.wip = new AtomicInteger();
            this.bufferSize = i;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(org.a.d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // org.a.c
        public void onNext(T t) {
            if (!this.done) {
                long j = this.index;
                if (j == 0 && !this.cancelled) {
                    getAndIncrement();
                    UnicastProcessor<T> c = UnicastProcessor.c(this.bufferSize, this);
                    this.windows.offer(c);
                    this.queue.offer(c);
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
        }

        @Override // org.a.c
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.onError(th);
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

        @Override // org.a.c
        public void onComplete() {
            if (!this.done) {
                Iterator<UnicastProcessor<T>> it = this.windows.iterator();
                while (it.hasNext()) {
                    it.next().onComplete();
                }
                this.windows.clear();
                this.done = true;
                drain();
            }
        }

        void drain() {
            if (this.wip.getAndIncrement() == 0) {
                org.a.c<? super io.reactivex.g<T>> cVar = this.actual;
                io.reactivex.internal.queue.a<UnicastProcessor<T>> aVar = this.queue;
                int i = 1;
                while (true) {
                    long j = this.requested.get();
                    long j2 = 0;
                    while (j2 != j) {
                        boolean z = this.done;
                        UnicastProcessor<T> poll = aVar.poll();
                        boolean z2 = poll == null;
                        if (!checkTerminated(z, z2, cVar, aVar)) {
                            if (z2) {
                                break;
                            }
                            cVar.onNext(poll);
                            j2++;
                        } else {
                            return;
                        }
                    }
                    if (j2 != j || !checkTerminated(this.done, aVar.isEmpty(), cVar, aVar)) {
                        if (j2 != 0 && j != Long.MAX_VALUE) {
                            this.requested.addAndGet(-j2);
                        }
                        int addAndGet = this.wip.addAndGet(-i);
                        if (addAndGet == 0) {
                            return;
                        }
                        i = addAndGet;
                    } else {
                        return;
                    }
                }
            }
        }

        boolean checkTerminated(boolean z, boolean z2, org.a.c<?> cVar, io.reactivex.internal.queue.a<?> aVar) {
            if (this.cancelled) {
                aVar.clear();
                return true;
            }
            if (z) {
                Throwable th = this.error;
                if (th != null) {
                    aVar.clear();
                    cVar.onError(th);
                    return true;
                } else if (z2) {
                    cVar.onComplete();
                    return true;
                }
            }
            return false;
        }

        @Override // org.a.d
        public void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                io.reactivex.internal.util.b.a(this.requested, j);
                if (!this.firstRequest.get() && this.firstRequest.compareAndSet(false, true)) {
                    this.s.request(io.reactivex.internal.util.b.M(this.size, io.reactivex.internal.util.b.N(this.skip, j - 1)));
                } else {
                    this.s.request(io.reactivex.internal.util.b.N(this.skip, j));
                }
                drain();
            }
        }

        @Override // org.a.d
        public void cancel() {
            this.cancelled = true;
            if (this.once.compareAndSet(false, true)) {
                run();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (decrementAndGet() == 0) {
                this.s.cancel();
            }
        }
    }
}
