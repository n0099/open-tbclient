package io.reactivex.internal.operators.completable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
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
public final class CompletableUsing extends Completable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Function completableFunction;
    public final Consumer disposer;
    public final boolean eager;
    public final Callable resourceSupplier;

    /* loaded from: classes8.dex */
    public final class UsingObserver extends AtomicReference implements CompletableObserver, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -674404550052917487L;
        public transient /* synthetic */ FieldHolder $fh;
        public final CompletableObserver actual;
        public Disposable d;
        public final Consumer disposer;
        public final boolean eager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UsingObserver(CompletableObserver completableObserver, Object obj, Consumer consumer, boolean z) {
            super(obj);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {completableObserver, obj, consumer, Boolean.valueOf(z)};
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
            this.actual = completableObserver;
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

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
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

        @Override // io.reactivex.CompletableObserver
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

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, disposable) == null) && DisposableHelper.validate(this.d, disposable)) {
                this.d = disposable;
                this.actual.onSubscribe(this);
            }
        }
    }

    public CompletableUsing(Callable callable, Function function, Consumer consumer, boolean z) {
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
        this.completableFunction = function;
        this.disposer = consumer;
        this.eager = z;
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, completableObserver) == null) {
            try {
                Object call = this.resourceSupplier.call();
                try {
                    ((CompletableSource) ObjectHelper.requireNonNull(this.completableFunction.apply(call), "The completableFunction returned a null CompletableSource")).subscribe(new UsingObserver(completableObserver, call, this.disposer, this.eager));
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    if (this.eager) {
                        try {
                            this.disposer.accept(call);
                        } catch (Throwable th2) {
                            Exceptions.throwIfFatal(th2);
                            EmptyDisposable.error(new CompositeException(th, th2), completableObserver);
                            return;
                        }
                    }
                    EmptyDisposable.error(th, completableObserver);
                    if (!this.eager) {
                        try {
                            this.disposer.accept(call);
                        } catch (Throwable th3) {
                            Exceptions.throwIfFatal(th3);
                            RxJavaPlugins.onError(th3);
                        }
                    }
                }
            } catch (Throwable th4) {
                Exceptions.throwIfFatal(th4);
                EmptyDisposable.error(th4, completableObserver);
            }
        }
    }
}
