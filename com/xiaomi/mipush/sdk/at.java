package com.xiaomi.mipush.sdk;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes4.dex */
public final class at {
    public static /* synthetic */ Interceptable $ic;
    public static final at a;

    /* renamed from: a  reason: collision with other field name */
    public static final /* synthetic */ at[] f82a;

    /* renamed from: b  reason: collision with root package name */
    public static final at f60931b;

    /* renamed from: c  reason: collision with root package name */
    public static final at f60932c;

    /* renamed from: d  reason: collision with root package name */
    public static final at f60933d;

    /* renamed from: e  reason: collision with root package name */
    public static final at f60934e;

    /* renamed from: f  reason: collision with root package name */
    public static final at f60935f;
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
        f60931b = new at("ENABLE_PUSH", 1);
        f60932c = new at("UPLOAD_HUAWEI_TOKEN", 2);
        f60933d = new at("UPLOAD_FCM_TOKEN", 3);
        f60934e = new at("UPLOAD_COS_TOKEN", 4);
        at atVar = new at("UPLOAD_FTOS_TOKEN", 5);
        f60935f = atVar;
        f82a = new at[]{a, f60931b, f60932c, f60933d, f60934e, atVar};
    }

    public at(String str, int i2) {
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

    public static at valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (at) Enum.valueOf(at.class, str) : (at) invokeL.objValue;
    }

    public static at[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (at[]) f82a.clone() : (at[]) invokeV.objValue;
    }
}
