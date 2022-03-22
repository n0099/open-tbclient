package com.xiaomi.mipush.sdk;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public final class af {
    public static /* synthetic */ Interceptable $ic;
    public static final af a;

    /* renamed from: a  reason: collision with other field name */
    public static final /* synthetic */ af[] f42a;

    /* renamed from: b  reason: collision with root package name */
    public static final af f44060b;

    /* renamed from: c  reason: collision with root package name */
    public static final af f44061c;

    /* renamed from: d  reason: collision with root package name */
    public static final af f44062d;

    /* renamed from: e  reason: collision with root package name */
    public static final af f44063e;

    /* renamed from: f  reason: collision with root package name */
    public static final af f44064f;
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
        f44060b = new af("MEIZU", 1);
        f44061c = new af("FCM", 2);
        f44062d = new af("OPPO", 3);
        f44063e = new af("VIVO", 4);
        af afVar = new af("OTHER", 5);
        f44064f = afVar;
        f42a = new af[]{a, f44060b, f44061c, f44062d, f44063e, afVar};
    }

    public af(String str, int i) {
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

    public static af valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (af) Enum.valueOf(af.class, str) : (af) invokeL.objValue;
    }

    public static af[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (af[]) f42a.clone() : (af[]) invokeV.objValue;
    }
}
