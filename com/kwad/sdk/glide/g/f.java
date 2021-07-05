package com.kwad.sdk.glide.g;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.SystemClock;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final double f37764a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(906037378, "Lcom/kwad/sdk/glide/g/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(906037378, "Lcom/kwad/sdk/glide/g/f;");
                return;
            }
        }
        f37764a = Build.VERSION.SDK_INT >= 17 ? 1.0d / Math.pow(10.0d, 6.0d) : 1.0d;
    }

    public static double a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(65537, null, j)) == null) ? (a() - j) * f37764a : invokeJ.doubleValue;
    }

    @TargetApi(17)
    public static long a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Build.VERSION.SDK_INT >= 17 ? SystemClock.elapsedRealtimeNanos() : SystemClock.uptimeMillis() : invokeV.longValue;
    }
}
