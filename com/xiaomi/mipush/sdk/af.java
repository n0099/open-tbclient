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
public final class af {
    public static /* synthetic */ Interceptable $ic;
    public static final af a;

    /* renamed from: a  reason: collision with other field name */
    public static final /* synthetic */ af[] f66a;

    /* renamed from: b  reason: collision with root package name */
    public static final af f59441b;

    /* renamed from: c  reason: collision with root package name */
    public static final af f59442c;

    /* renamed from: d  reason: collision with root package name */
    public static final af f59443d;

    /* renamed from: e  reason: collision with root package name */
    public static final af f59444e;

    /* renamed from: f  reason: collision with root package name */
    public static final af f59445f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1871206910, "Lcom/xiaomi/mipush/sdk/af;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1871206910, "Lcom/xiaomi/mipush/sdk/af;");
                return;
            }
        }
        a = new af("HUAWEI", 0);
        f59441b = new af("MEIZU", 1);
        f59442c = new af("FCM", 2);
        f59443d = new af("OPPO", 3);
        f59444e = new af("VIVO", 4);
        af afVar = new af("OTHER", 5);
        f59445f = afVar;
        f66a = new af[]{a, f59441b, f59442c, f59443d, f59444e, afVar};
    }

    public af(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static af valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (af) Enum.valueOf(af.class, str) : (af) invokeL.objValue;
    }

    public static af[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (af[]) f66a.clone() : (af[]) invokeV.objValue;
    }
}
