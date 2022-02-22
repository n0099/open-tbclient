package io.reactivex.internal.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes5.dex */
public final class BackpressureHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BackpressureHelper() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        throw new IllegalStateException("No instances!");
    }

    public static long add(AtomicLong atomicLong, long j2) {
        long j3;
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65537, null, atomicLong, j2)) == null) {
            do {
                j3 = atomicLong.get();
                if (j3 == Long.MAX_VALUE) {
                    return Long.MAX_VALUE;
                }
            } while (!atomicLong.compareAndSet(j3, addCap(j3, j2)));
            return j3;
        }
        return invokeLJ.longValue;
    }

    public static long addCancel(AtomicLong atomicLong, long j2) {
        long j3;
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, atomicLong, j2)) == null) {
            do {
                j3 = atomicLong.get();
                if (j3 == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                if (j3 == Long.MAX_VALUE) {
                    return Long.MAX_VALUE;
                }
            } while (!atomicLong.compareAndSet(j3, addCap(j3, j2)));
            return j3;
        }
        return invokeLJ.longValue;
    }

    public static long addCap(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            long j4 = j2 + j3;
            if (j4 < 0) {
                return Long.MAX_VALUE;
            }
            return j4;
        }
        return invokeCommon.longValue;
    }

    public static long multiplyCap(long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            long j4 = j2 * j3;
            if (((j2 | j3) >>> 31) == 0 || j4 / j2 == j3) {
                return j4;
            }
            return Long.MAX_VALUE;
        }
        return invokeCommon.longValue;
    }

    public static long produced(AtomicLong atomicLong, long j2) {
        long j3;
        long j4;
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65541, null, atomicLong, j2)) == null) {
            do {
                j3 = atomicLong.get();
                if (j3 == Long.MAX_VALUE) {
                    return Long.MAX_VALUE;
                }
                j4 = j3 - j2;
                if (j4 < 0) {
                    RxJavaPlugins.onError(new IllegalStateException("More produced than requested: " + j4));
                    j4 = 0L;
                }
            } while (!atomicLong.compareAndSet(j3, j4));
            return j4;
        }
        return invokeLJ.longValue;
    }

    public static long producedCancel(AtomicLong atomicLong, long j2) {
        long j3;
        long j4;
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65542, null, atomicLong, j2)) == null) {
            do {
                j3 = atomicLong.get();
                if (j3 == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                if (j3 == Long.MAX_VALUE) {
                    return Long.MAX_VALUE;
                }
                j4 = j3 - j2;
                if (j4 < 0) {
                    RxJavaPlugins.onError(new IllegalStateException("More produced than requested: " + j4));
                    j4 = 0L;
                }
            } while (!atomicLong.compareAndSet(j3, j4));
            return j4;
        }
        return invokeLJ.longValue;
    }
}
