package org.apache.commons.logging.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogConfigurationException;
import org.apache.commons.logging.LogFactory;
@Deprecated
/* loaded from: classes8.dex */
public class LogFactoryImpl extends LogFactory {
    public static final String ALLOW_FLAWED_CONTEXT_PROPERTY = "org.apache.commons.logging.Log.allowFlawedContext";
    public static final String ALLOW_FLAWED_DISCOVERY_PROPERTY = "org.apache.commons.logging.Log.allowFlawedDiscovery";
    public static final String ALLOW_FLAWED_HIERARCHY_PROPERTY = "org.apache.commons.logging.Log.allowFlawedHierarchy";
    public static final String LOG_PROPERTY = "org.apache.commons.logging.Log";
    public static final String LOG_PROPERTY_OLD = "org.apache.commons.logging.log";
    public Hashtable attributes;
    public Hashtable instances;
    public Constructor logConstructor;
    public Method logMethod;
    public Class[] logConstructorSignature = null;
    public Class[] logMethodSignature = null;

    public LogFactoryImpl() {
        throw new RuntimeException("Stub!");
    }

    public static ClassLoader getClassLoader(Class cls) {
        throw new RuntimeException("Stub!");
    }

    public static ClassLoader getContextClassLoader() throws LogConfigurationException {
        throw new RuntimeException("Stub!");
    }

    public static boolean isDiagnosticsEnabled() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.LogFactory
    public Object getAttribute(String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.LogFactory
    public String[] getAttributeNames() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.LogFactory
    public Log getInstance(Class cls) throws LogConfigurationException {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public String getLogClassName() {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public Constructor getLogConstructor() throws LogConfigurationException {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public boolean isJdk13LumberjackAvailable() {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public boolean isJdk14Available() {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    public boolean isLog4JAvailable() {
        throw new RuntimeException("Stub!");
    }

    public void logDiagnostic(String str) {
        throw new RuntimeException("Stub!");
    }

    public Log newInstance(String str) throws LogConfigurationException {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.LogFactory
    public void release() {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.LogFactory
    public void removeAttribute(String str) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.LogFactory
    public void setAttribute(String str, Object obj) {
        throw new RuntimeException("Stub!");
    }

    @Override // org.apache.commons.logging.LogFactory
    public Log getInstance(String str) throws LogConfigurationException {
        throw new RuntimeException("Stub!");
    }
}
