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
/* loaded from: classes8.dex */
public final class ObservableBuffer extends AbstractObservableWithUpstream {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Callable bufferSupplier;
    public final int count;
    public final int skip;

    /* loaded from: classes8.dex */
    public final class BufferExactObserver implements Observer, Disposable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer actual;
        public Collection buffer;
        public final Callable bufferSupplier;
        public final int count;
        public Disposable s;
        public int size;

        public BufferExactObserver(Observer observer, int i, Callable callable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, Integer.valueOf(i), callable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = observer;
            this.count = i;
            this.bufferSupplier = callable;
        }

        public boolean createBuffer() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    this.buffer = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "Empty buffer supplied");
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
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.s.isDisposed();
            }
            return invokeV.booleanValue;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            Collection collection;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (collection = this.buffer) != null) {
                this.buffer = null;
                if (!collection.isEmpty()) {
                    this.actual.onNext(collection);
                }
                this.actual.onComplete();
            }
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
        public void onNext(Object obj) {
            Collection collection;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, obj) == null) && (collection = this.buffer) != null) {
                collection.add(obj);
                int i = this.size + 1;
                this.size = i;
                if (i >= this.count) {
                    this.actual.onNext(collection);
                    this.size = 0;
                    createBuffer();
                }
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

    /* loaded from: classes8.dex */
    public final class BufferSkipObserver extends AtomicBoolean implements Observer, Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -8223395059921494546L;
        public transient /* synthetic */ FieldHolder $fh;
        public final Observer actual;
        public final Callable bufferSupplier;
        public final ArrayDeque buffers;
        public final int count;
        public long index;
        public Disposable s;
        public final int skip;

        public BufferSkipObserver(Observer observer, int i, int i2, Callable callable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {observer, Integer.valueOf(i), Integer.valueOf(i2), callable};
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
            this.count = i;
            this.skip = i2;
            this.bufferSupplier = callable;
            this.buffers = new ArrayDeque();
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
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.s.isDisposed();
            }
            return invokeV.booleanValue;
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

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048581, this, disposable) == null) && DisposableHelper.validate(this.s, disposable)) {
                this.s = disposable;
                this.actual.onSubscribe(this);
            }
        }

        @Override // io.reactivex.Observer
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
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
                Iterator it = this.buffers.iterator();
                while (it.hasNext()) {
                    Collection collection = (Collection) it.next();
                    collection.add(obj);
                    if (this.count <= collection.size()) {
                        it.remove();
                        this.actual.onNext(collection);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableBuffer(ObservableSource observableSource, int i, int i2, Callable callable) {
        super(observableSource);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {observableSource, Integer.valueOf(i), Integer.valueOf(i2), callable};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((ObservableSource) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.count = i;
        this.skip = i2;
        this.bufferSupplier = callable;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer observer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, observer) == null) {
            int i = this.skip;
            int i2 = this.count;
            if (i == i2) {
                BufferExactObserver bufferExactObserver = new BufferExactObserver(observer, i2, this.bufferSupplier);
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
