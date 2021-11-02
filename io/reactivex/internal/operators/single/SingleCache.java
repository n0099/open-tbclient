package io.reactivex.internal.operators.single;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes3.dex */
public final class SingleCache<T> extends Single<T> implements SingleObserver<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final CacheDisposable[] EMPTY;
    public static final CacheDisposable[] TERMINATED;
    public transient /* synthetic */ FieldHolder $fh;
    public Throwable error;
    public final AtomicReference<CacheDisposable<T>[]> observers;
    public final SingleSource<? extends T> source;
    public T value;
    public final AtomicInteger wip;

    /* loaded from: classes3.dex */
    public static final class CacheDisposable<T> extends AtomicBoolean implements Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 7514387411091976596L;
        public transient /* synthetic */ FieldHolder $fh;
        public final SingleObserver<? super T> actual;
        public final SingleCache<T> parent;

        public CacheDisposable(SingleObserver<? super T> singleObserver, SingleCache<T> singleCache) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleObserver, singleCache};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.actual = singleObserver;
            this.parent = singleCache;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && compareAndSet(false, true)) {
                this.parent.remove(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? get() : invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1878560195, "Lio/reactivex/internal/operators/single/SingleCache;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1878560195, "Lio/reactivex/internal/operators/single/SingleCache;");
                return;
            }
        }
        EMPTY = new CacheDisposable[0];
        TERMINATED = new CacheDisposable[0];
    }

    public SingleCache(SingleSource<? extends T> singleSource) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {singleSource};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.source = singleSource;
        this.wip = new AtomicInteger();
        this.observers = new AtomicReference<>(EMPTY);
    }

    public boolean add(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable<T>[] cacheDisposableArr2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cacheDisposable)) == null) {
            do {
                cacheDisposableArr = this.observers.get();
                if (cacheDisposableArr == TERMINATED) {
                    return false;
                }
                int length = cacheDisposableArr.length;
                cacheDisposableArr2 = new CacheDisposable[length + 1];
                System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
                cacheDisposableArr2[length] = cacheDisposable;
            } while (!this.observers.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable th) {
        CacheDisposable<T>[] andSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
            this.error = th;
            for (CacheDisposable<T> cacheDisposable : this.observers.getAndSet(TERMINATED)) {
                if (!cacheDisposable.isDisposed()) {
                    cacheDisposable.actual.onError(th);
                }
            }
        }
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable disposable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, disposable) == null) {
        }
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T t) {
        CacheDisposable<T>[] andSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, t) == null) {
            this.value = t;
            for (CacheDisposable<T> cacheDisposable : this.observers.getAndSet(TERMINATED)) {
                if (!cacheDisposable.isDisposed()) {
                    cacheDisposable.actual.onSuccess(t);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: java.util.concurrent.atomic.AtomicReference<io.reactivex.internal.operators.single.SingleCache$CacheDisposable<T>[]> */
    /* JADX WARN: Multi-variable type inference failed */
    public void remove(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cacheDisposable) == null) {
            do {
                cacheDisposableArr = this.observers.get();
                int length = cacheDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (cacheDisposableArr[i3] == cacheDisposable) {
                        i2 = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    cacheDisposableArr2 = EMPTY;
                } else {
                    CacheDisposable[] cacheDisposableArr3 = new CacheDisposable[length - 1];
                    System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i2);
                    System.arraycopy(cacheDisposableArr, i2 + 1, cacheDisposableArr3, i2, (length - i2) - 1);
                    cacheDisposableArr2 = cacheDisposableArr3;
                }
            } while (!this.observers.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
        }
    }

    /* JADX DEBUG: Type inference failed for r0v4. Raw type applied. Possible types: T, ? super T */
    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver<? super T> singleObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, singleObserver) == null) {
            CacheDisposable<T> cacheDisposable = new CacheDisposable<>(singleObserver, this);
            singleObserver.onSubscribe(cacheDisposable);
            if (add(cacheDisposable)) {
                if (cacheDisposable.isDisposed()) {
                    remove(cacheDisposable);
                }
                if (this.wip.getAndIncrement() == 0) {
                    this.source.subscribe(this);
                    return;
                }
                return;
            }
            Throwable th = this.error;
            if (th != null) {
                singleObserver.onError(th);
            } else {
                singleObserver.onSuccess((T) this.value);
            }
        }
    }
}
