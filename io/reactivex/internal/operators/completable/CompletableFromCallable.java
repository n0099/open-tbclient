package io.reactivex.internal.operators.completable;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import java.util.concurrent.Callable;
/* loaded from: classes3.dex */
public final class CompletableFromCallable extends Completable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Callable<?> callable;

    public CompletableFromCallable(Callable<?> callable) {
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

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, completableObserver) == null) {
            Disposable empty = Disposables.empty();
            completableObserver.onSubscribe(empty);
            try {
                this.callable.call();
                if (empty.isDisposed()) {
                    return;
                }
                completableObserver.onComplete();
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                if (empty.isDisposed()) {
                    return;
                }
                completableObserver.onError(th);
            }
        }
    }
}
