package com.dxmpay.apollon.restnet;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static InterfaceC2050a a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.dxmpay.apollon.restnet.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC2050a {
        void a(String str, String str2);

        boolean a(String str);
    }

    public static InterfaceC2050a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? a : (InterfaceC2050a) invokeV.objValue;
    }

    public static void a(InterfaceC2050a interfaceC2050a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, interfaceC2050a) == null) {
            a = interfaceC2050a;
        }
    }
}
