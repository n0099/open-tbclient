package io.reactivex.internal.operators.maybe;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public final class MaybeFromFuture extends Maybe {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Future future;
    public final long timeout;
    public final TimeUnit unit;

    public MaybeFromFuture(Future future, long j, TimeUnit timeUnit) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {future, Long.valueOf(j), timeUnit};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.future = future;
        this.timeout = j;
        this.unit = timeUnit;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver maybeObserver) {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, maybeObserver) == null) {
            Disposable empty = Disposables.empty();
            maybeObserver.onSubscribe(empty);
            if (!empty.isDisposed()) {
                try {
                    if (this.timeout <= 0) {
                        obj = this.future.get();
                    } else {
                        obj = this.future.get(this.timeout, this.unit);
                    }
                    if (!empty.isDisposed()) {
                        if (obj == null) {
                            maybeObserver.onComplete();
                        } else {
                            maybeObserver.onSuccess(obj);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    if (th instanceof ExecutionException) {
                        th = th.getCause();
                    }
                    Exceptions.throwIfFatal(th);
                    if (!empty.isDisposed()) {
                        maybeObserver.onError(th);
                    }
                }
            }
        }
    }
}
