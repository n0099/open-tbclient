package com.kuaishou.weapon.un;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes7.dex */
public class q1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f53781b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f53782c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final int f53783d = 3;

    /* renamed from: e  reason: collision with root package name */
    public static final int f53784e = -1;

    /* renamed from: f  reason: collision with root package name */
    public static int f53785f = -1;

    /* renamed from: g  reason: collision with root package name */
    public static int f53786g;

    /* renamed from: h  reason: collision with root package name */
    public static ThreadLocal<StringBuilder> f53787h;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(535001424, "Lcom/kuaishou/weapon/un/q1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(535001424, "Lcom/kuaishou/weapon/un/q1;");
                return;
            }
        }
        f53787h = new ThreadLocal<>();
    }

    public q1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String a(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, th)) == null) {
            if (th == null) {
                return "";
            }
            for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
                if (th2 instanceof UnknownHostException) {
                    return "";
                }
            }
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return stringWriter.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65539, null, i2, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length < 3) {
            return;
        }
        String fileName = stackTrace[2].getFileName();
        int lineNumber = stackTrace[2].getLineNumber();
        String methodName = stackTrace[2].getMethodName();
        if (fileName.length() > 5) {
            fileName = fileName.substring(0, fileName.length() - 5);
        }
        StringBuilder sb = f53787h.get();
        if (sb == null) {
            sb = new StringBuilder();
            f53787h.set(sb);
        }
        synchronized (sb) {
            sb.setLength(0);
            sb.append(PreferencesUtil.LEFT_MOUNT);
            sb.append(f53786g);
            sb.append("][");
            sb.append(fileName);
            sb.append(':');
            sb.append(lineNumber);
            sb.append('.');
            sb.append(methodName);
            sb.append("] ");
            sb.append(str);
            sb.toString();
            f53786g++;
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            int i2 = f53785f;
            if (i2 == -1 || i2 == 0 || i2 == 1) {
                a(1, str);
            }
        }
    }

    public static void a(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, str, th) == null) {
            int i2 = f53785f;
            if (i2 == -1 || i2 == 0 || i2 == 1) {
                a(1, str + StringUtils.LF + a(th));
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, str) == null) {
            int i2 = f53785f;
            if (i2 == -1 || i2 == 0 || i2 == 1 || i2 == 2) {
                a(2, str);
            }
        }
    }

    public static void b(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, th) == null) {
            int i2 = f53785f;
            if (i2 == -1 || i2 == 0 || i2 == 1 || i2 == 2) {
                a(2, str + StringUtils.LF + a(th));
            }
        }
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            int i2 = f53785f;
            if (i2 == -1 || i2 == 0) {
                a(0, str);
            }
        }
    }

    public static void c(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, th) == null) {
            int i2 = f53785f;
            if (i2 == -1 || i2 == 0) {
                a(0, str + StringUtils.LF + a(th));
            }
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
        }
    }
}
