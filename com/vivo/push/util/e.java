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
/* loaded from: classes10.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final int f76292a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f76293b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f76294c;

    /* renamed from: d  reason: collision with root package name */
    public static ExecutorService f76295d;
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
        f76292a = availableProcessors;
        f76293b = Math.max(2, Math.min(availableProcessors - 1, 4));
        f76294c = (f76292a * 2) + 1;
        f76295d = a("COMMON_THREAD");
    }

    public static ExecutorService a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? new ThreadPoolExecutor(f76293b, f76294c, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new f(str), new ThreadPoolExecutor.DiscardPolicy()) : (ExecutorService) invokeL.objValue;
    }
}
