package com.bytedance.sdk.openadsdk.m;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static a f31395a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public interface a {
        void a(String str, String str2);

        void a(String str, String str2, Throwable th);
    }

    public static void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, aVar) == null) {
            f31395a = aVar;
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f31395a != null : invokeV.booleanValue;
    }

    public static void a(String str, String str2) {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) || (aVar = f31395a) == null) {
            return;
        }
        aVar.a(str, str2);
    }

    public static void a(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, str, str2, th) == null) || f31395a == null) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        f31395a.a(str, str2, th);
    }
}
