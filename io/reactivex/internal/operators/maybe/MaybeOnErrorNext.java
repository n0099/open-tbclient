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
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class MaybeOnErrorNext extends AbstractMaybeWithUpstream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean allowFatal;
    public final Function resumeFunction;

    /* loaded from: classes8.dex */
    public final class OnErrorNextMaybeObserver extends AtomicReference implements MaybeObserver, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 2026620218879969836L;
        public transient /* synthetic */ FieldHolder $fh;
        public final MaybeObserver actual;
        public final boolean allowFatal;
        public final Function resumeFunction;

        /* loaded from: classes8.dex */
        public final class NextMaybeObserver implements MaybeObserver {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final MaybeObserver actual;
            public final AtomicReference d;

            public NextMaybeObserver(MaybeObserver maybeObserver, AtomicReference atomicReference) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {maybeObserver, atomicReference};
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
                this.d = atomicReference;
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.actual.onComplete();
                }
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
                    DisposableHelper.setOnce(this.d, disposable);
                }
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(Object obj) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
                    this.actual.onSuccess(obj);
                }
            }
        }

        public OnErrorNextMaybeObserver(MaybeObserver maybeObserver, Function function, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {maybeObserver, function, Boolean.valueOf(z)};
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
            this.resumeFunction = function;
            this.allowFatal = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                DisposableHelper.dispose(this);
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
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                if (!this.allowFatal && !(th instanceof Exception)) {
                    this.actual.onError(th);
                    return;
                }
                try {
                    MaybeSource maybeSource = (MaybeSource) ObjectHelper.requireNonNull(this.resumeFunction.apply(th), "The resumeFunction returned a null MaybeSource");
                    DisposableHelper.replace(this, null);
                    maybeSource.subscribe(new NextMaybeObserver(this.actual, this));
                } catch (Throwable th2) {
                    Exceptions.throwIfFatal(th2);
                    this.actual.onError(new CompositeException(th, th2));
                }
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, disposable) == null) && DisposableHelper.setOnce(this, disposable)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, obj) == null) {
                this.actual.onSuccess(obj);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaybeOnErrorNext(MaybeSource maybeSource, Function function, boolean z) {
        super(maybeSource);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {maybeSource, function, Boolean.valueOf(z)};
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
        this.resumeFunction = function;
        this.allowFatal = z;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver maybeObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, maybeObserver) == null) {
            this.source.subscribe(new OnErrorNextMaybeObserver(maybeObserver, this.resumeFunction, this.allowFatal));
        }
    }
}
