package io.reactivex.internal.util;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes10.dex */
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

    public static long add(AtomicLong atomicLong, long j) {
        long j2;
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65537, null, atomicLong, j)) == null) {
            do {
                j2 = atomicLong.get();
                if (j2 == Long.MAX_VALUE) {
                    return Long.MAX_VALUE;
                }
            } while (!atomicLong.compareAndSet(j2, addCap(j2, j)));
            return j2;
        }
        return invokeLJ.longValue;
    }

    public static long addCancel(AtomicLong atomicLong, long j) {
        long j2;
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(65538, null, atomicLong, j)) == null) {
            do {
                j2 = atomicLong.get();
                if (j2 == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                if (j2 == Long.MAX_VALUE) {
                    return Long.MAX_VALUE;
                }
            } while (!atomicLong.compareAndSet(j2, addCap(j2, j)));
            return j2;
        }
        return invokeLJ.longValue;
    }

    public static long addCap(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            long j3 = j + j2;
            if (j3 < 0) {
                return Long.MAX_VALUE;
            }
            return j3;
        }
        return invokeCommon.longValue;
    }

    public static long multiplyCap(long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65540, null, new Object[]{Long.valueOf(j), Long.valueOf(j2)})) == null) {
            long j3 = j * j2;
            if (((j | j2) >>> 31) == 0 || j3 / j == j2) {
                return j3;
            }
            return Long.MAX_VALUE;
        }
        return invokeCommon.longValue;
    }

    public static long produced(AtomicLong atomicLong, long j) {
        long j2;
        long j3;
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(AdIconUtil.AD_TEXT_ID, null, atomicLong, j)) == null) {
            do {
                j2 = atomicLong.get();
                if (j2 == Long.MAX_VALUE) {
                    return Long.MAX_VALUE;
                }
                j3 = j2 - j;
                if (j3 < 0) {
                    RxJavaPlugins.onError(new IllegalStateException("More produced than requested: " + j3));
                    j3 = 0L;
                }
            } while (!atomicLong.compareAndSet(j2, j3));
            return j3;
        }
        return invokeLJ.longValue;
    }

    public static long producedCancel(AtomicLong atomicLong, long j) {
        long j2;
        long j3;
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(AdIconUtil.BAIDU_LOGO_ID, null, atomicLong, j)) == null) {
            do {
                j2 = atomicLong.get();
                if (j2 == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                if (j2 == Long.MAX_VALUE) {
                    return Long.MAX_VALUE;
                }
                j3 = j2 - j;
                if (j3 < 0) {
                    RxJavaPlugins.onError(new IllegalStateException("More produced than requested: " + j3));
                    j3 = 0L;
                }
            } while (!atomicLong.compareAndSet(j2, j3));
            return j3;
        }
        return invokeLJ.longValue;
    }
}
