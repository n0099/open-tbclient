package com.yy.hiidostatis.inner.util.log;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.mobads.container.util.AdIconUtil;
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
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes2.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void brief(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, str, objArr) == null) && isLogOn()) {
            try {
                if (outputDebug()) {
                    String format = String.format("%s %s", getPreFix(), getLogText(null, str, objArr));
                    getTag();
                    writeLog(format, 1);
                }
            } catch (Throwable th) {
                getTag();
                String str2 = "Log.brief exception=" + th;
            }
        }
    }

    public static void debug(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65539, null, obj, str, objArr) == null) && isLogOn()) {
            try {
                if (outputDebug()) {
                    String format = String.format("%s %s", getPreFix(), getLogText(obj, str, objArr));
                    getTag();
                    writeLog(format, 1);
                }
            } catch (Throwable th) {
                getTag();
                String str2 = "Log.debug exception=" + th;
            }
        }
    }

    public static void error(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, str, objArr) == null) && isLogOn()) {
            try {
                String formatErrorMsg = formatErrorMsg(String.format("%s %s", getPreFix(), getLogText(obj, str, objArr)), objArr);
                getTag();
                writeLog(formatErrorMsg, 4);
            } catch (Throwable th) {
                getTag();
                String str2 = "Log.error exception=" + th;
            }
        }
    }

    public static void errorOn(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, obj, str, objArr) == null) {
            try {
                String formatErrorMsg = formatErrorMsg(String.format("%s %s", getPreFix(), getLogText(obj, str, objArr)), objArr);
                getTag();
                writeLog(formatErrorMsg, 4);
            } catch (Throwable th) {
                getTag();
                String str2 = "Log.error exception=" + th;
            }
        }
    }

    public static String formatErrorMsg(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, str, objArr)) == null) ? (objArr.length <= 0 || !(objArr[objArr.length + (-1)] instanceof Throwable)) ? str : logToFile(str, (Throwable) objArr[objArr.length - 1]) : (String) invokeLL.objValue;
    }

    public static String formatLog(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65543, null, i2, str)) == null) ? String.format("%s\t%8s\t%s\t%s", getTag(), getTypeName(i2), Util.formatDate("yyyy-MM-dd HH:mm:ss", System.currentTimeMillis()), str) : (String) invokeIL.objValue;
    }

    public static String getCallerFilename() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? Thread.currentThread().getStackTrace()[5].getFileName() : (String) invokeV.objValue;
    }

    public static int getCallerLineNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? Thread.currentThread().getStackTrace()[5].getLineNumber() : invokeV.intValue;
    }

    public static String getLogText(Object obj, String str, Object... objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65546, null, obj, str, objArr)) == null) {
            return PreferencesUtil.LEFT_MOUNT + objClassName(obj) + "] " + Util.formatStr(str, objArr);
        }
        return (String) invokeLLL.objValue;
    }

    public static String getPreFix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) ? mPrefix : (String) invokeV.objValue;
    }

    public static String getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? mTag : (String) invokeV.objValue;
    }

    public static String getTypeName(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65549, null, i2)) == null) ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? RomUtils.UNKNOWN : "ERROR" : "WARN" : "INFO" : "DEBUG" : (String) invokeI.objValue;
    }

    public static void info(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65550, null, obj, str, objArr) == null) && isLogOn()) {
            try {
                String format = String.format("%s %s", getPreFix(), getLogText(obj, str, objArr));
                getTag();
                writeLog(format, 2);
            } catch (Throwable th) {
                getTag();
                String str2 = "Log.info exception=" + th;
            }
        }
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

    public static void infoOn(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65552, null, obj, str, objArr) == null) {
            try {
                String format = String.format("%s %s", getPreFix(), getLogText(obj, str, objArr));
                getTag();
                writeLog(format, 2);
            } catch (Throwable th) {
                getTag();
                String str2 = "Log.info exception=" + th;
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
                            } catch (IOException unused) {
                            }
                        }
                        throw th3;
                    }
                }
            } catch (IOException unused2) {
            }
        }
    }

    public static boolean isLogOn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) ? HiidoSDK.instance().getOptions().isLogOn : invokeV.booleanValue;
    }

    public static String logToFile(String str, Throwable th) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, str, th)) == null) {
            StringWriter stringWriter = new StringWriter();
            stringWriter.write(str);
            stringWriter.write(StringUtils.LF);
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            String stringWriter2 = stringWriter.toString();
            try {
                printWriter.close();
                stringWriter.close();
            } catch (IOException unused) {
            }
            return stringWriter2;
        }
        return (String) invokeLL.objValue;
    }

    public static String msgForTextLog(Object obj, String str, int i2, String str2) {
        InterceptResult invokeLLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLIL = interceptable.invokeLLIL(65556, null, obj, str, i2, str2)) == null) {
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
            sb.append(i2);
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

    public static boolean outputDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) ? HiidoSDK.instance().getOptions().outputDebugLog || mIsDebugSdConfig : invokeV.booleanValue;
    }

    public static void setLogSetting(IBaseStatisLogWriter iBaseStatisLogWriter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, iBaseStatisLogWriter) == null) {
            sLogWriter = iBaseStatisLogWriter;
        }
    }

    public static void setLogTag(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65560, null, str) == null) || str == null) {
            return;
        }
        mTag = str;
        mPrefix = String.format(PREFIX_FORMAT, str);
    }

    public static void verbose(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65561, null, obj, str, objArr) == null) && isLogOn()) {
            try {
                if (outputDebug()) {
                    String format = String.format("%s %s", getPreFix(), getLogText(obj, str, objArr));
                    getTag();
                    writeLog(format, 1);
                }
            } catch (Throwable th) {
                getTag();
                String str2 = "Log.verbose exception=" + th;
            }
        }
    }

    public static void warn(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65562, null, obj, str, objArr) == null) && isLogOn()) {
            try {
                String format = String.format("%s %s", getPreFix(), getLogText(obj, str, objArr));
                getTag();
                writeLog(format, 3);
            } catch (Throwable th) {
                getTag();
                String str2 = "Log.warn exception=" + th;
            }
        }
    }

    public static void warnOn(Object obj, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65563, null, obj, str, objArr) == null) {
            try {
                String format = String.format("%s %s", getPreFix(), getLogText(obj, str, objArr));
                getTag();
                writeLog(format, 3);
            } catch (Throwable th) {
                getTag();
                String str2 = "Log.warn exception=" + th;
            }
        }
    }

    public static void writeLog(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65564, null, str, i2) == null) {
            try {
                if (sLogWriter != null) {
                    sLogWriter.write(i2, formatLog(i2, str));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
