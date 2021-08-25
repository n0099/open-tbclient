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
    public static final c f67801a;

    /* renamed from: b  reason: collision with root package name */
    public static final c f67802b;

    /* renamed from: c  reason: collision with root package name */
    public static final c f67803c;

    /* renamed from: d  reason: collision with root package name */
    public static final c f67804d;

    /* renamed from: e  reason: collision with root package name */
    public static final c f67805e;

    /* renamed from: f  reason: collision with root package name */
    public static final c f67806f;

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ c[] f67807h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public String f67808g;

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
        f67801a = new c("TYPE_2G", 0, "2g");
        f67802b = new c("TYPE_3G", 1, "3g");
        f67803c = new c("TYPE_4G", 2, "4g");
        f67804d = new c("TYPE_5G", 3, "5g");
        f67805e = new c("TYPE_WIFI", 4, "wifi");
        c cVar = new c("TYPE_UNKNOWN", 5, "mobile");
        f67806f = cVar;
        f67807h = new c[]{f67801a, f67802b, f67803c, f67804d, f67805e, cVar};
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
        this.f67808g = str2;
    }

    public static c valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (c) Enum.valueOf(c.class, str) : (c) invokeL.objValue;
    }

    public static c[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (c[]) f67807h.clone() : (c[]) invokeV.objValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67808g : (String) invokeV.objValue;
    }
}
