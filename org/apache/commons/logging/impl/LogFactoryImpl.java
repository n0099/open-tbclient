package org.apache.commons.logging.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Hashtable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogConfigurationException;
import org.apache.commons.logging.LogFactory;
@Deprecated
/* loaded from: classes12.dex */
public class LogFactoryImpl extends LogFactory {
    public static final String ALLOW_FLAWED_CONTEXT_PROPERTY = "org.apache.commons.logging.Log.allowFlawedContext";
    public static final String ALLOW_FLAWED_DISCOVERY_PROPERTY = "org.apache.commons.logging.Log.allowFlawedDiscovery";
    public static final String ALLOW_FLAWED_HIERARCHY_PROPERTY = "org.apache.commons.logging.Log.allowFlawedHierarchy";
    public static final String LOG_PROPERTY = "org.apache.commons.logging.Log";
    protected static final String LOG_PROPERTY_OLD = "org.apache.commons.logging.log";
    protected Hashtable attributes;
    protected Hashtable instances;
    protected Constructor logConstructor;
    protected Method logMethod;
    protected Class[] logConstructorSignature = null;
    protected Class[] logMethodSignature = null;

    public LogFactoryImpl() {
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

    @Override // org.apache.commons.logging.LogFactory
    public Log getInstance(String str) throws LogConfigurationException {
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

    protected static ClassLoader getContextClassLoader() throws LogConfigurationException {
        throw new RuntimeException("Stub!");
    }

    protected static boolean isDiagnosticsEnabled() {
        throw new RuntimeException("Stub!");
    }

    protected static ClassLoader getClassLoader(Class cls) {
        throw new RuntimeException("Stub!");
    }

    protected void logDiagnostic(String str) {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    protected String getLogClassName() {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    protected Constructor getLogConstructor() throws LogConfigurationException {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    protected boolean isJdk13LumberjackAvailable() {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    protected boolean isJdk14Available() {
        throw new RuntimeException("Stub!");
    }

    @Deprecated
    protected boolean isLog4JAvailable() {
        throw new RuntimeException("Stub!");
    }

    protected Log newInstance(String str) throws LogConfigurationException {
        throw new RuntimeException("Stub!");
    }
}
