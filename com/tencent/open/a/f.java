package com.tencent.open.a;

import android.os.Environment;
import android.text.TextUtils;
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
import com.tencent.open.a.d;
import java.io.File;
/* loaded from: classes6.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static f f38910a;

    /* renamed from: c  reason: collision with root package name */
    public static final b f38911c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f38912d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public a f38913b;

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
        f38911c = new b(c(), c.m, c.f38903g, c.f38904h, c.f38899c, c.f38905i, 10, c.f38901e, c.n);
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
        this.f38913b = new a(f38911c);
    }

    public static f a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (f38910a == null) {
                synchronized (f.class) {
                    if (f38910a == null) {
                        f38910a = new f();
                        f38912d = true;
                    }
                }
            }
            return f38910a;
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
            String str = c.f38900d;
            boolean z = false;
            try {
                d.c b2 = d.b.b();
                if (b2 != null) {
                    if (b2.c() > c.f38902f) {
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
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f38913b) == null) {
            return;
        }
        aVar.a();
        this.f38913b.b();
        this.f38913b = null;
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            synchronized (f.class) {
                a().d();
                if (f38910a != null) {
                    f38910a = null;
                }
            }
        }
    }

    public void a(int i2, String str, String str2, Throwable th) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, str2, th}) == null) {
            if (f38912d) {
                String b2 = com.tencent.open.utils.e.b();
                if (!TextUtils.isEmpty(b2)) {
                    String str3 = b2 + " SDK_VERSION:" + com.tencent.connect.common.Constants.SDK_VERSION;
                    if (this.f38913b == null) {
                        return;
                    }
                    e.f38909a.b(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str3, null);
                    this.f38913b.b(32, Thread.currentThread(), System.currentTimeMillis(), "openSDK_LOG", str3, null);
                    f38912d = false;
                }
            }
            e.f38909a.b(i2, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
            if (!d.a.a(c.f38898b, i2) || (aVar = this.f38913b) == null) {
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
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, th) == null) {
            a().a(2, str, str2, th);
        }
    }
}
