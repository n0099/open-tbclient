package d.a.q0.a.e0;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bumptech.glide.load.engine.GlideException;
import d.a.q0.a.g1.f;
import d.a.q0.a.h;
import d.a.q0.a.k;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f47286a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(114164386, "Ld/a/q0/a/e0/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(114164386, "Ld/a/q0/a/e0/d;");
        }
    }

    public static void a(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, str, objArr) == null) && k.f49133a && objArr != null) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : objArr) {
                if (obj != null) {
                    sb.append(obj.toString());
                }
            }
            Log.d(str, sb.toString());
        }
    }

    public static void b(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
            j("error", str, str2);
            d.a.q0.a.c1.a.g0().e(str, str2);
            if (k.f49133a) {
                Log.e(str, str2);
            }
        }
    }

    public static void c(String str, String str2, Throwable th) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, str, str2, th) == null) {
            if (th != null) {
                str3 = "Exception:" + th.getMessage() + "\n" + str2;
            } else {
                str3 = str2;
            }
            j("error", str, str3);
            d.a.q0.a.c1.a.g0().e(str, str2, th);
            if (k.f49133a) {
                Log.e(str, str2, th);
            }
        }
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) ? f47286a : invokeV.booleanValue;
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace != null && stackTrace.length > 5) {
                return stackTrace[5].getFileName();
            }
            return AppRuntime.getAppContext().getString(h.aiapps_err_message_get_name_fail);
        }
        return (String) invokeV.objValue;
    }

    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace == null || stackTrace.length <= 5) {
                return -1;
            }
            return stackTrace[5].getLineNumber();
        }
        return invokeV.intValue;
    }

    public static void g(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, str2) == null) {
            j("info", str, str2);
            d.a.q0.a.c1.a.g0().i(str, str2);
            if (k.f49133a) {
                Log.i(str, str2);
            }
        }
    }

    public static void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) {
            d.a.q0.a.c1.a.g0().i(str, str2);
            if (k.f49133a) {
                Log.i(str, str2);
            }
        }
    }

    public static void i(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, str, str2, th) == null) {
            d.a.q0.a.c1.a.g0().e(str, str2, th);
            if (k.f49133a) {
                Log.e(str, str2, th);
            }
        }
    }

    public static void j(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65546, null, str, str2, str3) == null) && !TextUtils.isEmpty(str3) && f47286a) {
            StringBuilder sb = new StringBuilder();
            String b2 = d.a.q0.a.v2.k.b(d.a.q0.a.v2.k.a(), "yyyy-MM-dd HH:mm:ss");
            String e2 = e();
            int f2 = f();
            sb.append(b2);
            sb.append(GlideException.IndentedAppendable.INDENT);
            sb.append(e2);
            sb.append(GlideException.IndentedAppendable.INDENT);
            sb.append("line:");
            sb.append(f2);
            sb.append("\n");
            sb.append("module:");
            sb.append(str2);
            sb.append("\n");
            sb.append(str3);
            f.V().q().g0(str, sb.toString());
        }
    }

    public static void k(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65547, null, z) == null) {
            f47286a = z;
        }
    }

    public static void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, str2) == null) {
            j("warn", str, str2);
            d.a.q0.a.c1.a.g0().w(str, str2);
            if (k.f49133a) {
                Log.w(str, str2);
            }
        }
    }
}
