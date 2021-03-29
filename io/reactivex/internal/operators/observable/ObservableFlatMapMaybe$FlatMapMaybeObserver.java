package io.reactivex.internal.operators.observable;

import f.a.i;
import f.a.j;
import f.a.l;
import f.a.o;
import f.a.t.a;
import f.a.t.b;
import f.a.w.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableFlatMapMaybe$FlatMapMaybeObserver<T, R> extends AtomicInteger implements o<T>, b {
    public static final long serialVersionUID = 8600231336733376951L;
    public final o<? super R> actual;
    public volatile boolean cancelled;

    /* renamed from: d  reason: collision with root package name */
    public b f68064d;
    public final boolean delayErrors;
    public final h<? super T, ? extends j<? extends R>> mapper;
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
            ObservableFlatMapMaybe$FlatMapMaybeObserver.this.innerComplete(this);
        }

        @Override // f.a.i
        public void onError(Throwable th) {
            ObservableFlatMapMaybe$FlatMapMaybeObserver.this.innerError(this, th);
        }

        @Override // f.a.i
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // f.a.i
        public void onSuccess(R r) {
            ObservableFlatMapMaybe$FlatMapMaybeObserver.this.innerSuccess(this, r);
        }
    }

    public ObservableFlatMapMaybe$FlatMapMaybeObserver(o<? super R> oVar, h<? super T, ? extends j<? extends R>> hVar, boolean z) {
        this.actual = oVar;
        this.mapper = hVar;
        this.delayErrors = z;
    }

    public void clear() {
        f.a.x.f.a<R> aVar = this.queue.get();
        if (aVar != null) {
            aVar.clear();
        }
    }

    @Override // f.a.t.b
    public void dispose() {
        this.cancelled = true;
        this.f68064d.dispose();
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
        AtomicReference<f.a.x.f.a<R>> atomicReference = this.queue;
        int i = 1;
        while (!this.cancelled) {
            if (!this.delayErrors && this.errors.get() != null) {
                Throwable terminate = this.errors.terminate();
                clear();
                oVar.onError(terminate);
                return;
            }
            boolean z = atomicInteger.get() == 0;
            f.a.x.f.a<R> aVar = atomicReference.get();
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

    public f.a.x.f.a<R> getOrCreateQueue() {
        f.a.x.f.a<R> aVar;
        do {
            f.a.x.f.a<R> aVar2 = this.queue.get();
            if (aVar2 != null) {
                return aVar2;
            }
            aVar = new f.a.x.f.a<>(l.a());
        } while (!this.queue.compareAndSet(null, aVar));
        return aVar;
    }

    public void innerComplete(ObservableFlatMapMaybe$FlatMapMaybeObserver<T, R>.InnerObserver innerObserver) {
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
                } else if (decrementAndGet() == 0) {
                    return;
                } else {
                    drainLoop();
                    return;
                }
            }
        }
        this.active.decrementAndGet();
        drain();
    }

    public void innerError(ObservableFlatMapMaybe$FlatMapMaybeObserver<T, R>.InnerObserver innerObserver, Throwable th) {
        this.set.c(innerObserver);
        if (this.errors.addThrowable(th)) {
            if (!this.delayErrors) {
                this.f68064d.dispose();
                this.set.dispose();
            }
            this.active.decrementAndGet();
            drain();
            return;
        }
        f.a.a0.a.f(th);
    }

    public void innerSuccess(ObservableFlatMapMaybe$FlatMapMaybeObserver<T, R>.InnerObserver innerObserver, R r) {
        this.set.c(innerObserver);
        if (get() == 0) {
            if (compareAndSet(0, 1)) {
                this.actual.onNext(r);
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
                if (decrementAndGet() == 0) {
                    return;
                }
                drainLoop();
            }
        }
        f.a.x.f.a<R> orCreateQueue = getOrCreateQueue();
        synchronized (orCreateQueue) {
            orCreateQueue.offer(r);
        }
        this.active.decrementAndGet();
        if (getAndIncrement() != 0) {
            return;
        }
        drainLoop();
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // f.a.o
    public void onComplete() {
        this.active.decrementAndGet();
        drain();
    }

    @Override // f.a.o
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

    @Override // f.a.o
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
            this.f68064d.dispose();
            onError(th);
        }
    }

    @Override // f.a.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.f68064d, bVar)) {
            this.f68064d = bVar;
            this.actual.onSubscribe(this);
        }
    }
}
