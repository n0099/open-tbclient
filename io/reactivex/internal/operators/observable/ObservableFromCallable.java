package io.reactivex.internal.operators.observable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
/* loaded from: classes2.dex */
public final class ObservableFromCallable<T> extends Observable<T> implements Callable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Callable<? extends T> callable;

    public ObservableFromCallable(Callable<? extends T> callable) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (T) ObjectHelper.requireNonNull(this.callable.call(), "The callable returned a null value") : (T) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: io.reactivex.internal.observers.DeferredScalarDisposable */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, observer) == null) {
            DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
            observer.onSubscribe(deferredScalarDisposable);
            if (deferredScalarDisposable.isDisposed()) {
                return;
            }
            try {
                deferredScalarDisposable.complete(ObjectHelper.requireNonNull(this.callable.call(), "Callable returned null"));
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                if (!deferredScalarDisposable.isDisposed()) {
                    observer.onError(th);
                } else {
                    RxJavaPlugins.onError(th);
                }
            }
        }
    }
}
