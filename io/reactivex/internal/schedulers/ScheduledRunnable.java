package io.reactivex.internal.schedulers;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes2.dex */
public final class ScheduledRunnable extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, Disposable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Object ASYNC_DISPOSED;
    public static final Object DONE;
    public static final int FUTURE_INDEX = 1;
    public static final Object PARENT_DISPOSED;
    public static final int PARENT_INDEX = 0;
    public static final Object SYNC_DISPOSED;
    public static final int THREAD_INDEX = 2;
    public static final long serialVersionUID = -6120223772001106981L;
    public transient /* synthetic */ FieldHolder $fh;
    public final Runnable actual;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(137979043, "Lio/reactivex/internal/schedulers/ScheduledRunnable;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(137979043, "Lio/reactivex/internal/schedulers/ScheduledRunnable;");
                return;
            }
        }
        PARENT_DISPOSED = new Object();
        SYNC_DISPOSED = new Object();
        ASYNC_DISPOSED = new Object();
        DONE = new Object();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScheduledRunnable(Runnable runnable, DisposableContainer disposableContainer) {
        super(3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {runnable, disposableContainer};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.actual = runnable;
        lazySet(0, disposableContainer);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            run();
            return null;
        }
        return invokeV.objValue;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Object obj;
        Object obj2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            while (true) {
                Object obj3 = get(1);
                if (obj3 == DONE || obj3 == SYNC_DISPOSED || obj3 == ASYNC_DISPOSED) {
                    break;
                }
                boolean z = get(2) != Thread.currentThread();
                if (compareAndSet(1, obj3, z ? ASYNC_DISPOSED : SYNC_DISPOSED)) {
                    if (obj3 != null) {
                        ((Future) obj3).cancel(z);
                    }
                }
            }
            do {
                obj = get(0);
                if (obj == DONE || obj == (obj2 = PARENT_DISPOSED) || obj == null) {
                    return;
                }
            } while (!compareAndSet(0, obj, obj2));
            ((DisposableContainer) obj).delete(this);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Object obj = get(0);
            return obj == PARENT_DISPOSED || obj == DONE;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IF, SGET, INVOKE, IF, SGET, IF, INVOKE, SGET, CHECK_CAST, INVOKE, IF, SGET, INVOKE, IF, SGET, IF, INVOKE, SGET, IF, IF, SGET, INVOKE, IF, SGET, IF, INVOKE, SGET, IF, SGET, INVOKE, IF, SGET, INVOKE, IF, SGET, IF, INVOKE, SGET, IF, INVOKE, INVOKE, SGET, MOVE_EXCEPTION, INVOKE, IF, SGET, INVOKE, IF, SGET, IF, INVOKE, SGET, CHECK_CAST, INVOKE, IF, SGET, INVOKE, IF, SGET, IF, INVOKE, SGET, IF, IF, SGET, INVOKE, IF, SGET, IF, INVOKE, SGET, IF, SGET, INVOKE, IF, SGET, INVOKE, IF, SGET, IF, INVOKE, SGET, IF, INVOKE, INVOKE, SGET, MOVE_EXCEPTION] complete} */
    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        Object obj3;
        boolean compareAndSet;
        Object obj4;
        Object obj5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            lazySet(2, Thread.currentThread());
            try {
                this.actual.run();
            } finally {
                try {
                    lazySet(2, null);
                    obj4 = get(0);
                    if (obj4 != PARENT_DISPOSED) {
                        ((DisposableContainer) obj4).delete(this);
                    }
                    do {
                        obj5 = get(1);
                        if (obj5 != SYNC_DISPOSED) {
                            return;
                        }
                        return;
                    } while (!compareAndSet(1, obj5, DONE));
                } catch (Throwable th) {
                    do {
                        if (obj == obj2) {
                            break;
                        } else if (obj == obj3) {
                            break;
                        }
                    } while (!compareAndSet);
                }
            }
            lazySet(2, null);
            obj4 = get(0);
            if (obj4 != PARENT_DISPOSED && compareAndSet(0, obj4, DONE) && obj4 != null) {
                ((DisposableContainer) obj4).delete(this);
            }
            do {
                obj5 = get(1);
                if (obj5 != SYNC_DISPOSED || obj5 == ASYNC_DISPOSED) {
                    return;
                }
            } while (!compareAndSet(1, obj5, DONE));
        }
    }

    public void setFuture(Future<?> future) {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, future) == null) {
            do {
                obj = get(1);
                if (obj == DONE) {
                    return;
                }
                if (obj == SYNC_DISPOSED) {
                    future.cancel(false);
                    return;
                } else if (obj == ASYNC_DISPOSED) {
                    future.cancel(true);
                    return;
                }
            } while (!compareAndSet(1, obj, future));
        }
    }
}
