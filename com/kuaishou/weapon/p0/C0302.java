package com.kuaishou.weapon.p0;

import android.text.TextUtils;
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
/* renamed from: com.kuaishou.weapon.p0.ʻˋ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0302 {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: ʻ  reason: contains not printable characters */
    public static final int f24 = 0;

    /* renamed from: ʼ  reason: contains not printable characters */
    public static final int f25 = 1;

    /* renamed from: ʽ  reason: contains not printable characters */
    public static final int f26 = 2;

    /* renamed from: ʾ  reason: contains not printable characters */
    public static final int f27 = 3;

    /* renamed from: ʿ  reason: contains not printable characters */
    public static final int f28 = -1;

    /* renamed from: ˆ  reason: contains not printable characters */
    public static int f29 = -1;

    /* renamed from: ˈ  reason: contains not printable characters */
    public static int f30 = 0;

    /* renamed from: ˉ  reason: contains not printable characters */
    public static final boolean f31 = true;

    /* renamed from: ˊ  reason: contains not printable characters */
    public static ThreadLocal<StringBuilder> f32;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(335181159, "Lcom/kuaishou/weapon/p0/ʻˋ;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(335181159, "Lcom/kuaishou/weapon/p0/ʻˋ;");
                return;
            }
        }
        f32 = new ThreadLocal<>();
    }

    public C0302() {
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public static String m164(Throwable th) {
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

    /* renamed from: ʻ  reason: contains not printable characters */
    public static void m165(int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65539, null, i, str) == null) || TextUtils.isEmpty(str)) {
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
        StringBuilder sb = f32.get();
        if (sb == null) {
            sb = new StringBuilder();
            f32.set(sb);
        }
        synchronized (sb) {
            sb.setLength(0);
            sb.append(PreferencesUtil.LEFT_MOUNT);
            sb.append(f30);
            sb.append("][");
            sb.append(fileName);
            sb.append(':');
            sb.append(lineNumber);
            sb.append(IStringUtil.EXTENSION_SEPARATOR);
            sb.append(methodName);
            sb.append("] ");
            sb.append(str);
            f30++;
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static void m166(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) {
            int i = f29;
            if (i == -1 || i == 0 || i == 1) {
                m165(1, str);
            }
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static void m167(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, str, th) == null) {
            int i = f29;
            if (i == -1 || i == 0 || i == 1) {
                m165(1, str + "\n" + m164(th));
            }
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static void m168(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, str) == null) {
            int i = f29;
            if (i == -1 || i == 0 || i == 1 || i == 2) {
                m165(2, str);
            }
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static void m169(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, th) == null) {
            int i = f29;
            if (i == -1 || i == 0 || i == 1 || i == 2) {
                m165(2, str + "\n" + m164(th));
            }
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public static void m170(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            int i = f29;
            if (i == -1 || i == 0) {
                m165(0, str);
            }
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public static void m171(String str, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, th) == null) {
            int i = f29;
            if (i == -1 || i == 0) {
                m165(0, str + "\n" + m164(th));
            }
        }
    }
}
