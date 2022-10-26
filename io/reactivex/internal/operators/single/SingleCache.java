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
/* loaded from: classes8.dex */
public final class SingleCache extends Single implements SingleObserver {
    public static /* synthetic */ Interceptable $ic;
    public static final CacheDisposable[] EMPTY;
    public static final CacheDisposable[] TERMINATED;
    public transient /* synthetic */ FieldHolder $fh;
    public Throwable error;
    public final AtomicReference observers;
    public final SingleSource source;
    public Object value;
    public final AtomicInteger wip;

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable disposable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, disposable) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public final class CacheDisposable extends AtomicBoolean implements Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 7514387411091976596L;
        public transient /* synthetic */ FieldHolder $fh;
        public final SingleObserver actual;
        public final SingleCache parent;

        public CacheDisposable(SingleObserver singleObserver, SingleCache singleCache) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {singleObserver, singleCache};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return get();
            }
            return invokeV.booleanValue;
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

    public SingleCache(SingleSource singleSource) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {singleSource};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.source = singleSource;
        this.wip = new AtomicInteger();
        this.observers = new AtomicReference(EMPTY);
    }

    @Override // io.reactivex.Single
    public void subscribeActual(SingleObserver singleObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, singleObserver) == null) {
            CacheDisposable cacheDisposable = new CacheDisposable(singleObserver, this);
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
                singleObserver.onSuccess(this.value);
            }
        }
    }

    public boolean add(CacheDisposable cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cacheDisposable)) == null) {
            do {
                cacheDisposableArr = (CacheDisposable[]) this.observers.get();
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
        CacheDisposable[] cacheDisposableArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
            this.error = th;
            for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.observers.getAndSet(TERMINATED)) {
                if (!cacheDisposable.isDisposed()) {
                    cacheDisposable.actual.onError(th);
                }
            }
        }
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(Object obj) {
        CacheDisposable[] cacheDisposableArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, obj) == null) {
            this.value = obj;
            for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.observers.getAndSet(TERMINATED)) {
                if (!cacheDisposable.isDisposed()) {
                    cacheDisposable.actual.onSuccess(obj);
                }
            }
        }
    }

    public void remove(CacheDisposable cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cacheDisposable) == null) {
            do {
                cacheDisposableArr = (CacheDisposable[]) this.observers.get();
                int length = cacheDisposableArr.length;
                if (length == 0) {
                    return;
                }
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (cacheDisposableArr[i2] == cacheDisposable) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    cacheDisposableArr2 = EMPTY;
                } else {
                    CacheDisposable[] cacheDisposableArr3 = new CacheDisposable[length - 1];
                    System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i);
                    System.arraycopy(cacheDisposableArr, i + 1, cacheDisposableArr3, i, (length - i) - 1);
                    cacheDisposableArr2 = cacheDisposableArr3;
                }
            } while (!this.observers.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
        }
    }
}
