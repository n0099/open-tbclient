package io.reactivex.internal.operators.maybe;

import io.reactivex.c.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.maybe.b;
import io.reactivex.k;
import io.reactivex.m;
import io.reactivex.o;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeZipArray<T, R> extends k<R> {
    final o<? extends T>[] sources;
    final h<? super Object[], ? extends R> zipper;

    @Override // io.reactivex.k
    protected void b(m<? super R> mVar) {
        o<? extends T>[] oVarArr = this.sources;
        int length = oVarArr.length;
        if (length == 1) {
            oVarArr[0].a(new b.a(mVar, new a()));
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(mVar, length, this.zipper);
        mVar.onSubscribe(zipCoordinator);
        for (int i = 0; i < length && !zipCoordinator.isDisposed(); i++) {
            o<? extends T> oVar = oVarArr[i];
            if (oVar == null) {
                zipCoordinator.innerError(new NullPointerException("One of the sources is null"), i);
                return;
            }
            oVar.a(zipCoordinator.observers[i]);
        }
    }

    /* loaded from: classes7.dex */
    static final class ZipCoordinator<T, R> extends AtomicInteger implements io.reactivex.disposables.b {
        private static final long serialVersionUID = -5556924161382950569L;
        final m<? super R> actual;
        final ZipMaybeObserver<T>[] observers;
        final Object[] values;
        final h<? super Object[], ? extends R> zipper;

        ZipCoordinator(m<? super R> mVar, int i, h<? super Object[], ? extends R> hVar) {
            super(i);
            this.actual = mVar;
            this.zipper = hVar;
            ZipMaybeObserver<T>[] zipMaybeObserverArr = new ZipMaybeObserver[i];
            for (int i2 = 0; i2 < i; i2++) {
                zipMaybeObserverArr[i2] = new ZipMaybeObserver<>(this, i2);
            }
            this.observers = zipMaybeObserverArr;
            this.values = new Object[i];
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() <= 0;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (getAndSet(0) > 0) {
                for (ZipMaybeObserver<T> zipMaybeObserver : this.observers) {
                    zipMaybeObserver.dispose();
                }
            }
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: ? super java.lang.Object[] */
        void innerSuccess(T t, int i) {
            this.values[i] = t;
            if (decrementAndGet() == 0) {
                try {
                    this.actual.onSuccess(io.reactivex.internal.functions.a.h(this.zipper.apply(this.values), "The zipper returned a null value"));
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.L(th);
                    this.actual.onError(th);
                }
            }
        }

        void disposeExcept(int i) {
            ZipMaybeObserver<T>[] zipMaybeObserverArr = this.observers;
            int length = zipMaybeObserverArr.length;
            for (int i2 = 0; i2 < i; i2++) {
                zipMaybeObserverArr[i2].dispose();
            }
            for (int i3 = i + 1; i3 < length; i3++) {
                zipMaybeObserverArr[i3].dispose();
            }
        }

        void innerError(Throwable th, int i) {
            if (getAndSet(0) > 0) {
                disposeExcept(i);
                this.actual.onError(th);
                return;
            }
            io.reactivex.e.a.onError(th);
        }

        void innerComplete(int i) {
            if (getAndSet(0) > 0) {
                disposeExcept(i);
                this.actual.onComplete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class ZipMaybeObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements m<T> {
        private static final long serialVersionUID = 3323743579927613702L;
        final int index;
        final ZipCoordinator<T, ?> parent;

        ZipMaybeObserver(ZipCoordinator<T, ?> zipCoordinator, int i) {
            this.parent = zipCoordinator;
            this.index = i;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.m
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // io.reactivex.m
        public void onSuccess(T t) {
            this.parent.innerSuccess(t, this.index);
        }

        @Override // io.reactivex.m
        public void onError(Throwable th) {
            this.parent.innerError(th, this.index);
        }

        @Override // io.reactivex.m
        public void onComplete() {
            this.parent.innerComplete(this.index);
        }
    }

    /* loaded from: classes7.dex */
    final class a implements h<T, R> {
        a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        @Override // io.reactivex.c.h
        public R apply(T t) throws Exception {
            return (R) io.reactivex.internal.functions.a.h(MaybeZipArray.this.zipper.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }
}
