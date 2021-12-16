package io.reactivex.internal.operators.maybe;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes4.dex */
public final class MaybeZipArray<T, R> extends Maybe<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MaybeSource<? extends T>[] sources;
    public final Function<? super Object[], ? extends R> zipper;

    /* loaded from: classes4.dex */
    public final class SingletonArrayFunc implements Function<T, R> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MaybeZipArray this$0;

        public SingletonArrayFunc(MaybeZipArray maybeZipArray) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {maybeZipArray};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = maybeZipArray;
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object[], java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public R apply(T t) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) ? (R) ObjectHelper.requireNonNull(this.this$0.zipper.apply(new Object[]{t}), "The zipper returned a null value") : (R) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static final class ZipCoordinator<T, R> extends AtomicInteger implements Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -5556924161382950569L;
        public transient /* synthetic */ FieldHolder $fh;
        public final MaybeObserver<? super R> actual;
        public final ZipMaybeObserver<T>[] observers;
        public final Object[] values;
        public final Function<? super Object[], ? extends R> zipper;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ZipCoordinator(MaybeObserver<? super R> maybeObserver, int i2, Function<? super Object[], ? extends R> function) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {maybeObserver, Integer.valueOf(i2), function};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = maybeObserver;
            this.zipper = function;
            ZipMaybeObserver<T>[] zipMaybeObserverArr = new ZipMaybeObserver[i2];
            for (int i5 = 0; i5 < i2; i5++) {
                zipMaybeObserverArr[i5] = new ZipMaybeObserver<>(this, i5);
            }
            this.observers = zipMaybeObserverArr;
            this.values = new Object[i2];
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (getAndSet(0) > 0) {
                    for (ZipMaybeObserver<T> zipMaybeObserver : this.observers) {
                        zipMaybeObserver.dispose();
                    }
                }
            }
        }

        public void disposeExcept(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) != null) {
                return;
            }
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
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || getAndSet(0) <= 0) {
                return;
            }
            disposeExcept(i2);
            this.actual.onComplete();
        }

        public void innerError(Throwable th, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048579, this, th, i2) == null) {
                if (getAndSet(0) > 0) {
                    disposeExcept(i2);
                    this.actual.onError(th);
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        /* JADX DEBUG: Type inference failed for r6v2. Raw type applied. Possible types: ? super java.lang.Object[] */
        public void innerSuccess(T t, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048580, this, t, i2) == null) {
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
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? get() <= 0 : invokeV.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public static final class ZipMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3323743579927613702L;
        public transient /* synthetic */ FieldHolder $fh;
        public final int index;
        public final ZipCoordinator<T, ?> parent;

        public ZipMaybeObserver(ZipCoordinator<T, ?> zipCoordinator, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zipCoordinator, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = zipCoordinator;
            this.index = i2;
        }

        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                DisposableHelper.dispose(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.parent.innerComplete(this.index);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                this.parent.innerError(th, this.index);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, disposable) == null) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, t) == null) {
                this.parent.innerSuccess(t, this.index);
            }
        }
    }

    public MaybeZipArray(MaybeSource<? extends T>[] maybeSourceArr, Function<? super Object[], ? extends R> function) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {maybeSourceArr, function};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.sources = maybeSourceArr;
        this.zipper = function;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, maybeObserver) == null) {
            MaybeSource<? extends T>[] maybeSourceArr = this.sources;
            int length = maybeSourceArr.length;
            if (length == 1) {
                maybeSourceArr[0].subscribe(new MaybeMap.MapMaybeObserver(maybeObserver, new SingletonArrayFunc(this)));
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
}
