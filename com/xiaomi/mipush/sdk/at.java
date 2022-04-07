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
public final class at {
    public static /* synthetic */ Interceptable $ic;
    public static final at a;

    /* renamed from: a  reason: collision with other field name */
    public static final /* synthetic */ at[] f58a;
    public static final at b;
    public static final at c;
    public static final at d;
    public static final at e;
    public static final at f;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1871206476, "Lcom/xiaomi/mipush/sdk/at;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1871206476, "Lcom/xiaomi/mipush/sdk/at;");
                return;
            }
        }
        a = new at("DISABLE_PUSH", 0);
        b = new at("ENABLE_PUSH", 1);
        c = new at("UPLOAD_HUAWEI_TOKEN", 2);
        d = new at("UPLOAD_FCM_TOKEN", 3);
        e = new at("UPLOAD_COS_TOKEN", 4);
        at atVar = new at("UPLOAD_FTOS_TOKEN", 5);
        f = atVar;
        f58a = new at[]{a, b, c, d, e, atVar};
    }

    public at(String str, int i) {
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

    public static at valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (at) Enum.valueOf(at.class, str) : (at) invokeL.objValue;
    }

    public static at[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (at[]) f58a.clone() : (at[]) invokeV.objValue;
    }
}
