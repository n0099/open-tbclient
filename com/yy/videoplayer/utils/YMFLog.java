package com.yy.videoplayer.utils;

import android.util.Log;
import com.yy.videoplayer.Constant;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.IllegalFormatException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes6.dex */
public class YMFLog {
    private static ILog mLogger = null;
    private static boolean mIsDebug = false;
    private static boolean mShowLines = true;
    private static boolean mShowFileName = true;
    private static boolean mShowFuncName = false;
    private static boolean mShowIdentity = true;
    private static boolean mIsSaveToFile = false;
    private static boolean mCloseLog = false;
    private static String mLogPath = null;
    private static ExecutorService mSingleThreadPool = Executors.newSingleThreadExecutor(new YMFLogThreadFactory());

    private static String tag() {
        return "YMFPlay";
    }

    private static boolean isDebuggable() {
        return mIsDebug;
    }

    private static boolean isSaveToFile() {
        return mIsSaveToFile;
    }

    public static void CloseLog() {
        mCloseLog = true;
    }

    public static void OpenLog() {
        mCloseLog = false;
    }

    public static void setFilePath(String str) {
        mLogPath = str;
        LogToES.setLogPath(str);
    }

    public static void setDebug(boolean z) {
        mIsDebug = z;
    }

    public static void setSaveToFile(boolean z) {
        mIsSaveToFile = z;
    }

    public static void registerLogger(Object obj) {
        mLogger = (ILog) obj;
    }

    public static void debug(Object obj, String str, String str2, Object... objArr) {
        if (!mCloseLog && isDebuggable()) {
            try {
                String msgForTextLog = msgForTextLog(obj, str, String.format(str2, objArr));
                if (mLogger != null) {
                    mLogger.debug(tag(), msgForTextLog);
                } else {
                    Log.d(tag(), msgForTextLog);
                }
                if (isSaveToFile() && BasicFileUtils.externalStorageExist()) {
                    logToFile(msgForTextLog);
                }
            } catch (NullPointerException e) {
                Log.e(tag(), "NullPointerException happened: ", e);
            } catch (IllegalFormatException e2) {
                Log.e(tag(), "IllegalFormatException happened: ", e2);
            }
        }
    }

    public static String debug(Object obj, String str, String str2) {
        if (mCloseLog) {
            return null;
        }
        if (isDebuggable()) {
            String msgForTextLog = msgForTextLog(obj, str, str2);
            if (mLogger != null) {
                mLogger.debug(tag(), msgForTextLog);
                return str2;
            }
            Log.d(tag(), msgForTextLog);
            return str2;
        }
        return str2;
    }

    public static void debug(Object obj, String str, Throwable th) {
        if (!mCloseLog && isDebuggable()) {
            String msgForTextLog = msgForTextLog(obj, str, "");
            if (mLogger != null) {
                mLogger.debug(tag(), msgForTextLog);
            } else {
                Log.d(tag(), msgForTextLog, th);
            }
            if (isSaveToFile() && BasicFileUtils.externalStorageExist()) {
                logToFile(msgForTextLog, th);
            }
        }
    }

    public static void info(Object obj, String str, String str2, Object... objArr) {
        if (!mCloseLog) {
            try {
                String msgForTextLog = msgForTextLog(obj, str, String.format(str2, objArr));
                if (mLogger != null) {
                    mLogger.info(tag(), msgForTextLog);
                } else {
                    Log.i(tag(), msgForTextLog);
                    logToFile(msgForTextLog);
                }
            } catch (NullPointerException e) {
                Log.e(tag(), "NullPointerException happened: ", e);
            } catch (IllegalFormatException e2) {
                Log.e(tag(), "IllegalFormatException happened: ", e2);
            }
        }
    }

    public static void info(Object obj, String str, String str2) {
        if (!mCloseLog) {
            String msgForTextLog = msgForTextLog(obj, str, str2);
            if (mLogger != null) {
                mLogger.info(tag(), msgForTextLog);
                return;
            }
            Log.i(tag(), msgForTextLog);
            logToFile(msgForTextLog);
        }
    }

    public static void warn(Object obj, String str, String str2, Object... objArr) {
        if (!mCloseLog) {
            try {
                String msgForTextLog = msgForTextLog(obj, str, String.format(str2, objArr));
                if (mLogger != null) {
                    mLogger.warn(tag(), msgForTextLog);
                } else {
                    Log.w(tag(), msgForTextLog);
                }
            } catch (NullPointerException e) {
                Log.e(tag(), "NullPointerException happened: ", e);
            } catch (IllegalFormatException e2) {
                Log.e(tag(), "IllegalFormatException happened: ", e2);
            }
        }
    }

    public static void warn(Object obj, String str, String str2) {
        if (!mCloseLog) {
            String msgForTextLog = msgForTextLog(obj, str, str2);
            if (mLogger != null) {
                mLogger.warn(tag(), msgForTextLog);
            } else {
                Log.w(tag(), msgForTextLog);
            }
        }
    }

    public static void error(Object obj, String str, String str2, Object... objArr) {
        if (!mCloseLog) {
            try {
                String msgForTextLog = msgForTextLog(obj, str, String.format(str2, objArr));
                if (mLogger != null) {
                    mLogger.error(tag(), msgForTextLog);
                } else {
                    Log.e(tag(), msgForTextLog);
                    logToFile(msgForTextLog);
                }
            } catch (NullPointerException e) {
                Log.e(tag(), "NullPointerException happened: ", e);
            } catch (IllegalFormatException e2) {
                Log.e(tag(), "IllegalFormatException happened: ", e2);
            }
        }
    }

    public static void error(Object obj, String str, String str2) {
        String msgForTextLog = msgForTextLog(obj, str, str2);
        if (mLogger != null) {
            mLogger.error(tag(), msgForTextLog);
            return;
        }
        Log.e(tag(), msgForTextLog);
        logToFile(msgForTextLog);
    }

    public static void error(Object obj, String str, Throwable th) {
        String msgForTextLog = msgForTextLog(obj, str, "");
        if (mLogger != null) {
            mLogger.error(tag(), msgForTextLog, th);
            return;
        }
        Log.e(tag(), msgForTextLog, th);
        logToFile(msgForTextLog);
    }

    private static String objClassName(Object obj) {
        return obj instanceof String ? (String) obj : obj.getClass().getSimpleName();
    }

    private static void logToFile(String str) {
        writeToLog(str);
    }

    /* loaded from: classes6.dex */
    private static class YMFLogThreadFactory implements ThreadFactory {
        private YMFLogThreadFactory() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "YMFLog_Thread");
        }
    }

    private static void writeToLog(final String str) {
        if (!mCloseLog && mLogPath != null) {
            mSingleThreadPool.execute(new Runnable() { // from class: com.yy.videoplayer.utils.YMFLog.1
                @Override // java.lang.Runnable
                public void run() {
                    if (BasicFileUtils.externalStorageExist()) {
                        try {
                            LogToES.writeLogToFile(LogToES.getAbsolutionLogPath(), Constant.DEFAULT_LOG_NAME, str);
                        } catch (Throwable th) {
                            Log.e("YMFLogs", "writeLogToFile fail, " + th);
                        }
                    }
                }
            });
        }
    }

    private static void logToFile(String str, Throwable th) {
        if (!mCloseLog) {
            StringWriter stringWriter = new StringWriter();
            stringWriter.write(str);
            stringWriter.write("\n");
            new PrintWriter(stringWriter).println(th.getMessage());
            writeToLog(stringWriter.toString());
        }
    }

    private static String msgForTextLog(Object obj, String str, String str2) {
        StackTraceElement[] stackTraceElementArr = null;
        if (!mShowFileName || !mShowFuncName || !mShowLines) {
            stackTraceElementArr = Thread.currentThread().getStackTrace();
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (mShowFileName || mShowIdentity || mShowFuncName) {
                sb.append("[");
                if (mShowFileName && stackTraceElementArr != null) {
                    String fileName = stackTraceElementArr[4].getFileName();
                    if (fileName != null || obj == null || "".equals(objClassName(obj))) {
                        sb.append((CharSequence) fileName, 0, fileName.length() - 5);
                    } else {
                        sb.append(objClassName(obj));
                    }
                }
                if (mShowIdentity && obj != null) {
                    sb.append(" @");
                    sb.append(Integer.toHexString(System.identityHashCode(obj)));
                }
                if (mShowFuncName && stackTraceElementArr != null) {
                    sb.append(" ");
                    sb.append(stackTraceElementArr[4].getMethodName());
                }
                sb.append("] ");
            } else {
                sb.append(" ");
            }
            sb.append(str2);
            sb.append("(");
            sb.append(Thread.currentThread().getId());
            if (mShowLines && stackTraceElementArr != null) {
                sb.append(":");
                sb.append(stackTraceElementArr[4].getLineNumber());
            }
            sb.append(")");
            str2 = sb.toString();
            return str2;
        } catch (Exception e) {
            return str2;
        }
    }

    public static String stackTraceOf(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static String threadStack() {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            printWriter.println(stackTraceElement.toString());
        }
        return stringWriter.toString();
    }
}
