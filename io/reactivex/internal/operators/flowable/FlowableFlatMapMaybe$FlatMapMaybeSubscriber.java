package io.reactivex.internal.operators.flowable;

import f.a.e;
import f.a.g;
import f.a.i;
import f.a.j;
import f.a.t.a;
import f.a.t.b;
import f.a.w.h;
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
    public final AtomicReference<f.a.x.f.a<R>> queue = new AtomicReference<>();

    /* loaded from: classes7.dex */
    public final class InnerObserver extends AtomicReference<b> implements i<R>, b {
        public static final long serialVersionUID = -502562646270949838L;

        public InnerObserver() {
        }

        @Override // f.a.t.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // f.a.t.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // f.a.i
        public void onComplete() {
            FlowableFlatMapMaybe$FlatMapMaybeSubscriber.this.innerComplete(this);
        }

        @Override // f.a.i
        public void onError(Throwable th) {
            FlowableFlatMapMaybe$FlatMapMaybeSubscriber.this.innerError(this, th);
        }

        @Override // f.a.i
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // f.a.i
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
        f.a.x.f.a<R> aVar = this.queue.get();
        if (aVar != null) {
            aVar.clear();
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0075, code lost:
        if (r9 != r5) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0079, code lost:
        if (r15.cancelled == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007b, code lost:
        clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007e, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0081, code lost:
        if (r15.delayErrors != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x008b, code lost:
        if (r15.errors.get() == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x008d, code lost:
        r1 = r15.errors.terminate();
        clear();
        r0.onError(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0099, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x009e, code lost:
        if (r1.get() != 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a0, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a2, code lost:
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a3, code lost:
        r6 = r2.get();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00a9, code lost:
        if (r6 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00af, code lost:
        if (r6.isEmpty() == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b1, code lost:
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b2, code lost:
        if (r5 == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b4, code lost:
        if (r11 == false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00b6, code lost:
        r1 = r15.errors.terminate();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00bc, code lost:
        if (r1 == null) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00be, code lost:
        r0.onError(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00c2, code lost:
        r0.onComplete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00c5, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00c8, code lost:
        if (r9 == 0) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ca, code lost:
        f.a.x.i.b.e(r15.requested, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00d4, code lost:
        if (r15.maxConcurrency == Integer.MAX_VALUE) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00d6, code lost:
        r15.s.request(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00db, code lost:
        r4 = addAndGet(-r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:?, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drainLoop() {
        c<? super R> cVar = this.actual;
        AtomicInteger atomicInteger = this.active;
        AtomicReference<f.a.x.f.a<R>> atomicReference = this.queue;
        int i = 1;
        do {
            long j = this.requested.get();
            long j2 = 0;
            while (true) {
                boolean z = false;
                if (j2 == j) {
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
                    f.a.x.f.a<R> aVar = atomicReference.get();
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

    public f.a.x.f.a<R> getOrCreateQueue() {
        f.a.x.f.a<R> aVar;
        do {
            f.a.x.f.a<R> aVar2 = this.queue.get();
            if (aVar2 != null) {
                return aVar2;
            }
            aVar = new f.a.x.f.a<>(e.a());
        } while (!this.queue.compareAndSet(null, aVar));
        return aVar;
    }

    public void innerComplete(FlowableFlatMapMaybe$FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver) {
        this.set.c(innerObserver);
        if (get() == 0) {
            if (compareAndSet(0, 1)) {
                boolean z = this.active.decrementAndGet() == 0;
                f.a.x.f.a<R> aVar = this.queue.get();
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
        f.a.a0.a.f(th);
    }

    public void innerSuccess(FlowableFlatMapMaybe$FlatMapMaybeSubscriber<T, R>.InnerObserver innerObserver, R r) {
        this.set.c(innerObserver);
        if (get() == 0) {
            if (compareAndSet(0, 1)) {
                boolean z = this.active.decrementAndGet() == 0;
                if (this.requested.get() != 0) {
                    this.actual.onNext(r);
                    f.a.x.f.a<R> aVar = this.queue.get();
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
                    f.a.x.i.b.e(this.requested, 1L);
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        this.s.request(1L);
                    }
                } else {
                    f.a.x.f.a<R> orCreateQueue = getOrCreateQueue();
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
        f.a.x.f.a<R> orCreateQueue2 = getOrCreateQueue();
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
        f.a.a0.a.f(th);
    }

    @Override // g.d.c
    public void onNext(T t) {
        try {
            j<? extends R> apply = this.mapper.apply(t);
            f.a.x.b.a.b(apply, "The mapper returned a null MaybeSource");
            j<? extends R> jVar = apply;
            this.active.getAndIncrement();
            InnerObserver innerObserver = new InnerObserver();
            if (this.cancelled || !this.set.b(innerObserver)) {
                return;
            }
            jVar.a(innerObserver);
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
            f.a.x.i.b.a(this.requested, j);
            drain();
        }
    }
}
