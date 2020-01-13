package io.reactivex.internal.operators.observable;

import io.reactivex.c.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.e;
import io.reactivex.t;
import io.reactivex.u;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes5.dex */
public final class ObservableWithLatestFromMany<T, R> extends io.reactivex.internal.operators.observable.a<T, R> {
    final h<? super Object[], R> combiner;
    final Iterable<? extends t<?>> nwL;
    final t<?>[] nxJ;

    @Override // io.reactivex.q
    protected void a(u<? super R> uVar) {
        int length;
        t<?>[] tVarArr = this.nxJ;
        int i = 0;
        if (tVarArr == null) {
            tVarArr = new t[8];
            try {
                for (t<?> tVar : this.nwL) {
                    if (i == tVarArr.length) {
                        tVarArr = (t[]) Arrays.copyOf(tVarArr, (i >> 1) + i);
                    }
                    int i2 = i + 1;
                    tVarArr[i] = tVar;
                    i = i2;
                }
                length = i;
            } catch (Throwable th) {
                io.reactivex.exceptions.a.I(th);
                EmptyDisposable.error(th, uVar);
                return;
            }
        } else {
            length = tVarArr.length;
        }
        if (length == 0) {
            new b(this.source, new a()).a(uVar);
            return;
        }
        WithLatestFromObserver withLatestFromObserver = new WithLatestFromObserver(uVar, this.combiner, length);
        uVar.onSubscribe(withLatestFromObserver);
        withLatestFromObserver.subscribe(tVarArr, length);
        this.source.subscribe(withLatestFromObserver);
    }

    /* loaded from: classes5.dex */
    static final class WithLatestFromObserver<T, R> extends AtomicInteger implements io.reactivex.disposables.b, u<T> {
        private static final long serialVersionUID = 1577321883966341961L;
        final u<? super R> actual;
        final h<? super Object[], R> combiner;
        final AtomicReference<io.reactivex.disposables.b> d;
        volatile boolean done;
        final AtomicThrowable error;
        final WithLatestInnerObserver[] observers;
        final AtomicReferenceArray<Object> values;

        WithLatestFromObserver(u<? super R> uVar, h<? super Object[], R> hVar, int i) {
            this.actual = uVar;
            this.combiner = hVar;
            WithLatestInnerObserver[] withLatestInnerObserverArr = new WithLatestInnerObserver[i];
            for (int i2 = 0; i2 < i; i2++) {
                withLatestInnerObserverArr[i2] = new WithLatestInnerObserver(this, i2);
            }
            this.observers = withLatestInnerObserverArr;
            this.values = new AtomicReferenceArray<>(i);
            this.d = new AtomicReference<>();
            this.error = new AtomicThrowable();
        }

        void subscribe(t<?>[] tVarArr, int i) {
            WithLatestInnerObserver[] withLatestInnerObserverArr = this.observers;
            AtomicReference<io.reactivex.disposables.b> atomicReference = this.d;
            for (int i2 = 0; i2 < i && !DisposableHelper.isDisposed(atomicReference.get()) && !this.done; i2++) {
                tVarArr[i2].subscribe(withLatestInnerObserverArr[i2]);
            }
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this.d, bVar);
        }

        @Override // io.reactivex.u
        public void onNext(T t) {
            if (!this.done) {
                AtomicReferenceArray<Object> atomicReferenceArray = this.values;
                int length = atomicReferenceArray.length();
                Object[] objArr = new Object[length + 1];
                objArr[0] = t;
                for (int i = 0; i < length; i++) {
                    Object obj = atomicReferenceArray.get(i);
                    if (obj != null) {
                        objArr[i + 1] = obj;
                    } else {
                        return;
                    }
                }
                try {
                    e.a(this.actual, io.reactivex.internal.functions.a.h(this.combiner.apply(objArr), "combiner returned a null value"), this, this.error);
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.I(th);
                    dispose();
                    onError(th);
                }
            }
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            if (this.done) {
                io.reactivex.e.a.onError(th);
                return;
            }
            this.done = true;
            cancelAllBut(-1);
            e.a((u<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                cancelAllBut(-1);
                e.a(this.actual, this, this.error);
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.d.get());
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.d);
            for (WithLatestInnerObserver withLatestInnerObserver : this.observers) {
                withLatestInnerObserver.dispose();
            }
        }

        void innerNext(int i, Object obj) {
            this.values.set(i, obj);
        }

        void innerError(int i, Throwable th) {
            this.done = true;
            DisposableHelper.dispose(this.d);
            cancelAllBut(i);
            e.a((u<?>) this.actual, th, (AtomicInteger) this, this.error);
        }

        void innerComplete(int i, boolean z) {
            if (!z) {
                this.done = true;
                cancelAllBut(i);
                e.a(this.actual, this, this.error);
            }
        }

        void cancelAllBut(int i) {
            WithLatestInnerObserver[] withLatestInnerObserverArr = this.observers;
            for (int i2 = 0; i2 < withLatestInnerObserverArr.length; i2++) {
                if (i2 != i) {
                    withLatestInnerObserverArr[i2].dispose();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class WithLatestInnerObserver extends AtomicReference<io.reactivex.disposables.b> implements u<Object> {
        private static final long serialVersionUID = 3256684027868224024L;
        boolean hasValue;
        final int index;
        final WithLatestFromObserver<?, ?> parent;

        WithLatestInnerObserver(WithLatestFromObserver<?, ?> withLatestFromObserver, int i) {
            this.parent = withLatestFromObserver;
            this.index = i;
        }

        @Override // io.reactivex.u
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // io.reactivex.u
        public void onNext(Object obj) {
            if (!this.hasValue) {
                this.hasValue = true;
            }
            this.parent.innerNext(this.index, obj);
        }

        @Override // io.reactivex.u
        public void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        @Override // io.reactivex.u
        public void onComplete() {
            this.parent.innerComplete(this.index, this.hasValue);
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }
    }

    /* loaded from: classes5.dex */
    final class a implements h<T, R> {
        a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        @Override // io.reactivex.c.h
        public R apply(T t) throws Exception {
            return (R) io.reactivex.internal.functions.a.h(ObservableWithLatestFromMany.this.combiner.apply(new Object[]{t}), "The combiner returned a null value");
        }
    }
}
