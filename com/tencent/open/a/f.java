package com.tencent.open.a;

import android.os.Environment;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.a.d;
import java.io.File;
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static f f41896a;

    /* renamed from: c  reason: collision with root package name */
    public static final b f41897c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f41898d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public a f41899b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2039280004, "Lcom/tencent/open/a/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2039280004, "Lcom/tencent/open/a/f;");
                return;
            }
        }
        f41897c = new b(c(), c.m, c.f41889g, c.f41890h, c.f41885c, c.f41891i, 10, c.f41887e, c.n);
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f41899b = new a(f41897c);
    }

    public static f a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f41896a == null) {
                synchronized (f.class) {
                    if (f41896a == null) {
                        f41896a = new f();
                        f41898d = true;
                    }
                }
            }
            return f41896a;
        }
        return (f) invokeV.objValue;
    }

    public static final void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2) == null) {
            a().a(2, str, str2, null);
        }
    }

    public static final void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, str2) == null) {
            a().a(4, str, str2, null);
        }
    }

    public static final void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) {
            a().a(8, str, str2, null);
        }
    }

    public static final void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, str2) == null) {
            a().a(16, str, str2, null);
        }
    }

    public static final void b(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, str2, th) == null) {
            a().a(16, str, str2, th);
        }
    }

    public static File c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            String str = c.f41886d;
            boolean z = false;
            try {
                d.c b2 = d.b.b();
                if (b2 != null) {
                    if (b2.c() > c.f41888f) {
                        z = true;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (z) {
                return new File(Environment.getExternalStorageDirectory(), str);
            }
            return new File(com.tencent.open.utils.e.c(), str);
        }
        return (File) invokeV.objValue;
    }

    public void d() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f41899b) == null) {
            return;
        }
        aVar.a();
        this.f41899b.b();
        this.f41899b = null;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            synchronized (f.class) {
                a().d();
                if (f41896a != null) {
                    f41896a = null;
                }
            }
        }
    }

    public void a(int i2, String str, String str2, Throwable th) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, str2, th}) == null) {
            if (f41898d) {
                String b2 = com.tencent.open.utils.e.b();
                if (!TextUtils.isEmpty(b2)) {
                    String str3 = b2 + " SDK_VERSION:" + com.tencent.connect.common.Constants.SDK_VERSION;
                    if (this.f41899b == null) {
                        return;
                    }
                    e.f41895a.b(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str3, null);
                    this.f41899b.b(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str3, null);
                    f41898d = false;
                }
            }
            e.f41895a.b(i2, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
            if (!d.a.a(c.f41884b, i2) || (aVar = this.f41899b) == null) {
                return;
            }
            aVar.b(i2, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
        }
    }

    public static final void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) {
            a().a(1, str, str2, null);
        }
    }

    public static final void a(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65540, null, str, str2, th) == null) {
            a().a(2, str, str2, th);
        }
    }
}
