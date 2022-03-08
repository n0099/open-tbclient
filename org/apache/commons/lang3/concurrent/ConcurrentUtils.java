package org.apache.commons.lang3.concurrent;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.Validate;
/* loaded from: classes9.dex */
public class ConcurrentUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static final class ConstantFuture<T> implements Future<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final T value;

        public ConstantFuture(T t) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = t;
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
                return false;
            }
            return invokeZ.booleanValue;
        }

        @Override // java.util.concurrent.Future
        public T get() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.value : (T) invokeV.objValue;
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.concurrent.Future
        public T get(long j2, TimeUnit timeUnit) {
            InterceptResult invokeJL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeJL = interceptable.invokeJL(Constants.METHOD_SEND_USER_MSG, this, j2, timeUnit)) == null) ? this.value : (T) invokeJL.objValue;
        }
    }

    public ConcurrentUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Throwable checkedException(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, th)) == null) {
            boolean z = (th == null || (th instanceof RuntimeException) || (th instanceof Error)) ? false : true;
            Validate.isTrue(z, "Not a checked exception: " + th, new Object[0]);
            return th;
        }
        return (Throwable) invokeL.objValue;
    }

    public static <T> Future<T> constantFuture(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, t)) == null) ? new ConstantFuture(t) : (Future) invokeL.objValue;
    }

    public static <K, V> V createIfAbsent(ConcurrentMap<K, V> concurrentMap, K k, ConcurrentInitializer<V> concurrentInitializer) throws ConcurrentException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, concurrentMap, k, concurrentInitializer)) == null) {
            if (concurrentMap == null || concurrentInitializer == null) {
                return null;
            }
            V v = concurrentMap.get(k);
            return v == null ? (V) putIfAbsent(concurrentMap, k, concurrentInitializer.get()) : v;
        }
        return (V) invokeLLL.objValue;
    }

    public static <K, V> V createIfAbsentUnchecked(ConcurrentMap<K, V> concurrentMap, K k, ConcurrentInitializer<V> concurrentInitializer) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, concurrentMap, k, concurrentInitializer)) == null) {
            try {
                return (V) createIfAbsent(concurrentMap, k, concurrentInitializer);
            } catch (ConcurrentException e2) {
                throw new ConcurrentRuntimeException(e2.getCause());
            }
        }
        return (V) invokeLLL.objValue;
    }

    public static ConcurrentException extractCause(ExecutionException executionException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, executionException)) == null) {
            if (executionException == null || executionException.getCause() == null) {
                return null;
            }
            throwCause(executionException);
            return new ConcurrentException(executionException.getMessage(), executionException.getCause());
        }
        return (ConcurrentException) invokeL.objValue;
    }

    public static ConcurrentRuntimeException extractCauseUnchecked(ExecutionException executionException) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, executionException)) == null) {
            if (executionException == null || executionException.getCause() == null) {
                return null;
            }
            throwCause(executionException);
            return new ConcurrentRuntimeException(executionException.getMessage(), executionException.getCause());
        }
        return (ConcurrentRuntimeException) invokeL.objValue;
    }

    public static void handleCause(ExecutionException executionException) throws ConcurrentException {
        ConcurrentException extractCause;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, executionException) == null) && (extractCause = extractCause(executionException)) != null) {
            throw extractCause;
        }
    }

    public static void handleCauseUnchecked(ExecutionException executionException) {
        ConcurrentRuntimeException extractCauseUnchecked;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, executionException) == null) && (extractCauseUnchecked = extractCauseUnchecked(executionException)) != null) {
            throw extractCauseUnchecked;
        }
    }

    public static <T> T initialize(ConcurrentInitializer<T> concurrentInitializer) throws ConcurrentException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, concurrentInitializer)) == null) {
            if (concurrentInitializer != null) {
                return concurrentInitializer.get();
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static <T> T initializeUnchecked(ConcurrentInitializer<T> concurrentInitializer) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, concurrentInitializer)) == null) {
            try {
                return (T) initialize(concurrentInitializer);
            } catch (ConcurrentException e2) {
                throw new ConcurrentRuntimeException(e2.getCause());
            }
        }
        return (T) invokeL.objValue;
    }

    public static <K, V> V putIfAbsent(ConcurrentMap<K, V> concurrentMap, K k, V v) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, concurrentMap, k, v)) == null) {
            if (concurrentMap == null) {
                return null;
            }
            V putIfAbsent = concurrentMap.putIfAbsent(k, v);
            return putIfAbsent != null ? putIfAbsent : v;
        }
        return (V) invokeLLL.objValue;
    }

    public static void throwCause(ExecutionException executionException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, executionException) == null) {
            if (!(executionException.getCause() instanceof RuntimeException)) {
                if (executionException.getCause() instanceof Error) {
                    throw ((Error) executionException.getCause());
                }
                return;
            }
            throw ((RuntimeException) executionException.getCause());
        }
    }
}
