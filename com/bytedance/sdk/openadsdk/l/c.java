package com.bytedance.sdk.openadsdk.l;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final c f68292a;

    /* renamed from: b  reason: collision with root package name */
    public static final c f68293b;

    /* renamed from: c  reason: collision with root package name */
    public static final c f68294c;

    /* renamed from: d  reason: collision with root package name */
    public static final c f68295d;

    /* renamed from: e  reason: collision with root package name */
    public static final c f68296e;

    /* renamed from: f  reason: collision with root package name */
    public static final c f68297f;

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ c[] f68298h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public String f68299g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(97960400, "Lcom/bytedance/sdk/openadsdk/l/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(97960400, "Lcom/bytedance/sdk/openadsdk/l/c;");
                return;
            }
        }
        f68292a = new c("TYPE_2G", 0, "2g");
        f68293b = new c("TYPE_3G", 1, "3g");
        f68294c = new c("TYPE_4G", 2, "4g");
        f68295d = new c("TYPE_5G", 3, "5g");
        f68296e = new c("TYPE_WIFI", 4, "wifi");
        c cVar = new c("TYPE_UNKNOWN", 5, "mobile");
        f68297f = cVar;
        f68298h = new c[]{f68292a, f68293b, f68294c, f68295d, f68296e, cVar};
    }

    public c(String str, int i2, String str2) {
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
        this.f68299g = str2;
    }

    public static c valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (c) Enum.valueOf(c.class, str) : (c) invokeL.objValue;
    }

    public static c[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (c[]) f68298h.clone() : (c[]) invokeV.objValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f68299g : (String) invokeV.objValue;
    }
}
