package com.yy.hiidostatis.inner.util.log;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
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
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static String mTag = "StatisSDK";
    public static IBaseStatisLogWriter sLogWriter;
    public static final String PREFIX_FORMAT = "[%s]";
    public static String mPrefix = String.format(PREFIX_FORMAT, "StatisSDK");
    public static boolean mIsDebugSdConfig = false;
    public static long lastLogTime = 0;
    public static int lastLogTimeCount = 0;

    public static String getTypeName(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "UNKNOWN" : "ERROR" : "WARN" : "INFO" : "DEBUG";
    }

    public static String getCallerFilename() {
        return Thread.currentThread().getStackTrace()[5].getFileName();
    }

    public static int getCallerLineNumber() {
        return Thread.currentThread().getStackTrace()[5].getLineNumber();
    }

    public static String getPreFix() {
        return mPrefix;
    }

    public static String getTag() {
        return mTag;
    }

    public static boolean isLogOn() {
        return HiidoSDK.instance().getOptions().isLogOn;
    }

    public static boolean outputDebug() {
        if (!HiidoSDK.instance().getOptions().outputDebugLog && !mIsDebugSdConfig) {
            return false;
        }
        return true;
    }

    public static void brief(String str, Object... objArr) {
        if (!isLogOn()) {
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
        if (!isLogOn()) {
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
        if (!isLogOn()) {
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

    public static void verbose(Object obj, String str, Object... objArr) {
        if (!isLogOn()) {
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

    public static void errorOn(Object obj, String str, Object... objArr) {
        try {
            String formatErrorMsg = formatErrorMsg(String.format("%s %s", getPreFix(), getLogText(obj, str, objArr)), objArr);
            Log.e(getTag(), formatErrorMsg);
            writeLog(formatErrorMsg, 4);
        } catch (Throwable th) {
            String tag = getTag();
            Log.e(tag, "Log.error exception=" + th);
        }
    }

    public static void info(Object obj, String str, Object... objArr) {
        if (!isLogOn()) {
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
        try {
            String format = String.format("%s %s", getPreFix(), getLogText(obj, str, objArr));
            Log.i(getTag(), format);
            writeLog(format, 2);
        } catch (Throwable th) {
            String tag = getTag();
            Log.e(tag, "Log.info exception=" + th);
        }
    }

    public static void warn(Object obj, String str, Object... objArr) {
        if (!isLogOn()) {
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
        try {
            String format = String.format("%s %s", getPreFix(), getLogText(obj, str, objArr));
            Log.w(getTag(), format);
            writeLog(format, 3);
        } catch (Throwable th) {
            String tag = getTag();
            Log.e(tag, "Log.warn exception=" + th);
        }
    }

    public static String formatErrorMsg(String str, Object... objArr) {
        if (objArr.length > 0 && (objArr[objArr.length - 1] instanceof Throwable)) {
            return logToFile(str, (Throwable) objArr[objArr.length - 1]);
        }
        return str;
    }

    public static String formatLog(int i, String str) {
        return String.format("%s\t%8s\t%s\t%s", getTag(), getTypeName(i), Util.formatDate("yyyy-MM-dd HH:mm:ss", System.currentTimeMillis()), str);
    }

    public static String logToFile(String str, Throwable th) {
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

    public static void writeLog(String str, int i) {
        try {
            if (sLogWriter != null) {
                sLogWriter.write(i, formatLog(i, str));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String getLogText(Object obj, String str, Object... objArr) {
        return PreferencesUtil.LEFT_MOUNT + objClassName(obj) + "] " + Util.formatStr(str, objArr);
    }

    public static void infoLimitTime(Object obj, String str, Object... objArr) {
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

    public static void initLogConfig(Context context) {
        StringBuffer stringBuffer;
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

    public static String msgForTextLog(Object obj, String str, int i, String str2) {
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

    public static String objClassName(Object obj) {
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

    public static void setLogSetting(IBaseStatisLogWriter iBaseStatisLogWriter) {
        sLogWriter = iBaseStatisLogWriter;
    }

    public static void setLogTag(String str) {
        if (str != null) {
            mTag = str;
            mPrefix = String.format(PREFIX_FORMAT, str);
        }
    }
}
