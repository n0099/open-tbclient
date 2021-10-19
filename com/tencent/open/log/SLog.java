package com.tencent.open.log;

import android.os.Environment;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.d;
import java.io.File;
/* loaded from: classes10.dex */
public class SLog implements TraceLevel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "openSDK_LOG";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f76722c;
    public static SLog instance;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public a f76723a;

    /* renamed from: b  reason: collision with root package name */
    public Tracer f76724b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(998197758, "Lcom/tencent/open/log/SLog;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(998197758, "Lcom/tencent/open/log/SLog;");
        }
    }

    public SLog() {
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
        this.f76723a = new a(new b(a(), c.m, c.f76754g, c.f76755h, c.f76750c, c.f76756i, 10, c.f76752e, c.n));
    }

    public static final void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) {
            getInstance().a(2, str, str2, null);
        }
    }

    public static final void e(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, str2) == null) {
            getInstance().a(16, str, str2, null);
        }
    }

    public static void flushLogs() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            getInstance().c();
        }
    }

    public static SLog getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            if (instance == null) {
                synchronized (SLog.class) {
                    if (instance == null) {
                        instance = new SLog();
                        f76722c = true;
                    }
                }
            }
            return instance;
        }
        return (SLog) invokeV.objValue;
    }

    public static final void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) {
            getInstance().a(4, str, str2, null);
        }
    }

    public static void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
            synchronized (SLog.class) {
                getInstance().b();
                if (instance != null) {
                    instance = null;
                }
            }
        }
    }

    public static final void u(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, str, str2) == null) {
            getInstance().a(32, str, str2, null);
        }
    }

    public static final void v(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, str, str2) == null) {
            getInstance().a(1, str, str2, null);
        }
    }

    public static final void w(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, str, str2) == null) {
            getInstance().a(8, str, str2, null);
        }
    }

    public void a(int i2, String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), str, str2, th}) == null) {
            if (f76722c) {
                String b2 = com.tencent.open.utils.f.b();
                if (!TextUtils.isEmpty(b2)) {
                    String str3 = b2 + " SDK_VERSION:" + Constants.SDK_VERSION;
                    if (this.f76723a == null) {
                        return;
                    }
                    e.f76761a.a(32, Thread.currentThread(), System.currentTimeMillis(), TAG, str3, null);
                    this.f76723a.a(32, Thread.currentThread(), System.currentTimeMillis(), TAG, str3, null);
                    f76722c = false;
                }
            }
            e.f76761a.a(i2, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
            if (d.a.a(c.f76749b, i2)) {
                a aVar = this.f76723a;
                if (aVar == null) {
                    return;
                }
                aVar.a(i2, Thread.currentThread(), System.currentTimeMillis(), str, str2, th);
            }
            Tracer tracer = this.f76724b;
            if (tracer != null) {
                try {
                    tracer.a(i2, Thread.currentThread(), System.currentTimeMillis(), str, a(str2), th);
                } catch (Exception unused) {
                }
            }
        }
    }

    public void b() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (aVar = this.f76723a) == null) {
            return;
        }
        aVar.a();
        this.f76723a.b();
        this.f76723a = null;
    }

    public void c() {
        a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(com.baidu.android.imsdk.internal.Constants.METHOD_SEND_USER_MSG, this) == null) || (aVar = this.f76723a) == null) {
            return;
        }
        aVar.a();
    }

    public void setCustomLogger(Tracer tracer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tracer) == null) {
            this.f76724b = tracer;
        }
    }

    public static final void d(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, str, str2, th) == null) {
            getInstance().a(2, str, str2, th);
        }
    }

    public static final void e(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, str2, th) == null) {
            getInstance().a(16, str, str2, th);
        }
    }

    public static final void i(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, str, str2, th) == null) {
            getInstance().a(4, str, str2, th);
        }
    }

    public static final void u(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, str, str2, th) == null) {
            getInstance().a(32, str, str2, th);
        }
    }

    public static final void v(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65552, null, str, str2, th) == null) {
            getInstance().a(1, str, str2, th);
        }
    }

    public static final void w(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65554, null, str, str2, th) == null) {
            getInstance().a(8, str, str2, th);
        }
    }

    private String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) ? TextUtils.isEmpty(str) ? "" : d.a(str) ? "xxxxxx" : str : (String) invokeL.objValue;
    }

    public static File a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = c.f76751d;
            try {
                d.c b2 = d.b.b();
                if (b2 != null && b2.c() > c.f76753f) {
                    return new File(Environment.getExternalStorageDirectory(), str);
                }
                return new File(com.tencent.open.utils.f.c(), str);
            } catch (Throwable th) {
                e(TAG, "getLogFilePath:", th);
                return null;
            }
        }
        return (File) invokeV.objValue;
    }
}
