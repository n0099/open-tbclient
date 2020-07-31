package io.reactivex.internal.operators.observable;

import io.reactivex.c.h;
import io.reactivex.internal.a.f;
import io.reactivex.internal.a.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.t;
import io.reactivex.u;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableFlatMap<T, U> extends a<T, U> {
    final int bufferSize;
    final boolean delayErrors;
    final h<? super T, ? extends t<? extends U>> mapper;
    final int maxConcurrency;

    @Override // io.reactivex.q
    public void a(u<? super U> uVar) {
        if (!ObservableScalarXMap.a(this.source, uVar, this.mapper)) {
            this.source.subscribe(new MergeObserver(uVar, this.mapper, this.delayErrors, this.maxConcurrency, this.bufferSize));
        }
    }

    /* loaded from: classes7.dex */
    static final class MergeObserver<T, U> extends AtomicInteger implements io.reactivex.disposables.b, u<T> {
        private static final long serialVersionUID = -2117620485640801370L;
        final u<? super U> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final AtomicThrowable errors = new AtomicThrowable();
        long lastId;
        int lastIndex;
        final h<? super T, ? extends t<? extends U>> mapper;
        final int maxConcurrency;
        final AtomicReference<InnerObserver<?, ?>[]> observers;
        volatile f<U> queue;
        io.reactivex.disposables.b s;
        Queue<t<? extends U>> sources;
        long uniqueId;
        int wip;
        static final InnerObserver<?, ?>[] EMPTY = new InnerObserver[0];
        static final InnerObserver<?, ?>[] CANCELLED = new InnerObserver[0];

        MergeObserver(u<? super U> uVar, h<? super T, ? extends t<? extends U>> hVar, boolean z, int i, int i2) {
            this.actual = uVar;
            this.mapper = hVar;
            this.delayErrors = z;
            this.maxConcurrency = i;
            this.bufferSize = i2;
            if (i != Integer.MAX_VALUE) {
                this.sources = new ArrayDeque(i);
            }
            this.observers = new AtomicReference<>(EMPTY);
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.s, bVar)) {
                this.s = bVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            if (!this.done) {
                try {
                    t<? extends U> tVar = (t) io.reactivex.internal.functions.a.k(this.mapper.apply(t), "The mapper returned a null ObservableSource");
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        synchronized (this) {
                            if (this.wip == this.maxConcurrency) {
                                this.sources.offer(tVar);
                                return;
                            }
                            this.wip++;
                        }
                    }
                    subscribeInner(tVar);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.K(th);
                    this.s.dispose();
                    onError(th);
                }
            }
        }

        void subscribeInner(t<? extends U> tVar) {
            t<? extends U> tVar2 = tVar;
            while (tVar2 instanceof Callable) {
                tryEmitScalar((Callable) tVar2);
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    synchronized (this) {
                        tVar2 = this.sources.poll();
                        if (tVar2 == null) {
                            this.wip--;
                            return;
                        }
                    }
                } else {
                    return;
                }
            }
            long j = this.uniqueId;
            this.uniqueId = 1 + j;
            InnerObserver<T, U> innerObserver = new InnerObserver<>(this, j);
            if (addInner(innerObserver)) {
                tVar2.subscribe(innerObserver);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.observable.ObservableFlatMap$InnerObserver<?, ?>[]> */
        /* JADX WARN: Multi-variable type inference failed */
        boolean addInner(InnerObserver<T, U> innerObserver) {
            InnerObserver<?, ?>[] innerObserverArr;
            InnerObserver[] innerObserverArr2;
            do {
                innerObserverArr = this.observers.get();
                if (innerObserverArr == CANCELLED) {
                    innerObserver.dispose();
                    return false;
                }
                int length = innerObserverArr.length;
                innerObserverArr2 = new InnerObserver[length + 1];
                System.arraycopy(innerObserverArr, 0, innerObserverArr2, 0, length);
                innerObserverArr2[length] = innerObserver;
            } while (!this.observers.compareAndSet(innerObserverArr, innerObserverArr2));
            return true;
        }

        void removeInner(InnerObserver<T, U> innerObserver) {
            InnerObserver<?, ?>[] innerObserverArr;
            InnerObserver<?, ?>[] innerObserverArr2;
            do {
                innerObserverArr = this.observers.get();
                int length = innerObserverArr.length;
                if (length != 0) {
                    int i = -1;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        } else if (innerObserverArr[i2] == innerObserver) {
                            i = i2;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i >= 0) {
                        if (length == 1) {
                            innerObserverArr2 = EMPTY;
                        } else {
                            innerObserverArr2 = new InnerObserver[length - 1];
                            System.arraycopy(innerObserverArr, 0, innerObserverArr2, 0, i);
                            System.arraycopy(innerObserverArr, i + 1, innerObserverArr2, i, (length - i) - 1);
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.observers.compareAndSet(innerObserverArr, innerObserverArr2));
        }

        void tryEmitScalar(Callable<? extends U> callable) {
            try {
                U call = callable.call();
                if (call != null) {
                    if (get() == 0 && compareAndSet(0, 1)) {
                        this.actual.onNext(call);
                        if (decrementAndGet() == 0) {
                            return;
                        }
                    } else {
                        f<U> fVar = this.queue;
                        if (fVar == null) {
                            if (this.maxConcurrency == Integer.MAX_VALUE) {
                                fVar = new io.reactivex.internal.queue.a<>(this.bufferSize);
                            } else {
                                fVar = new SpscArrayQueue<>(this.maxConcurrency);
                            }
                            this.queue = fVar;
                        }
                        if (!fVar.offer(call)) {
                            onError(new IllegalStateException("Scalar queue full?!"));
                            return;
                        } else if (getAndIncrement() != 0) {
                            return;
                        }
                    }
                    drainLoop();
                }
            } catch (Throwable th) {
                io.reactivex.exceptions.a.K(th);
                this.errors.addThrowable(th);
                drain();
            }
        }

        void tryEmit(U u, InnerObserver<T, U> innerObserver) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.actual.onNext(u);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                g gVar = innerObserver.queue;
                if (gVar == null) {
                    gVar = new io.reactivex.internal.queue.a(this.bufferSize);
                    innerObserver.queue = gVar;
                }
                gVar.offer(u);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.onError(th);
            } else if (this.errors.addThrowable(th)) {
                this.done = true;
                drain();
            } else {
                io.reactivex.e.a.onError(th);
            }
        }

        @Override // io.reactivex.u
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                drain();
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            Throwable terminate;
            if (!this.cancelled) {
                this.cancelled = true;
                if (disposeAll() && (terminate = this.errors.terminate()) != null && terminate != ExceptionHelper.TERMINATED) {
                    io.reactivex.e.a.onError(terminate);
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:64:0x00ba, code lost:
            if (r11 != null) goto L46;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void drainLoop() {
            boolean z;
            u<? super U> uVar = this.actual;
            int i = 1;
            while (!checkTerminate()) {
                f<U> fVar = this.queue;
                if (fVar != null) {
                    while (!checkTerminate()) {
                        Object obj = (U) fVar.poll();
                        if (obj != null) {
                            uVar.onNext(obj);
                        } else if (obj == null) {
                        }
                    }
                    return;
                }
                boolean z2 = this.done;
                f<U> fVar2 = this.queue;
                InnerObserver<?, ?>[] innerObserverArr = this.observers.get();
                int length = innerObserverArr.length;
                if (z2 && ((fVar2 == null || fVar2.isEmpty()) && length == 0)) {
                    Throwable terminate = this.errors.terminate();
                    if (terminate != ExceptionHelper.TERMINATED) {
                        if (terminate == null) {
                            uVar.onComplete();
                            return;
                        } else {
                            uVar.onError(terminate);
                            return;
                        }
                    }
                    return;
                }
                if (length != 0) {
                    long j = this.lastId;
                    int i2 = this.lastIndex;
                    if (length <= i2 || innerObserverArr[i2].id != j) {
                        if (length <= i2) {
                            i2 = 0;
                        }
                        for (int i3 = 0; i3 < length && innerObserverArr[i2].id != j; i3++) {
                            i2++;
                            if (i2 == length) {
                                i2 = 0;
                            }
                        }
                        this.lastIndex = i2;
                        this.lastId = innerObserverArr[i2].id;
                    }
                    int i4 = i2;
                    boolean z3 = false;
                    int i5 = 0;
                    while (i5 < length) {
                        if (!checkTerminate()) {
                            InnerObserver<T, U> innerObserver = innerObserverArr[i4];
                            while (!checkTerminate()) {
                                g<U> gVar = innerObserver.queue;
                                if (gVar != null) {
                                    while (true) {
                                        try {
                                            Object obj2 = (U) gVar.poll();
                                            if (obj2 == null) {
                                                break;
                                            }
                                            uVar.onNext(obj2);
                                            if (checkTerminate()) {
                                                return;
                                            }
                                        } catch (Throwable th) {
                                            io.reactivex.exceptions.a.K(th);
                                            innerObserver.dispose();
                                            this.errors.addThrowable(th);
                                            if (!checkTerminate()) {
                                                removeInner(innerObserver);
                                                i5++;
                                                z3 = true;
                                            } else {
                                                return;
                                            }
                                        }
                                    }
                                }
                                boolean z4 = innerObserver.done;
                                g<U> gVar2 = innerObserver.queue;
                                if (z4 && (gVar2 == null || gVar2.isEmpty())) {
                                    removeInner(innerObserver);
                                    if (checkTerminate()) {
                                        return;
                                    }
                                    z3 = true;
                                }
                                i4++;
                                if (i4 == length) {
                                    i4 = 0;
                                }
                                i5++;
                            }
                            return;
                        }
                        return;
                    }
                    this.lastIndex = i4;
                    this.lastId = innerObserverArr[i4].id;
                    z = z3;
                } else {
                    z = false;
                }
                if (z) {
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        synchronized (this) {
                            t<? extends U> poll = this.sources.poll();
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
                    int addAndGet = addAndGet(-i);
                    if (addAndGet == 0) {
                        return;
                    }
                    i = addAndGet;
                }
            }
        }

        boolean checkTerminate() {
            if (this.cancelled) {
                return true;
            }
            Throwable th = this.errors.get();
            if (!this.delayErrors && th != null) {
                disposeAll();
                Throwable terminate = this.errors.terminate();
                if (terminate != ExceptionHelper.TERMINATED) {
                    this.actual.onError(terminate);
                }
                return true;
            }
            return false;
        }

        boolean disposeAll() {
            InnerObserver<?, ?>[] andSet;
            this.s.dispose();
            if (this.observers.get() == CANCELLED || (andSet = this.observers.getAndSet(CANCELLED)) == CANCELLED) {
                return false;
            }
            for (InnerObserver<?, ?> innerObserver : andSet) {
                innerObserver.dispose();
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class InnerObserver<T, U> extends AtomicReference<io.reactivex.disposables.b> implements u<U> {
        private static final long serialVersionUID = -4606175640614850599L;
        volatile boolean done;
        int fusionMode;
        final long id;
        final MergeObserver<T, U> parent;
        volatile g<U> queue;

        InnerObserver(MergeObserver<T, U> mergeObserver, long j) {
            this.id = j;
            this.parent = mergeObserver;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.setOnce(this, bVar) && (bVar instanceof io.reactivex.internal.a.b)) {
                io.reactivex.internal.a.b bVar2 = (io.reactivex.internal.a.b) bVar;
                int requestFusion = bVar2.requestFusion(7);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = bVar2;
                    this.done = true;
                    this.parent.drain();
                } else if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = bVar2;
                }
            }
        }

        @Override // io.reactivex.u
        public void onNext(U u) {
            if (this.fusionMode == 0) {
                this.parent.tryEmit(u, this);
            } else {
                this.parent.drain();
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (this.parent.errors.addThrowable(th)) {
                if (!this.parent.delayErrors) {
                    this.parent.disposeAll();
                }
                this.done = true;
                this.parent.drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }
    }
}
