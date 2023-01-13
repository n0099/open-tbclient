package io.reactivex.internal.operators.observable;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public final class ObservableFromFuture<T> extends Observable<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Future<? extends T> future;
    public final long timeout;
    public final TimeUnit unit;

    public ObservableFromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
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

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: io.reactivex.internal.observers.DeferredScalarDisposable */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
            DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
            observer.onSubscribe(deferredScalarDisposable);
            if (!deferredScalarDisposable.isDisposed()) {
                try {
                    if (this.unit != null) {
                        t = this.future.get(this.timeout, this.unit);
                    } else {
                        t = this.future.get();
                    }
                    deferredScalarDisposable.complete(ObjectHelper.requireNonNull(t, "Future returned null"));
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    if (!deferredScalarDisposable.isDisposed()) {
                        observer.onError(th);
                    }
                }
            }
        }
    }
}
