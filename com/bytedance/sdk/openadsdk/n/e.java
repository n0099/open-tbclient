package com.bytedance.sdk.openadsdk.n;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.n.a.c;
import java.util.Set;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.n.a.b f68040a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.n.a.c f68041b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f68042c;

    /* renamed from: d  reason: collision with root package name */
    public static volatile boolean f68043d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile boolean f68044e;

    /* renamed from: f  reason: collision with root package name */
    public static volatile boolean f68045f;

    /* renamed from: g  reason: collision with root package name */
    public static volatile int f68046g;

    /* renamed from: h  reason: collision with root package name */
    public static volatile int f68047h;

    /* renamed from: i  reason: collision with root package name */
    public static volatile Integer f68048i;

    /* renamed from: j  reason: collision with root package name */
    public static volatile com.bytedance.sdk.openadsdk.n.b.c f68049j;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile Context k;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(98020044, "Lcom/bytedance/sdk/openadsdk/n/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(98020044, "Lcom/bytedance/sdk/openadsdk/n/e;");
                return;
            }
        }
        f68042c = com.bytedance.sdk.component.utils.k.c();
        f68044e = true;
        f68046g = 0;
        f68047h = 3;
    }

    public static Context a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? k : (Context) invokeV.objValue;
    }

    public static void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(AdIconUtil.BAIDU_LOGO_ID, null, z) == null) {
            f68045f = z;
        }
    }

    public static com.bytedance.sdk.openadsdk.n.a.b c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? f68040a : (com.bytedance.sdk.openadsdk.n.a.b) invokeV.objValue;
    }

    public static void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) {
            f68044e = z;
        }
    }

    public static com.bytedance.sdk.openadsdk.n.a.c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? f68041b : (com.bytedance.sdk.openadsdk.n.a.c) invokeV.objValue;
    }

    public static void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65538, null, i2) == null) {
            f68046g = i2;
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.n.a.c cVar, Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, cVar, context) == null) {
            if (cVar != null && context != null) {
                k = context.getApplicationContext();
                if (f68041b != null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.n.a.b bVar = f68040a;
                if (bVar != null && bVar.f67967a.getAbsolutePath().equals(cVar.f67969a.getAbsolutePath())) {
                    throw new IllegalArgumentException("DiskLruCache 和 DiskCache 不能使用相同的目录");
                }
                f68041b = cVar;
                f68049j = com.bytedance.sdk.openadsdk.n.b.c.a(context);
                f68041b.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.n.e.1
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

                    @Override // com.bytedance.sdk.openadsdk.n.a.c.a
                    public void a(String str) {
                        Interceptable interceptable2 = $ic;
                        if ((interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) && e.f68042c) {
                            String str2 = "new cache created: " + str;
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.n.a.c.a
                    public void a(Set<String> set) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, set) == null) {
                            e.f68049j.a(set, 0);
                            if (e.f68042c) {
                                String str = "cache file removed, " + set;
                            }
                        }
                    }
                });
                f a2 = f.a();
                a2.a(cVar);
                a2.a(f68049j);
                d c2 = d.c();
                c2.a(cVar);
                c2.a(f68049j);
                return;
            }
            throw new IllegalArgumentException("DiskLruCache and Context can't be null !!!");
        }
    }
}
