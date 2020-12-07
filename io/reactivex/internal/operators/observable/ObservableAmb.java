package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class ObservableAmb<T> extends q<T> {
    final Iterable<? extends t<? extends T>> pFh;
    final t<? extends T>[] pGw;

    @Override // io.reactivex.q
    public void a(u<? super T> uVar) {
        int length;
        t<? extends T>[] tVarArr;
        t<? extends T>[] tVarArr2 = this.pGw;
        if (tVarArr2 == null) {
            t<? extends T>[] tVarArr3 = new q[8];
            try {
                int i = 0;
                for (t<? extends T> tVar : this.pFh) {
                    if (tVar == null) {
                        EmptyDisposable.error(new NullPointerException("One of the sources is null"), uVar);
                        return;
                    }
                    if (i == tVarArr3.length) {
                        tVarArr = new t[(i >> 2) + i];
                        System.arraycopy(tVarArr3, 0, tVarArr, 0, i);
                    } else {
                        tVarArr = tVarArr3;
                    }
                    int i2 = i + 1;
                    tVarArr[i] = tVar;
                    i = i2;
                    tVarArr3 = tVarArr;
                }
                length = i;
                tVarArr2 = tVarArr3;
            } catch (Throwable th) {
                io.reactivex.exceptions.a.J(th);
                EmptyDisposable.error(th, uVar);
                return;
            }
        } else {
            length = tVarArr2.length;
        }
        if (length == 0) {
            EmptyDisposable.complete(uVar);
        } else if (length == 1) {
            tVarArr2[0].subscribe(uVar);
        } else {
            new a(uVar, length).subscribe(tVarArr2);
        }
    }

    /* loaded from: classes9.dex */
    static final class a<T> implements io.reactivex.disposables.b {
        final u<? super T> actual;
        final AtomicInteger pFj = new AtomicInteger();
        final AmbInnerObserver<T>[] pGx;

        a(u<? super T> uVar, int i) {
            this.actual = uVar;
            this.pGx = new AmbInnerObserver[i];
        }

        public void subscribe(t<? extends T>[] tVarArr) {
            AmbInnerObserver<T>[] ambInnerObserverArr = this.pGx;
            int length = ambInnerObserverArr.length;
            for (int i = 0; i < length; i++) {
                ambInnerObserverArr[i] = new AmbInnerObserver<>(this, i + 1, this.actual);
            }
            this.pFj.lazySet(0);
            this.actual.onSubscribe(this);
            for (int i2 = 0; i2 < length && this.pFj.get() == 0; i2++) {
                tVarArr[i2].subscribe(ambInnerObserverArr[i2]);
            }
        }

        public boolean RN(int i) {
            int i2 = this.pFj.get();
            if (i2 != 0) {
                return i2 == i;
            } else if (this.pFj.compareAndSet(0, i)) {
                AmbInnerObserver<T>[] ambInnerObserverArr = this.pGx;
                int length = ambInnerObserverArr.length;
                for (int i3 = 0; i3 < length; i3++) {
                    if (i3 + 1 != i) {
                        ambInnerObserverArr[i3].dispose();
                    }
                }
                return true;
            } else {
                return false;
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.pFj.get() != -1) {
                this.pFj.lazySet(-1);
                for (AmbInnerObserver<T> ambInnerObserver : this.pGx) {
                    ambInnerObserver.dispose();
                }
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.pFj.get() == -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static final class AmbInnerObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements u<T> {
        private static final long serialVersionUID = -1185974347409665484L;
        final u<? super T> actual;
        final int index;
        final a<T> parent;
        boolean won;

        AmbInnerObserver(a<T> aVar, int i, u<? super T> uVar) {
            this.parent = aVar;
            this.index = i;
            this.actual = uVar;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            if (this.won) {
                this.actual.onNext(t);
            } else if (this.parent.RN(this.index)) {
                this.won = true;
                this.actual.onNext(t);
            } else {
                get().dispose();
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (this.won) {
                this.actual.onError(th);
            } else if (this.parent.RN(this.index)) {
                this.won = true;
                this.actual.onError(th);
            } else {
                io.reactivex.d.a.onError(th);
            }
        }

        @Override // io.reactivex.u
        public void onComplete() {
            if (this.won) {
                this.actual.onComplete();
            } else if (this.parent.RN(this.index)) {
                this.won = true;
                this.actual.onComplete();
            }
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }
    }
}
