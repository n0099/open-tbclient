package io.reactivex.internal.operators.observable;

import f.a.a0.a;
import f.a.n;
import f.a.o;
import f.a.t.b;
import f.a.w.h;
import f.a.x.c.e;
import f.a.x.c.f;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableFlatMap$MergeObserver<T, U> extends AtomicInteger implements b, o<T> {
    public static final long serialVersionUID = -2117620485640801370L;
    public final o<? super U> actual;
    public final int bufferSize;
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public volatile boolean done;
    public final AtomicThrowable errors = new AtomicThrowable();
    public long lastId;
    public int lastIndex;
    public final h<? super T, ? extends n<? extends U>> mapper;
    public final int maxConcurrency;
    public final AtomicReference<ObservableFlatMap$InnerObserver<?, ?>[]> observers;
    public volatile e<U> queue;
    public b s;
    public Queue<n<? extends U>> sources;
    public long uniqueId;
    public int wip;
    public static final ObservableFlatMap$InnerObserver<?, ?>[] EMPTY = new ObservableFlatMap$InnerObserver[0];
    public static final ObservableFlatMap$InnerObserver<?, ?>[] CANCELLED = new ObservableFlatMap$InnerObserver[0];

    public ObservableFlatMap$MergeObserver(o<? super U> oVar, h<? super T, ? extends n<? extends U>> hVar, boolean z, int i, int i2) {
        this.actual = oVar;
        this.mapper = hVar;
        this.delayErrors = z;
        this.maxConcurrency = i;
        this.bufferSize = i2;
        if (i != Integer.MAX_VALUE) {
            this.sources = new ArrayDeque(i);
        }
        this.observers = new AtomicReference<>(EMPTY);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableFlatMap$InnerObserver<?, ?>[]> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean addInner(ObservableFlatMap$InnerObserver<T, U> observableFlatMap$InnerObserver) {
        ObservableFlatMap$InnerObserver<?, ?>[] observableFlatMap$InnerObserverArr;
        ObservableFlatMap$InnerObserver[] observableFlatMap$InnerObserverArr2;
        do {
            observableFlatMap$InnerObserverArr = this.observers.get();
            if (observableFlatMap$InnerObserverArr == CANCELLED) {
                observableFlatMap$InnerObserver.dispose();
                return false;
            }
            int length = observableFlatMap$InnerObserverArr.length;
            observableFlatMap$InnerObserverArr2 = new ObservableFlatMap$InnerObserver[length + 1];
            System.arraycopy(observableFlatMap$InnerObserverArr, 0, observableFlatMap$InnerObserverArr2, 0, length);
            observableFlatMap$InnerObserverArr2[length] = observableFlatMap$InnerObserver;
        } while (!this.observers.compareAndSet(observableFlatMap$InnerObserverArr, observableFlatMap$InnerObserverArr2));
        return true;
    }

    public boolean checkTerminate() {
        if (this.cancelled) {
            return true;
        }
        Throwable th = this.errors.get();
        if (this.delayErrors || th == null) {
            return false;
        }
        disposeAll();
        Throwable terminate = this.errors.terminate();
        if (terminate != ExceptionHelper.f68097a) {
            this.actual.onError(terminate);
        }
        return true;
    }

    @Override // f.a.t.b
    public void dispose() {
        Throwable terminate;
        if (this.cancelled) {
            return;
        }
        this.cancelled = true;
        if (!disposeAll() || (terminate = this.errors.terminate()) == null || terminate == ExceptionHelper.f68097a) {
            return;
        }
        a.f(terminate);
    }

    public boolean disposeAll() {
        ObservableFlatMap$InnerObserver<?, ?>[] andSet;
        this.s.dispose();
        ObservableFlatMap$InnerObserver<?, ?>[] observableFlatMap$InnerObserverArr = this.observers.get();
        ObservableFlatMap$InnerObserver<?, ?>[] observableFlatMap$InnerObserverArr2 = CANCELLED;
        if (observableFlatMap$InnerObserverArr == observableFlatMap$InnerObserverArr2 || (andSet = this.observers.getAndSet(observableFlatMap$InnerObserverArr2)) == CANCELLED) {
            return false;
        }
        for (ObservableFlatMap$InnerObserver<?, ?> observableFlatMap$InnerObserver : andSet) {
            observableFlatMap$InnerObserver.dispose();
        }
        return true;
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            drainLoop();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x009f, code lost:
        if (r11 != null) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drainLoop() {
        o<? super U> oVar = this.actual;
        int i = 1;
        while (!checkTerminate()) {
            e<U> eVar = this.queue;
            if (eVar != null) {
                while (!checkTerminate()) {
                    Object obj = (U) eVar.poll();
                    if (obj != null) {
                        oVar.onNext(obj);
                    } else if (obj == null) {
                    }
                }
                return;
            }
            boolean z = this.done;
            e<U> eVar2 = this.queue;
            ObservableFlatMap$InnerObserver<?, ?>[] observableFlatMap$InnerObserverArr = this.observers.get();
            int length = observableFlatMap$InnerObserverArr.length;
            if (z && ((eVar2 == null || eVar2.isEmpty()) && length == 0)) {
                Throwable terminate = this.errors.terminate();
                if (terminate != ExceptionHelper.f68097a) {
                    if (terminate == null) {
                        oVar.onComplete();
                        return;
                    } else {
                        oVar.onError(terminate);
                        return;
                    }
                }
                return;
            }
            boolean z2 = false;
            if (length != 0) {
                long j = this.lastId;
                int i2 = this.lastIndex;
                if (length <= i2 || observableFlatMap$InnerObserverArr[i2].id != j) {
                    if (length <= i2) {
                        i2 = 0;
                    }
                    for (int i3 = 0; i3 < length && observableFlatMap$InnerObserverArr[i2].id != j; i3++) {
                        i2++;
                        if (i2 == length) {
                            i2 = 0;
                        }
                    }
                    this.lastIndex = i2;
                    this.lastId = observableFlatMap$InnerObserverArr[i2].id;
                }
                int i4 = 0;
                boolean z3 = false;
                while (i4 < length) {
                    if (checkTerminate()) {
                        return;
                    }
                    ObservableFlatMap$InnerObserver<T, U> observableFlatMap$InnerObserver = observableFlatMap$InnerObserverArr[i2];
                    while (!checkTerminate()) {
                        f<U> fVar = observableFlatMap$InnerObserver.queue;
                        if (fVar != null) {
                            while (true) {
                                try {
                                    Object obj2 = (U) fVar.poll();
                                    if (obj2 == null) {
                                        break;
                                    }
                                    oVar.onNext(obj2);
                                    if (checkTerminate()) {
                                        return;
                                    }
                                } catch (Throwable th) {
                                    f.a.u.a.a(th);
                                    observableFlatMap$InnerObserver.dispose();
                                    this.errors.addThrowable(th);
                                    if (checkTerminate()) {
                                        return;
                                    }
                                    removeInner(observableFlatMap$InnerObserver);
                                    i4++;
                                    z3 = true;
                                }
                            }
                        }
                        boolean z4 = observableFlatMap$InnerObserver.done;
                        f<U> fVar2 = observableFlatMap$InnerObserver.queue;
                        if (z4 && (fVar2 == null || fVar2.isEmpty())) {
                            removeInner(observableFlatMap$InnerObserver);
                            if (checkTerminate()) {
                                return;
                            }
                            z3 = true;
                        }
                        i2++;
                        if (i2 == length) {
                            i2 = 0;
                        }
                        i4++;
                    }
                    return;
                }
                this.lastIndex = i2;
                this.lastId = observableFlatMap$InnerObserverArr[i2].id;
                z2 = z3;
            }
            if (z2) {
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    synchronized (this) {
                        n<? extends U> poll = this.sources.poll();
                        if (poll == null) {
                            this.wip--;
                        } else {
                            subscribeInner(poll);
                        }
                    }
                } else {
                    continue;
                }
            } else {
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return this.cancelled;
    }

    @Override // f.a.o
    public void onComplete() {
        if (this.done) {
            return;
        }
        this.done = true;
        drain();
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        if (this.done) {
            a.f(th);
        } else if (this.errors.addThrowable(th)) {
            this.done = true;
            drain();
        } else {
            a.f(th);
        }
    }

    @Override // f.a.o
    public void onNext(T t) {
        if (this.done) {
            return;
        }
        try {
            n<? extends U> apply = this.mapper.apply(t);
            f.a.x.b.a.b(apply, "The mapper returned a null ObservableSource");
            n<? extends U> nVar = apply;
            if (this.maxConcurrency != Integer.MAX_VALUE) {
                synchronized (this) {
                    if (this.wip == this.maxConcurrency) {
                        this.sources.offer(nVar);
                        return;
                    }
                    this.wip++;
                }
            }
            subscribeInner(nVar);
        } catch (Throwable th) {
            f.a.u.a.a(th);
            this.s.dispose();
            onError(th);
        }
    }

    @Override // f.a.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.s, bVar)) {
            this.s = bVar;
            this.actual.onSubscribe(this);
        }
    }

    public void removeInner(ObservableFlatMap$InnerObserver<T, U> observableFlatMap$InnerObserver) {
        ObservableFlatMap$InnerObserver<?, ?>[] observableFlatMap$InnerObserverArr;
        ObservableFlatMap$InnerObserver<?, ?>[] observableFlatMap$InnerObserverArr2;
        do {
            observableFlatMap$InnerObserverArr = this.observers.get();
            int length = observableFlatMap$InnerObserverArr.length;
            if (length == 0) {
                return;
            }
            int i = -1;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (observableFlatMap$InnerObserverArr[i2] == observableFlatMap$InnerObserver) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            if (i < 0) {
                return;
            }
            if (length == 1) {
                observableFlatMap$InnerObserverArr2 = EMPTY;
            } else {
                ObservableFlatMap$InnerObserver<?, ?>[] observableFlatMap$InnerObserverArr3 = new ObservableFlatMap$InnerObserver[length - 1];
                System.arraycopy(observableFlatMap$InnerObserverArr, 0, observableFlatMap$InnerObserverArr3, 0, i);
                System.arraycopy(observableFlatMap$InnerObserverArr, i + 1, observableFlatMap$InnerObserverArr3, i, (length - i) - 1);
                observableFlatMap$InnerObserverArr2 = observableFlatMap$InnerObserverArr3;
            }
        } while (!this.observers.compareAndSet(observableFlatMap$InnerObserverArr, observableFlatMap$InnerObserverArr2));
    }

    public void subscribeInner(n<? extends U> nVar) {
        while (nVar instanceof Callable) {
            tryEmitScalar((Callable) nVar);
            if (this.maxConcurrency == Integer.MAX_VALUE) {
                return;
            }
            synchronized (this) {
                nVar = this.sources.poll();
                if (nVar == null) {
                    this.wip--;
                    return;
                }
            }
        }
        long j = this.uniqueId;
        this.uniqueId = 1 + j;
        ObservableFlatMap$InnerObserver<T, U> observableFlatMap$InnerObserver = new ObservableFlatMap$InnerObserver<>(this, j);
        if (addInner(observableFlatMap$InnerObserver)) {
            nVar.subscribe(observableFlatMap$InnerObserver);
        }
    }

    public void tryEmit(U u, ObservableFlatMap$InnerObserver<T, U> observableFlatMap$InnerObserver) {
        if (get() == 0 && compareAndSet(0, 1)) {
            this.actual.onNext(u);
            if (decrementAndGet() == 0) {
                return;
            }
        } else {
            f fVar = observableFlatMap$InnerObserver.queue;
            if (fVar == null) {
                fVar = new f.a.x.f.a(this.bufferSize);
                observableFlatMap$InnerObserver.queue = fVar;
            }
            fVar.offer(u);
            if (getAndIncrement() != 0) {
                return;
            }
        }
        drainLoop();
    }

    public void tryEmitScalar(Callable<? extends U> callable) {
        try {
            U call = callable.call();
            if (call == null) {
                return;
            }
            if (get() == 0 && compareAndSet(0, 1)) {
                this.actual.onNext(call);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                e<U> eVar = this.queue;
                if (eVar == null) {
                    if (this.maxConcurrency == Integer.MAX_VALUE) {
                        eVar = new f.a.x.f.a<>(this.bufferSize);
                    } else {
                        eVar = new SpscArrayQueue<>(this.maxConcurrency);
                    }
                    this.queue = eVar;
                }
                if (!eVar.offer(call)) {
                    onError(new IllegalStateException("Scalar queue full?!"));
                    return;
                } else if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        } catch (Throwable th) {
            f.a.u.a.a(th);
            this.errors.addThrowable(th);
            drain();
        }
    }
}
