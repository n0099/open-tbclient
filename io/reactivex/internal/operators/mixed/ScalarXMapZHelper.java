package io.reactivex.internal.operators.mixed;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.MaybeSource;
import io.reactivex.Observer;
import io.reactivex.SingleSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.maybe.MaybeToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import java.util.concurrent.Callable;
/* loaded from: classes8.dex */
public final class ScalarXMapZHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ScalarXMapZHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        throw new IllegalStateException("No instances!");
    }

    public static boolean tryAsCompletable(Object obj, Function function, CompletableObserver completableObserver) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, obj, function, completableObserver)) == null) {
            if (obj instanceof Callable) {
                CompletableSource completableSource = null;
                try {
                    Object call = ((Callable) obj).call();
                    if (call != null) {
                        completableSource = (CompletableSource) ObjectHelper.requireNonNull(function.apply(call), "The mapper returned a null CompletableSource");
                    }
                    if (completableSource == null) {
                        EmptyDisposable.complete(completableObserver);
                    } else {
                        completableSource.subscribe(completableObserver);
                    }
                    return true;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    EmptyDisposable.error(th, completableObserver);
                    return true;
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean tryAsMaybe(Object obj, Function function, Observer observer) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, obj, function, observer)) == null) {
            if (obj instanceof Callable) {
                MaybeSource maybeSource = null;
                try {
                    Object call = ((Callable) obj).call();
                    if (call != null) {
                        maybeSource = (MaybeSource) ObjectHelper.requireNonNull(function.apply(call), "The mapper returned a null MaybeSource");
                    }
                    if (maybeSource == null) {
                        EmptyDisposable.complete(observer);
                    } else {
                        maybeSource.subscribe(MaybeToObservable.create(observer));
                    }
                    return true;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    EmptyDisposable.error(th, observer);
                    return true;
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean tryAsSingle(Object obj, Function function, Observer observer) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, obj, function, observer)) == null) {
            if (obj instanceof Callable) {
                SingleSource singleSource = null;
                try {
                    Object call = ((Callable) obj).call();
                    if (call != null) {
                        singleSource = (SingleSource) ObjectHelper.requireNonNull(function.apply(call), "The mapper returned a null SingleSource");
                    }
                    if (singleSource == null) {
                        EmptyDisposable.complete(observer);
                    } else {
                        singleSource.subscribe(SingleToObservable.create(observer));
                    }
                    return true;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    EmptyDisposable.error(th, observer);
                    return true;
                }
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
