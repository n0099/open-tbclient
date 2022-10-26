package io.reactivex.internal.operators.maybe;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class MaybeCache extends Maybe implements MaybeObserver {
    public static /* synthetic */ Interceptable $ic;
    public static final CacheDisposable[] EMPTY;
    public static final CacheDisposable[] TERMINATED;
    public transient /* synthetic */ FieldHolder $fh;
    public Throwable error;
    public final AtomicReference observers;
    public final AtomicReference source;
    public Object value;

    @Override // io.reactivex.MaybeObserver
    public void onSubscribe(Disposable disposable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, disposable) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public final class CacheDisposable extends AtomicReference implements Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -5791853038359966195L;
        public transient /* synthetic */ FieldHolder $fh;
        public final MaybeObserver actual;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CacheDisposable(MaybeObserver maybeObserver, MaybeCache maybeCache) {
            super(maybeCache);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {maybeObserver, maybeCache};
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
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            MaybeCache maybeCache;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (maybeCache = (MaybeCache) getAndSet(null)) != null) {
                maybeCache.remove(this);
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (get() == null) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1125124395, "Lio/reactivex/internal/operators/maybe/MaybeCache;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1125124395, "Lio/reactivex/internal/operators/maybe/MaybeCache;");
                return;
            }
        }
        EMPTY = new CacheDisposable[0];
        TERMINATED = new CacheDisposable[0];
    }

    @Override // io.reactivex.MaybeObserver
    public void onComplete() {
        CacheDisposable[] cacheDisposableArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.observers.getAndSet(TERMINATED)) {
                if (!cacheDisposable.isDisposed()) {
                    cacheDisposable.actual.onComplete();
                }
            }
        }
    }

    public MaybeCache(MaybeSource maybeSource) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {maybeSource};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.source = new AtomicReference(maybeSource);
        this.observers = new AtomicReference(EMPTY);
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

    @Override // io.reactivex.MaybeObserver
    public void onError(Throwable th) {
        CacheDisposable[] cacheDisposableArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
            this.error = th;
            for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.observers.getAndSet(TERMINATED)) {
                if (!cacheDisposable.isDisposed()) {
                    cacheDisposable.actual.onError(th);
                }
            }
        }
    }

    @Override // io.reactivex.MaybeObserver
    public void onSuccess(Object obj) {
        CacheDisposable[] cacheDisposableArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, obj) == null) {
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
        if (interceptable == null || interceptable.invokeL(1048581, this, cacheDisposable) == null) {
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

    @Override // io.reactivex.Maybe
    public void subscribeActual(MaybeObserver maybeObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, maybeObserver) == null) {
            CacheDisposable cacheDisposable = new CacheDisposable(maybeObserver, this);
            maybeObserver.onSubscribe(cacheDisposable);
            if (add(cacheDisposable)) {
                if (cacheDisposable.isDisposed()) {
                    remove(cacheDisposable);
                    return;
                }
                MaybeSource maybeSource = (MaybeSource) this.source.getAndSet(null);
                if (maybeSource != null) {
                    maybeSource.subscribe(this);
                }
            } else if (!cacheDisposable.isDisposed()) {
                Throwable th = this.error;
                if (th != null) {
                    maybeObserver.onError(th);
                    return;
                }
                Object obj = this.value;
                if (obj != null) {
                    maybeObserver.onSuccess(obj);
                } else {
                    maybeObserver.onComplete();
                }
            }
        }
    }
}
