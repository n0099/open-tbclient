package org.chromium.base;

import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import java.util.Locale;
import org.chromium.base.annotations.RemovableInRelease;
/* loaded from: classes2.dex */
public class Log {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    public static final String sDeprecatedTagPrefix = "cr.";
    public static boolean sEnableLog = false;
    public static final String sTagPrefix = "cr_";

    @RemovableInRelease
    public static boolean isDebug() {
        return true;
    }

    @RemovableInRelease
    public static void d(String str, String str2, Object... objArr) {
        Throwable throwableToLog = getThrowableToLog(objArr);
        String formatLogWithStack = formatLogWithStack(str2, throwableToLog, objArr);
        if (throwableToLog != null) {
            if (sEnableLog) {
                android.util.Log.d(normalizeTag(str), formatLogWithStack, throwableToLog);
            }
        } else if (sEnableLog) {
            android.util.Log.d(normalizeTag(str), formatLogWithStack);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        Throwable throwableToLog = getThrowableToLog(objArr);
        String formatLog = formatLog(str2, throwableToLog, objArr);
        if (throwableToLog != null) {
            if (sEnableLog) {
                android.util.Log.e(normalizeTag(str), formatLog, throwableToLog);
            }
        } else if (sEnableLog) {
            android.util.Log.e(normalizeTag(str), formatLog);
        }
    }

    public static String formatLog(String str, Throwable th, Object... objArr) {
        if (objArr != null) {
            if ((th == null && objArr.length > 0) || objArr.length > 1) {
                return String.format(Locale.US, str, objArr);
            }
            return str;
        }
        return str;
    }

    public static String formatLogWithStack(String str, Throwable th, Object... objArr) {
        return PreferencesUtil.LEFT_MOUNT + getCallOrigin() + "] " + formatLog(str, th, objArr);
    }

    public static void i(String str, String str2, Object... objArr) {
        Throwable throwableToLog = getThrowableToLog(objArr);
        String formatLog = formatLog(str2, throwableToLog, objArr);
        if (throwableToLog != null) {
            if (sEnableLog) {
                android.util.Log.i(normalizeTag(str), formatLog, throwableToLog);
            }
        } else if (sEnableLog) {
            android.util.Log.i(normalizeTag(str), formatLog);
        }
    }

    @RemovableInRelease
    public static void v(String str, String str2, Object... objArr) {
        Throwable throwableToLog = getThrowableToLog(objArr);
        String formatLogWithStack = formatLogWithStack(str2, throwableToLog, objArr);
        if (throwableToLog != null) {
            if (sEnableLog) {
                android.util.Log.v(normalizeTag(str), formatLogWithStack, throwableToLog);
            }
        } else if (sEnableLog) {
            android.util.Log.v(normalizeTag(str), formatLogWithStack);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        Throwable throwableToLog = getThrowableToLog(objArr);
        String formatLog = formatLog(str2, throwableToLog, objArr);
        if (throwableToLog != null) {
            if (sEnableLog) {
                android.util.Log.w(normalizeTag(str), formatLog, throwableToLog);
            }
        } else if (sEnableLog) {
            android.util.Log.w(normalizeTag(str), formatLog);
        }
    }

    public static void wtf(String str, String str2, Object... objArr) {
        Throwable throwableToLog = getThrowableToLog(objArr);
        String formatLog = formatLog(str2, throwableToLog, objArr);
        if (throwableToLog != null) {
            if (sEnableLog) {
                android.util.Log.wtf(normalizeTag(str), formatLog, throwableToLog);
            }
        } else if (sEnableLog) {
            android.util.Log.wtf(normalizeTag(str), formatLog);
        }
    }

    public static void enableLog(boolean z) {
        sEnableLog = z;
    }

    public static String getStackTraceString(Throwable th) {
        return android.util.Log.getStackTraceString(th);
    }

    public static Throwable getThrowableToLog(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        Object obj = objArr[objArr.length - 1];
        if (!(obj instanceof Throwable)) {
            return null;
        }
        return (Throwable) obj;
    }

    public static String normalizeTag(String str) {
        if (str.startsWith(sTagPrefix)) {
            return str;
        }
        int i = 0;
        if (str.startsWith(sDeprecatedTagPrefix)) {
            i = 3;
        }
        return sTagPrefix + str.substring(i, str.length());
    }

    @RemovableInRelease
    public static String getCallOrigin() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = Log.class.getName();
        int i = 0;
        while (true) {
            if (i >= stackTrace.length) {
                break;
            } else if (stackTrace[i].getClassName().equals(name)) {
                i += 3;
                break;
            } else {
                i++;
            }
        }
        return stackTrace[i].getFileName() + ":" + stackTrace[i].getLineNumber();
    }

    public static boolean isLoggable(String str, int i) {
        if (!isDebug() && i <= 4) {
            return false;
        }
        return android.util.Log.isLoggable(str, i);
    }
}
