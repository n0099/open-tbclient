package io.reactivex.internal.operators.observable;

import f.b.l;
import f.b.o;
import f.b.r;
import f.b.s;
import f.b.t.a;
import f.b.t.b;
import f.b.w.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableFlatMapSingle$FlatMapSingleObserver<T, R> extends AtomicInteger implements o<T>, b {
    public static final long serialVersionUID = 8600231336733376951L;
    public final o<? super R> actual;
    public volatile boolean cancelled;

    /* renamed from: d  reason: collision with root package name */
    public b f69218d;
    public final boolean delayErrors;
    public final h<? super T, ? extends s<? extends R>> mapper;
    public final a set = new a();
    public final AtomicThrowable errors = new AtomicThrowable();
    public final AtomicInteger active = new AtomicInteger(1);
    public final AtomicReference<f.b.x.f.a<R>> queue = new AtomicReference<>();

    /* loaded from: classes7.dex */
    public final class InnerObserver extends AtomicReference<b> implements r<R>, b {
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

        @Override // f.b.r
        public void onError(Throwable th) {
            ObservableFlatMapSingle$FlatMapSingleObserver.this.innerError(this, th);
        }

        @Override // f.b.r
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // f.b.r
        public void onSuccess(R r) {
            ObservableFlatMapSingle$FlatMapSingleObserver.this.innerSuccess(this, r);
        }
    }

    public ObservableFlatMapSingle$FlatMapSingleObserver(o<? super R> oVar, h<? super T, ? extends s<? extends R>> hVar, boolean z) {
        this.actual = oVar;
        this.mapper = hVar;
        this.delayErrors = z;
    }

    public void clear() {
        f.b.x.f.a<R> aVar = this.queue.get();
        if (aVar != null) {
            aVar.clear();
        }
    }

    @Override // f.b.t.b
    public void dispose() {
        this.cancelled = true;
        this.f69218d.dispose();
        this.set.dispose();
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    public void drainLoop() {
        o<? super R> oVar = this.actual;
        AtomicInteger atomicInteger = this.active;
        AtomicReference<f.b.x.f.a<R>> atomicReference = this.queue;
        int i = 1;
        while (!this.cancelled) {
            if (!this.delayErrors && this.errors.get() != null) {
                Throwable terminate = this.errors.terminate();
                clear();
                oVar.onError(terminate);
                return;
            }
            boolean z = atomicInteger.get() == 0;
            f.b.x.f.a<R> aVar = atomicReference.get();
            R poll = aVar != null ? aVar.poll() : (Object) null;
            boolean z2 = poll == null;
            if (z && z2) {
                Throwable terminate2 = this.errors.terminate();
                if (terminate2 != null) {
                    oVar.onError(terminate2);
                    return;
                } else {
                    oVar.onComplete();
                    return;
                }
            } else if (z2) {
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            } else {
                oVar.onNext(poll);
            }
        }
        clear();
    }

    public f.b.x.f.a<R> getOrCreateQueue() {
        f.b.x.f.a<R> aVar;
        do {
            f.b.x.f.a<R> aVar2 = this.queue.get();
            if (aVar2 != null) {
                return aVar2;
            }
            aVar = new f.b.x.f.a<>(l.a());
        } while (!this.queue.compareAndSet(null, aVar));
        return aVar;
    }

    public void innerError(ObservableFlatMapSingle$FlatMapSingleObserver<T, R>.InnerObserver innerObserver, Throwable th) {
        this.set.c(innerObserver);
        if (this.errors.addThrowable(th)) {
            if (!this.delayErrors) {
                this.f69218d.dispose();
                this.set.dispose();
            }
            this.active.decrementAndGet();
            drain();
            return;
        }
        f.b.a0.a.f(th);
    }

    public void innerSuccess(ObservableFlatMapSingle$FlatMapSingleObserver<T, R>.InnerObserver innerObserver, R r) {
        this.set.c(innerObserver);
        if (get() == 0) {
            if (compareAndSet(0, 1)) {
                this.actual.onNext(r);
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
                if (decrementAndGet() == 0) {
                    return;
                }
                drainLoop();
            }
        }
        f.b.x.f.a<R> orCreateQueue = getOrCreateQueue();
        synchronized (orCreateQueue) {
            orCreateQueue.offer(r);
        }
        this.active.decrementAndGet();
        if (getAndIncrement() != 0) {
            return;
        }
        drainLoop();
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // f.b.o
    public void onComplete() {
        this.active.decrementAndGet();
        drain();
    }

    @Override // f.b.o
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

    @Override // f.b.o
    public void onNext(T t) {
        try {
            s<? extends R> apply = this.mapper.apply(t);
            f.b.x.b.a.b(apply, "The mapper returned a null SingleSource");
            s<? extends R> sVar = apply;
            this.active.getAndIncrement();
            InnerObserver innerObserver = new InnerObserver();
            if (this.cancelled || !this.set.b(innerObserver)) {
                return;
            }
            sVar.a(innerObserver);
        } catch (Throwable th) {
            f.b.u.a.a(th);
            this.f69218d.dispose();
            onError(th);
        }
    }

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.f69218d, bVar)) {
            this.f69218d = bVar;
            this.actual.onSubscribe(this);
        }
    }
}
