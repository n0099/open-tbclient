package com.dxmpay.apollon.utils;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.ApollonConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes12.dex */
public final class LogUtil {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean DEBUG;
    public static final boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f55182b;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f55183c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f55184d;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f55185e;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1437985431, "Lcom/dxmpay/apollon/utils/LogUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1437985431, "Lcom/dxmpay/apollon/utils/LogUtil;");
                return;
            }
        }
        boolean z = ApollonConstants.DEBUG;
        DEBUG = z;
        a = z;
        f55182b = z;
        f55183c = z;
        f55184d = z;
        f55185e = z;
    }

    public LogUtil() {
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

    public static void d(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) && f55182b) {
            TextUtils.isEmpty(str2);
            TextUtils.isEmpty(str);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2, th) == null) && f55185e) {
            TextUtils.isEmpty(str2);
            TextUtils.isEmpty(str);
        }
    }

    public static void errord(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, str) == null) && ApollonConstants.DEBUG) {
            String str2 = getTAG() + "---" + str;
        }
    }

    public static String getTAG() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            try {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                StringBuilder sb = new StringBuilder();
                if (stackTrace != null) {
                    StackTraceElement stackTraceElement = stackTrace[4];
                    sb.append(((Object) stackTraceElement.getFileName().subSequence(0, stackTraceElement.getFileName().length() - 5)) + "." + stackTraceElement.getMethodName() + "#" + stackTraceElement.getLineNumber());
                }
                return sb.toString();
            } catch (NullPointerException unused) {
                return "PROGUARDED";
            }
        }
        return (String) invokeV.objValue;
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65544, null, str, str2) == null) && f55183c) {
            TextUtils.isEmpty(str2);
            TextUtils.isEmpty(str);
        }
    }

    public static void logd(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, null, str) == null) && ApollonConstants.DEBUG) {
            String str2 = getTAG() + "---" + str + "#pid=" + Process.myPid();
        }
    }

    public static void mark() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65547, null) == null) && ApollonConstants.DEBUG) {
            getTAG();
        }
    }

    public static void saveLog(Context context, String str) {
        String absolutePath;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65549, null, context, str) == null) && f55182b) {
            String str2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS    ", Locale.ENGLISH).format(new Date()) + str + org.apache.commons.lang3.StringUtils.LF;
            try {
                File externalFilesDir = context.getExternalFilesDir(null);
                if (externalFilesDir != null) {
                    absolutePath = externalFilesDir.getAbsolutePath();
                } else {
                    absolutePath = context.getFilesDir().getAbsolutePath();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(new File(absolutePath + "/wallet.log"), true);
                fileOutputStream.write(str2.getBytes());
                fileOutputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void traces() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65550, null) == null) && ApollonConstants.DEBUG) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            StringBuilder sb = new StringBuilder();
            if (stackTrace != null) {
                StackTraceElement stackTraceElement = stackTrace[3];
                sb.append(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "#line=" + stackTraceElement.getLineNumber() + "的调用：\n");
                for (int i2 = 4; i2 < stackTrace.length && i2 < 15; i2++) {
                    StackTraceElement stackTraceElement2 = stackTrace[i2];
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i2 - 4);
                    sb2.append("--");
                    sb2.append(stackTraceElement2.getClassName());
                    sb2.append(".");
                    sb2.append(stackTraceElement2.getMethodName());
                    sb2.append("(...)#line:");
                    sb2.append(stackTraceElement2.getLineNumber());
                    sb2.append(org.apache.commons.lang3.StringUtils.LF);
                    sb.append(sb2.toString());
                }
            }
            String str = getTAG() + "--" + sb.toString();
        }
    }

    public static void v(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65551, null, str, str2) == null) && a) {
            TextUtils.isEmpty(str2);
            TextUtils.isEmpty(str);
        }
    }

    public static void w(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65552, null, str, str2) == null) && f55184d) {
            TextUtils.isEmpty(str2);
            TextUtils.isEmpty(str);
        }
    }

    public static void errord(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, str, str2) == null) && ApollonConstants.DEBUG) {
            String str3 = getTAG() + "---" + str2;
        }
    }

    public static void logd(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65546, null, str, str2) == null) && ApollonConstants.DEBUG) {
            String str3 = getTAG() + "---" + str2;
        }
    }

    public static void mark(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65548, null, str) == null) && ApollonConstants.DEBUG) {
            String str2 = getTAG() + "---" + str;
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            d(ApollonConstants.APOLLON_REST_TAG, str);
        }
    }
}
