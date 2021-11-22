package io.reactivex.internal.operators.completable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import java.util.concurrent.Callable;
/* loaded from: classes2.dex */
public final class CompletableToSingle<T> extends Single<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final T completionValue;
    public final Callable<? extends T> completionValueSupplier;
    public final CompletableSource source;

    /* loaded from: classes2.dex */
    public final class ToSingle implements CompletableObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final SingleObserver<? super T> observer;
        public final /* synthetic */ CompletableToSingle this$0;

        public ToSingle(CompletableToSingle completableToSingle, SingleObserver<? super T> singleObserver) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {completableToSingle, singleObserver};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = completableToSingle;
            this.observer = singleObserver;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            T call;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                CompletableToSingle completableToSingle = this.this$0;
                Callable<? extends T> callable = completableToSingle.completionValueSupplier;
                if (callable != null) {
                    try {
                        call = callable.call();
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.observer.onError(th);
                        return;
                    }
                } else {
                    call = completableToSingle.completionValue;
                }
                if (call == null) {
                    this.observer.onError(new NullPointerException("The value supplied is null"));
                } else {
                    this.observer.onSuccess(call);
                }
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.observer.onError(th);
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, disposable) == null) {
                this.observer.onSubscribe(disposable);
            }
        }
    }

    public CompletableToSingle(CompletableSource completableSource, Callable<? extends T> callable, T t) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {completableSource, callable, t};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.source = completableSource;
        this.completionValue = t;
        this.completionValueSupplier = callable;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, singleObserver) == null) {
            this.source.subscribe(new ToSingle(this, singleObserver));
        }
    }
}
