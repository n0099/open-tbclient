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
/* loaded from: classes8.dex */
public final class MaybeZipArray extends Maybe {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MaybeSource[] sources;
    public final Function zipper;

    /* loaded from: classes8.dex */
    public final class SingletonArrayFunc implements Function {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = maybeZipArray;
        }

        @Override // io.reactivex.functions.Function
        public Object apply(Object obj) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                return ObjectHelper.requireNonNull(this.this$0.zipper.apply(new Object[]{obj}), "The zipper returned a null value");
            }
            return invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public final class ZipCoordinator extends AtomicInteger implements Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -5556924161382950569L;
        public transient /* synthetic */ FieldHolder $fh;
        public final MaybeObserver actual;
        public final ZipMaybeObserver[] observers;
        public final Object[] values;
        public final Function zipper;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ZipCoordinator(MaybeObserver maybeObserver, int i, Function function) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {maybeObserver, Integer.valueOf(i), function};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = maybeObserver;
            this.zipper = function;
            ZipMaybeObserver[] zipMaybeObserverArr = new ZipMaybeObserver[i];
            for (int i4 = 0; i4 < i; i4++) {
                zipMaybeObserverArr[i4] = new ZipMaybeObserver(this, i4);
            }
            this.observers = zipMaybeObserverArr;
            this.values = new Object[i];
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (getAndSet(0) > 0) {
                    for (ZipMaybeObserver zipMaybeObserver : this.observers) {
                        zipMaybeObserver.dispose();
                    }
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (get() <= 0) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public void disposeExcept(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                ZipMaybeObserver[] zipMaybeObserverArr = this.observers;
                int length = zipMaybeObserverArr.length;
                for (int i2 = 0; i2 < i; i2++) {
                    zipMaybeObserverArr[i2].dispose();
                }
                while (true) {
                    i++;
                    if (i < length) {
                        zipMaybeObserverArr[i].dispose();
                    } else {
                        return;
                    }
                }
            }
        }

        public void innerComplete(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && getAndSet(0) > 0) {
                disposeExcept(i);
                this.actual.onComplete();
            }
        }

        public void innerError(Throwable th, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048579, this, th, i) == null) {
                if (getAndSet(0) > 0) {
                    disposeExcept(i);
                    this.actual.onError(th);
                    return;
                }
                RxJavaPlugins.onError(th);
            }
        }

        public void innerSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048580, this, obj, i) == null) {
                this.values[i] = obj;
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
    }

    /* loaded from: classes8.dex */
    public final class ZipMaybeObserver extends AtomicReference implements MaybeObserver {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 3323743579927613702L;
        public transient /* synthetic */ FieldHolder $fh;
        public final int index;
        public final ZipCoordinator parent;

        public ZipMaybeObserver(ZipCoordinator zipCoordinator, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zipCoordinator, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = zipCoordinator;
            this.index = i;
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
        public void onSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
                this.parent.innerSuccess(obj, this.index);
            }
        }
    }

    public MaybeZipArray(MaybeSource[] maybeSourceArr, Function function) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {maybeSourceArr, function};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.sources = maybeSourceArr;
        this.zipper = function;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver maybeObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, maybeObserver) == null) {
            MaybeSource[] maybeSourceArr = this.sources;
            int length = maybeSourceArr.length;
            if (length == 1) {
                maybeSourceArr[0].subscribe(new MaybeMap.MapMaybeObserver(maybeObserver, new SingletonArrayFunc(this)));
                return;
            }
            ZipCoordinator zipCoordinator = new ZipCoordinator(maybeObserver, length, this.zipper);
            maybeObserver.onSubscribe(zipCoordinator);
            for (int i = 0; i < length && !zipCoordinator.isDisposed(); i++) {
                MaybeSource maybeSource = maybeSourceArr[i];
                if (maybeSource == null) {
                    zipCoordinator.innerError(new NullPointerException("One of the sources is null"), i);
                    return;
                }
                maybeSource.subscribe(zipCoordinator.observers[i]);
            }
        }
    }
}
