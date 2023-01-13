package io.reactivex.internal.operators.maybe;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
/* loaded from: classes9.dex */
public final class MaybeFromCallable<T> extends Maybe<T> implements Callable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Callable<? extends T> callable;

    public MaybeFromCallable(Callable<? extends T> callable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.callable = callable;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.callable.call();
        }
        return (T) invokeV.objValue;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, maybeObserver) == null) {
            Disposable empty = Disposables.empty();
            maybeObserver.onSubscribe(empty);
            if (!empty.isDisposed()) {
                try {
                    Object obj = (T) this.callable.call();
                    if (!empty.isDisposed()) {
                        if (obj == null) {
                            maybeObserver.onComplete();
                        } else {
                            maybeObserver.onSuccess(obj);
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    if (!empty.isDisposed()) {
                        maybeObserver.onError(th);
                    } else {
                        RxJavaPlugins.onError(th);
                    }
                }
            }
        }
    }
}
