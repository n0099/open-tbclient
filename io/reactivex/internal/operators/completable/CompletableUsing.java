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
/* loaded from: classes9.dex */
public final class CompletableUsing<R> extends Completable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Function<? super R, ? extends CompletableSource> completableFunction;
    public final Consumer<? super R> disposer;
    public final boolean eager;
    public final Callable<R> resourceSupplier;

    /* loaded from: classes9.dex */
    public static final class UsingObserver<R> extends AtomicReference<Object> implements CompletableObserver, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -674404550052917487L;
        public transient /* synthetic */ FieldHolder $fh;
        public final CompletableObserver actual;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f73457d;
        public final Consumer<? super R> disposer;
        public final boolean eager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UsingObserver(CompletableObserver completableObserver, R r, Consumer<? super R> consumer, boolean z) {
            super(r);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {completableObserver, r, consumer, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                this.f73457d.dispose();
                this.f73457d = DisposableHelper.DISPOSED;
                disposeResourceAfter();
            }
        }

        public void disposeResourceAfter() {
            Object andSet;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (andSet = getAndSet(this)) == this) {
                return;
            }
            try {
                this.disposer.accept(andSet);
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                RxJavaPlugins.onError(th);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f73457d.isDisposed() : invokeV.booleanValue;
        }

        @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f73457d = DisposableHelper.DISPOSED;
                if (this.eager) {
                    Object andSet = getAndSet(this);
                    if (andSet == this) {
                        return;
                    }
                    try {
                        this.disposer.accept(andSet);
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        this.actual.onError(th);
                        return;
                    }
                }
                this.actual.onComplete();
                if (this.eager) {
                    return;
                }
                disposeResourceAfter();
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, th) == null) {
                this.f73457d = DisposableHelper.DISPOSED;
                if (this.eager) {
                    Object andSet = getAndSet(this);
                    if (andSet == this) {
                        return;
                    }
                    try {
                        this.disposer.accept(andSet);
                    } catch (Throwable th2) {
                        Exceptions.throwIfFatal(th2);
                        th = new CompositeException(th, th2);
                    }
                }
                this.actual.onError(th);
                if (this.eager) {
                    return;
                }
                disposeResourceAfter();
            }
        }

        @Override // io.reactivex.CompletableObserver
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, disposable) == null) && DisposableHelper.validate(this.f73457d, disposable)) {
                this.f73457d = disposable;
                this.actual.onSubscribe(this);
            }
        }
    }

    public CompletableUsing(Callable<R> callable, Function<? super R, ? extends CompletableSource> function, Consumer<? super R> consumer, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callable, function, consumer, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
                R call = this.resourceSupplier.call();
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
                    if (this.eager) {
                        return;
                    }
                    try {
                        this.disposer.accept(call);
                    } catch (Throwable th3) {
                        Exceptions.throwIfFatal(th3);
                        RxJavaPlugins.onError(th3);
                    }
                }
            } catch (Throwable th4) {
                Exceptions.throwIfFatal(th4);
                EmptyDisposable.error(th4, completableObserver);
            }
        }
    }
}
