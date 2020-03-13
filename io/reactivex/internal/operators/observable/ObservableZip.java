package io.reactivex.internal.operators.observable;

import io.reactivex.c.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.u;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableZip<T, R> extends q<R> {
    final int bufferSize;
    final boolean delayError;
    final Iterable<? extends t<? extends T>> nwF;
    final t<? extends T>[] nxZ;
    final h<? super Object[], ? extends R> zipper;

    @Override // io.reactivex.q
    public void a(u<? super R> uVar) {
        int length;
        t<? extends T>[] tVarArr;
        t<? extends T>[] tVarArr2 = this.nxZ;
        if (tVarArr2 == null) {
            tVarArr2 = new q[8];
            length = 0;
            for (t<? extends T> tVar : this.nwF) {
                if (length == tVarArr2.length) {
                    tVarArr = new t[(length >> 2) + length];
                    System.arraycopy(tVarArr2, 0, tVarArr, 0, length);
                } else {
                    tVarArr = tVarArr2;
                }
                tVarArr[length] = tVar;
                length++;
                tVarArr2 = tVarArr;
            }
        } else {
            length = tVarArr2.length;
        }
        if (length == 0) {
            EmptyDisposable.complete(uVar);
        } else {
            new ZipCoordinator(uVar, this.zipper, length, this.delayError).subscribe(tVarArr2, this.bufferSize);
        }
    }

    /* loaded from: classes7.dex */
    static final class ZipCoordinator<T, R> extends AtomicInteger implements io.reactivex.disposables.b {
        private static final long serialVersionUID = 2983708048395377667L;
        final u<? super R> actual;
        volatile boolean cancelled;
        final boolean delayError;
        final a<T, R>[] observers;
        final T[] row;
        final h<? super Object[], ? extends R> zipper;

        ZipCoordinator(u<? super R> uVar, h<? super Object[], ? extends R> hVar, int i, boolean z) {
            this.actual = uVar;
            this.zipper = hVar;
            this.observers = new a[i];
            this.row = (T[]) new Object[i];
            this.delayError = z;
        }

        public void subscribe(t<? extends T>[] tVarArr, int i) {
            a<T, R>[] aVarArr = this.observers;
            int length = aVarArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                aVarArr[i2] = new a<>(this, i);
            }
            lazySet(0);
            this.actual.onSubscribe(this);
            for (int i3 = 0; i3 < length && !this.cancelled; i3++) {
                tVarArr[i3].subscribe(aVarArr[i3]);
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelSources();
                if (getAndIncrement() == 0) {
                    clear();
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        void cancel() {
            clear();
            cancelSources();
        }

        void cancelSources() {
            for (a<T, R> aVar : this.observers) {
                aVar.dispose();
            }
        }

        void clear() {
            for (a<T, R> aVar : this.observers) {
                aVar.queue.clear();
            }
        }

        public void drain() {
            Throwable th;
            int i;
            if (getAndIncrement() == 0) {
                a<T, R>[] aVarArr = this.observers;
                u<? super R> uVar = this.actual;
                T[] tArr = this.row;
                boolean z = this.delayError;
                int i2 = 1;
                while (true) {
                    int i3 = 0;
                    int length = aVarArr.length;
                    int i4 = 0;
                    int i5 = 0;
                    while (i4 < length) {
                        a<T, R> aVar = aVarArr[i4];
                        if (tArr[i5] == null) {
                            boolean z2 = aVar.done;
                            T poll = aVar.queue.poll();
                            boolean z3 = poll == null;
                            if (!checkTerminated(z2, z3, uVar, z, aVar)) {
                                if (!z3) {
                                    tArr[i5] = poll;
                                    i = i3;
                                } else {
                                    i = i3 + 1;
                                }
                                i3 = i;
                            } else {
                                return;
                            }
                        } else if (aVar.done && !z && (th = aVar.error) != null) {
                            cancel();
                            uVar.onError(th);
                            return;
                        }
                        i4++;
                        i5++;
                    }
                    if (i3 == 0) {
                        try {
                            uVar.onNext((Object) io.reactivex.internal.functions.a.h(this.zipper.apply(tArr.clone()), "The zipper returned a null value"));
                            Arrays.fill(tArr, (Object) null);
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.H(th2);
                            cancel();
                            uVar.onError(th2);
                            return;
                        }
                    } else {
                        int addAndGet = addAndGet(-i2);
                        if (addAndGet == 0) {
                            return;
                        }
                        i2 = addAndGet;
                    }
                }
            }
        }

        boolean checkTerminated(boolean z, boolean z2, u<? super R> uVar, boolean z3, a<?, ?> aVar) {
            if (this.cancelled) {
                cancel();
                return true;
            }
            if (z) {
                if (z3) {
                    if (z2) {
                        Throwable th = aVar.error;
                        cancel();
                        if (th != null) {
                            uVar.onError(th);
                            return true;
                        }
                        uVar.onComplete();
                        return true;
                    }
                } else {
                    Throwable th2 = aVar.error;
                    if (th2 != null) {
                        cancel();
                        uVar.onError(th2);
                        return true;
                    } else if (z2) {
                        cancel();
                        uVar.onComplete();
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class a<T, R> implements u<T> {
        volatile boolean done;
        Throwable error;
        final ZipCoordinator<T, R> nyF;
        final io.reactivex.internal.queue.a<T> queue;
        final AtomicReference<io.reactivex.disposables.b> s = new AtomicReference<>();

        a(ZipCoordinator<T, R> zipCoordinator, int i) {
            this.nyF = zipCoordinator;
            this.queue = new io.reactivex.internal.queue.a<>(i);
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.s, bVar);
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            this.queue.offer(t);
            this.nyF.drain();
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            this.nyF.drain();
        }

        @Override // io.reactivex.u
        public void onComplete() {
            this.done = true;
            this.nyF.drain();
        }

        public void dispose() {
            DisposableHelper.dispose(this.s);
        }
    }
}
