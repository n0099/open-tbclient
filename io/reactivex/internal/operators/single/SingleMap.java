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
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
/* loaded from: classes2.dex */
public final class SingleMap<T, R> extends Single<R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Function<? super T, ? extends R> mapper;
    public final SingleSource<? extends T> source;

    /* loaded from: classes2.dex */
    public static final class MapSingleObserver<T, R> implements SingleObserver<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Function<? super T, ? extends R> mapper;
        public final SingleObserver<? super R> t;

        public MapSingleObserver(SingleObserver<? super R> singleObserver, Function<? super T, ? extends R> function) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleObserver, function};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.t = singleObserver;
            this.mapper = function;
        }

        @Override // io.reactivex.SingleObserver
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, th) == null) {
                this.t.onError(th);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, disposable) == null) {
                this.t.onSubscribe(disposable);
            }
        }

        @Override // io.reactivex.SingleObserver
        public void onSuccess(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t) == null) {
                try {
                    this.t.onSuccess(ObjectHelper.requireNonNull(this.mapper.apply(t), "The mapper function returned a null value."));
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    onError(th);
                }
            }
        }
    }

    public SingleMap(SingleSource<? extends T> singleSource, Function<? super T, ? extends R> function) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {singleSource, function};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.source = singleSource;
        this.mapper = function;
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super R> singleObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, singleObserver) == null) {
            this.source.subscribe(new MapSingleObserver(singleObserver, this.mapper));
        }
    }
}
