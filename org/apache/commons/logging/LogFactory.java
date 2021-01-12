package org.apache.commons.logging;

import java.util.Hashtable;
@Deprecated
/* loaded from: classes5.dex */
public abstract class LogFactory {
    public static final String DIAGNOSTICS_DEST_PROPERTY = "org.apache.commons.logging.diagnostics.dest";
    public static final String FACTORY_DEFAULT = "org.apache.commons.logging.impl.LogFactoryImpl";
    public static final String FACTORY_PROPERTIES = "commons-logging.properties";
    public static final String FACTORY_PROPERTY = "org.apache.commons.logging.LogFactory";
    public static final String HASHTABLE_IMPLEMENTATION_PROPERTY = "org.apache.commons.logging.LogFactory.HashtableImpl";
    public static final String PRIORITY_KEY = "priority";
    protected static final String SERVICE_ID = "META-INF/services/org.apache.commons.logging.LogFactory";
    public static final String TCCL_KEY = "use_tccl";
    protected static Hashtable factories;
    protected static LogFactory nullClassLoaderFactory;

    public abstract Object getAttribute(String str);

    public abstract String[] getAttributeNames();

    public abstract Log getInstance(Class cls) throws LogConfigurationException;

    public abstract Log getInstance(String str) throws LogConfigurationException;

    public abstract void release();

    public abstract void removeAttribute(String str);

    public abstract void setAttribute(String str, Object obj);

    /* JADX INFO: Access modifiers changed from: protected */
    public LogFactory() {
        throw new RuntimeException("Stub!");
    }

    public static LogFactory getFactory() throws LogConfigurationException {
        throw new RuntimeException("Stub!");
    }

    public static Log getLog(Class cls) throws LogConfigurationException {
        throw new RuntimeException("Stub!");
    }

    public static Log getLog(String str) throws LogConfigurationException {
        throw new RuntimeException("Stub!");
    }

    public static void release(ClassLoader classLoader) {
        throw new RuntimeException("Stub!");
    }

    public static void releaseAll() {
        throw new RuntimeException("Stub!");
    }

    protected static ClassLoader getClassLoader(Class cls) {
        throw new RuntimeException("Stub!");
    }

    protected static ClassLoader getContextClassLoader() throws LogConfigurationException {
        throw new RuntimeException("Stub!");
    }

    protected static ClassLoader directGetContextClassLoader() throws LogConfigurationException {
        throw new RuntimeException("Stub!");
    }

    protected static LogFactory newFactory(String str, ClassLoader classLoader, ClassLoader classLoader2) throws LogConfigurationException {
        throw new RuntimeException("Stub!");
    }

    protected static LogFactory newFactory(String str, ClassLoader classLoader) {
        throw new RuntimeException("Stub!");
    }

    protected static Object createFactory(String str, ClassLoader classLoader) {
        throw new RuntimeException("Stub!");
    }

    protected static boolean isDiagnosticsEnabled() {
        throw new RuntimeException("Stub!");
    }

    protected static final void logRawDiagnostic(String str) {
        throw new RuntimeException("Stub!");
    }

    public static String objectId(Object obj) {
        throw new RuntimeException("Stub!");
    }
}
