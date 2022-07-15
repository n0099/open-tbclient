package com.xiaomi.mipush.sdk;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class ag {
    public static /* synthetic */ Interceptable $ic;
    public static final ag a;

    /* renamed from: a  reason: collision with other field name */
    public static final /* synthetic */ ag[] f770a;
    public static final ag b;
    public static final ag c;
    public static final ag d;
    public static final ag e;
    public static final ag f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1871206879, "Lcom/xiaomi/mipush/sdk/ag;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1871206879, "Lcom/xiaomi/mipush/sdk/ag;");
                return;
            }
        }
        a = new ag("HUAWEI", 0);
        b = new ag("MEIZU", 1);
        c = new ag("FCM", 2);
        d = new ag("OPPO", 3);
        e = new ag("VIVO", 4);
        ag agVar = new ag("OTHER", 5);
        f = agVar;
        f770a = new ag[]{a, b, c, d, e, agVar};
    }

    public ag(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ag valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ag) Enum.valueOf(ag.class, str) : (ag) invokeL.objValue;
    }

    public static ag[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ag[]) f770a.clone() : (ag[]) invokeV.objValue;
    }
}
