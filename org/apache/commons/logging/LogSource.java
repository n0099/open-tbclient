package org.apache.commons.logging;

import java.lang.reflect.Constructor;
import java.util.Hashtable;
@Deprecated
/* loaded from: classes8.dex */
public class LogSource {
    public static boolean jdk14IsAvailable;
    public static boolean log4jIsAvailable;
    public static Constructor logImplctor;
    public static Hashtable logs;

    public LogSource() {
        throw new RuntimeException("Stub!");
    }

    public static Log getInstance(String str) {
        throw new RuntimeException("Stub!");
    }

    public static String[] getLogNames() {
        throw new RuntimeException("Stub!");
    }

    public static Log makeNewLogInstance(String str) {
        throw new RuntimeException("Stub!");
    }

    public static void setLogImplementation(String str) throws LinkageError, ExceptionInInitializerError, NoSuchMethodException, SecurityException, ClassNotFoundException {
        throw new RuntimeException("Stub!");
    }

    public static Log getInstance(Class cls) {
        throw new RuntimeException("Stub!");
    }

    public static void setLogImplementation(Class cls) throws LinkageError, ExceptionInInitializerError, NoSuchMethodException, SecurityException {
        throw new RuntimeException("Stub!");
    }
}
