package com.kwad.sdk.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ak {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Handler f39336a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(408734328, "Lcom/kwad/sdk/utils/ak;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(408734328, "Lcom/kwad/sdk/utils/ak;");
                return;
            }
        }
        f39336a = new Handler(Looper.getMainLooper());
    }

    public static void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, runnable) == null) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                runnable.run();
            } else {
                f39336a.post(runnable);
            }
        }
    }

    public static void a(Runnable runnable, Object obj, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{runnable, obj, Long.valueOf(j)}) == null) {
            Message obtain = Message.obtain(f39336a, runnable);
            obtain.obj = obj;
            f39336a.sendMessageDelayed(obtain, j);
        }
    }
}
