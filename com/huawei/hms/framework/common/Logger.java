package com.huawei.hms.framework.common;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.Arrays;
import java.util.IllegalFormatException;
import org.json.JSONException;
/* loaded from: classes8.dex */
public class Logger {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int MAX_STACK_DEEP_LENGTH = 20;
    public static final int MAX_STACK_DEEP_LENGTH_NORMAL = 8;
    public static final String SPLIT = "|";
    public static final String TAG = "NetworkKit_Logger";
    public static final String TAG_NETWORKKIT_PRE = "NetworkKit_";
    public static final String TAG_NETWORK_SDK_PRE = "NetworkSdk_";
    public static ExtLogger extLogger = null;
    public static boolean kitPrint = true;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.huawei.hms.framework.common.Logger$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-156692665, "Lcom/huawei/hms/framework/common/Logger;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-156692665, "Lcom/huawei/hms/framework/common/Logger;");
        }
    }

    /* loaded from: classes8.dex */
    public static class ThrowableWrapper extends Throwable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = 7129050843360571879L;
        public transient /* synthetic */ FieldHolder $fh;
        public String message;
        public Throwable ownerThrowable;
        public Throwable thisCause;

        public ThrowableWrapper(Throwable th) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {th};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.ownerThrowable = th;
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (!(th instanceof IOException) && !(th instanceof JSONException)) {
                i = 20;
            } else {
                i = 8;
            }
            if (stackTrace.length > i) {
                setStackTrace((StackTraceElement[]) Arrays.copyOf(stackTrace, i));
            } else {
                setStackTrace(stackTrace);
            }
            setMessage(StringUtils.anonymizeMessage(th.getMessage()));
        }

        public /* synthetic */ ThrowableWrapper(Throwable th, AnonymousClass1 anonymousClass1) {
            this(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCause(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, this, th) == null) {
                this.thisCause = th;
            }
        }

        public void setMessage(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.message = str;
            }
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                Throwable th = this.thisCause;
                if (th == this) {
                    return null;
                }
                return th;
            }
            return (Throwable) invokeV.objValue;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.message;
            }
            return (String) invokeV.objValue;
        }

        @Override // java.lang.Throwable
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                Throwable th = this.ownerThrowable;
                if (th == null) {
                    return "";
                }
                String name = th.getClass().getName();
                if (this.message != null) {
                    String str = name + ": ";
                    if (this.message.startsWith(str)) {
                        return this.message;
                    }
                    return str + this.message;
                }
                return name;
            }
            return (String) invokeV.objValue;
        }
    }

    public Logger() {
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

    public static String complexAppTag(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return TAG_NETWORK_SDK_PRE + str;
        }
        return (String) invokeL.objValue;
    }

    public static String complexTag(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            return "NetworkKit_" + str;
        }
        return (String) invokeL.objValue;
    }

    public static boolean isAPPLoggable(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65551, null, i)) == null) {
            if (extLogger != null && i >= 3) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public static boolean isKitLoggable(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65552, null, i)) == null) {
            if (kitPrint && isLoggable(i)) {
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public static boolean isLoggable(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65553, null, i)) == null) {
            return Log.isLoggable("NetworkKit_", i);
        }
        return invokeI.booleanValue;
    }

    public static String complexMsg(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, str, i)) == null) {
            if (!TextUtils.isEmpty(str)) {
                return getCallMethodInfo(i) + "|" + str;
            }
            return getCallMethodInfo(i);
        }
        return (String) invokeLI.objValue;
    }

    @SuppressLint({"LogTagMismatch"})
    public static void d(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, str, obj) == null) {
            println(3, str, obj);
        }
    }

    public static void e(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, obj) == null) {
            println(6, str, obj);
        }
    }

    @SuppressLint({"LogTagMismatch"})
    public static void i(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, str, obj) == null) {
            println(4, str, obj);
        }
    }

    public static void setExtLogger(ExtLogger extLogger2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65557, null, extLogger2, z) == null) {
            extLogger = extLogger2;
            kitPrint = z;
            i(TAG, "logger = " + extLogger2 + z);
        }
    }

    public static void v(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, null, str, obj) == null) {
            println(2, str, obj);
        }
    }

    public static void w(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65560, null, str, obj) == null) {
            println(5, str, obj);
        }
    }

    @SuppressLint({"LogTagMismatch"})
    public static void d(String str, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, str, str2, objArr) == null) {
            println(3, str, str2, objArr);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, str, str2, objArr) == null) {
            println(6, str, str2, objArr);
        }
    }

    @SuppressLint({"LogTagMismatch"})
    public static void i(String str, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, str, str2, objArr) == null) {
            println(4, str, str2, objArr);
        }
    }

    public static void println(int i, String str, Object obj) {
        String obj2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeILL(65555, null, i, str, obj) != null) || i < 3) {
            return;
        }
        if (obj == null) {
            obj2 = StringUtil.NULL_STRING;
        } else {
            obj2 = obj.toString();
        }
        logPrintln(i, str, obj2);
    }

    public static void v(String str, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65559, null, str, str2, objArr) == null) {
            println(2, str, str2, objArr);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65562, null, str, str2, objArr) == null) {
            println(5, str, str2, objArr);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, str, str2, th) == null) {
            if (isAPPLoggable(6)) {
                extLogger.e(complexAppTag(str), complexMsg(str2, 5), getNewThrowable(th));
            }
            if (kitPrint) {
                Log.e(complexTag(str), complexMsg(str2, 5), getNewThrowable(th));
            }
        }
    }

    public static void extLogPrintln(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65546, null, i, str, str2) == null) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            if (i == 6) {
                                extLogger.e(str, str2);
                                return;
                            }
                            return;
                        }
                        extLogger.w(str, str2);
                        return;
                    }
                    extLogger.i(str, str2);
                    return;
                }
                extLogger.d(str, str2);
                return;
            }
            extLogger.v(str, str2);
        }
    }

    public static int logPrintln(int i, String str, String str2) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65554, null, i, str, str2)) == null) {
            if (isAPPLoggable(i)) {
                extLogPrintln(i, complexAppTag(str), complexMsg(str2, 7));
            }
            if (isKitLoggable(i)) {
                return Log.println(i, complexTag(str), complexMsg(str2, 7));
            }
            return 1;
        }
        return invokeILL.intValue;
    }

    public static void w(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65561, null, str, str2, th) == null) {
            if (isAPPLoggable(5)) {
                extLogger.w(complexAppTag(str), complexMsg(str2, 5), getNewThrowable(th));
            }
            if (kitPrint) {
                Log.w(complexTag(str), complexMsg(str2, 5), getNewThrowable(th));
            }
        }
    }

    public static String getCallMethodInfo(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65547, null, i)) == null) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace.length > i) {
                StackTraceElement stackTraceElement = stackTrace[i];
                return Thread.currentThread().getName() + "|" + stackTraceElement.getFileName() + "|" + stackTraceElement.getClassName() + "|" + stackTraceElement.getMethodName() + "|" + stackTraceElement.getLineNumber();
            }
            return "";
        }
        return (String) invokeI.objValue;
    }

    public static Throwable getNewThrowable(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, th)) == null) {
            if (isLoggable(3)) {
                return th;
            }
            if (th == null) {
                return null;
            }
            ThrowableWrapper throwableWrapper = new ThrowableWrapper(th, null);
            Throwable cause = th.getCause();
            ThrowableWrapper throwableWrapper2 = throwableWrapper;
            while (cause != null) {
                ThrowableWrapper throwableWrapper3 = new ThrowableWrapper(cause, null);
                throwableWrapper2.setCause(throwableWrapper3);
                cause = cause.getCause();
                throwableWrapper2 = throwableWrapper3;
            }
            return throwableWrapper;
        }
        return (Throwable) invokeL.objValue;
    }

    public static void println(int i, String str, String str2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65556, null, new Object[]{Integer.valueOf(i), str, str2, objArr}) != null) || i < 3) {
            return;
        }
        if (str2 == null) {
            Log.w(TAG, "format is null, not log");
            return;
        }
        try {
            logPrintln(i, str, StringUtils.format(str2, objArr));
        } catch (IllegalFormatException e) {
            w(TAG, "log format error" + str2, e);
        }
    }
}
