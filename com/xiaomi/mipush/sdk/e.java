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
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public static final e a;

    /* renamed from: a  reason: collision with other field name */
    public static final /* synthetic */ e[] f100a;
    public static final e b;
    public static final e c;
    public static final e d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f101a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(78185898, "Lcom/xiaomi/mipush/sdk/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(78185898, "Lcom/xiaomi/mipush/sdk/e;");
                return;
            }
        }
        a = new e("ASSEMBLE_PUSH_HUAWEI", 0, 1);
        b = new e("ASSEMBLE_PUSH_FCM", 1, 2);
        c = new e("ASSEMBLE_PUSH_COS", 2, 3);
        e eVar = new e("ASSEMBLE_PUSH_FTOS", 3, 4);
        d = eVar;
        f100a = new e[]{a, b, c, eVar};
    }

    public e(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f101a = i2;
    }

    public static e valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (e) Enum.valueOf(e.class, str) : (e) invokeL.objValue;
    }

    public static e[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (e[]) f100a.clone() : (e[]) invokeV.objValue;
    }
}
