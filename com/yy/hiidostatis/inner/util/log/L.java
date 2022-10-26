package com.yy.hiidostatis.inner.util.log;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.api.HiidoSDK;
import com.yy.hiidostatis.inner.util.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;
/* loaded from: classes8.dex */
public class L {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String PREFIX_FORMAT = "[%s]";
    public static long lastLogTime = 0;
    public static int lastLogTimeCount = 0;
    public static boolean mIsDebugSdConfig = false;
    public static String mPrefix = null;
    public static String mTag = "StatisSDK";
    public static IBaseStatisLogWriter sLogWriter;
    public transient /* synthetic */ FieldHolder $fh;

    public static String getTypeName(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65549, null, i)) == null) ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? RomUtils.UNKNOWN : "ERROR" : "WARN" : "INFO" : "DEBUG" : (String) invokeI.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(735961787, "Lcom/yy/hiidostatis/inner/util/log/L;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(735961787, "Lcom/yy/hiidostatis/inner/util/log/L;");
                return;
            }
        }
        mPrefix = String.format(PREFIX_FORMAT, "StatisSDK");
        mIsDebugSdConfig = false;
        lastLogTime = 0L;
        lastLogTimeCount = 0;
    }

    public L() {
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

    public static String getCallerFilename() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return Thread.currentThread().getStackTrace()[5].getFileName();
        }
        return (String) invokeV.objValue;
    }

    public static int getCallerLineNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return Thread.currentThread().getStackTrace()[5].getLineNumber();
        }
        return invokeV.intValue;
    }

    public static String getPreFix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return mPrefix;
        }
        return (String) invokeV.objValue;
    }

    public static String getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return mTag;
        }
        return (String) invokeV.objValue;
    }

    public static boolean isLogOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            return HiidoSDK.instance().getOptions().isLogOn;
        }
        return invokeV.booleanValue;
    }

    public static boolean outputDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            if (!HiidoSDK.instance().getOptions().outputDebugLog && !mIsDebugSdConfig) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static void brief(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, str, objArr) != null) || !isLogOn()) {
            return;
        }
        try {
            if (outputDebug()) {
                String format = String.format("%s %s", getPreFix(), getLogText(null, str, objArr));
                Log.i(getTag(), format);
                writeLog(format, 1);
            }
        } catch (Throwable th) {
            String tag = getTag();
            Log.e(tag, "Log.brief exception=" + th);
        }
    }

    public static void debug(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65539, null, obj, str, objArr) != null) || !isLogOn()) {
            return;
        }
        try {
            if (outputDebug()) {
                String format = String.format("%s %s", getPreFix(), getLogText(obj, str, objArr));
                Log.i(getTag(), format);
                writeLog(format, 1);
            }
        } catch (Throwable th) {
            String tag = getTag();
            Log.e(tag, "Log.debug exception=" + th);
        }
    }

    public static void error(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, str, objArr) != null) || !isLogOn()) {
            return;
        }
        try {
            String formatErrorMsg = formatErrorMsg(String.format("%s %s", getPreFix(), getLogText(obj, str, objArr)), objArr);
            Log.e(getTag(), formatErrorMsg);
            writeLog(formatErrorMsg, 4);
        } catch (Throwable th) {
            String tag = getTag();
            Log.e(tag, "Log.error exception=" + th);
        }
    }

    public static void errorOn(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, obj, str, objArr) == null) {
            try {
                String formatErrorMsg = formatErrorMsg(String.format("%s %s", getPreFix(), getLogText(obj, str, objArr)), objArr);
                Log.e(getTag(), formatErrorMsg);
                writeLog(formatErrorMsg, 4);
            } catch (Throwable th) {
                String tag = getTag();
                Log.e(tag, "Log.error exception=" + th);
            }
        }
    }

    public static void info(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65550, null, obj, str, objArr) != null) || !isLogOn()) {
            return;
        }
        try {
            String format = String.format("%s %s", getPreFix(), getLogText(obj, str, objArr));
            Log.i(getTag(), format);
            writeLog(format, 2);
        } catch (Throwable th) {
            String tag = getTag();
            Log.e(tag, "Log.info exception=" + th);
        }
    }

    public static void infoOn(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65552, null, obj, str, objArr) == null) {
            try {
                String format = String.format("%s %s", getPreFix(), getLogText(obj, str, objArr));
                Log.i(getTag(), format);
                writeLog(format, 2);
            } catch (Throwable th) {
                String tag = getTag();
                Log.e(tag, "Log.info exception=" + th);
            }
        }
    }

    public static void verbose(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65561, null, obj, str, objArr) != null) || !isLogOn()) {
            return;
        }
        try {
            if (outputDebug()) {
                String format = String.format("%s %s", getPreFix(), getLogText(obj, str, objArr));
                Log.i(getTag(), format);
                writeLog(format, 1);
            }
        } catch (Throwable th) {
            String tag = getTag();
            Log.e(tag, "Log.verbose exception=" + th);
        }
    }

    public static void warn(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65562, null, obj, str, objArr) != null) || !isLogOn()) {
            return;
        }
        try {
            String format = String.format("%s %s", getPreFix(), getLogText(obj, str, objArr));
            Log.w(getTag(), format);
            writeLog(format, 3);
        } catch (Throwable th) {
            String tag = getTag();
            Log.e(tag, "Log.warn exception=" + th);
        }
    }

    public static void warnOn(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65563, null, obj, str, objArr) == null) {
            try {
                String format = String.format("%s %s", getPreFix(), getLogText(obj, str, objArr));
                Log.w(getTag(), format);
                writeLog(format, 3);
            } catch (Throwable th) {
                String tag = getTag();
                Log.e(tag, "Log.warn exception=" + th);
            }
        }
    }

    public static String formatErrorMsg(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, objArr)) == null) {
            if (objArr.length > 0 && (objArr[objArr.length - 1] instanceof Throwable)) {
                return logToFile(str, (Throwable) objArr[objArr.length - 1]);
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public static void writeLog(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65564, null, str, i) == null) {
            try {
                if (sLogWriter != null) {
                    sLogWriter.write(i, formatLog(i, str));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static String formatLog(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65543, null, i, str)) == null) {
            return String.format("%s\t%8s\t%s\t%s", getTag(), getTypeName(i), Util.formatDate("yyyy-MM-dd HH:mm:ss", System.currentTimeMillis()), str);
        }
        return (String) invokeIL.objValue;
    }

    public static String logToFile(String str, Throwable th) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, str, th)) == null) {
            StringWriter stringWriter = new StringWriter();
            stringWriter.write(str);
            stringWriter.write("\n");
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            String stringWriter2 = stringWriter.toString();
            try {
                printWriter.close();
                stringWriter.close();
            } catch (IOException e) {
                Log.e("L", "", e);
            }
            return stringWriter2;
        }
        return (String) invokeLL.objValue;
    }

    public static String getLogText(Object obj, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, obj, str, objArr)) == null) {
            return PreferencesUtil.LEFT_MOUNT + objClassName(obj) + "] " + Util.formatStr(str, objArr);
        }
        return (String) invokeLLL.objValue;
    }

    public static void infoLimitTime(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, obj, str, objArr) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - lastLogTime > 60000) {
                lastLogTimeCount = 0;
            }
            if (lastLogTimeCount < 20) {
                info(obj, str, objArr);
                lastLogTimeCount++;
                lastLogTime = currentTimeMillis;
            }
        }
    }

    public static void initLogConfig(Context context) {
        StringBuffer stringBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, context) == null) {
            FileInputStream fileInputStream = null;
            try {
                try {
                    stringBuffer = new StringBuffer();
                } catch (Throwable th) {
                    th = th;
                }
                if (context.getExternalCacheDir() == null) {
                    return;
                }
                stringBuffer.append(context.getExternalFilesDir(null).getAbsolutePath());
                stringBuffer.append(File.separator);
                stringBuffer.append("hdconfig.txt");
                String stringBuffer2 = stringBuffer.toString();
                stringBuffer.setLength(0);
                File file = new File(stringBuffer2);
                if (!file.exists()) {
                    debug(mTag, "initLogConfig is empty", new Object[0]);
                    return;
                }
                Properties properties = new Properties();
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    properties.load(fileInputStream2);
                    boolean parseBoolean = Boolean.parseBoolean(properties.getProperty("isDebug"));
                    mIsDebugSdConfig = parseBoolean;
                    debug(mTag, "initLogConfig,mIsDebugSdConfig=%b,mIsLogOnSdConfig=%b", Boolean.valueOf(parseBoolean));
                    fileInputStream2.close();
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    try {
                        th.printStackTrace();
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                    } catch (Throwable th3) {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e) {
                                Log.e("L", "", e);
                            }
                        }
                        throw th3;
                    }
                }
            } catch (IOException e2) {
                Log.e("L", "", e2);
            }
        }
    }

    public static String msgForTextLog(Object obj, String str, int i, String str2) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65556, null, obj, str, i, str2)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append("(P:");
            sb.append(Process.myPid());
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            sb.append("(T:");
            sb.append(Thread.currentThread().getId());
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            sb.append("(C:");
            sb.append(objClassName(obj));
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            sb.append("at (");
            sb.append(str);
            sb.append(":");
            sb.append(i);
            sb.append(SmallTailInfo.EMOTION_SUFFIX);
            String sb2 = sb.toString();
            sb.setLength(0);
            return sb2;
        }
        return (String) invokeLLIL.objValue;
    }

    public static String objClassName(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, obj)) == null) {
            if (obj == null) {
                return "";
            }
            if (obj instanceof String) {
                return (String) obj;
            }
            String simpleName = obj.getClass().getSimpleName();
            if (TextUtils.isEmpty(simpleName)) {
                String name = obj.getClass().getName();
                return name.substring(name.lastIndexOf(46) + 1);
            }
            return simpleName;
        }
        return (String) invokeL.objValue;
    }

    public static void setLogSetting(IBaseStatisLogWriter iBaseStatisLogWriter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, iBaseStatisLogWriter) == null) {
            sLogWriter = iBaseStatisLogWriter;
        }
    }

    public static void setLogTag(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65560, null, str) == null) && str != null) {
            mTag = str;
            mPrefix = String.format(PREFIX_FORMAT, str);
        }
    }
}
