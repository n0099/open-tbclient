package org.apache.commons.logging.impl;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Properties;
import org.apache.commons.logging.Log;
@Deprecated
/* loaded from: classes12.dex */
public class SimpleLog implements Serializable, Log {
    protected static final String DEFAULT_DATE_TIME_FORMAT = "yyyy/MM/dd HH:mm:ss:SSS zzz";
    public static final int LOG_LEVEL_ALL = 0;
    public static final int LOG_LEVEL_DEBUG = 2;
    public static final int LOG_LEVEL_ERROR = 5;
    public static final int LOG_LEVEL_FATAL = 6;
    public static final int LOG_LEVEL_INFO = 3;
    public static final int LOG_LEVEL_OFF = 7;
    public static final int LOG_LEVEL_TRACE = 1;
    public static final int LOG_LEVEL_WARN = 4;
    protected static DateFormat dateFormatter = null;
    protected static String dateTimeFormat = null;
    protected static boolean showDateTime = false;
    protected static boolean showLogName = false;
    protected static boolean showShortName = false;
    protected static final Properties simpleLogProps = null;
    protected static final String systemPrefix = "org.apache.commons.logging.simplelog.";
    protected int currentLogLevel;
    protected String logName;

    public SimpleLog(String str) {
        throw new RuntimeException("Stub!");
    }

    public void setLevel(int i) {
        throw new RuntimeException("Stub!");
    }

    public int getLevel() {
        throw new RuntimeException("Stub!");
    }

    protected void log(int i, Object obj, Throwable th) {
        throw new RuntimeException("Stub!");
    }

    protected void write(StringBuffer stringBuffer) {
        throw new RuntimeException("Stub!");
    }

    protected boolean isLevelEnabled(int i) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final void debug(Object obj) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final void debug(Object obj, Throwable th) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final void trace(Object obj) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final void trace(Object obj, Throwable th) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final void info(Object obj) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final void info(Object obj, Throwable th) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final void warn(Object obj) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final void warn(Object obj, Throwable th) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final void error(Object obj) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final void error(Object obj, Throwable th) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final void fatal(Object obj) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final void fatal(Object obj, Throwable th) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isDebugEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isErrorEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isFatalEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isInfoEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isTraceEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public final boolean isWarnEnabled() {
        throw new RuntimeException("Stub!");
    }
}
