package io.reactivex.internal.operators.maybe;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class MaybeUsing extends Maybe {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean eager;
    public final Consumer resourceDisposer;
    public final Callable resourceSupplier;
    public final Function sourceSupplier;

    /* loaded from: classes8.dex */
    public final class UsingObserver extends AtomicReference implements MaybeObserver, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -674404550052917487L;
        public transient /* synthetic */ FieldHolder $fh;
        public final MaybeObserver actual;
        public Disposable d;
        public final Consumer disposer;
        public final boolean eager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UsingObserver(MaybeObserver maybeObserver, Object obj, Consumer consumer, boolean z) {
            super(obj);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {maybeObserver, obj, consumer, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = maybeObserver;
            this.disposer = consumer;
            this.eager = z;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.dispose();
                this.d = DisposableHelper.DISPOSED;
                disposeResourceAfter();
            }
        }

        public void disposeResourceAfter() {
            Object andSet;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (andSet = getAndSet(this)) != this) {
                try {
                    this.disposer.accept(andSet);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    RxJavaPlugins.onError(th);
                }
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.d.isDisposed();
            }
            return invokeV.booleanValue;
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.d = DisposableHelper.DISPOSED;
                if (this.eager) {
                    Object andSet = getAndSet(this);
                    if (andSet != this) {
                        try {
                            this.disposer.accept(andSet);
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.actual.onError(th);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                this.actual.onComplete();
                if (!this.eager) {
                    disposeResourceAfter();
                }
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, th) == null) {
                this.d = DisposableHelper.DISPOSED;
                if (this.eager) {
                    Object andSet = getAndSet(this);
                    if (andSet != this) {
                        try {
                            this.disposer.accept(andSet);
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            th = new CompositeException(th, th2);
                        }
                    } else {
                        return;
                    }
                }
                this.actual.onError(th);
                if (!this.eager) {
                    disposeResourceAfter();
                }
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
                this.d = DisposableHelper.DISPOSED;
                if (this.eager) {
                    Object andSet = getAndSet(this);
                    if (andSet != this) {
                        try {
                            this.disposer.accept(andSet);
                        } catch (Throwable th) {
                            Exceptions.throwIfFatal(th);
                            this.actual.onError(th);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                this.actual.onSuccess(obj);
                if (!this.eager) {
                    disposeResourceAfter();
                }
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, disposable) == null) && DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                this.actual.onSubscribe(this);
            }
        }
    }

    public MaybeUsing(Callable callable, Function function, Consumer consumer, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callable, function, consumer, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.resourceSupplier = callable;
        this.sourceSupplier = function;
        this.resourceDisposer = consumer;
        this.eager = z;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver maybeObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, maybeObserver) == null) {
            try {
                Object call = this.resourceSupplier.call();
                try {
                    ((MaybeSource) ObjectHelper.requireNonNull(this.sourceSupplier.apply(call), "The sourceSupplier returned a null MaybeSource")).subscribe(new UsingObserver(maybeObserver, call, this.resourceDisposer, this.eager));
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    if (this.eager) {
                        try {
                            this.resourceDisposer.accept(call);
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            EmptyDisposable.error(new CompositeException(th, th2), maybeObserver);
                            return;
                        }
                    }
                    EmptyDisposable.error(th, maybeObserver);
                    if (!this.eager) {
                        try {
                            this.resourceDisposer.accept(call);
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            RxJavaPlugins.onError(th3);
                        }
                    }
                }
            } catch (Throwable th4) {
                Exceptions.throwIfFatal(th4);
                EmptyDisposable.error(th4, maybeObserver);
            }
        }
    }
}
