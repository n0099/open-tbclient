package io.reactivex.internal.operators.observable;

import io.reactivex.c.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableCombineLatest<T, R> extends q<R> {
    final int bufferSize;
    final h<? super Object[], ? extends R> combiner;
    final boolean delayError;
    final Iterable<? extends t<? extends T>> mRN;
    final t<? extends T>[] mTn;

    @Override // io.reactivex.q
    public void a(u<? super R> uVar) {
        int length;
        t<? extends T>[] tVarArr;
        t<? extends T>[] tVarArr2;
        t<? extends T>[] tVarArr3 = this.mTn;
        if (tVarArr3 == null) {
            t<? extends T>[] tVarArr4 = new q[8];
            length = 0;
            for (t<? extends T> tVar : this.mRN) {
                if (length == tVarArr4.length) {
                    tVarArr2 = new t[(length >> 2) + length];
                    System.arraycopy(tVarArr4, 0, tVarArr2, 0, length);
                } else {
                    tVarArr2 = tVarArr4;
                }
                tVarArr2[length] = tVar;
                length++;
                tVarArr4 = tVarArr2;
            }
            tVarArr = tVarArr4;
        } else {
            length = tVarArr3.length;
            tVarArr = tVarArr3;
        }
        if (length == 0) {
            EmptyDisposable.complete(uVar);
        } else {
            new LatestCoordinator(uVar, this.combiner, length, this.bufferSize, this.delayError).subscribe(tVarArr);
        }
    }

    /* loaded from: classes7.dex */
    static final class LatestCoordinator<T, R> extends AtomicInteger implements io.reactivex.disposables.b {
        private static final long serialVersionUID = 8567835998786448817L;
        int active;
        final u<? super R> actual;
        volatile boolean cancelled;
        final h<? super Object[], ? extends R> combiner;
        int complete;
        final boolean delayError;
        volatile boolean done;
        final AtomicThrowable errors = new AtomicThrowable();
        Object[] latest;
        final CombinerObserver<T, R>[] observers;
        final io.reactivex.internal.queue.a<Object[]> queue;

        LatestCoordinator(u<? super R> uVar, h<? super Object[], ? extends R> hVar, int i, int i2, boolean z) {
            this.actual = uVar;
            this.combiner = hVar;
            this.delayError = z;
            this.latest = new Object[i];
            CombinerObserver<T, R>[] combinerObserverArr = new CombinerObserver[i];
            for (int i3 = 0; i3 < i; i3++) {
                combinerObserverArr[i3] = new CombinerObserver<>(this, i3);
            }
            this.observers = combinerObserverArr;
            this.queue = new io.reactivex.internal.queue.a<>(i2);
        }

        public void subscribe(t<? extends T>[] tVarArr) {
            CombinerObserver<T, R>[] combinerObserverArr = this.observers;
            int length = combinerObserverArr.length;
            this.actual.onSubscribe(this);
            for (int i = 0; i < length && !this.done && !this.cancelled; i++) {
                tVarArr[i].subscribe(combinerObserverArr[i]);
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelSources();
                if (getAndIncrement() == 0) {
                    clear(this.queue);
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        void cancelSources() {
            for (CombinerObserver<T, R> combinerObserver : this.observers) {
                combinerObserver.dispose();
            }
        }

        void clear(io.reactivex.internal.queue.a<?> aVar) {
            synchronized (this) {
                this.latest = null;
            }
            aVar.clear();
        }

        void drain() {
            if (getAndIncrement() == 0) {
                io.reactivex.internal.queue.a<Object[]> aVar = this.queue;
                u<? super R> uVar = this.actual;
                boolean z = this.delayError;
                int i = 1;
                while (!this.cancelled) {
                    if (!z && this.errors.get() != null) {
                        cancelSources();
                        clear(aVar);
                        uVar.onError(this.errors.terminate());
                        return;
                    }
                    boolean z2 = this.done;
                    Object[] poll = aVar.poll();
                    boolean z3 = poll == null;
                    if (z2 && z3) {
                        clear(aVar);
                        Throwable terminate = this.errors.terminate();
                        if (terminate == null) {
                            uVar.onComplete();
                            return;
                        } else {
                            uVar.onError(terminate);
                            return;
                        }
                    } else if (!z3) {
                        try {
                            uVar.onNext((Object) io.reactivex.internal.functions.a.h(this.combiner.apply(poll), "The combiner returned a null value"));
                        } catch (Throwable th) {
                            io.reactivex.exceptions.a.L(th);
                            this.errors.addThrowable(th);
                            cancelSources();
                            clear(aVar);
                            uVar.onError(this.errors.terminate());
                            return;
                        }
                    } else {
                        int addAndGet = addAndGet(-i);
                        if (addAndGet == 0) {
                            return;
                        }
                        i = addAndGet;
                    }
                }
                clear(aVar);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: io.reactivex.internal.queue.a<java.lang.Object[]> */
        /* JADX WARN: Multi-variable type inference failed */
        void innerNext(int i, T t) {
            boolean z = false;
            synchronized (this) {
                Object[] objArr = this.latest;
                if (objArr != null) {
                    Object obj = objArr[i];
                    int i2 = this.active;
                    if (obj == null) {
                        i2++;
                        this.active = i2;
                    }
                    objArr[i] = t;
                    if (i2 == objArr.length) {
                        this.queue.offer(objArr.clone());
                        z = true;
                    }
                    if (z) {
                        drain();
                    }
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0021, code lost:
            if (r2 == r1.length) goto L18;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void innerError(int i, Throwable th) {
            if (this.errors.addThrowable(th)) {
                if (this.delayError) {
                    synchronized (this) {
                        Object[] objArr = this.latest;
                        if (objArr != null) {
                            r0 = objArr[i] == null;
                            if (!r0) {
                                int i2 = this.complete + 1;
                                this.complete = i2;
                            }
                            this.done = true;
                        } else {
                            return;
                        }
                    }
                }
                if (r0) {
                    cancelSources();
                }
                drain();
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0015, code lost:
            if (r2 == r1.length) goto L19;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void innerComplete(int i) {
            synchronized (this) {
                Object[] objArr = this.latest;
                if (objArr != null) {
                    boolean z = objArr[i] == null;
                    if (!z) {
                        int i2 = this.complete + 1;
                        this.complete = i2;
                    }
                    this.done = true;
                    if (z) {
                        cancelSources();
                    }
                    drain();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class CombinerObserver<T, R> extends AtomicReference<io.reactivex.disposables.b> implements u<T> {
        private static final long serialVersionUID = -4823716997131257941L;
        final int index;
        final LatestCoordinator<T, R> parent;

        CombinerObserver(LatestCoordinator<T, R> latestCoordinator, int i) {
            this.parent = latestCoordinator;
            this.index = i;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            this.parent.innerNext(this.index, t);
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            this.parent.innerComplete(this.index);
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }
    }
}
