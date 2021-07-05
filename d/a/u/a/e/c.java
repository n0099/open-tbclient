package d.a.u.a.e;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
/* loaded from: classes9.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static String f70557a = "liteUBC";

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f70558b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-953875281, "Ld/a/u/a/e/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-953875281, "Ld/a/u/a/e/c;");
                return;
            }
        }
        f70558b = d.a.u.a.a.d().b();
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65537, null, str, str2) == null) && f70558b) {
            String str3 = f70557a;
            Log.d(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65538, null, str, str2, th) == null) && f70558b) {
            String str3 = f70557a;
            Log.e(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2, th);
        }
    }

    public static void c(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) && f70558b) {
            String str3 = f70557a;
            Log.i(str3, str + ZeusCrashHandler.NAME_SEPERATOR + str2);
        }
    }
}
