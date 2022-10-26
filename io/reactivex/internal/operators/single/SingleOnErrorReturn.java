package io.reactivex.internal.operators.single;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
/* loaded from: classes8.dex */
public final class SingleOnErrorReturn extends Single {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SingleSource source;
    public final Object value;
    public final Function valueSupplier;

    /* loaded from: classes8.dex */
    public final class OnErrorReturn implements SingleObserver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final SingleObserver observer;
        public final /* synthetic */ SingleOnErrorReturn this$0;

        public OnErrorReturn(SingleOnErrorReturn singleOnErrorReturn, SingleObserver singleObserver) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleOnErrorReturn, singleObserver};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = singleOnErrorReturn;
            this.observer = singleObserver;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            Object apply;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                SingleOnErrorReturn singleOnErrorReturn = this.this$0;
                Function function = singleOnErrorReturn.valueSupplier;
                if (function != null) {
                    try {
                        apply = function.apply(th);
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        this.observer.onError(new CompositeException(th, th2));
                        return;
                    }
                } else {
                    apply = singleOnErrorReturn.value;
                }
                if (apply == null) {
                    NullPointerException nullPointerException = new NullPointerException("Value supplied was null");
                    nullPointerException.initCause(th);
                    this.observer.onError(nullPointerException);
                    return;
                }
                this.observer.onSuccess(apply);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, disposable) == null) {
                this.observer.onSubscribe(disposable);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                this.observer.onSuccess(obj);
            }
        }
    }

    public SingleOnErrorReturn(SingleSource singleSource, Function function, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {singleSource, function, obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.source = singleSource;
        this.valueSupplier = function;
        this.value = obj;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver singleObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, singleObserver) == null) {
            this.source.subscribe(new OnErrorReturn(this, singleObserver));
        }
    }
}
