package com.tencent.open.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(String str) {
        InterceptResult invokeL;
        int a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (com.tencent.open.utils.f.a() == null || (a = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), str).a("Common_BusinessReportFrequency")) == 0) {
                return 100;
            }
            return a;
        }
        return invokeL.intValue;
    }

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            int a = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), (String) null).a("Common_HttpRetryCount");
            if (a == 0) {
                return 2;
            }
            return a;
        }
        return invokeV.intValue;
    }
}
