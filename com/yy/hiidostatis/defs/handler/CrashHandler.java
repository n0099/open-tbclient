package com.yy.hiidostatis.defs.handler;

import android.content.Context;
import com.baidu.android.common.others.lang.StringUtil;
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
/* loaded from: classes7.dex */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    public static Context mContext;
    public static Thread.UncaughtExceptionHandler mDefaultHandler;
    public static OnHandlerListener mOnHandlerListener;
    public static IOnStatisListener mOnStatisListener;
    public static IStatisAPI mStatisAPI;

    /* loaded from: classes7.dex */
    public interface OnHandlerListener {
        void handler(int i2, String str, String str2);
    }

    public CrashHandler(Context context, IStatisAPI iStatisAPI, IOnStatisListener iOnStatisListener, OnHandlerListener onHandlerListener) {
        mContext = context;
        mStatisAPI = iStatisAPI;
        mOnStatisListener = iOnStatisListener;
        mOnHandlerListener = onHandlerListener;
    }

    public static void crashCallBack(int i2, String str) {
        Object[] objArr = new Object[1];
        objArr[0] = i2 == 1 ? "java" : "native";
        L.debug("CrashHandler", "%s crash occur.", objArr);
        String replace = str.replace(".dmp", ".log");
        L.brief("crashCallBack,dmpFilePath=%s,logFilePath=%s", str, replace);
        FileUtil.writeFile(replace, generateCrashLog());
        OnHandlerListener onHandlerListener = mOnHandlerListener;
        if (onHandlerListener != null) {
            onHandlerListener.handler(i2, str, replace);
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

    public static String getCurrentStack() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : new Throwable("").getStackTrace()) {
            sb.append(stackTraceElement.toString());
            sb.append("\n");
        }
        return sb.toString();
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

    public static void testJavaCrash() {
        System.out.println(10 / 0);
    }

    public static native void testNativeCrash();

    public static native void testNativeCrashThread();

    public String getDmpPath() {
        String str = mContext.getFilesDir().getAbsolutePath() + File.separator + "hdsdkDump";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public void init() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        mDefaultHandler = defaultUncaughtExceptionHandler;
        L.debug(this, "old DefaultUncaughtExceptionHandler is %s,new DefaultUncaughtExceptionHandler is %s", defaultUncaughtExceptionHandler != null ? defaultUncaughtExceptionHandler.getClass().getSimpleName() : StringUtil.NULL_STRING, CrashHandler.class.getSimpleName());
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

    public native int initNativeHandler(String str);

    public boolean loadLibrary() {
        try {
            System.loadLibrary("hiidostatisjni");
            return true;
        } catch (Throwable th) {
            L.debug(this, "loadLibrary failure. %s", th);
            return false;
        }
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
