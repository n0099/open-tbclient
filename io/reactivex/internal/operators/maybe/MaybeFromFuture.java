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
/* loaded from: classes2.dex */
public final class MaybeFromFuture<T> extends Maybe<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Future<? extends T> future;
    public final long timeout;
    public final TimeUnit unit;

    public MaybeFromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {future, Long.valueOf(j), timeUnit};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.future = future;
        this.timeout = j;
        this.unit = timeUnit;
    }

    /* JADX DEBUG: Type inference failed for r1v11. Raw type applied. Possible types: T, ? super T */
    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, maybeObserver) == null) {
            Disposable empty = Disposables.empty();
            maybeObserver.onSubscribe(empty);
            if (empty.isDisposed()) {
                return;
            }
            try {
                if (this.timeout <= 0) {
                    obj = (T) this.future.get();
                } else {
                    obj = (T) this.future.get(this.timeout, this.unit);
                }
                if (empty.isDisposed()) {
                    return;
                }
                if (obj == null) {
                    maybeObserver.onComplete();
                } else {
                    maybeObserver.onSuccess(obj);
                }
            } catch (Throwable th) {
                th = th;
                if (th instanceof ExecutionException) {
                    th = th.getCause();
                }
                Exceptions.throwIfFatal(th);
                if (empty.isDisposed()) {
                    return;
                }
                maybeObserver.onError(th);
            }
        }
    }
}
