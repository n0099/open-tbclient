package io.reactivex.internal.operators.single;

import io.reactivex.aa;
import io.reactivex.c.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.single.a;
import io.reactivex.w;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class SingleZipArray<T, R> extends w<R> {
    final aa<? extends T>[] ooN;
    final h<? super Object[], ? extends R> zipper;

    @Override // io.reactivex.w
    protected void b(y<? super R> yVar) {
        aa<? extends T>[] aaVarArr = this.ooN;
        int length = aaVarArr.length;
        if (length == 1) {
            aaVarArr[0].a(new a.C0965a(yVar, new a()));
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(yVar, length, this.zipper);
        yVar.onSubscribe(zipCoordinator);
        for (int i = 0; i < length && !zipCoordinator.isDisposed(); i++) {
            aa<? extends T> aaVar = aaVarArr[i];
            if (aaVar == null) {
                zipCoordinator.innerError(new NullPointerException("One of the sources is null"), i);
                return;
            }
            aaVar.a(zipCoordinator.observers[i]);
        }
    }

    /* loaded from: classes7.dex */
    static final class ZipCoordinator<T, R> extends AtomicInteger implements io.reactivex.disposables.b {
        private static final long serialVersionUID = -5556924161382950569L;
        final y<? super R> actual;
        final ZipSingleObserver<T>[] observers;
        final Object[] values;
        final h<? super Object[], ? extends R> zipper;

        ZipCoordinator(y<? super R> yVar, int i, h<? super Object[], ? extends R> hVar) {
            super(i);
            this.actual = yVar;
            this.zipper = hVar;
            ZipSingleObserver<T>[] zipSingleObserverArr = new ZipSingleObserver[i];
            for (int i2 = 0; i2 < i; i2++) {
                zipSingleObserverArr[i2] = new ZipSingleObserver<>(this, i2);
            }
            this.observers = zipSingleObserverArr;
            this.values = new Object[i];
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() <= 0;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (getAndSet(0) > 0) {
                for (ZipSingleObserver<T> zipSingleObserver : this.observers) {
                    zipSingleObserver.dispose();
                }
            }
        }

        /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: ? super java.lang.Object[] */
        void innerSuccess(T t, int i) {
            this.values[i] = t;
            if (decrementAndGet() == 0) {
                try {
                    this.actual.onSuccess(io.reactivex.internal.functions.a.k(this.zipper.apply(this.values), "The zipper returned a null value"));
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.J(th);
                    this.actual.onError(th);
                }
            }
        }

        void disposeExcept(int i) {
            ZipSingleObserver<T>[] zipSingleObserverArr = this.observers;
            int length = zipSingleObserverArr.length;
            for (int i2 = 0; i2 < i; i2++) {
                zipSingleObserverArr[i2].dispose();
            }
            for (int i3 = i + 1; i3 < length; i3++) {
                zipSingleObserverArr[i3].dispose();
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
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class ZipSingleObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements y<T> {
        private static final long serialVersionUID = 3323743579927613702L;
        final int index;
        final ZipCoordinator<T, ?> parent;

        ZipSingleObserver(ZipCoordinator<T, ?> zipCoordinator, int i) {
            this.parent = zipCoordinator;
            this.index = i;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.y
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // io.reactivex.y
        public void onSuccess(T t) {
            this.parent.innerSuccess(t, this.index);
        }

        @Override // io.reactivex.y
        public void onError(Throwable th) {
            this.parent.innerError(th, this.index);
        }
    }

    /* loaded from: classes7.dex */
    final class a implements h<T, R> {
        a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        @Override // io.reactivex.c.h
        public R apply(T t) throws Exception {
            return (R) io.reactivex.internal.functions.a.k(SingleZipArray.this.zipper.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }
}
