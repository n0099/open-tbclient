package com.bytedance.sdk.openadsdk.multipro;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.core.o;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f67751a = "com.bytedance.openadsdk";

    /* renamed from: b  reason: collision with root package name */
    public static String f67752b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(935188188, "Lcom/bytedance/sdk/openadsdk/multipro/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(935188188, "Lcom/bytedance/sdk/openadsdk/multipro/e;");
                return;
            }
        }
        f67752b = "content://" + f67751a + ".TTMultiProvider";
        a();
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || o.a() == null) {
            return;
        }
        f67751a = o.a().getPackageName();
        f67752b = "content://" + f67751a + ".TTMultiProvider";
    }
}
