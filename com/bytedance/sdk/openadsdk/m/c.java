package com.bytedance.sdk.openadsdk.m;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final c f31364a;

    /* renamed from: b  reason: collision with root package name */
    public static final c f31365b;

    /* renamed from: c  reason: collision with root package name */
    public static final c f31366c;

    /* renamed from: d  reason: collision with root package name */
    public static final c f31367d;

    /* renamed from: e  reason: collision with root package name */
    public static final c f31368e;

    /* renamed from: f  reason: collision with root package name */
    public static final c f31369f;

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ c[] f31370h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public String f31371g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(97990191, "Lcom/bytedance/sdk/openadsdk/m/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(97990191, "Lcom/bytedance/sdk/openadsdk/m/c;");
                return;
            }
        }
        f31364a = new c("TYPE_2G", 0, "2g");
        f31365b = new c("TYPE_3G", 1, "3g");
        f31366c = new c("TYPE_4G", 2, "4g");
        f31367d = new c("TYPE_5G", 3, "5g");
        f31368e = new c("TYPE_WIFI", 4, "wifi");
        c cVar = new c("TYPE_UNKNOWN", 5, "mobile");
        f31369f = cVar;
        f31370h = new c[]{f31364a, f31365b, f31366c, f31367d, f31368e, cVar};
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
        this.f31371g = str2;
    }

    public static c valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (c) Enum.valueOf(c.class, str) : (c) invokeL.objValue;
    }

    public static c[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (c[]) f31370h.clone() : (c[]) invokeV.objValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f31371g : (String) invokeV.objValue;
    }
}
