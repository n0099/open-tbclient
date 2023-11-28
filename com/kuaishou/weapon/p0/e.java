package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.IStringUtil;
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
/* loaded from: classes10.dex */
public class e {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e = -1;
    public static int f = -1;
    public static ThreadLocal<StringBuilder> g;
    public static int h;
    public transient /* synthetic */ FieldHolder $fh;

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, str) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1651774886, "Lcom/kuaishou/weapon/p0/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1651774886, "Lcom/kuaishou/weapon/p0/e;");
                return;
            }
        }
        g = new ThreadLocal<>();
    }

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public static void a(int i, String str) {
        String sb;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(65539, null, i, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length < 3) {
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        Log.e("WeaponSDK", str);
                        return;
                    }
                    return;
                }
                Log.d("WeaponSDK", str);
                return;
            }
            Log.i("WeaponSDK", str);
            return;
        }
        String fileName = stackTrace[2].getFileName();
        int lineNumber = stackTrace[2].getLineNumber();
        String methodName = stackTrace[2].getMethodName();
        if (fileName.length() > 5) {
            fileName = fileName.substring(0, fileName.length() - 5);
        }
        StringBuilder sb2 = g.get();
        if (sb2 == null) {
            sb2 = new StringBuilder();
            g.set(sb2);
        }
        synchronized (sb2) {
            sb2.setLength(0);
            sb2.append(PreferencesUtil.LEFT_MOUNT);
            sb2.append(h);
            sb2.append("][");
            sb2.append(fileName);
            sb2.append(':');
            sb2.append(lineNumber);
            sb2.append(IStringUtil.EXTENSION_SEPARATOR);
            sb2.append(methodName);
            sb2.append("] ");
            sb2.append(str);
            sb = sb2.toString();
            h++;
        }
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    Log.e("WeaponSDK", sb);
                    return;
                }
                return;
            }
            Log.d("WeaponSDK", sb);
            return;
        }
        Log.i("WeaponSDK", sb);
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            int i = f;
            if (i == -1 || i == 0) {
                a(0, str);
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, str) == null) {
            int i = f;
            if (i == -1 || i == 0 || i == 1) {
                a(1, str);
            }
        }
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            int i = f;
            if (i == -1 || i == 0 || i == 1 || i == 2) {
                a(2, str);
            }
        }
    }

    public static void a(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, str, th) == null) {
            int i = f;
            if (i == -1 || i == 0) {
                a(0, str + "\n" + a(th));
            }
        }
    }

    public static void b(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, th) == null) {
            int i = f;
            if (i == -1 || i == 0 || i == 1) {
                a(1, str + "\n" + a(th));
            }
        }
    }

    public static void c(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, th) == null) {
            int i = f;
            if (i == -1 || i == 0 || i == 1 || i == 2) {
                a(2, str + "\n" + a(th));
            }
        }
    }
}
