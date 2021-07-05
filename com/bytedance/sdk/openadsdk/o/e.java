package com.bytedance.sdk.openadsdk.o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.o.a.c;
import java.util.Set;
/* loaded from: classes6.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.o.a.b f31595a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.o.a.c f31596b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f31597c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f31598d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile boolean f31599e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f31600f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile int f31601g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile int f31602h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile Integer f31603i;
    public static volatile com.bytedance.sdk.openadsdk.o.b.c j;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile Context k;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(98049835, "Lcom/bytedance/sdk/openadsdk/o/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(98049835, "Lcom/bytedance/sdk/openadsdk/o/e;");
                return;
            }
        }
        f31597c = com.bytedance.sdk.component.utils.j.c();
        f31599e = true;
        f31601g = 0;
        f31602h = 3;
    }

    public static Context a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? k : (Context) invokeV.objValue;
    }

    public static void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.BAIDU_LOGO_ID, null, z) == null) {
            f31600f = z;
        }
    }

    public static com.bytedance.sdk.openadsdk.o.a.b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f31595a : (com.bytedance.sdk.openadsdk.o.a.b) invokeV.objValue;
    }

    public static void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65540, null, z) == null) {
            f31599e = z;
        }
    }

    public static com.bytedance.sdk.openadsdk.o.a.c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f31596b : (com.bytedance.sdk.openadsdk.o.a.c) invokeV.objValue;
    }

    public static void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i2) == null) {
            f31601g = i2;
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.o.a.c cVar, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, cVar, context) == null) {
            if (cVar != null && context != null) {
                k = context.getApplicationContext();
                if (f31596b != null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.o.a.b bVar = f31595a;
                if (bVar != null && bVar.f31525a.getAbsolutePath().equals(cVar.f31527a.getAbsolutePath())) {
                    throw new IllegalArgumentException("DiskLruCache 和 DiskCache 不能使用相同的目录");
                }
                f31596b = cVar;
                j = com.bytedance.sdk.openadsdk.o.b.c.a(context);
                f31596b.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.o.e.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.o.a.c.a
                    public void a(String str) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) && e.f31597c) {
                            Log.i("TAG_PROXY_DiskLruCache", "new cache created: " + str);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.o.a.c.a
                    public void a(Set<String> set) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set) == null) {
                            e.j.a(set, 0);
                            if (e.f31597c) {
                                Log.i("TAG_PROXY_DiskLruCache", "cache file removed, " + set);
                            }
                        }
                    }
                });
                f a2 = f.a();
                a2.a(cVar);
                a2.a(j);
                d c2 = d.c();
                c2.a(cVar);
                c2.a(j);
                return;
            }
            throw new IllegalArgumentException("DiskLruCache and Context can't be null !!!");
        }
    }
}
