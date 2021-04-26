package io.reactivex.internal.operators.single;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.single.SingleMap;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class SingleZipArray<T, R> extends Single<R> {
    public final SingleSource<? extends T>[] sources;
    public final Function<? super Object[], ? extends R> zipper;

    /* loaded from: classes7.dex */
    public final class SingletonArrayFunc implements Function<T, R> {
        public SingletonArrayFunc() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public R apply(T t) throws Exception {
            return (R) ObjectHelper.requireNonNull(SingleZipArray.this.zipper.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }

    /* loaded from: classes7.dex */
    public static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
        public static final long serialVersionUID = -5556924161382950569L;
        public final SingleObserver<? super R> actual;
        public final ZipSingleObserver<T>[] observers;
        public final Object[] values;
        public final Function<? super Object[], ? extends R> zipper;

        public ZipCoordinator(SingleObserver<? super R> singleObserver, int i2, Function<? super Object[], ? extends R> function) {
            super(i2);
            this.actual = singleObserver;
            this.zipper = function;
            ZipSingleObserver<T>[] zipSingleObserverArr = new ZipSingleObserver[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                zipSingleObserverArr[i3] = new ZipSingleObserver<>(this, i3);
            }
            this.observers = zipSingleObserverArr;
            this.values = new Object[i2];
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (getAndSet(0) > 0) {
                for (ZipSingleObserver<T> zipSingleObserver : this.observers) {
                    zipSingleObserver.dispose();
                }
            }
        }

        public void disposeExcept(int i2) {
            ZipSingleObserver<T>[] zipSingleObserverArr = this.observers;
            int length = zipSingleObserverArr.length;
            for (int i3 = 0; i3 < i2; i3++) {
                zipSingleObserverArr[i3].dispose();
            }
            while (true) {
                i2++;
                if (i2 >= length) {
                    return;
                }
                zipSingleObserverArr[i2].dispose();
            }
        }

        public void innerError(Throwable th, int i2) {
            if (getAndSet(0) > 0) {
                disposeExcept(i2);
                this.actual.onError(th);
                return;
            }
            RxJavaPlugins.onError(th);
        }

        /* JADX DEBUG: Type inference failed for r3v2. Raw type applied. Possible types: ? super java.lang.Object[] */
        public void innerSuccess(T t, int i2) {
            this.values[i2] = t;
            if (decrementAndGet() == 0) {
                try {
                    this.actual.onSuccess(ObjectHelper.requireNonNull(this.zipper.apply(this.values), "The zipper returned a null value"));
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.actual.onError(th);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() <= 0;
        }
    }

    /* loaded from: classes7.dex */
    public static final class ZipSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T> {
        public static final long serialVersionUID = 3323743579927613702L;
        public final int index;
        public final ZipCoordinator<T, ?> parent;

        public ZipSingleObserver(ZipCoordinator<T, ?> zipCoordinator, int i2) {
            this.parent = zipCoordinator;
            this.index = i2;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            this.parent.innerError(th, this.index);
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            this.parent.innerSuccess(t, this.index);
        }
    }

    public SingleZipArray(SingleSource<? extends T>[] singleSourceArr, Function<? super Object[], ? extends R> function) {
        this.sources = singleSourceArr;
        this.zipper = function;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        SingleSource<? extends T>[] singleSourceArr = this.sources;
        int length = singleSourceArr.length;
        if (length == 1) {
            singleSourceArr[0].subscribe(new SingleMap.MapSingleObserver(singleObserver, new SingletonArrayFunc()));
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(singleObserver, length, this.zipper);
        singleObserver.onSubscribe(zipCoordinator);
        for (int i2 = 0; i2 < length && !zipCoordinator.isDisposed(); i2++) {
            SingleSource<? extends T> singleSource = singleSourceArr[i2];
            if (singleSource == null) {
                zipCoordinator.innerError(new NullPointerException("One of the sources is null"), i2);
                return;
            }
            singleSource.subscribe(zipCoordinator.observers[i2]);
        }
    }
}
