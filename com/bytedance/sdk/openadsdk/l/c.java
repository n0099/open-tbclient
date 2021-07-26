package com.bytedance.sdk.openadsdk.l;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final c f31657a;

    /* renamed from: b  reason: collision with root package name */
    public static final c f31658b;

    /* renamed from: c  reason: collision with root package name */
    public static final c f31659c;

    /* renamed from: d  reason: collision with root package name */
    public static final c f31660d;

    /* renamed from: e  reason: collision with root package name */
    public static final c f31661e;

    /* renamed from: f  reason: collision with root package name */
    public static final c f31662f;

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ c[] f31663h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: g  reason: collision with root package name */
    public String f31664g;

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
        f31657a = new c("TYPE_2G", 0, "2g");
        f31658b = new c("TYPE_3G", 1, "3g");
        f31659c = new c("TYPE_4G", 2, "4g");
        f31660d = new c("TYPE_5G", 3, "5g");
        f31661e = new c("TYPE_WIFI", 4, "wifi");
        c cVar = new c("TYPE_UNKNOWN", 5, "mobile");
        f31662f = cVar;
        f31663h = new c[]{f31657a, f31658b, f31659c, f31660d, f31661e, cVar};
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
        this.f31664g = str2;
    }

    public static c valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (c) Enum.valueOf(c.class, str) : (c) invokeL.objValue;
    }

    public static c[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (c[]) f31663h.clone() : (c[]) invokeV.objValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f31664g : (String) invokeV.objValue;
    }
}
