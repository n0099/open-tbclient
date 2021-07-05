package io.reactivex.internal.operators.maybe;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;
import io.reactivex.internal.observers.DeferredScalarDisposable;
/* loaded from: classes10.dex */
public final class MaybeToObservable<T> extends Observable<T> implements HasUpstreamMaybeSource<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MaybeSource<T> source;

    /* loaded from: classes10.dex */
    public static final class MaybeToObservableObserver<T> extends DeferredScalarDisposable<T> implements MaybeObserver<T> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 7603343402964826922L;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f75997d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MaybeToObservableObserver(Observer<? super T> observer) {
            super(observer);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Observer) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.dispose();
                this.f75997d.dispose();
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                complete();
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
                error(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, disposable) == null) && DisposableHelper.validate(this.f75997d, disposable)) {
                this.f75997d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, t) == null) {
                complete(t);
            }
        }
    }

    public MaybeToObservable(MaybeSource<T> maybeSource) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {maybeSource};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.source = maybeSource;
    }

    @Experimental
    public static <T> MaybeObserver<T> create(Observer<? super T> observer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, observer)) == null) ? new MaybeToObservableObserver(observer) : (MaybeObserver) invokeL.objValue;
    }

    @Override // io.reactivex.internal.fuseable.HasUpstreamMaybeSource
    public MaybeSource<T> source() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.source : (MaybeSource) invokeV.objValue;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, observer) == null) {
            this.source.subscribe(create(observer));
        }
    }
}
