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
public final class o {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final o f78414a;

    /* renamed from: a  reason: collision with other field name */
    public static final /* synthetic */ o[] f824a;

    /* renamed from: b  reason: collision with root package name */
    public static final o f78415b;

    /* renamed from: c  reason: collision with root package name */
    public static final o f78416c;

    /* renamed from: d  reason: collision with root package name */
    public static final o f78417d;

    /* renamed from: e  reason: collision with root package name */
    public static final o f78418e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1664386297, "Lcom/xiaomi/push/o;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1664386297, "Lcom/xiaomi/push/o;");
                return;
            }
        }
        f78414a = new o("China", 0);
        f78415b = new o("Global", 1);
        f78416c = new o("Europe", 2);
        f78417d = new o("Russia", 3);
        o oVar = new o("India", 4);
        f78418e = oVar;
        f824a = new o[]{f78414a, f78415b, f78416c, f78417d, oVar};
    }

    public o(String str, int i2) {
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

    public static o valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (o) Enum.valueOf(o.class, str) : (o) invokeL.objValue;
    }

    public static o[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (o[]) f824a.clone() : (o[]) invokeV.objValue;
    }
}
