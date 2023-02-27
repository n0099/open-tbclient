package com.facebook.common.logging;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
/* loaded from: classes7.dex */
public class FLogDefaultLoggingDelegate implements LoggingDelegate {
    public static final FLogDefaultLoggingDelegate sInstance = new FLogDefaultLoggingDelegate();
    public String mApplicationTag = "unknown";
    public int mMinimumLoggingLevel = 5;

    public static FLogDefaultLoggingDelegate getInstance() {
        return sInstance;
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public int getMinimumLoggingLevel() {
        return this.mMinimumLoggingLevel;
    }

    public static String getMsg(String str, Throwable th) {
        return str + '\n' + getStackTraceString(th);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void d(String str, String str2) {
        println(3, str, str2);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void e(String str, String str2) {
        println(6, str, str2);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void i(String str, String str2) {
        println(4, str, str2);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void v(String str, String str2) {
        println(2, str, str2);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void w(String str, String str2) {
        println(5, str, str2);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void wtf(String str, String str2) {
        println(6, str, str2);
    }

    public static String getStackTraceString(Throwable th) {
        if (th == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    private String prefixTag(String str) {
        if (this.mApplicationTag != null) {
            return this.mApplicationTag + ":" + str;
        }
        return str;
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public boolean isLoggable(int i) {
        if (this.mMinimumLoggingLevel <= i) {
            return true;
        }
        return false;
    }

    public void setApplicationTag(String str) {
        this.mApplicationTag = str;
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void setMinimumLoggingLevel(int i) {
        this.mMinimumLoggingLevel = i;
    }

    private void println(int i, String str, String str2) {
        Log.println(i, prefixTag(str), str2);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void d(String str, String str2, Throwable th) {
        println(3, str, str2, th);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void e(String str, String str2, Throwable th) {
        println(6, str, str2, th);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void i(String str, String str2, Throwable th) {
        println(4, str, str2, th);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void log(int i, String str, String str2) {
        println(i, str, str2);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void v(String str, String str2, Throwable th) {
        println(2, str, str2, th);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void w(String str, String str2, Throwable th) {
        println(5, str, str2, th);
    }

    @Override // com.facebook.common.logging.LoggingDelegate
    public void wtf(String str, String str2, Throwable th) {
        println(6, str, str2, th);
    }

    private void println(int i, String str, String str2, Throwable th) {
        Log.println(i, prefixTag(str), getMsg(str2, th));
    }
}
