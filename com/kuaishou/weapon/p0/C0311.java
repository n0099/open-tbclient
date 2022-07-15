package com.kuaishou.weapon.p0;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* renamed from: com.kuaishou.weapon.p0.ʻᵎ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0311 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public C0311() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String m207(Context context, C0374 c0374) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, c0374)) == null) {
            try {
                return c0374.m420();
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static void m208(String str, Context context, C0374 c0374) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, context, c0374) == null) {
            try {
                c0374.m424(str);
            } catch (Exception unused) {
            }
        }
    }
}
