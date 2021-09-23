package io.reactivex.internal.operators.completable;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
@Experimental
/* loaded from: classes10.dex */
public final class CompletableCache extends Completable implements CompletableObserver {
    public static /* synthetic */ Interceptable $ic;
    public static final InnerCompletableCache[] EMPTY;
    public static final InnerCompletableCache[] TERMINATED;
    public transient /* synthetic */ FieldHolder $fh;
    public Throwable error;
    public final AtomicReference<InnerCompletableCache[]> observers;
    public final AtomicBoolean once;
    public final CompletableSource source;

    /* loaded from: classes10.dex */
    public final class InnerCompletableCache extends AtomicBoolean implements Disposable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 8943152917179642732L;
        public transient /* synthetic */ FieldHolder $fh;
        public final CompletableObserver actual;
        public final /* synthetic */ CompletableCache this$0;

        public InnerCompletableCache(CompletableCache completableCache, CompletableObserver completableObserver) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {completableCache, completableObserver};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = completableCache;
            this.actual = completableObserver;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && compareAndSet(false, true)) {
                this.this$0.remove(this);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-54833967, "Lio/reactivex/internal/operators/completable/CompletableCache;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-54833967, "Lio/reactivex/internal/operators/completable/CompletableCache;");
                return;
            }
        }
        EMPTY = new InnerCompletableCache[0];
        TERMINATED = new InnerCompletableCache[0];
    }

    public CompletableCache(CompletableSource completableSource) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {completableSource};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.source = completableSource;
        this.observers = new AtomicReference<>(EMPTY);
        this.once = new AtomicBoolean();
    }

    public boolean add(InnerCompletableCache innerCompletableCache) {
        InnerCompletableCache[] innerCompletableCacheArr;
        InnerCompletableCache[] innerCompletableCacheArr2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, innerCompletableCache)) == null) {
            do {
                innerCompletableCacheArr = this.observers.get();
                if (innerCompletableCacheArr == TERMINATED) {
                    return false;
                }
                int length = innerCompletableCacheArr.length;
                innerCompletableCacheArr2 = new InnerCompletableCache[length + 1];
                System.arraycopy(innerCompletableCacheArr, 0, innerCompletableCacheArr2, 0, length);
                innerCompletableCacheArr2[length] = innerCompletableCache;
            } while (!this.observers.compareAndSet(innerCompletableCacheArr, innerCompletableCacheArr2));
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onComplete() {
        InnerCompletableCache[] andSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (InnerCompletableCache innerCompletableCache : this.observers.getAndSet(TERMINATED)) {
                if (!innerCompletableCache.get()) {
                    innerCompletableCache.actual.onComplete();
                }
            }
        }
    }

    @Override // io.reactivex.CompletableObserver
    public void onError(Throwable th) {
        InnerCompletableCache[] andSet;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, th) == null) {
            this.error = th;
            for (InnerCompletableCache innerCompletableCache : this.observers.getAndSet(TERMINATED)) {
                if (!innerCompletableCache.get()) {
                    innerCompletableCache.actual.onError(th);
                }
            }
        }
    }

    @Override // io.reactivex.CompletableObserver
    public void onSubscribe(Disposable disposable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, disposable) == null) {
        }
    }

    public void remove(InnerCompletableCache innerCompletableCache) {
        InnerCompletableCache[] innerCompletableCacheArr;
        InnerCompletableCache[] innerCompletableCacheArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, innerCompletableCache) == null) {
            do {
                innerCompletableCacheArr = this.observers.get();
                int length = innerCompletableCacheArr.length;
                if (length == 0) {
                    return;
                }
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (innerCompletableCacheArr[i3] == innerCompletableCache) {
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
                    innerCompletableCacheArr2 = EMPTY;
                } else {
                    InnerCompletableCache[] innerCompletableCacheArr3 = new InnerCompletableCache[length - 1];
                    System.arraycopy(innerCompletableCacheArr, 0, innerCompletableCacheArr3, 0, i2);
                    System.arraycopy(innerCompletableCacheArr, i2 + 1, innerCompletableCacheArr3, i2, (length - i2) - 1);
                    innerCompletableCacheArr2 = innerCompletableCacheArr3;
                }
            } while (!this.observers.compareAndSet(innerCompletableCacheArr, innerCompletableCacheArr2));
        }
    }

    @Override // io.reactivex.Completable
    public void subscribeActual(CompletableObserver completableObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, completableObserver) == null) {
            InnerCompletableCache innerCompletableCache = new InnerCompletableCache(this, completableObserver);
            completableObserver.onSubscribe(innerCompletableCache);
            if (add(innerCompletableCache)) {
                if (innerCompletableCache.isDisposed()) {
                    remove(innerCompletableCache);
                }
                if (this.once.compareAndSet(false, true)) {
                    this.source.subscribe(this);
                    return;
                }
                return;
            }
            Throwable th = this.error;
            if (th != null) {
                completableObserver.onError(th);
            } else {
                completableObserver.onComplete();
            }
        }
    }
}
