package com.kuaishou.weapon.p0;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* renamed from: com.kuaishou.weapon.p0.ʼᵎ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0340 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: ʻ  reason: contains not printable characters */
    public static volatile boolean f132 = false;

    /* renamed from: ʼ  reason: contains not printable characters */
    public static volatile boolean f133 = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(335392517, "Lcom/kuaishou/weapon/p0/ʼᵎ;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(335392517, "Lcom/kuaishou/weapon/p0/ʼᵎ;");
                return;
            }
        }
        try {
            f132 = ((Boolean) Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("is64Bit", new Class[0]).invoke(Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("getRuntime", new Class[0]).invoke(null, new Object[0]), new Object[0])).booleanValue();
        } catch (Exception unused) {
            f132 = false;
        }
        f133 = System.getProperty("java.vm.version").startsWith("2");
    }

    public C0340() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static boolean m289() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f132 : invokeV.booleanValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static boolean m290() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? f133 : invokeV.booleanValue;
    }
}
