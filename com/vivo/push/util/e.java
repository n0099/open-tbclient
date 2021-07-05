package com.vivo.push.util;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int f42224a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f42225b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f42226c;

    /* renamed from: d  reason: collision with root package name */
    public static ExecutorService f42227d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(744178263, "Lcom/vivo/push/util/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(744178263, "Lcom/vivo/push/util/e;");
                return;
            }
        }
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f42224a = availableProcessors;
        f42225b = Math.max(2, Math.min(availableProcessors - 1, 4));
        f42226c = (f42224a * 2) + 1;
        f42227d = a("COMMON_THREAD");
    }

    public static ExecutorService a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? new ThreadPoolExecutor(f42225b, f42226c, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new f(str), new ThreadPoolExecutor.DiscardPolicy()) : (ExecutorService) invokeL.objValue;
    }
}
