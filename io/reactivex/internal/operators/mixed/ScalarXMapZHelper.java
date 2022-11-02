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
import io.reactivex.annotations.Experimental;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.maybe.MaybeToObservable;
import io.reactivex.internal.operators.single.SingleToObservable;
import java.util.concurrent.Callable;
@Experimental
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

    public static <T> boolean tryAsCompletable(Object obj, Function<? super T, ? extends CompletableSource> function, CompletableObserver completableObserver) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, obj, function, completableObserver)) == null) {
            if (obj instanceof Callable) {
                CompletableSource completableSource = null;
                try {
                    Object obj2 = (Object) ((Callable) obj).call();
                    if (obj2 != 0) {
                        completableSource = (CompletableSource) ObjectHelper.requireNonNull(function.apply(obj2), "The mapper returned a null CompletableSource");
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

    public static <T, R> boolean tryAsMaybe(Object obj, Function<? super T, ? extends MaybeSource<? extends R>> function, Observer<? super R> observer) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, obj, function, observer)) == null) {
            if (obj instanceof Callable) {
                MaybeSource maybeSource = null;
                try {
                    Object obj2 = (Object) ((Callable) obj).call();
                    if (obj2 != 0) {
                        maybeSource = (MaybeSource) ObjectHelper.requireNonNull(function.apply(obj2), "The mapper returned a null MaybeSource");
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

    public static <T, R> boolean tryAsSingle(Object obj, Function<? super T, ? extends SingleSource<? extends R>> function, Observer<? super R> observer) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, obj, function, observer)) == null) {
            if (obj instanceof Callable) {
                SingleSource singleSource = null;
                try {
                    Object obj2 = (Object) ((Callable) obj).call();
                    if (obj2 != 0) {
                        singleSource = (SingleSource) ObjectHelper.requireNonNull(function.apply(obj2), "The mapper returned a null SingleSource");
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
