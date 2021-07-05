package io.reactivex.internal.operators.observable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes10.dex */
public final class ObservableBuffer<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Callable<U> bufferSupplier;
    public final int count;
    public final int skip;

    /* loaded from: classes10.dex */
    public static final class BufferExactObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer<? super U> actual;
        public U buffer;
        public final Callable<U> bufferSupplier;
        public final int count;
        public Disposable s;
        public int size;

        public BufferExactObserver(Observer<? super U> observer, int i2, Callable<U> callable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, Integer.valueOf(i2), callable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = observer;
            this.count = i2;
            this.bufferSupplier = callable;
        }

        public boolean createBuffer() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    this.buffer = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "Empty buffer supplied");
                    return true;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.buffer = null;
                    Disposable disposable = this.s;
                    if (disposable == null) {
                        EmptyDisposable.error(th, this.actual);
                        return false;
                    }
                    disposable.dispose();
                    this.actual.onError(th);
                    return false;
                }
            }
            return invokeV.booleanValue;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.s.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.s.isDisposed() : invokeV.booleanValue;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            U u;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (u = this.buffer) == null) {
                return;
            }
            this.buffer = null;
            if (!u.isEmpty()) {
                this.actual.onNext(u);
            }
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, th) == null) {
                this.buffer = null;
                this.actual.onError(th);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            U u;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, t) == null) || (u = this.buffer) == null) {
                return;
            }
            u.add(t);
            int i2 = this.size + 1;
            this.size = i2;
            if (i2 >= this.count) {
                this.actual.onNext(u);
                this.size = 0;
                createBuffer();
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048582, this, disposable) == null) && DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                this.actual.onSubscribe(this);
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class BufferSkipObserver<T, U extends Collection<? super T>> extends AtomicBoolean implements Observer<T>, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -8223395059921494546L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer<? super U> actual;
        public final Callable<U> bufferSupplier;
        public final ArrayDeque<U> buffers;
        public final int count;
        public long index;
        public Disposable s;
        public final int skip;

        public BufferSkipObserver(Observer<? super U> observer, int i2, int i3, Callable<U> callable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, Integer.valueOf(i2), Integer.valueOf(i3), callable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = observer;
            this.count = i2;
            this.skip = i3;
            this.bufferSupplier = callable;
            this.buffers = new ArrayDeque<>();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.s.dispose();
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.s.isDisposed() : invokeV.booleanValue;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                while (!this.buffers.isEmpty()) {
                    this.actual.onNext(this.buffers.poll());
                }
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, th) == null) {
                this.buffers.clear();
                this.actual.onError(th);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: java.util.ArrayDeque<U extends java.util.Collection<? super T>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.Observer
        public void onNext(T t) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, t) == null) {
                long j = this.index;
                this.index = 1 + j;
                if (j % this.skip == 0) {
                    try {
                        this.buffers.offer((Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources."));
                    } catch (Throwable th) {
                        this.buffers.clear();
                        this.s.dispose();
                        this.actual.onError(th);
                        return;
                    }
                }
                Iterator<U> it = this.buffers.iterator();
                while (it.hasNext()) {
                    U next = it.next();
                    next.add(t);
                    if (this.count <= next.size()) {
                        it.remove();
                        this.actual.onNext(next);
                    }
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, disposable) == null) && DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                this.actual.onSubscribe(this);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableBuffer(ObservableSource<T> observableSource, int i2, int i3, Callable<U> callable) {
        super(observableSource);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observableSource, Integer.valueOf(i2), Integer.valueOf(i3), callable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                super((ObservableSource) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.count = i2;
        this.skip = i3;
        this.bufferSupplier = callable;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super U> observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
            int i2 = this.skip;
            int i3 = this.count;
            if (i2 == i3) {
                BufferExactObserver bufferExactObserver = new BufferExactObserver(observer, i3, this.bufferSupplier);
                if (bufferExactObserver.createBuffer()) {
                    this.source.subscribe(bufferExactObserver);
                    return;
                }
                return;
            }
            this.source.subscribe(new BufferSkipObserver(observer, this.count, this.skip, this.bufferSupplier));
        }
    }
}
