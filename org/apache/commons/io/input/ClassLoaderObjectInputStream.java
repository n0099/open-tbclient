package org.apache.commons.io.input;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Proxy;
/* loaded from: classes.dex */
public class ClassLoaderObjectInputStream extends ObjectInputStream {
    private final ClassLoader classLoader;

    public ClassLoaderObjectInputStream(ClassLoader classLoader, InputStream inputStream) {
        super(inputStream);
        this.classLoader = classLoader;
    }

    @Override // java.io.ObjectInputStream
    protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) {
        Class<?> cls = Class.forName(objectStreamClass.getName(), false, this.classLoader);
        return cls != null ? cls : super.resolveClass(objectStreamClass);
    }

    @Override // java.io.ObjectInputStream
    protected Class<?> resolveProxyClass(String[] strArr) {
        Class[] clsArr = new Class[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            clsArr[i] = Class.forName(strArr[i], false, this.classLoader);
        }
        try {
            return Proxy.getProxyClass(this.classLoader, clsArr);
        } catch (IllegalArgumentException e) {
            return super.resolveProxyClass(strArr);
        }
    }
}
