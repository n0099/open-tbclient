package io.reactivex.internal.operators.flowable;

import f.b.e;
import f.b.g;
import f.b.i;
import f.b.j;
import f.b.t.a;
import f.b.t.b;
import f.b.w.h;
import g.d.c;
import g.d.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableFlatMapMaybe$FlatMapMaybeSubscriber<T, R> extends AtomicInteger implements g<T>, d {
    public static final long serialVersionUID = 8600231336733376951L;
    public final c<? super R> actual;
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public final h<? super T, ? extends j<? extends R>> mapper;
    public final int maxConcurrency;
    public d s;
    public final AtomicLong requested = new AtomicLong();
    public final a set = new a();
    public final AtomicThrowable errors = new AtomicThrowable();
    public final AtomicInteger active = new AtomicInteger(1);
    public final AtomicReference<f.b.x.f.a<R>> queue = new AtomicReference<>();

    /* loaded from: classes7.dex */
    public final class InnerObserver extends AtomicReference<b> implements i<R>, b {
        public static final long serialVersionUID = -502562646270949838L;

        public InnerObserver() {
        }

        @Override // f.b.t.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // f.b.t.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // f.b.i
        public void onComplete() {
            FlowableFlatMapMaybe$FlatMapMaybeSubscriber.this.innerComplete(this);
        }

        @Override // f.b.i
        public void onError(Throwable th) {
            FlowableFlatMapMaybe$FlatMapMaybeSubscriber.this.innerError(this, th);
        }

        @Override // f.b.i
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // f.b.i
        public void onSuccess(R r) {
            FlowableFlatMapMaybe$FlatMapMaybeSubscriber.this.innerSuccess(this, r);
        }
    }

    public FlowableFlatMapMaybe$FlatMapMaybeSubscriber(c<? super R> cVar, h<? super T, ? extends j<? extends R>> hVar, boolean z, int i) {
        this.actual = cVar;
        this.mapper = hVar;
        this.delayErrors = z;
        this.maxConcurrency = i;
    }

    @Override // g.d.d
    public void cancel() {
        this.cancelled = true;
        this.s.cancel();
        this.set.dispose();
    }

    public void clear() {
        f.b.x.f.a<R> aVar = this.queue.get();
        if (aVar != null) {
            aVar.clear();
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0077, code lost:
        if (r13 != 0) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007b, code lost:
        if (r17.cancelled == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007d, code lost:
        clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0080, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0083, code lost:
        if (r17.delayErrors != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008d, code lost:
        if (r17.errors.get() == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x008f, code lost:
        r2 = r17.errors.terminate();
        clear();
        r1.onError(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009b, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a0, code lost:
        if (r2.get() != 0) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a2, code lost:
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a4, code lost:
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a5, code lost:
        r7 = r3.get();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ab, code lost:
        if (r7 == null) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b1, code lost:
        if (r7.isEmpty() == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00b3, code lost:
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b4, code lost:
        if (r6 == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b6, code lost:
        if (r12 == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b8, code lost:
        r2 = r17.errors.terminate();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00be, code lost:
        if (r2 == null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00c0, code lost:
        r1.onError(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c4, code lost:
        r1.onComplete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00c7, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00ca, code lost:
        if (r10 == 0) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00cc, code lost:
        f.b.x.i.b.e(r17.requested, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d6, code lost:
        if (r17.maxConcurrency == Integer.MAX_VALUE) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00d8, code lost:
        r17.s.request(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00dd, code lost:
        r5 = addAndGet(-r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drainLoop() {
        c<? super R> cVar = this.actual;
        AtomicInteger atomicInteger = this.active;
        AtomicReference<f.b.x.f.a<R>> atomicReference = this.queue;
        int i = 1;
        do {
            long j = this.requested.get();
            long j2 = 0;
            while (true) {
                boolean z = false;
                int i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                if (i2 == 0) {
                    break;
                } else if (this.cancelled) {
                    clear();
                    return;
                } else if (!this.delayErrors && this.errors.get() != null) {
                    Throwable terminate = this.errors.terminate();
                    clear();
                    cVar.onError(terminate);
                    return;
                } else {
                    boolean z2 = atomicInteger.get() == 0;
                    f.b.x.f.a<R> aVar = atomicReference.get();
                    R poll = aVar != null ? aVar.poll() : (Object) null;
                    boolean z3 = poll == null;
                    if (z2 && z3) {
                        Throwable terminate2 = this.errors.terminate();
                        if (terminate2 != null) {
                            cVar.onError(terminate2);
                            return;
                        } else {
                            cVar.onComplete();
                            return;
                        }
                    } else if (z3) {
                        break;
                    } else {
                        cVar.onNext(poll);
                        j2++;
                    }
                }
            }
        } while (i != 0);
    }

    public f.b.x.f.a<R> getOrCreateQueue() {
        f.b.x.f.a<R> aVar;
        do {
            f.b.x.f.a<R> aVar2 = this.queue.get();
            if (aVar2 != null) {
                return aVar2;
            }
            aVar = new f.b.x.f.a<>(e.a());
        } while (!this.queue.compareAndSet(null, aVar));
        return aVar;
    }

    public void innerComplete(FlowableFlatMapMaybe$FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver) {
        this.set.c(innerObserver);
        if (get() == 0) {
            if (compareAndSet(0, 1)) {
                boolean z = this.active.decrementAndGet() == 0;
                f.b.x.f.a<R> aVar = this.queue.get();
                if (z && (aVar == null || aVar.isEmpty())) {
                    Throwable terminate = this.errors.terminate();
                    if (terminate != null) {
                        this.actual.onError(terminate);
                        return;
                    } else {
                        this.actual.onComplete();
                        return;
                    }
                }
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    this.s.request(1L);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
                drainLoop();
                return;
            }
        }
        this.active.decrementAndGet();
        if (this.maxConcurrency != Integer.MAX_VALUE) {
            this.s.request(1L);
        }
        drain();
    }

    public void innerError(FlowableFlatMapMaybe$FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver, Throwable th) {
        this.set.c(innerObserver);
        if (this.errors.addThrowable(th)) {
            if (!this.delayErrors) {
                this.s.cancel();
                this.set.dispose();
            } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.s.request(1L);
            }
            this.active.decrementAndGet();
            drain();
            return;
        }
        f.b.a0.a.f(th);
    }

    public void innerSuccess(FlowableFlatMapMaybe$FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver, R r) {
        this.set.c(innerObserver);
        if (get() == 0) {
            if (compareAndSet(0, 1)) {
                boolean z = this.active.decrementAndGet() == 0;
                if (this.requested.get() != 0) {
                    this.actual.onNext(r);
                    f.b.x.f.a<R> aVar = this.queue.get();
                    if (z && (aVar == null || aVar.isEmpty())) {
                        Throwable terminate = this.errors.terminate();
                        if (terminate != null) {
                            this.actual.onError(terminate);
                            return;
                        } else {
                            this.actual.onComplete();
                            return;
                        }
                    }
                    f.b.x.i.b.e(this.requested, 1L);
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        this.s.request(1L);
                    }
                } else {
                    f.b.x.f.a<R> orCreateQueue = getOrCreateQueue();
                    synchronized (orCreateQueue) {
                        orCreateQueue.offer(r);
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
                drainLoop();
            }
        }
        f.b.x.f.a<R> orCreateQueue2 = getOrCreateQueue();
        synchronized (orCreateQueue2) {
            orCreateQueue2.offer(r);
        }
        this.active.decrementAndGet();
        if (getAndIncrement() != 0) {
            return;
        }
        drainLoop();
    }

    @Override // g.d.c
    public void onComplete() {
        this.active.decrementAndGet();
        drain();
    }

    @Override // g.d.c
    public void onError(Throwable th) {
        this.active.decrementAndGet();
        if (this.errors.addThrowable(th)) {
            if (!this.delayErrors) {
                this.set.dispose();
            }
            drain();
            return;
        }
        f.b.a0.a.f(th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        try {
            j<? extends R> apply = this.mapper.apply(t);
            f.b.x.b.a.b(apply, "The mapper returned a null MaybeSource");
            j<? extends R> jVar = apply;
            this.active.getAndIncrement();
            InnerObserver innerObserver = new InnerObserver();
            if (this.cancelled || !this.set.b(innerObserver)) {
                return;
            }
            jVar.a(innerObserver);
        } catch (Throwable th) {
            f.b.u.a.a(th);
            this.s.cancel();
            onError(th);
        }
    }

    @Override // f.b.g, g.d.c
    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.s, dVar)) {
            this.s = dVar;
            this.actual.onSubscribe(this);
            int i = this.maxConcurrency;
            if (i == Integer.MAX_VALUE) {
                dVar.request(Long.MAX_VALUE);
            } else {
                dVar.request(i);
            }
        }
    }

    @Override // g.d.d
    public void request(long j) {
        if (SubscriptionHelper.validate(j)) {
            f.b.x.i.b.a(this.requested, j);
            drain();
        }
    }
}
