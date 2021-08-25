package com.xiaomi.mipush.sdk;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final e f77125a;

    /* renamed from: a  reason: collision with other field name */
    public static final /* synthetic */ e[] f91a;

    /* renamed from: b  reason: collision with root package name */
    public static final e f77126b;

    /* renamed from: c  reason: collision with root package name */
    public static final e f77127c;

    /* renamed from: d  reason: collision with root package name */
    public static final e f77128d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public int f92a;

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
        f77125a = new e("ASSEMBLE_PUSH_HUAWEI", 0, 1);
        f77126b = new e("ASSEMBLE_PUSH_FCM", 1, 2);
        f77127c = new e("ASSEMBLE_PUSH_COS", 2, 3);
        e eVar = new e("ASSEMBLE_PUSH_FTOS", 3, 4);
        f77128d = eVar;
        f91a = new e[]{f77125a, f77126b, f77127c, eVar};
    }

    public e(String str, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f92a = i3;
    }

    public static e valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (e) Enum.valueOf(e.class, str) : (e) invokeL.objValue;
    }

    public static e[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (e[]) f91a.clone() : (e[]) invokeV.objValue;
    }
}
