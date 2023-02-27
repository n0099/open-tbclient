package com.yy.hiidostatis.defs.handler;

import android.content.Context;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.logsystem.exceptionhandler.impl.ExceptionHandlerImpl;
import com.yy.hiidostatis.defs.interf.IOnStatisListener;
import com.yy.hiidostatis.defs.interf.IStatisAPI;
import com.yy.hiidostatis.inner.util.FileUtil;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.inner.util.log.L;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.UUID;
/* loaded from: classes8.dex */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    public static Context mContext;
    public static Thread.UncaughtExceptionHandler mDefaultHandler;
    public static OnHandlerListener mOnHandlerListener;
    public static IOnStatisListener mOnStatisListener;
    public static IStatisAPI mStatisAPI;

    /* loaded from: classes8.dex */
    public interface OnHandlerListener {
        void handler(int i, String str, String str2);
    }

    public static native void testNativeCrash();

    public static native void testNativeCrashThread();

    public native int initNativeHandler(String str);

    public CrashHandler(Context context, IStatisAPI iStatisAPI, IOnStatisListener iOnStatisListener, OnHandlerListener onHandlerListener) {
        mContext = context;
        mStatisAPI = iStatisAPI;
        mOnStatisListener = iOnStatisListener;
        mOnHandlerListener = onHandlerListener;
    }

    public static String getCurrentStack() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : new Throwable("").getStackTrace()) {
            sb.append(stackTraceElement.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void testJavaCrash() {
        System.out.println(10 / 0);
    }

    public String getDmpPath() {
        String str = mContext.getFilesDir().getAbsolutePath() + File.separator + "hdsdkDump";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public boolean loadLibrary() {
        try {
            System.loadLibrary("hiidostatisjni");
            return true;
        } catch (Throwable th) {
            L.debug(this, "loadLibrary failure. %s", th);
            return false;
        }
    }

    public static void crashCallBack(int i, String str) {
        String str2;
        Object[] objArr = new Object[1];
        if (i == 1) {
            str2 = ExceptionHandlerImpl.EXCEPTION_TYPE_JAVA;
        } else {
            str2 = "native";
        }
        objArr[0] = str2;
        L.debug("CrashHandler", "%s crash occur.", objArr);
        String replace = str.replace(".dmp", ".log");
        L.brief("crashCallBack,dmpFilePath=%s,logFilePath=%s", str, replace);
        FileUtil.writeFile(replace, generateCrashLog());
        OnHandlerListener onHandlerListener = mOnHandlerListener;
        if (onHandlerListener != null) {
            onHandlerListener.handler(i, str, replace);
        }
    }

    private void dealJavaException(Throwable th) {
        String str = getDmpPath() + File.separator + "J-" + UUID.randomUUID().toString() + ".dmp";
        FileUtil.writeFile(str, getStackTrace(th));
        crashCallBack(1, str);
    }

    public static String generateCrashLog() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("LOGCAT STACK:\n");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"logcat", "-v", "threadtime", "-t", "500", "-d", "*:V"}).getInputStream()), 1024);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    if (!readLine.contains(L.getTag())) {
                        stringBuffer.append(readLine);
                        stringBuffer.append("\n");
                    }
                } else {
                    bufferedReader.close();
                    return stringBuffer.toString();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void init() {
        String str;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        mDefaultHandler = defaultUncaughtExceptionHandler;
        if (defaultUncaughtExceptionHandler != null) {
            str = defaultUncaughtExceptionHandler.getClass().getSimpleName();
        } else {
            str = StringUtil.NULL_STRING;
        }
        L.debug(this, "old DefaultUncaughtExceptionHandler is %s,new DefaultUncaughtExceptionHandler is %s", str, CrashHandler.class.getSimpleName());
        Thread.setDefaultUncaughtExceptionHandler(this);
        L.debug(this, "init java crash handler", new Object[0]);
        if (loadLibrary()) {
            try {
                initNativeHandler(getDmpPath());
                L.debug(this, "init native crash handler", new Object[0]);
            } catch (Throwable th) {
                L.debug(this, "initNativeHandler error:%e", th);
            }
        }
    }

    public static String getStackTrace(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    private void handleException(final Throwable th) {
        ThreadPool.getPool().execute(new Thread() { // from class: com.yy.hiidostatis.defs.handler.CrashHandler.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                CrashHandler.mStatisAPI.reportCrashInner(CrashHandler.mOnStatisListener.getCurrentUid(), th);
            }
        });
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            handleException(th);
            Thread.sleep(800L);
        } catch (Throwable th2) {
            L.debug(this, "deal crash uncaughtException happen another exception=%s", th2);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = mDefaultHandler;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
