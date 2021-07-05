package com.bytedance.sdk.openadsdk.preload.geckox.h;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f32113a;

    /* renamed from: b  reason: collision with root package name */
    public static c f32114b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1932817989, "Lcom/bytedance/sdk/openadsdk/preload/geckox/h/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1932817989, "Lcom/bytedance/sdk/openadsdk/preload/geckox/h/b;");
                return;
            }
        }
        f32114b = new a();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            f32113a = true;
        }
    }

    public static void b(String str, String str2, Throwable th) {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65540, null, str, str2, th) == null) && f32113a && (cVar = f32114b) != null) {
            cVar.b(str, str2, th);
        }
    }

    public static void a(String str, Object... objArr) {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, str, objArr) == null) && f32113a && (cVar = f32114b) != null) {
            cVar.a(str, objArr);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, str, str2, th) == null) && f32113a && (cVar = f32114b) != null) {
            cVar.a(str, str2, th);
        }
    }
}
