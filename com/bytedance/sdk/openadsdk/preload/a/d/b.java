package com.bytedance.sdk.openadsdk.preload.a.d;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes6.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final b f31910a;

    /* renamed from: b  reason: collision with root package name */
    public static final b f31911b;

    /* renamed from: c  reason: collision with root package name */
    public static final b f31912c;

    /* renamed from: d  reason: collision with root package name */
    public static final b f31913d;

    /* renamed from: e  reason: collision with root package name */
    public static final b f31914e;

    /* renamed from: f  reason: collision with root package name */
    public static final b f31915f;

    /* renamed from: g  reason: collision with root package name */
    public static final b f31916g;

    /* renamed from: h  reason: collision with root package name */
    public static final b f31917h;

    /* renamed from: i  reason: collision with root package name */
    public static final b f31918i;
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
        f31910a = new b("BEGIN_ARRAY", 0);
        f31911b = new b("END_ARRAY", 1);
        f31912c = new b("BEGIN_OBJECT", 2);
        f31913d = new b("END_OBJECT", 3);
        f31914e = new b("NAME", 4);
        f31915f = new b("STRING", 5);
        f31916g = new b("NUMBER", 6);
        f31917h = new b("BOOLEAN", 7);
        f31918i = new b("NULL", 8);
        b bVar = new b("END_DOCUMENT", 9);
        j = bVar;
        k = new b[]{f31910a, f31911b, f31912c, f31913d, f31914e, f31915f, f31916g, f31917h, f31918i, bVar};
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
