package com.fun.ad.sdk.internal.api.utils;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.FunAdSdk;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes11.dex */
public final class LogPrinter {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FunAdSdk";

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f62864a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1148640567, "Lcom/fun/ad/sdk/internal/api/utils/LogPrinter;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1148640567, "Lcom/fun/ad/sdk/internal/api/utils/LogPrinter;");
                return;
            }
        }
        f62864a = Pattern.compile("(\\$\\d+)+$");
    }

    public LogPrinter() {
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

    public static void a(Throwable th, int i2, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLILL(65538, null, th, i2, str, objArr) == null) && FunAdSdk.isLogEnabled()) {
            try {
                StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                StackTraceElement stackTraceElement = stackTrace[2];
                if (str == null) {
                    str = stackTraceElement.getMethodName();
                } else if (objArr != null && objArr.length != 0) {
                    str = String.format(str, objArr);
                }
                String className = stackTrace[2].getClassName();
                Matcher matcher = f62864a.matcher(className);
                String str2 = "";
                if (matcher.find()) {
                    className = matcher.replaceAll("");
                }
                Object[] objArr2 = new Object[3];
                objArr2[0] = className.substring(className.lastIndexOf(46) + 1);
                objArr2[1] = str;
                if (th != null) {
                    str2 = StringUtils.LF + Log.getStackTraceString(th);
                }
                objArr2[2] = str2;
                Log.println(i2, TAG, String.format("[%s] %s%s", objArr2));
            } catch (Exception e2) {
                e(e2);
            }
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            a(null, 3, null, new Object[0]);
        }
    }

    public static void d(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, objArr) == null) {
            a(null, 3, str, objArr);
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            a(null, 6, null, new Object[0]);
        }
    }

    public static void e(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, objArr) == null) {
            a(null, 6, str, objArr);
        }
    }

    public static void e(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, th) == null) {
            a(th, 6, "", new Object[0]);
        }
    }

    public static void e(Throwable th, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, th, str, objArr) == null) {
            a(th, 6, str, objArr);
        }
    }

    public static void v(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, objArr) == null) {
            a(null, 2, str, objArr);
        }
    }
}
