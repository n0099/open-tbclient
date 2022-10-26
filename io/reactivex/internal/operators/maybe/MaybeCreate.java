package io.reactivex.internal.operators.maybe;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class MaybeCreate extends Maybe {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MaybeOnSubscribe source;

    /* loaded from: classes8.dex */
    public final class Emitter extends AtomicReference implements MaybeEmitter, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -2467358622224974244L;
        public transient /* synthetic */ FieldHolder $fh;
        public final MaybeObserver actual;

        public Emitter(MaybeObserver maybeObserver) {
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

        @Override // io.reactivex.MaybeEmitter
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, th) == null) && !tryOnError(th)) {
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.MaybeEmitter
        public void setCancellable(Cancellable cancellable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, cancellable) == null) {
                setDisposable(new CancellableDisposable(cancellable));
            }
        }

        @Override // io.reactivex.MaybeEmitter
        public void setDisposable(Disposable disposable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, disposable) == null) {
                DisposableHelper.set(this, disposable);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                DisposableHelper.dispose(this);
            }
        }

        @Override // io.reactivex.MaybeEmitter, io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return DisposableHelper.isDisposed((Disposable) get());
            }
            return invokeV.booleanValue;
        }

        @Override // io.reactivex.MaybeEmitter
        public void onComplete() {
            Disposable disposable;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                Object obj = get();
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                if (obj != disposableHelper && (disposable = (Disposable) getAndSet(disposableHelper)) != DisposableHelper.DISPOSED) {
                    try {
                        this.actual.onComplete();
                    } finally {
                        if (disposable != null) {
                            disposable.dispose();
                        }
                    }
                }
            }
        }

        @Override // io.reactivex.MaybeEmitter
        public void onSuccess(Object obj) {
            Disposable disposable;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
                Object obj2 = get();
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                if (obj2 != disposableHelper && (disposable = (Disposable) getAndSet(disposableHelper)) != DisposableHelper.DISPOSED) {
                    try {
                        if (obj == null) {
                            this.actual.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));
                        } else {
                            this.actual.onSuccess(obj);
                        }
                        if (disposable != null) {
                            disposable.dispose();
                        }
                    } catch (Throwable th) {
                        if (disposable != null) {
                            disposable.dispose();
                        }
                        throw th;
                    }
                }
            }
        }

        @Override // io.reactivex.MaybeEmitter
        public boolean tryOnError(Throwable th) {
            InterceptResult invokeL;
            Disposable disposable;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, th)) == null) {
                if (th == null) {
                    th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
                }
                Object obj = get();
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                if (obj != disposableHelper && (disposable = (Disposable) getAndSet(disposableHelper)) != DisposableHelper.DISPOSED) {
                    try {
                        this.actual.onError(th);
                    } finally {
                        if (disposable != null) {
                            disposable.dispose();
                        }
                    }
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    public MaybeCreate(MaybeOnSubscribe maybeOnSubscribe) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {maybeOnSubscribe};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.source = maybeOnSubscribe;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver maybeObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, maybeObserver) == null) {
            Emitter emitter = new Emitter(maybeObserver);
            maybeObserver.onSubscribe(emitter);
            try {
                this.source.subscribe(emitter);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                emitter.onError(th);
            }
        }
    }
}
