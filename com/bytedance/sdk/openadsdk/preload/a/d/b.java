package com.bytedance.sdk.openadsdk.preload.a.d;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes9.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final b f68902a;

    /* renamed from: b  reason: collision with root package name */
    public static final b f68903b;

    /* renamed from: c  reason: collision with root package name */
    public static final b f68904c;

    /* renamed from: d  reason: collision with root package name */
    public static final b f68905d;

    /* renamed from: e  reason: collision with root package name */
    public static final b f68906e;

    /* renamed from: f  reason: collision with root package name */
    public static final b f68907f;

    /* renamed from: g  reason: collision with root package name */
    public static final b f68908g;

    /* renamed from: h  reason: collision with root package name */
    public static final b f68909h;

    /* renamed from: i  reason: collision with root package name */
    public static final b f68910i;

    /* renamed from: j  reason: collision with root package name */
    public static final b f68911j;
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
        f68902a = new b("BEGIN_ARRAY", 0);
        f68903b = new b("END_ARRAY", 1);
        f68904c = new b("BEGIN_OBJECT", 2);
        f68905d = new b("END_OBJECT", 3);
        f68906e = new b("NAME", 4);
        f68907f = new b("STRING", 5);
        f68908g = new b("NUMBER", 6);
        f68909h = new b("BOOLEAN", 7);
        f68910i = new b("NULL", 8);
        b bVar = new b("END_DOCUMENT", 9);
        f68911j = bVar;
        k = new b[]{f68902a, f68903b, f68904c, f68905d, f68906e, f68907f, f68908g, f68909h, f68910i, bVar};
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
