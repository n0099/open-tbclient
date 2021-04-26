package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.maybe.MaybeMap;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeZipArray<T, R> extends Maybe<R> {
    public final MaybeSource<? extends T>[] sources;
    public final Function<? super Object[], ? extends R> zipper;

    /* loaded from: classes7.dex */
    public final class SingletonArrayFunc implements Function<T, R> {
        public SingletonArrayFunc() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public R apply(T t) throws Exception {
            return (R) ObjectHelper.requireNonNull(MaybeZipArray.this.zipper.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }

    /* loaded from: classes7.dex */
    public static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
        public static final long serialVersionUID = -5556924161382950569L;
        public final MaybeObserver<? super R> actual;
        public final ZipMaybeObserver<T>[] observers;
        public final Object[] values;
        public final Function<? super Object[], ? extends R> zipper;

        public ZipCoordinator(MaybeObserver<? super R> maybeObserver, int i2, Function<? super Object[], ? extends R> function) {
            super(i2);
            this.actual = maybeObserver;
            this.zipper = function;
            ZipMaybeObserver<T>[] zipMaybeObserverArr = new ZipMaybeObserver[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                zipMaybeObserverArr[i3] = new ZipMaybeObserver<>(this, i3);
            }
            this.observers = zipMaybeObserverArr;
            this.values = new Object[i2];
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (getAndSet(0) > 0) {
                for (ZipMaybeObserver<T> zipMaybeObserver : this.observers) {
                    zipMaybeObserver.dispose();
                }
            }
        }

        public void disposeExcept(int i2) {
            ZipMaybeObserver<T>[] zipMaybeObserverArr = this.observers;
            int length = zipMaybeObserverArr.length;
            for (int i3 = 0; i3 < i2; i3++) {
                zipMaybeObserverArr[i3].dispose();
            }
            while (true) {
                i2++;
                if (i2 >= length) {
                    return;
                }
                zipMaybeObserverArr[i2].dispose();
            }
        }

        public void innerComplete(int i2) {
            if (getAndSet(0) > 0) {
                disposeExcept(i2);
                this.actual.onComplete();
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
    public static final class ZipMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        public static final long serialVersionUID = 3323743579927613702L;
        public final int index;
        public final ZipCoordinator<T, ?> parent;

        public ZipMaybeObserver(ZipCoordinator<T, ?> zipCoordinator, int i2) {
            this.parent = zipCoordinator;
            this.index = i2;
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            this.parent.innerComplete(this.index);
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            this.parent.innerError(th, this.index);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            DisposableHelper.setOnce(this, disposable);
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            this.parent.innerSuccess(t, this.index);
        }
    }

    public MaybeZipArray(MaybeSource<? extends T>[] maybeSourceArr, Function<? super Object[], ? extends R> function) {
        this.sources = maybeSourceArr;
        this.zipper = function;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        MaybeSource<? extends T>[] maybeSourceArr = this.sources;
        int length = maybeSourceArr.length;
        if (length == 1) {
            maybeSourceArr[0].subscribe(new MaybeMap.MapMaybeObserver(maybeObserver, new SingletonArrayFunc()));
            return;
        }
        ZipCoordinator zipCoordinator = new ZipCoordinator(maybeObserver, length, this.zipper);
        maybeObserver.onSubscribe(zipCoordinator);
        for (int i2 = 0; i2 < length && !zipCoordinator.isDisposed(); i2++) {
            MaybeSource<? extends T> maybeSource = maybeSourceArr[i2];
            if (maybeSource == null) {
                zipCoordinator.innerError(new NullPointerException("One of the sources is null"), i2);
                return;
            }
            maybeSource.subscribe(zipCoordinator.observers[i2]);
        }
    }
}
