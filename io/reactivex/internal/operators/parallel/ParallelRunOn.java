package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.schedulers.h;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.b;
import io.reactivex.j;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.a.c;
import org.a.d;
/* loaded from: classes7.dex */
public final class ParallelRunOn<T> extends io.reactivex.parallel.a<T> {
    final io.reactivex.parallel.a<? extends T> mTX;
    final int prefetch;
    final v scheduler;

    @Override // io.reactivex.parallel.a
    public void a(c<? super T>[] cVarArr) {
        if (b(cVarArr)) {
            int length = cVarArr.length;
            c<T>[] cVarArr2 = new c[length];
            if (this.scheduler instanceof h) {
                ((h) this.scheduler).a(length, new a(cVarArr, cVarArr2));
            } else {
                for (int i = 0; i < length; i++) {
                    a(i, cVarArr, cVarArr2, this.scheduler.dCD());
                }
            }
            this.mTX.a(cVarArr2);
        }
    }

    void a(int i, c<? super T>[] cVarArr, c<T>[] cVarArr2, v.c cVar) {
        c<? super T> cVar2 = cVarArr[i];
        SpscArrayQueue spscArrayQueue = new SpscArrayQueue(this.prefetch);
        if (cVar2 instanceof io.reactivex.internal.a.a) {
            cVarArr2[i] = new RunOnConditionalSubscriber((io.reactivex.internal.a.a) cVar2, this.prefetch, spscArrayQueue, cVar);
        } else {
            cVarArr2[i] = new RunOnSubscriber(cVar2, this.prefetch, spscArrayQueue, cVar);
        }
    }

    /* loaded from: classes7.dex */
    final class a implements h.a {
        final c<T>[] mUb;
        final c<? super T>[] subscribers;

        a(c<? super T>[] cVarArr, c<T>[] cVarArr2) {
            this.subscribers = cVarArr;
            this.mUb = cVarArr2;
        }

        @Override // io.reactivex.internal.schedulers.h.a
        public void a(int i, v.c cVar) {
            ParallelRunOn.this.a(i, this.subscribers, this.mUb, cVar);
        }
    }

    @Override // io.reactivex.parallel.a
    public int dCO() {
        return this.mTX.dCO();
    }

    /* loaded from: classes7.dex */
    static abstract class BaseRunOnSubscriber<T> extends AtomicInteger implements j<T>, Runnable, d {
        private static final long serialVersionUID = 9222303586456402150L;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        Throwable error;
        final int limit;
        final int prefetch;
        final SpscArrayQueue<T> queue;
        final AtomicLong requested = new AtomicLong();
        d s;
        final v.c worker;

        BaseRunOnSubscriber(int i, SpscArrayQueue<T> spscArrayQueue, v.c cVar) {
            this.prefetch = i;
            this.queue = spscArrayQueue;
            this.limit = i - (i >> 2);
            this.worker = cVar;
        }

        @Override // org.a.c
        public final void onNext(T t) {
            if (!this.done) {
                if (!this.queue.offer(t)) {
                    this.s.cancel();
                    onError(new MissingBackpressureException("Queue is full?!"));
                    return;
                }
                schedule();
            }
        }

        @Override // org.a.c
        public final void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            schedule();
        }

        @Override // org.a.c
        public final void onComplete() {
            if (!this.done) {
                this.done = true;
                schedule();
            }
        }

        @Override // org.a.d
        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                b.a(this.requested, j);
                schedule();
            }
        }

        @Override // org.a.d
        public final void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.s.cancel();
                this.worker.dispose();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        final void schedule() {
            if (getAndIncrement() == 0) {
                this.worker.I(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class RunOnSubscriber<T> extends BaseRunOnSubscriber<T> {
        private static final long serialVersionUID = 1075119423897941642L;
        final c<? super T> actual;

        RunOnSubscriber(c<? super T> cVar, int i, SpscArrayQueue<T> spscArrayQueue, v.c cVar2) {
            super(i, spscArrayQueue, cVar2);
            this.actual = cVar;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(this.prefetch);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th;
            int i = 1;
            int i2 = this.consumed;
            SpscArrayQueue<T> spscArrayQueue = this.queue;
            c<? super T> cVar = this.actual;
            int i3 = this.limit;
            while (true) {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    if (this.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    }
                    boolean z = this.done;
                    if (z && (th = this.error) != null) {
                        spscArrayQueue.clear();
                        cVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                    T poll = spscArrayQueue.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        cVar.onComplete();
                        this.worker.dispose();
                        return;
                    } else if (z2) {
                        break;
                    } else {
                        cVar.onNext(poll);
                        j2++;
                        int i4 = i2 + 1;
                        if (i4 == i3) {
                            i2 = 0;
                            this.s.request(i4);
                        } else {
                            i2 = i4;
                        }
                    }
                }
                if (j2 == j) {
                    if (this.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    } else if (this.done) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            spscArrayQueue.clear();
                            cVar.onError(th2);
                            this.worker.dispose();
                            return;
                        } else if (spscArrayQueue.isEmpty()) {
                            cVar.onComplete();
                            this.worker.dispose();
                            return;
                        }
                    }
                }
                if (j2 != 0 && j != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j2);
                }
                int i5 = get();
                if (i5 == i) {
                    this.consumed = i2;
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    i = i5;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class RunOnConditionalSubscriber<T> extends BaseRunOnSubscriber<T> {
        private static final long serialVersionUID = 1075119423897941642L;
        final io.reactivex.internal.a.a<? super T> actual;

        RunOnConditionalSubscriber(io.reactivex.internal.a.a<? super T> aVar, int i, SpscArrayQueue<T> spscArrayQueue, v.c cVar) {
            super(i, spscArrayQueue, cVar);
            this.actual = aVar;
        }

        @Override // io.reactivex.j, org.a.c
        public void onSubscribe(d dVar) {
            if (SubscriptionHelper.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(this.prefetch);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th;
            int i = 1;
            int i2 = this.consumed;
            SpscArrayQueue<T> spscArrayQueue = this.queue;
            io.reactivex.internal.a.a<? super T> aVar = this.actual;
            int i3 = this.limit;
            while (true) {
                long j = this.requested.get();
                long j2 = 0;
                while (j2 != j) {
                    if (this.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    }
                    boolean z = this.done;
                    if (z && (th = this.error) != null) {
                        spscArrayQueue.clear();
                        aVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                    T poll = spscArrayQueue.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        aVar.onComplete();
                        this.worker.dispose();
                        return;
                    } else if (z2) {
                        break;
                    } else {
                        long j3 = aVar.tryOnNext(poll) ? j2 + 1 : j2;
                        int i4 = i2 + 1;
                        if (i4 == i3) {
                            i2 = 0;
                            this.s.request(i4);
                        } else {
                            i2 = i4;
                        }
                        j2 = j3;
                    }
                }
                if (j2 == j) {
                    if (this.cancelled) {
                        spscArrayQueue.clear();
                        return;
                    } else if (this.done) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            spscArrayQueue.clear();
                            aVar.onError(th2);
                            this.worker.dispose();
                            return;
                        } else if (spscArrayQueue.isEmpty()) {
                            aVar.onComplete();
                            this.worker.dispose();
                            return;
                        }
                    }
                }
                if (j2 != 0 && j != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j2);
                }
                int i5 = get();
                if (i5 == i) {
                    this.consumed = i2;
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    i = i5;
                }
            }
        }
    }
}
