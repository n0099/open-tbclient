package org.apache.commons.logging.impl;

import java.io.Serializable;
import org.apache.commons.logging.Log;
@Deprecated
/* loaded from: classes5.dex */
public class NoOpLog implements Serializable, Log {
    public NoOpLog() {
        throw new RuntimeException("Stub!");
    }

    public NoOpLog(String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void trace(Object obj) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void trace(Object obj, Throwable th) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void debug(Object obj) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void debug(Object obj, Throwable th) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void info(Object obj) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void info(Object obj, Throwable th) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void warn(Object obj) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void warn(Object obj, Throwable th) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void error(Object obj) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void error(Object obj, Throwable th) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void fatal(Object obj) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void fatal(Object obj, Throwable th) {
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
