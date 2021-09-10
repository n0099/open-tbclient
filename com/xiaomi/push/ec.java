package com.xiaomi.push;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public final class ec {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final ec f77563a;

    /* renamed from: a  reason: collision with other field name */
    public static final /* synthetic */ ec[] f322a;

    /* renamed from: b  reason: collision with root package name */
    public static final ec f77564b;

    /* renamed from: c  reason: collision with root package name */
    public static final ec f77565c;

    /* renamed from: d  reason: collision with root package name */
    public static final ec f77566d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public String f323a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-56375966, "Lcom/xiaomi/push/ec;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-56375966, "Lcom/xiaomi/push/ec;");
                return;
            }
        }
        f77563a = new ec("ACTIVITY", 0, "activity");
        f77564b = new ec("SERVICE_ACTION", 1, "service_action");
        f77565c = new ec("SERVICE_COMPONENT", 2, "service_component");
        ec ecVar = new ec("PROVIDER", 3, "provider");
        f77566d = ecVar;
        f322a = new ec[]{f77563a, f77564b, f77565c, ecVar};
    }

    public ec(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f323a = str2;
    }

    public static ec valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ec) Enum.valueOf(ec.class, str) : (ec) invokeL.objValue;
    }

    public static ec[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ec[]) f322a.clone() : (ec[]) invokeV.objValue;
    }
}
