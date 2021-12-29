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
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public final class MaybeFlatMapNotification<T, R> extends AbstractMaybeWithUpstream<T, R> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Callable<? extends MaybeSource<? extends R>> onCompleteSupplier;
    public final Function<? super Throwable, ? extends MaybeSource<? extends R>> onErrorMapper;
    public final Function<? super T, ? extends MaybeSource<? extends R>> onSuccessMapper;

    /* loaded from: classes4.dex */
    public static final class FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 4375739915521278546L;
        public transient /* synthetic */ FieldHolder $fh;
        public final MaybeObserver<? super R> actual;

        /* renamed from: d  reason: collision with root package name */
        public Disposable f64561d;
        public final Callable<? extends MaybeSource<? extends R>> onCompleteSupplier;
        public final Function<? super Throwable, ? extends MaybeSource<? extends R>> onErrorMapper;
        public final Function<? super T, ? extends MaybeSource<? extends R>> onSuccessMapper;

        /* loaded from: classes4.dex */
        public final class InnerObserver implements MaybeObserver<R> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ FlatMapMaybeObserver this$0;

            public InnerObserver(FlatMapMaybeObserver flatMapMaybeObserver) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {flatMapMaybeObserver};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = flatMapMaybeObserver;
            }

            @Override // io.reactivex.MaybeObserver
            public void onComplete() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.this$0.actual.onComplete();
                }
            }

            @Override // io.reactivex.MaybeObserver
            public void onError(Throwable th) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                    this.this$0.actual.onError(th);
                }
            }

            @Override // io.reactivex.MaybeObserver
            public void onSubscribe(Disposable disposable) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, disposable) == null) {
                    DisposableHelper.setOnce(this.this$0, disposable);
                }
            }

            @Override // io.reactivex.MaybeObserver
            public void onSuccess(R r) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048579, this, r) == null) {
                    this.this$0.actual.onSuccess(r);
                }
            }
        }

        public FlatMapMaybeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends MaybeSource<? extends R>> function, Function<? super Throwable, ? extends MaybeSource<? extends R>> function2, Callable<? extends MaybeSource<? extends R>> callable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {maybeObserver, function, function2, callable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = maybeObserver;
            this.onSuccessMapper = function;
            this.onErrorMapper = function2;
            this.onCompleteSupplier = callable;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                DisposableHelper.dispose(this);
                this.f64561d.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? DisposableHelper.isDisposed(get()) : invokeV.booleanValue;
        }

        @Override // io.reactivex.MaybeObserver
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    ((MaybeSource) ObjectHelper.requireNonNull(this.onCompleteSupplier.call(), "The onCompleteSupplier returned a null MaybeSource")).subscribe(new InnerObserver(this));
                } catch (Exception e2) {
                    Exceptions.throwIfFatal(e2);
                    this.actual.onError(e2);
                }
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                try {
                    ((MaybeSource) ObjectHelper.requireNonNull(this.onErrorMapper.apply(th), "The onErrorMapper returned a null MaybeSource")).subscribe(new InnerObserver(this));
                } catch (Exception e2) {
                    Exceptions.throwIfFatal(e2);
                    this.actual.onError(new CompositeException(th, e2));
                }
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048580, this, disposable) == null) && DisposableHelper.validate(this.f64561d, disposable)) {
                this.f64561d = disposable;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.MaybeObserver
        public void onSuccess(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, t) == null) {
                try {
                    ((MaybeSource) ObjectHelper.requireNonNull(this.onSuccessMapper.apply(t), "The onSuccessMapper returned a null MaybeSource")).subscribe(new InnerObserver(this));
                } catch (Exception e2) {
                    Exceptions.throwIfFatal(e2);
                    this.actual.onError(e2);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaybeFlatMapNotification(MaybeSource<T> maybeSource, Function<? super T, ? extends MaybeSource<? extends R>> function, Function<? super Throwable, ? extends MaybeSource<? extends R>> function2, Callable<? extends MaybeSource<? extends R>> callable) {
        super(maybeSource);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {maybeSource, function, function2, callable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((MaybeSource) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.onSuccessMapper = function;
        this.onErrorMapper = function2;
        this.onCompleteSupplier = callable;
    }

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver<? super R> maybeObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, maybeObserver) == null) {
            this.source.subscribe(new FlatMapMaybeObserver(maybeObserver, this.onSuccessMapper, this.onErrorMapper, this.onCompleteSupplier));
        }
    }
}
