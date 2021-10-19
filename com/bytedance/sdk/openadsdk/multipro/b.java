package com.bytedance.sdk.openadsdk.multipro;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f68457a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f68458b;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_info", "is_support_multi_process", Boolean.TRUE);
            f68457a = true;
            f68458b = true;
        }
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (!f68458b) {
                f68457a = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_info", "is_support_multi_process", false);
                f68458b = true;
            }
            return f68457a;
        }
        return invokeV.booleanValue;
    }
}
