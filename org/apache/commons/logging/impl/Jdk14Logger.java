package org.apache.commons.logging.impl;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.logging.Log;
@Deprecated
/* loaded from: classes.dex */
public class Jdk14Logger implements Serializable, Log {
    protected static final Level dummyLevel = null;
    protected transient Logger logger;
    protected String name;

    public Jdk14Logger(String str) {
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

    public Logger getLogger() {
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
    public boolean isDebugEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public boolean isErrorEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public boolean isFatalEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public boolean isInfoEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public boolean isTraceEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public boolean isWarnEnabled() {
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
    public void warn(Object obj) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.Log
    public void warn(Object obj, Throwable th) {
        throw new RuntimeException("Stub!");
    }
}
