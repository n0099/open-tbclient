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
public final class au {
    public static /* synthetic */ Interceptable $ic;
    public static final au a;

    /* renamed from: a  reason: collision with other field name */
    public static final /* synthetic */ au[] f59a;
    public static final au b;
    public static final au c;
    public static final au d;
    public static final au e;
    public static final au f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1871206445, "Lcom/xiaomi/mipush/sdk/au;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1871206445, "Lcom/xiaomi/mipush/sdk/au;");
                return;
            }
        }
        a = new au("DISABLE_PUSH", 0);
        b = new au("ENABLE_PUSH", 1);
        c = new au("UPLOAD_HUAWEI_TOKEN", 2);
        d = new au("UPLOAD_FCM_TOKEN", 3);
        e = new au("UPLOAD_COS_TOKEN", 4);
        au auVar = new au("UPLOAD_FTOS_TOKEN", 5);
        f = auVar;
        f59a = new au[]{a, b, c, d, e, auVar};
    }

    public au(String str, int i) {
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

    public static au valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (au) Enum.valueOf(au.class, str) : (au) invokeL.objValue;
    }

    public static au[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (au[]) f59a.clone() : (au[]) invokeV.objValue;
    }
}
