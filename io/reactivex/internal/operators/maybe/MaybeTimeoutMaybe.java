package io.reactivex.internal.operators.maybe;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class MaybeTimeoutMaybe extends AbstractMaybeWithUpstream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MaybeSource fallback;
    public final MaybeSource other;

    /* loaded from: classes8.dex */
    public final class TimeoutFallbackMaybeObserver extends AtomicReference implements MaybeObserver {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 8663801314800248617L;
        public transient /* synthetic */ FieldHolder $fh;
        public final MaybeObserver actual;

        public TimeoutFallbackMaybeObserver(MaybeObserver maybeObserver) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {maybeObserver};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = maybeObserver;
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.actual.onError(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, disposable) == null) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
                this.actual.onSuccess(obj);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.actual.onComplete();
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class TimeoutMainMaybeObserver extends AtomicReference implements MaybeObserver, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -5955289211445418871L;
        public transient /* synthetic */ FieldHolder $fh;
        public final MaybeObserver actual;
        public final MaybeSource fallback;
        public final TimeoutOtherMaybeObserver other;
        public final TimeoutFallbackMaybeObserver otherObserver;

        public TimeoutMainMaybeObserver(MaybeObserver maybeObserver, MaybeSource maybeSource) {
            TimeoutFallbackMaybeObserver timeoutFallbackMaybeObserver;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {maybeObserver, maybeSource};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = maybeObserver;
            this.other = new TimeoutOtherMaybeObserver(this);
            this.fallback = maybeSource;
            if (maybeSource != null) {
                timeoutFallbackMaybeObserver = new TimeoutFallbackMaybeObserver(maybeObserver);
            } else {
                timeoutFallbackMaybeObserver = null;
            }
            this.otherObserver = timeoutFallbackMaybeObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                DisposableHelper.dispose(this);
                DisposableHelper.dispose(this.other);
                TimeoutFallbackMaybeObserver timeoutFallbackMaybeObserver = this.otherObserver;
                if (timeoutFallbackMaybeObserver != null) {
                    DisposableHelper.dispose(timeoutFallbackMaybeObserver);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return DisposableHelper.isDisposed((Disposable) get());
            }
            return invokeV.booleanValue;
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                DisposableHelper.dispose(this.other);
                if (getAndSet(DisposableHelper.DISPOSED) != DisposableHelper.DISPOSED) {
                    this.actual.onComplete();
                }
            }
        }

        public void otherComplete() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && DisposableHelper.dispose(this)) {
                MaybeSource maybeSource = this.fallback;
                if (maybeSource == null) {
                    this.actual.onError(new TimeoutException());
                } else {
                    maybeSource.subscribe(this.otherObserver);
                }
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                DisposableHelper.dispose(this.other);
                if (getAndSet(DisposableHelper.DISPOSED) != DisposableHelper.DISPOSED) {
                    this.actual.onError(th);
                } else {
                    RxJavaPlugins.onError(th);
                }
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, disposable) == null) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, obj) == null) {
                DisposableHelper.dispose(this.other);
                if (getAndSet(DisposableHelper.DISPOSED) != DisposableHelper.DISPOSED) {
                    this.actual.onSuccess(obj);
                }
            }
        }

        public void otherError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048583, this, th) == null) {
                if (DisposableHelper.dispose(this)) {
                    this.actual.onError(th);
                } else {
                    RxJavaPlugins.onError(th);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public final class TimeoutOtherMaybeObserver extends AtomicReference implements MaybeObserver {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 8663801314800248617L;
        public transient /* synthetic */ FieldHolder $fh;
        public final TimeoutMainMaybeObserver parent;

        public TimeoutOtherMaybeObserver(TimeoutMainMaybeObserver timeoutMainMaybeObserver) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {timeoutMainMaybeObserver};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.parent = timeoutMainMaybeObserver;
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                this.parent.otherError(th);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, disposable) == null) {
                DisposableHelper.setOnce(this, disposable);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
                this.parent.otherComplete();
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.parent.otherComplete();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaybeTimeoutMaybe(MaybeSource maybeSource, MaybeSource maybeSource2, MaybeSource maybeSource3) {
        super(maybeSource);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {maybeSource, maybeSource2, maybeSource3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((MaybeSource) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.other = maybeSource2;
        this.fallback = maybeSource3;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver maybeObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, maybeObserver) == null) {
            TimeoutMainMaybeObserver timeoutMainMaybeObserver = new TimeoutMainMaybeObserver(maybeObserver, this.fallback);
            maybeObserver.onSubscribe(timeoutMainMaybeObserver);
            this.other.subscribe(timeoutMainMaybeObserver.other);
            this.source.subscribe(timeoutMainMaybeObserver);
        }
    }
}
