package com.bytedance.sdk.openadsdk.preload.a.d;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final b f32020a;

    /* renamed from: b  reason: collision with root package name */
    public static final b f32021b;

    /* renamed from: c  reason: collision with root package name */
    public static final b f32022c;

    /* renamed from: d  reason: collision with root package name */
    public static final b f32023d;

    /* renamed from: e  reason: collision with root package name */
    public static final b f32024e;

    /* renamed from: f  reason: collision with root package name */
    public static final b f32025f;

    /* renamed from: g  reason: collision with root package name */
    public static final b f32026g;

    /* renamed from: h  reason: collision with root package name */
    public static final b f32027h;

    /* renamed from: i  reason: collision with root package name */
    public static final b f32028i;
    public static final b j;
    public static final /* synthetic */ b[] k;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(639710253, "Lcom/bytedance/sdk/openadsdk/preload/a/d/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(639710253, "Lcom/bytedance/sdk/openadsdk/preload/a/d/b;");
                return;
            }
        }
        f32020a = new b("BEGIN_ARRAY", 0);
        f32021b = new b("END_ARRAY", 1);
        f32022c = new b("BEGIN_OBJECT", 2);
        f32023d = new b("END_OBJECT", 3);
        f32024e = new b("NAME", 4);
        f32025f = new b("STRING", 5);
        f32026g = new b("NUMBER", 6);
        f32027h = new b("BOOLEAN", 7);
        f32028i = new b("NULL", 8);
        b bVar = new b("END_DOCUMENT", 9);
        j = bVar;
        k = new b[]{f32020a, f32021b, f32022c, f32023d, f32024e, f32025f, f32026g, f32027h, f32028i, bVar};
    }

    public b(String str, int i2) {
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

    public static b valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (b) Enum.valueOf(b.class, str) : (b) invokeL.objValue;
    }

    public static b[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (b[]) k.clone() : (b[]) invokeV.objValue;
    }
}
